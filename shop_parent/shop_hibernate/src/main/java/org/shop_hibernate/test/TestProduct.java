package org.shop_hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.shop_hibernate.form.Product;

public class TestProduct {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product product = new Product();
		product.setProduct_name("Honda");
		product.setProduct_price(10000);
		Product product1 = new Product();
		product1.setProduct_name("Hero");
		product1.setProduct_price(12000);
		try {
			session.save(product);
			session.save(product1);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

	}
}
