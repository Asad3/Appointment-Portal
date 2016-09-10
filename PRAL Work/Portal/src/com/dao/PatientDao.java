package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.data.Patient;
import com.single.admin.SessionFactoryInstance;

public class PatientDao {

	public void addPatient(Patient patient){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(patient);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	public int authenticate(String email, String password){
		int i = 0;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		String hql = "FROM Patient pat WHERE pat.email = :patient_email AND pat.password= :patient_password";
		Query query = session.createQuery(hql);
		query.setParameter("patient_email",email);
		query.setParameter("patient_password", password);
		@SuppressWarnings("rawtypes")
		List results = query.list();
		i = results.size();
		return i;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Patient> getAllPatients(){
		ArrayList<Patient> patients = new ArrayList<Patient>(); 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		String hql = "FROM Patient";
		Query query = session.createQuery(hql);
		patients = (ArrayList<Patient>) query.list();
		session.close();
		sessionFactory.close();
		return patients;
	}
	
	public void updatePatient(Patient patient){
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(patient);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deletePatient(Patient patient){
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(patient);
		session.getTransaction().commit();
		session.close();
	}
	
}
