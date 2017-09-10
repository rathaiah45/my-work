package org.cts.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.cts.domain.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private final static Logger LOGGER = Logger
			.getLogger(EmployeeDaoImpl.class);
	@Autowired
	public SessionFactory sessionFactory;

	public void savePerson(Person person) {
		LOGGER.info("------Person details saved---------------");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (session != null) {
			try {
				session.save(person);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				LOGGER.error("Failed to save person details");
			}
		}
	}

	@SuppressWarnings("unchecked")
	public boolean existUser(Person person) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		boolean flag = false;
		List<Person> list = null;
		if (session != null) {
			list = session.createCriteria(Person.class).list();
			tx.commit();
		}
		for (Person person2 : list) {
			if (person2.getFull_name().equalsIgnoreCase(person.getFull_name())) {
				flag = true;
			}
		}
		return flag;
	}

	public Person getPerson(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Person person = (Person) session.get(Person.class, id);
		return person;
	}

	public Person getPersonById(String username) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		Person person =null;
		try {
			tx = session.beginTransaction();
			//person = (Person) session.createQuery("from "+Person.class.getName()+" where user_name='"+userName+"'").uniqueResult();    //get(Person.class, userName);
			Criteria criteria = session.createCriteria(Person.class);
			//Integer userName1=Integer.parseInt(userName);
			person=(Person)criteria.add(Restrictions.eq("username", username)).uniqueResult();
			//person=(Person) criteria.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return person;
	}
}
