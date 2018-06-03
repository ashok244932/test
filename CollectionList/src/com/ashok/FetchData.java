package com.ashok;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		
		Query query=session.createQuery("from Question");
		List<Question> list1=query.list();
		Iterator<Question> itr=list1.iterator();
		
		while(itr.hasNext())
		{
			Question q= itr.next();
		System.out.println("Question "+q.getId()+" : "+q.getQname() );
		
		System.out.println("Answers:");
		
		List<String> list2=q.getAnswer();
		Iterator<String> itr1=list2.iterator();
		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
		}
		
		
		}
		
		session.close();  
	    System.out.println("success"); 
	}

}
