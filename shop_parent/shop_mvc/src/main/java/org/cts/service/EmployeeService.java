package org.cts.service;

import org.cts.domain.Person;

public interface EmployeeService {
	public void savePerson(Person person);
	public boolean existUser(Person person);
	public boolean autheticate(String username,String password);
}
