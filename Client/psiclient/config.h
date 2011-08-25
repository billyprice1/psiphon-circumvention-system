/*
 * Copyright (c) 2011, Psiphon Inc.
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

#pragma once

#include <tchar.h>

static const TCHAR* PLINK_SOCKS_PROXY_PORT = _T("1080");
static const TCHAR* POLIPO_HTTP_PROXY_PORT = _T("8080");
static const TCHAR* VPN_CONNECTION_NAME = _T("Psiphon3");
static const TCHAR* LOCAL_SETTINGS_REGISTRY_KEY = _T("Software\\Psiphon3");
static const char* LOCAL_SETTINGS_REGISTRY_VALUE_SERVERS = "Servers";
static const TCHAR* HTTP_HANDSHAKE_REQUEST_PATH = _T("/handshake");
static const TCHAR* HTTP_CONNECTED_REQUEST_PATH = _T("/connected");
static const TCHAR* HTTP_FAILED_REQUEST_PATH = _T("/failed");
static const TCHAR* HTTP_DOWNLOAD_REQUEST_PATH = _T("/download");

static int VPN_CONNECTION_TIMEOUT_SECONDS = 20;
static int SSH_CONNECTION_TIMEOUT_SECONDS = 20;
