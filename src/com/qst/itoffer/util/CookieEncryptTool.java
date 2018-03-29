package com.qst.itoffer.util;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;

public class CookieEncryptTool {
	public static String encodeBase64(String cleartext) {
		try {
			cleartext = new String(Base64.encodeBase64(cleartext.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cleartext;
	}
	public static String decodeBase64(String cleartext) {
		try {
			cleartext = new String(Base64.decodeBase64(cleartext.getBytes()),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cleartext;
	}
}
