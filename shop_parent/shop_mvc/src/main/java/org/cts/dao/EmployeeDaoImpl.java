package org.cts.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.cts.domain.Address;
import org.cts.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private final static Logger LOGGER = Logger
			.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Address address;

	/* O */

	public void saveEmployee(Employee employee) {
		LOGGER.info("-------Employee Details Save-----------");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (session != null) {
			try {
				List<Address> list = employee.getAddress();
				list.add(address);
				session.save(employee);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				LOGGER.error("Trascation failed Employee Object"
						+ e.getMessage());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		List<Employee> list = session.createCriteria(Employee.class).list();
		return list;
	}

	public Integer deleteEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.delete(employee);
		return employee.getEmployee_id();
	}

	public Integer updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(employee);
		return employee.getEmployee_id();
	}
}
