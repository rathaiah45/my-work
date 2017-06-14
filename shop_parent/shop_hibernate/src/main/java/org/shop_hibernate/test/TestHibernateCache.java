package org.shop_hibernate.test;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.shop_hibernate.form.Commerce;

@SuppressWarnings("deprecation")
public class TestHibernateCache {

	public static void main(String[] args) {
		store();
		try {
			Session session = new AnnotationConfiguration()
					.configure().buildSessionFactory()
					.openSession();/*
									 * HibernateUtil.getSessionFactory().openSession
									 * ();
									 */
			session.beginTransaction();

			Commerce cmx = (Commerce) session.load(Commerce.class, new Integer(
					1));
			System.out.println(cmx.getName());
			cmx = (Commerce) session.load(Commerce.class, new Integer(1));
			System.out.println(cmx.getName());
			session.getTransaction().commit();
			session.close();

			Session another = new AnnotationConfiguration()
					.configure("hibernate.cfg.xml").buildSessionFactory()
					.openSession();
			another.beginTransaction();

			Commerce cm = (Commerce) another.load(Commerce.class,
					new Integer(1));
			System.out.println(cm.getName());
		} catch (Exception e) {

		} finally {
			HibernateUtil.shutdown();
		}
	}

	public static void store() {
		Session session = new AnnotationConfiguration()
				.configure("hibernate.cfg.xml").buildSessionFactory()
				.openSession();
		session.beginTransaction();
		Commerce cmd = new Commerce();
		cmd.setName("Agilent");
		session.save(cmd);
		session.getTransaction().commit();
	}
}
