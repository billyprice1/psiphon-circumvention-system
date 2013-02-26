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

package com.psiphon3.psiphonlibrary;

public interface EmbeddedValues
{
/*[[[cog
import cog
import utils
cog.outl('final String PROPAGATION_CHANNEL_ID = "%s";' % utils.get_embedded_value(buildname, 'PROPAGATION_CHANNEL_ID'))
cog.outl('final String SPONSOR_ID = "%s";' % utils.get_embedded_value(buildname, 'SPONSOR_ID'))
cog.outl('final String CLIENT_VERSION = "%s";' % utils.get_embedded_value(buildname, 'CLIENT_VERSION'))
utils.outl_escaped('final String EMBEDDED_SERVER_LIST = "%s";' % utils.get_embedded_value(buildname, 'EMBEDDED_SERVER_LIST'))
cog.outl('final String REMOTE_SERVER_LIST_URL = "%s";' % utils.get_embedded_value(buildname, 'REMOTE_SERVER_LIST_URL'))
cog.outl('final String REMOTE_SERVER_LIST_SIGNATURE_PUBLIC_KEY = "%s";' % utils.get_embedded_value(buildname, 'REMOTE_SERVER_LIST_SIGNATURE_PUBLIC_KEY'))
cog.outl('final String FEEDBACK_ENCRYPTION_PUBLIC_KEY = "%s";' % utils.get_embedded_value(buildname, 'FEEDBACK_ENCRYPTION_PUBLIC_KEY'))
cog.outl('final String INFO_LINK_URL = "%s";' % utils.get_embedded_value(buildname, 'INFO_LINK_URL'))
cog.outl('final String PROXIED_WEB_APP_HTTP_AUTH_USERNAME = "%s";' % utils.get_embedded_value(buildname, 'PROXIED_WEB_APP_HTTP_AUTH_USERNAME'))
cog.outl('final String PROXIED_WEB_APP_HTTP_AUTH_PASSWORD = "%s";' % utils.get_embedded_value(buildname, 'PROXIED_WEB_APP_HTTP_AUTH_PASSWORD'))
]]]*/
    final String PROPAGATION_CHANNEL_ID = "";

    final String SPONSOR_ID = "";

    final String CLIENT_VERSION = "2";

    final String EMBEDDED_SERVER_LIST = "";

    final String REMOTE_SERVER_LIST_URL =
        "https://s3.amazonaws.com/invalid_bucket_name/server_entries";

    final String REMOTE_SERVER_LIST_SIGNATURE_PUBLIC_KEY = "";

    final String FEEDBACK_ENCRYPTION_PUBLIC_KEY = "";

    // NOTE: Info link may be opened when not tunneled
    final String INFO_LINK_URL = "https://sites.google.com/a/psiphon3.com/psiphon3/";

    final String PROXIED_WEB_APP_HTTP_AUTH_USERNAME = "";

    final String PROXIED_WEB_APP_HTTP_AUTH_PASSWORD = "";
//[[[end]]]
}
