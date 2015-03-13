#define BLOG_CHANNEL_server 0
#define BLOG_CHANNEL_client 1
#define BLOG_CHANNEL_flooder 2
#define BLOG_CHANNEL_tun2socks 3
#define BLOG_CHANNEL_ncd 4
#define BLOG_CHANNEL_ncd_var 5
#define BLOG_CHANNEL_ncd_list 6
#define BLOG_CHANNEL_ncd_depend 7
#define BLOG_CHANNEL_ncd_multidepend 8
#define BLOG_CHANNEL_ncd_dynamic_depend 9
#define BLOG_CHANNEL_ncd_concat 10
#define BLOG_CHANNEL_ncd_if 11
#define BLOG_CHANNEL_ncd_strcmp 12
#define BLOG_CHANNEL_ncd_regex_match 13
#define BLOG_CHANNEL_ncd_logical 14
#define BLOG_CHANNEL_ncd_sleep 15
#define BLOG_CHANNEL_ncd_print 16
#define BLOG_CHANNEL_ncd_blocker 17
#define BLOG_CHANNEL_ncd_run 18
#define BLOG_CHANNEL_ncd_runonce 19
#define BLOG_CHANNEL_ncd_daemon 20
#define BLOG_CHANNEL_ncd_spawn 21
#define BLOG_CHANNEL_ncd_imperative 22
#define BLOG_CHANNEL_ncd_ref 23
#define BLOG_CHANNEL_ncd_index 24
#define BLOG_CHANNEL_ncd_alias 25
#define BLOG_CHANNEL_ncd_process_manager 26
#define BLOG_CHANNEL_ncd_ondemand 27
#define BLOG_CHANNEL_ncd_foreach 28
#define BLOG_CHANNEL_ncd_choose 29
#define BLOG_CHANNEL_ncd_net_backend_waitdevice 30
#define BLOG_CHANNEL_ncd_net_backend_waitlink 31
#define BLOG_CHANNEL_ncd_net_backend_badvpn 32
#define BLOG_CHANNEL_ncd_net_backend_wpa_supplicant 33
#define BLOG_CHANNEL_ncd_net_backend_rfkill 34
#define BLOG_CHANNEL_ncd_net_up 35
#define BLOG_CHANNEL_ncd_net_dns 36
#define BLOG_CHANNEL_ncd_net_iptables 37
#define BLOG_CHANNEL_ncd_net_ipv4_addr 38
#define BLOG_CHANNEL_ncd_net_ipv4_route 39
#define BLOG_CHANNEL_ncd_net_ipv4_dhcp 40
#define BLOG_CHANNEL_ncd_net_ipv4_arp_probe 41
#define BLOG_CHANNEL_ncd_net_watch_interfaces 42
#define BLOG_CHANNEL_ncd_sys_watch_input 43
#define BLOG_CHANNEL_ncd_sys_watch_usb 44
#define BLOG_CHANNEL_ncd_sys_evdev 45
#define BLOG_CHANNEL_ncd_sys_watch_directory 46
#define BLOG_CHANNEL_StreamPeerIO 47
#define BLOG_CHANNEL_DatagramPeerIO 48
#define BLOG_CHANNEL_BReactor 49
#define BLOG_CHANNEL_BSignal 50
#define BLOG_CHANNEL_FragmentProtoAssembler 51
#define BLOG_CHANNEL_BPredicate 52
#define BLOG_CHANNEL_ServerConnection 53
#define BLOG_CHANNEL_Listener 54
#define BLOG_CHANNEL_DataProto 55
#define BLOG_CHANNEL_FrameDecider 56
#define BLOG_CHANNEL_BSocksClient 57
#define BLOG_CHANNEL_BDHCPClientCore 58
#define BLOG_CHANNEL_BDHCPClient 59
#define BLOG_CHANNEL_NCDIfConfig 60
#define BLOG_CHANNEL_BUnixSignal 61
#define BLOG_CHANNEL_BProcess 62
#define BLOG_CHANNEL_PRStreamSink 63
#define BLOG_CHANNEL_PRStreamSource 64
#define BLOG_CHANNEL_PacketProtoDecoder 65
#define BLOG_CHANNEL_DPRelay 66
#define BLOG_CHANNEL_BThreadWork 67
#define BLOG_CHANNEL_DPReceive 68
#define BLOG_CHANNEL_BInputProcess 69
#define BLOG_CHANNEL_NCDUdevMonitorParser 70
#define BLOG_CHANNEL_NCDUdevMonitor 71
#define BLOG_CHANNEL_NCDUdevCache 72
#define BLOG_CHANNEL_NCDUdevManager 73
#define BLOG_CHANNEL_BTime 74
#define BLOG_CHANNEL_BEncryption 75
#define BLOG_CHANNEL_SPProtoDecoder 76
#define BLOG_CHANNEL_LineBuffer 77
#define BLOG_CHANNEL_BTap 78
#define BLOG_CHANNEL_lwip 79
#define BLOG_CHANNEL_NCDConfigTokenizer 80
#define BLOG_CHANNEL_NCDConfigParser 81
#define BLOG_CHANNEL_NCDValParser 82
#define BLOG_CHANNEL_nsskey 83
#define BLOG_CHANNEL_addr 84
#define BLOG_CHANNEL_PasswordListener 85
#define BLOG_CHANNEL_NCDInterfaceMonitor 86
#define BLOG_CHANNEL_NCDRfkillMonitor 87
#define BLOG_CHANNEL_udpgw 88
#define BLOG_CHANNEL_UdpGwClient 89
#define BLOG_CHANNEL_SocksUdpGwClient 90
#define BLOG_CHANNEL_BNetwork 91
#define BLOG_CHANNEL_BConnection 92
#define BLOG_CHANNEL_BSSLConnection 93
#define BLOG_CHANNEL_BDatagram 94
#define BLOG_CHANNEL_PeerChat 95
#define BLOG_CHANNEL_BArpProbe 96
#define BLOG_CHANNEL_NCDModuleIndex 97
#define BLOG_CHANNEL_NCDModuleProcess 98
#define BLOG_CHANNEL_NCDValGenerator 99
#define BLOG_CHANNEL_ncd_from_string 100
#define BLOG_CHANNEL_ncd_to_string 101
#define BLOG_CHANNEL_ncd_value 102
#define BLOG_CHANNEL_ncd_try 103
#define BLOG_CHANNEL_ncd_sys_request_server 104
#define BLOG_CHANNEL_NCDRequest 105
#define BLOG_CHANNEL_ncd_net_ipv6_wait_dynamic_addr 106
#define BLOG_CHANNEL_NCDRequestClient 107
#define BLOG_CHANNEL_ncd_request 108
#define BLOG_CHANNEL_ncd_sys_request_client 109
#define BLOG_CHANNEL_ncd_exit 110
#define BLOG_CHANNEL_ncd_getargs 111
#define BLOG_CHANNEL_ncd_arithmetic 112
#define BLOG_CHANNEL_ncd_parse 113
#define BLOG_CHANNEL_ncd_valuemetic 114
#define BLOG_CHANNEL_ncd_file 115
#define BLOG_CHANNEL_ncd_netmask 116
#define BLOG_CHANNEL_ncd_implode 117
#define BLOG_CHANNEL_ncd_call2 118
#define BLOG_CHANNEL_ncd_assert 119
#define BLOG_CHANNEL_ncd_reboot 120
#define BLOG_CHANNEL_ncd_explode 121
#define BLOG_CHANNEL_NCDPlaceholderDb 122
#define BLOG_CHANNEL_NCDVal 123
#define BLOG_CHANNEL_ncd_net_ipv6_addr 124
#define BLOG_CHANNEL_ncd_net_ipv6_route 125
#define BLOG_CHANNEL_ncd_net_ipv4_addr_in_network 126
#define BLOG_CHANNEL_ncd_net_ipv6_addr_in_network 127
#define BLOG_CHANNEL_dostest_server 128
#define BLOG_CHANNEL_dostest_attacker 129
#define BLOG_CHANNEL_ncd_timer 130
#define BLOG_CHANNEL_ncd_file_open 131
#define BLOG_CHANNEL_ncd_backtrack 132
#define BLOG_CHANNEL_ncd_socket 133
#define BLOG_CHANNEL_ncd_depend_scope 134
#define BLOG_CHANNEL_ncd_substr 135
#define BLOG_CHANNEL_ncd_sys_start_process 136
#define BLOG_CHANNEL_NCDBuildProgram 137
#define BLOG_CHANNEL_ncd_log 138
#define BLOG_CHANNEL_ncd_log_msg 139
#define BLOG_CHANNEL_ncd_buffer 140
#define BLOG_CHANNEL_ncd_getenv 141
#define BLOG_CHANNEL_BThreadSignal 142
#define BLOG_CHANNEL_BLockReactor 143
#define BLOG_CHANNEL_ncd_load_module 144
#define BLOG_NUM_CHANNELS 145
