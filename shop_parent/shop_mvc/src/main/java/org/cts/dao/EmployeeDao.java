package org.cts.dao;

import java.util.List;

import org.cts.domain.Employee;

public interface EmployeeDao {
	public void saveEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Integer deleteEmployee(Employee employee);

	public Integer updateEmployee(Employee employee);
}
