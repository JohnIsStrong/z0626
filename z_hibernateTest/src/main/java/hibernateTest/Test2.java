package hibernateTest;

import java.util.List;

import org.hibernate.Hibernate;
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

import po.Address;
import po.FullName;
import po.User;

public class Test2 {
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
		User u=new User("john",100);
		Address adr=new Address();
		adr.setCity("sh");
		adr.setU(u);
		Transaction tx=sen.beginTransaction();
		//sen.persist(u);
		sen.persist(adr);
		tx.commit();
		
	}
	@Test
	public void testFind(){
		Address adr=(Address)sen.get(Address.class, 1);
		
		Hibernate.initialize(adr.getU());
		
	}
	

}
