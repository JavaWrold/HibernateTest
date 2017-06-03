package cn.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.hibernate.utils.HibernateUtils;

public class HtmTest {

	// 级联保存
	@Test
	public void testTx() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Custorm custorm = new Custorm();
			custorm.setCustName("nishizhuma");
			custorm.setCustLevel("vip");
			custorm.setCustSource("wang");
			custorm.setCustPhone("110");
			custorm.setCustMobile("999");

			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("hehejk");
			linkMan.setLkm_gender("nv");
			linkMan.setLkm_phone("991");

			LinkMan linkman2 = new LinkMan();
			linkman2.setLkm_name("hehehsdfgd");
			linkman2.setLkm_gender("nan");
			linkman2.setLkm_phone("921");

			custorm.getSetLinkMans().add(linkMan);
			custorm.getSetLinkMans().add(linkman2);

			session.save(custorm);

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

	// 级联删除
	@Test
	public void testDelete() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Custorm custorm = session.get(Custorm.class, 1);
			session.delete(custorm);

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
	public void testUpdate() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Custorm custorm = session.get(Custorm.class, 5);
			LinkMan linkMan = session.get(LinkMan.class, 3);

			custorm.getSetLinkMans().add(linkMan);
			linkMan.setCustorm(custorm);

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
