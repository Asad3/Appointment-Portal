package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.data.Admin;
import com.single.admin.SessionFactoryInstance;

public class AdminDao {

	public void addAdmin(Admin admin){
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close();
	}

	public int authenticate(String email, String password){
		int i = 0;
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		String hql = "FROM Admin adm WHERE adm.email = :admin_email AND adm.password= :admin_password";
		Query query = session.createQuery(hql);
		query.setParameter("admin_email",email);
		query.setParameter("admin_password", password);
		@SuppressWarnings("rawtypes")
		List results = query.list();
		i = results.size();
		return i;
	}
	
}
