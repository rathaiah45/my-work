package org.cts.dao;

//import org.cts.domain.Employee;
import org.cts.domain.Person;

public interface EmployeeDao {
	//public void saveEmployee(Employee employee);
	public void savePerson(Person person);
	public boolean existUser(Person person);
	public Person getPersonById(String userName);
}
