 package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.data.Doctor;
import com.single.admin.SessionFactoryInstance;


public class DoctorDao {

	public void addDoctor(Doctor doctor){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(doctor);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Doctor> getAllDoctors(){
		ArrayList<Doctor> doctors = new ArrayList<Doctor>(); 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		String hql = "FROM Doctor";
		Query query = session.createQuery(hql);
		doctors = (ArrayList<Doctor>) query.list();
		session.close();
		sessionFactory.close();
		return doctors;
	}
	
	public int authenticate(String email, String password){
		int i = 0;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		String hql = "FROM Doctor doc WHERE doc.email = :doctor_email AND doc.password= :doctor_password";
		Query query = session.createQuery(hql);
		query.setParameter("doctor_email",email);
		query.setParameter("doctor_password", password);
		@SuppressWarnings("rawtypes")
		List results = query.list();
		i = results.size();
		return i;
	}
	
	public void updateDoctor(Doctor doctor){
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(doctor);
		session.getTransaction().commit();
		session.close();
	}	
	
	public void deleteDoctor(Doctor doctor){
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(doctor);
		session.getTransaction().commit();
		session.close();
	}
	
}