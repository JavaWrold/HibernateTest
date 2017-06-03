package cn.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;
import org.junit.Test;

import cn.hibernate.utils.HibernateUtils;

public class HtmTest {
	@Test
	public void testThread() {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getCurrentThreadSession();
			tx = session.beginTransaction();

			User user = new User();
			user.setUsername("bibi");
			user.setPassword("123456");
			user.setAddress("hehe");
			// session.save(user);
			// 保存对象
			session.persist(user);

			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		} finally {
			// session.close();
		}
	}

	@Test
	public void testTx() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			User user = new User();
			user.setUsername("shabi");
			user.setPassword("1314");
			user.setAddress("meiguo");
			session.save(user);

			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

	@Test
	public void testAdd() {
		//
		Configuration cfg = new Configuration();
		cfg.configure();
		//
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		//
		Session session = sessionFactory.openSession();
		//
		Transaction tx = session.beginTransaction();
		// 增加
		User user = new User();
		user.setUsername("nishizhu");
		user.setPassword("asd123");
		user.setAddress("erbijie");
		session.save(user);
		//
		tx.commit();
		//
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testGet() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Statistics stats = sessionFactory.getStatistics();
		System.out.println("Stats enabled=" + stats.isStatisticsEnabled());

		stats.setStatisticsEnabled(true);
		System.out.println("Stats enabled=" + stats.isStatisticsEnabled());

		// 根据ID值进行查询
		User user = session.get(User.class, 9);
		System.out.println(user);

		// 测试二级缓存
		user = session.get(User.class, 9);
		System.out.println(user);

		tx.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testUpdate() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		User user = session.get(User.class, 10);
		user.setUsername("nishizhuma");
		session.update(user);
		user = session.get(User.class, 10);
		System.out.println(user);

		tx.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testDelete() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		User user = session.get(User.class, 2);
		session.delete(user);

		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
