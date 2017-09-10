package org.cts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.log4j.Logger;
import org.cts.dao.EmployeeDao;
import org.cts.domain.Person;
import org.cts.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class CommonController extends BaseController{
	private static final Logger LOGGER = Logger
			.getLogger(CommonController.class);
	@Autowired
	public EmployeeService employeeService;

	@Autowired
	public EmployeeDao employeeDao;

	@RequestMapping(value = "/save-person", method = RequestMethod.POST)
	public String savePerson(Person person) {
		if (!employeeService.existUser(person)) {
			employeeService.savePerson(person);
		} else {
			LOGGER.info("USER DETAILS ALREADY AVAILABLE : "
					+ person.getFull_name());
		}
		return "login";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String login(String username, String password,
			HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = null;
		username = req.getParameter("username");
		password = req.getParameter("password");
		Person person = null;
		if (employeeService.autheticate(username, password)) {
			if (session == null) {
				session = req.getSession(true);
			}
			person = employeeDao.getPersonById(username);
			session.setAttribute("email", person.getEmail());
		}
		return "success";
	}

	/*@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		//HttpSession session = req.getSession(false);
		if (session != null) {
			//session.removeAttribute("person");
			session.invalidate();
			LOGGER.info("SessionId"+session.getId());
		}
		return "login";
	}
*/
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profile(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		if (session != null) {
			return "success";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout() {
		//HttpSession session = req.getSession(false);
		getUserSession().invalidate();
		return "login";
	}
}
