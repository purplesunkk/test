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
package com.junicorn.kira;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * 常量类
 * 
 * @author	<a href="mailto:biezhi.me@gmail.com" target="_blank">biezhi</a>
 * @since	1.0
 */
public class Const {
	
	/**
	 * 默认编码
	 */
	public static final Charset CHARSET = Charset.forName("UTF-8");
	
	/**
	 * 编码器
	 */
	public static final CharsetEncoder ENCODER = CHARSET.newEncoder();

	/**
	 * 默认主页文件
	 */
	public static String DEFAULT_ROOTFILE = "index.html";
	
}
