package cn.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.hibernate.utils.HibernateUtils;

public class ManyTest {

	@Test
	public void testTableDelete() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 根据ID查询
			User user = session.get(User.class, 1);
			Role role = session.get(Role.class, 1);
			// 把角色对象移除
			user.getSetUser().remove(role);

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
	public void testTable() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 根据ID查询
			User user = session.get(User.class, 1);
			Role role = session.get(Role.class, 1);
			// 把角色对象放到用户里面
			user.getSetUser().add(role);

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
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			User user = new User();
			user.setUsername("nishi");
			user.setPassword("asd");

			User user2 = new User();
			user2.setUsername("nishizhuma");
			user2.setPassword("asd123");

			Role role = new Role();
			role.setRole_name("董事长");
			role.setRole_memo("lihailewodege");

			user.getSetUser().add(role);
			user2.getSetUser().add(role);

			session.save(user);
			session.save(user2);

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

}
