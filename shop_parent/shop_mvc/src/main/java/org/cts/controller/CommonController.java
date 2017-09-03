package org.cts.controller;

import java.util.List;

import org.cts.dao.AddressDao;
import org.cts.domain.Employee;
import org.cts.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class CommonController {

	@Autowired
	public EmployeeService employeeService;

	@Autowired
	public AddressDao addressDao;

	@RequestMapping(value = "/save-data", method = RequestMethod.POST)
	public void saveData(Employee employee) {
		/*List<Address> list = employee.getAddress();
		list.add(address);
		employee.setAddress(list);*/
		employeeService.saveDetails(employee);
	}
}
