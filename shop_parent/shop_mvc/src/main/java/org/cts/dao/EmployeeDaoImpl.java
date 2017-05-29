package org.cts.dao;

import org.apache.log4j.Logger;
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

	public void saveEmployee(Employee employee) {
		LOGGER.info("-------Employee Details Save-----------");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (session != null) {
			try {
				session.save(employee);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				LOGGER.error("Trascation failed Employee Object"
						+ e.getMessage());
			}
		}
	}
}
