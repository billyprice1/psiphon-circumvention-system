/*
 * Copyright (c) 2012, Psiphon Inc.
 * All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.psiphon3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import com.psiphon3.Utils;
import com.psiphon3.PsiphonAndroidService.Message;


public class PsiphonAndroidActivity extends Activity implements OnClickListener
{
    public static final String ADD_MESSAGE = "com.psiphon3.PsiphonAndroidActivity.ADD_MESSAGE";
    public static final String ADD_MESSAGE_TEXT = "com.psiphon3.PsiphonAndroidActivity.ADD_MESSAGE_TEXT";
    public static final String ADD_MESSAGE_CLASS = "com.psiphon3.PsiphonAndroidActivity.ADD_MESSAGE_CLASS";
    
    private TableLayout m_messagesTableLayout;
    private ScrollView m_messagesScrollView;
    private Animation m_animRotate;
    private ImageView m_startImageView;
    private LocalBroadcastManager m_localBroadcastManager;
    private PsiphonAndroidService m_service;


    // local service binding, as in http://developer.android.com/reference/android/app/Service.html
    
    private ServiceConnection m_connection = new ServiceConnection()
    {
        public void onServiceConnected(ComponentName className, IBinder service)
        {
            m_service = ((PsiphonAndroidService.LocalBinder)service).getService();
            PsiphonAndroidActivity.this.hookUpMessages();
        }

        public void onServiceDisconnected(ComponentName className)
        {
            m_service = null;
        }
    };
 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        
        m_messagesTableLayout = (TableLayout)findViewById(R.id.messagesTableLayout);
        m_messagesScrollView = (ScrollView)findViewById(R.id.messagesScrollView);
        m_startImageView = (ImageView)findViewById(R.id.startImageView);
        m_animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        m_startImageView.setOnClickListener(this);
    }

    public class AddMessageReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String message = intent.getStringExtra(ADD_MESSAGE_TEXT);
            MessageClass messageClass = MessageClass.values()[intent.getIntExtra(ADD_MESSAGE_CLASS, 0)];
            AddMessage(message, messageClass);
        }
    }
    
    @Override
    protected void onStart()
    {
        super.onStart();

        // Using both "started" service and "bound" service interfaces:
        // - "started" to ensure tunnel service lives beyond this activity
        // - "bound" to interact with service (check connection status, start/stop, etc.)
        
        startService(new Intent(this, PsiphonAndroidService.class));
        bindService(new Intent(this, PsiphonAndroidService.class), m_connection, Context.BIND_AUTO_CREATE);

        // The next step is to restore messages and hook up the message receiver.
        // Since bind is asynchronous, hookUpMessages is called by onServiceConnected...
    }

    protected void hookUpMessages()
    {
        // Restore messages previously posted by the service
        
        for (Message msg : m_service.getMessages())
        {
            AddMessage(msg.m_message, msg.m_messageClass);
        }
        
        // Listen for new messages
        // Using local broad cast (http://developer.android.com/reference/android/support/v4/content/LocalBroadcastManager.html)
        
        IntentFilter filter = new IntentFilter(ADD_MESSAGE);
        m_localBroadcastManager = LocalBroadcastManager.getInstance(this);
        m_localBroadcastManager.registerReceiver(new AddMessageReceiver(), filter);        
    }
    
    @Override
    protected void onStop()
    {
        super.onStop();
        
        unbindService(m_connection);
    }
    
    public enum MessageClass { GOOD, BAD, NEUTRAL, DEBUG };
    
    public void AddMessage(String message, MessageClass messageClass)
    {
        TableRow row = new TableRow(this);
        TextView messageTextView = new TextView(this);
        ImageView messageClassImageView = new ImageView(this);
        
        messageTextView.setText(message);
        
        int messageClassImageRes = 0;
        int messageClassImageDesc = 0;
        int logPriority = 0;
        switch (messageClass)
        {
        case GOOD:
            messageClassImageRes = android.R.drawable.presence_online;
            messageClassImageDesc = R.string.message_image_good_desc;
            logPriority = Log.INFO;
            break;
        case BAD:
            messageClassImageRes = android.R.drawable.presence_busy;
            messageClassImageDesc = R.string.message_image_bad_desc;
            logPriority = Log.WARN;
            break;
        case DEBUG:
            messageClassImageRes = android.R.drawable.presence_away;
            messageClassImageDesc = R.string.message_image_debug_desc;
            logPriority = Log.DEBUG;
            break;
        default:
            messageClassImageRes = android.R.drawable.presence_invisible;
            messageClassImageDesc = R.string.message_image_neutral_desc;
            logPriority = Log.INFO;
            break;
        }
        messageClassImageView.setImageResource(messageClassImageRes);
        messageClassImageView.setContentDescription(getResources().getText(messageClassImageDesc));
        
        // Make sure the class image is aligned to the right.
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
        layoutParams.gravity = android.view.Gravity.RIGHT; 
        messageClassImageView.setLayoutParams(layoutParams);
        
        row.addView(messageTextView);
        row.addView(messageClassImageView);
        
        m_messagesTableLayout.addView(row);
        
        // Also log to LogCat
        Log.println(logPriority, PsiphonConstants.TAG, message);
        
        // Wait until the messages list is updated before attempting to scroll 
        // to the bottom.
        m_messagesScrollView.post(
            new Runnable()
            {
                @Override
                public void run()
                {
                    m_messagesScrollView.fullScroll(View.FOCUS_DOWN);
                }
            });
    }
    
    private void spinImage()
    {
        m_startImageView.startAnimation(m_animRotate);
    }
    
    // OnClickListener implementation
    @Override
    public void onClick(View view) 
    {
        if (view == m_startImageView)
        {
            AddMessage("start clicked", MessageClass.DEBUG);
            spinImage();
        }
    }
}
