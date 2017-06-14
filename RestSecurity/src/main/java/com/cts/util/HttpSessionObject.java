package com.cts.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpSessionObject {

	public static HttpSession getSessionObject(HttpServletRequest request) {
		HttpSession session = null;
		if (session == null) {
			session = request.getSession(true);
		}
		return session;
	}
}
