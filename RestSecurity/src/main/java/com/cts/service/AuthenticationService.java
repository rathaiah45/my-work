package com.cts.service;

import java.io.IOException;
import java.util.StringTokenizer;

import sun.misc.BASE64Decoder;

public class AuthenticationService {
	public boolean authenticate(String credential) {
		if (null == credential) {
			return false;
		}
		final String encodedUSerPassword = credential.replaceFirst("Basic"
				+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodeBytes = new BASE64Decoder()
					.decodeBuffer(encodedUSerPassword);
			usernameAndPassword = new String(decodeBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
		boolean authenticationStatus = "admin".equals(username)
				&& "admin".equals(password);
		return authenticationStatus;
	}
}
