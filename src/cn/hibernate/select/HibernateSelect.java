package cn.hibernate.select;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import cn.hibernate.manytomany.Role;
import cn.hibernate.manytomany.User;
import cn.hibernate.utils.HibernateUtils;

public class HibernateSelect {

	// ���󵼺���ѯ
	@Test
	public void testSelect() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// ����ID��ѯ
			User user = session.get(User.class, 1);
			Set<Role> set = user.getSetUser();
			System.out.println(set.size());

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

	// OID��ѯ
	@Test
	public void testSelect1() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// ����ID��ѯ
			User user = session.get(User.class, 1);

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

	// hql��ѯ����
	@SuppressWarnings({ "unused", "unchecked" })
	@Test
	public void testSelect2() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// ����ID��ѯ
			Query<User> query = session.createQuery("from User");
			List<User> users = query.list();
			for (User user : users) {
				System.out.println(user);
			}

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

	// hql������ѯ
	@SuppressWarnings({ "unused", "unchecked" })
	@Test
	public void testSelect3() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// ����ID��ѯ
			Query<User> query = session.createQuery("from User where username=? and password=?");
			query.setParameter(0, "nishi");
			query.setParameter(1, "asd");
			List<User> users = query.list();
			for (User user : users) {
				System.out.println(user);
			}

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
