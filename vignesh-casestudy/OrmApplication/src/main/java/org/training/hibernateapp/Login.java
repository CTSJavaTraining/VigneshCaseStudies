package org.training.hibernateapp;


import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {


	private static SessionFactory factory= new Configuration().configure().buildSessionFactory();
	
	public void login(String username, String password) {
		
		Session session=factory.openSession();
		Transaction loginTransaction=null;
		

		String hql = "FROM Employee";
		Query query = ((SharedSessionContract) session).createQuery(hql);
		List results = query.list();		
		
		loginTransaction=session.beginTransaction();
		
		
		
	}
}
