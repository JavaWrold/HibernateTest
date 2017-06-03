package cn.hibernate.extend2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

public class TextExtend {

	@Test
	public void test1() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Roles roles = new Roles();
			roles.setRole("student");

			Student student = new Student();
			student.setStu_name("lihongsheng");
			student.setStu_age(24);

			Teacher teacher = new Teacher();
			teacher.setTea_name("anyang");
			teacher.setTea_age(18);

			session.persist(roles);
			session.persist(student);
			session.persist(teacher);

			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sessionFactory.close();
			session.close();
		}
	}
}
