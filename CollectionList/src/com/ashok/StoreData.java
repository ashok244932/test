package com.ashok;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session= factory.openSession();
		
		Transaction t=session.beginTransaction();
		
		ArrayList<String> list1= new ArrayList<String>();
		list1.add("Java is a programming language");
		list1.add("Java is a platform");
		
		ArrayList<String> list2= new ArrayList<String>();
		list2.add("Servlet is an Interface");
		list2.add("Servlet is an API");
		
		Question q1=new Question();
		q1.setQname("what is java");
		q1.setAnswer(list1);
		
		Question q2=new Question();
		q2.setQname("what is Servlet");
		q2.setAnswer(list2);
		
		session.persist(q1);
		session.persist(q2);
		t.commit();
		session.close();
		
		System.out.println("Question added successfully");  
				
	}

}
