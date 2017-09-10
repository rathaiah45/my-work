package org.cts.service;

import org.cts.dao.EmployeeDao;
import org.cts.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDao employeeDao;

	public void savePerson(Person person) {
		employeeDao.savePerson(person);
	}

	public boolean existUser(Person person) {
		return employeeDao.existUser(person);
	}

	public boolean autheticate(String username, String password) {
		Person person = employeeDao.getPersonById(username);
		if (person != null && person.getUsername().equalsIgnoreCase(username)
				&& person.getPassword().equalsIgnoreCase(password)) {
			return true;
		} else {
			return false;
		}
	}
}
