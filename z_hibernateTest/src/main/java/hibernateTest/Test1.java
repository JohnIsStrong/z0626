package hibernateTest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import po.FullName;
import po.User;

public class Test1 {
	private static SessionFactory sf;
	private Session sen;
	@BeforeClass
	public static void beforeClass(){
		sf=new Configuration().configure().buildSessionFactory();
		
	}
	@Before
	public void before(){
		sen=sf.openSession();
	}
	@After
	public void after(){
		sen.close();
	}
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
	@Test
	public void testPersist(){
		User u = new User("john",100);
		
		
		u.getTels().add("123");
		u.getTels().add("234");
		
		Transaction tx=sen.beginTransaction();
		sen.persist(u);
		tx.commit();
		System.out.println(u.getId());
		//sen.save(u);
	}
	@Test
	public void testFind(){
//		User u=(User)sen.get(User.class, 1);
//		System.out.println(u.getUanme());
//		FullName fn=new FullName();
//		fn.setFirstName("john");
//		fn.setLastName("yu");
		
		User u=(User)sen.load(User.class, 20);
		System.out.println(u.getAge());
//		for(String s:u.getTels()){
//			System.out.println(s);
//		}
		
//		System.out.println(u.getUanme());
//		System.out.println(u.getClass().getName());
	}
//	@Test
//	public void testFind1(){
//		String hql="from User where id<=:id";
//		Query query=sen.createQuery(hql);
//		query.setInteger("id", 2);
//		List<User> us=query.list();
//		for(User u:us){
//			System.out.println(u.getId());
//		}
//	}
	@Test
	public void test3(){
		Transaction tx=sen.beginTransaction();
		User u=(User)sen.load(User.class, 20);
		//u.getTels().add("567");
		for(String s:u.getTels()){
			if("567".equals(s)){
				s="abc";
			}
		}
		
		
		tx.commit();
	}
	@Test
	public void testDel(){
		Transaction tx=sen.beginTransaction();
		User u=(User)sen.get(User.class, 1);
		
		sen.delete(u);
		tx.commit();
	//ß	User u1=sen.merge(u);
	}
	
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();

	}

}
