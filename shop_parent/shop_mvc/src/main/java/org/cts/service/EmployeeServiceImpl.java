package org.cts.service;

import org.cts.dao.EmployeeDao;
import org.cts.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDao employeeDao;

	public void saveDetails(Employee employee) {
		employeeDao.saveEmployee(employee);

	}

}
