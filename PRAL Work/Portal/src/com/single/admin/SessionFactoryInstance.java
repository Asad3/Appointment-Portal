
package com.single.admin;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryInstance {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	private SessionFactoryInstance(){
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void closeFactory(){
		sessionFactory.close();
	}
}
