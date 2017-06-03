package cn.hibernate.annonation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.Test;

import cn.hibernate.utils.HibernateUtils;

public class Testann {
	@Test
	public void testThread() {
		// Session session = new
		// AnnotationConfiguration().configure().buildSessionFactory().openSession();
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.build();
		// 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Session session = null;
		Transaction tx = null;
		try {
			// session = HibernateUtils.getSessionFactory().openSession();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			User user = new User();
			user.setUsername("bis12356");
			user.setPassword("asdz456");
			user.setAddress("hwesdffe");
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
	public void testSelect() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		Query<User> query = session.getNamedQuery("findUserByName");
		query.setParameter("username", "nishizhu");
		List<User> lists = query.list();

		for (User user : lists) {
			System.out.println(user);
		}
	}
}
