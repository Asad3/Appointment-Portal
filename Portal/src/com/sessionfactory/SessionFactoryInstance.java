
package com.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryInstance {

	private static SessionFactory sessionFactory = null;
	
	private SessionFactoryInstance(){
		
	}
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static void closeFactory(){
		sessionFactory.close();
	}
}
