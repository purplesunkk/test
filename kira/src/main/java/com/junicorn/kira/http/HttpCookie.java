/**
 * Copyright (c) 2015, biezhi 王爵 (biezhi.me@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.junicorn.kira.http;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class HttpCookie {
	
	private final static String RFC1123_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
	
	private final static TimeZone GMT_ZONE = TimeZone.getTimeZone("GMT");
	
	private static DateFormat RFC_DATEFORMAT = new SimpleDateFormat(RFC1123_PATTERN, Locale.US);
	
	static {
		RFC_DATEFORMAT.setTimeZone(GMT_ZONE);
	}

	private String name;
	
	private String value;
	
	private long expireTime = -1;
	
	private String path;
	
	private String domain;
	
	private boolean secure;
	
	public HttpCookie(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	public long getExpireTime() {
		return expireTime;
	}
	
	public boolean hasExpired() {
		return expireTime > System.currentTimeMillis();
	}
	
	public String getPath() {
		return path;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public boolean isSecure() {
		return secure;
	}
	
	public String toHeader() {
		StringBuilder header = new StringBuilder();
		header.append(name).append('=').append(value);
		if(domain != null) {
			header.append("; ").append("Domain=").append(domain);
		}
		if(path != null) {
			header.append("; ").append("Path=").append(path);
		}
		if(expireTime > -1) {
			header.append("; ").append("Expires=").append(RFC_DATEFORMAT.format(new Date(expireTime)));
		}
		if(secure) {
			header.append("; ").append("Secure");
		}
		return header.toString();
	}
	
	@Override
	public String toString() {
		return name + '=' + value;
	}
	
}
