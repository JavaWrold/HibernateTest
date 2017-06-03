package cn.hibernate.component;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.Test;

import cn.hibernate.utils.HibernateUtils;

@SuppressWarnings("deprecation")
public class ComTest {

	@Test
	public void test() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			People people1 = new People(1, "lihongsheng", new Address(2014, "datong", "china"));
			People people2 = new People(2, "anyang", new Address(2015, "luliang", "china"));

			session.save(people1);
			session.save(people2);

			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testSelectHQL() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		Query<People> query = session.getNamedQuery("findPeopleByName");
		query.setParameter("name", "anyang");
		List<People> lists = query.list();

		for (People people : lists) {
			System.out.println(people);
		}
	}

	@Test
	public void testSelectSQL() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();

		@SuppressWarnings({ "unchecked" })
		SQLQuery<People> sqlQuery = session.getNamedSQLQuery("findPeopleByName1");
		sqlQuery.addEntity(People.class);
		List<People> lists = sqlQuery.getResultList();

		for (People people : lists) {
			System.out.println(people);
		}
	}
}
