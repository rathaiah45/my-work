package org.cts.controller;

import java.text.MessageFormat;
import java.util.MissingResourceException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class BaseController {
	private static final Logger LOGGER = Logger.getLogger(BaseController.class);

	static final String SESSION_OBJ_KEY = "sessionObject";

	public HttpServletRequest getRequest() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		return attributes.getRequest();
	}

	public HttpServletResponse getResponse() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		return attributes.getResponse();
	}

	private HttpSession getSession() {
		return getNewSession();
	}

	public HttpSession getNewSession() {
		return getRequest().getSession(true);
	}

	public HttpSession getExistingSession() {
		return getRequest().getSession(false);
	}

	protected HttpSession getUserSession() {
		HttpSession session = getExistingSession();

		if (session == null) {
			session = getNewSession();
			LOGGER.info("New Session ==========> " + session.getId());
		} else {
			LOGGER.info("Existing Session ==========> " + session.getId());
		}
		return session;
	}

	public ServletContext getServletContext() {
		return getSession().getServletContext(); // servlet2.3
	}

	/*
	 * public void createCookie(String key, String value) { Cookie cookie = new
	 * Cookie(key,value); cookie.setPath("/"); cookie.setMaxAge(3600);
	 * getResponse().addCookie(cookie); }
	 */

	/*
	 * protected void updateServiceRequest(ServiceRequest req,
	 * OauthTokenProperties oAuthProp, String serviceUrl) { if (req != null) {
	 * req.setOauthProp(oAuthProp); req.setEndPoint(serviceUrl); } }
	 */

	/**
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String getUpdatedUrl(String url, Object... params) {
		try {
			return MessageFormat.format(url, params);
		} catch (MissingResourceException e) {
			return '!' + url + '!';
		}
	}
}
