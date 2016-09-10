package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.data.Patient;
import com.sessionfactory.SessionFactoryInstance;

public class PatientDao {

	public void addPatient(Patient patient){
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(patient);
		session.getTransaction().commit();
		session.close();
	}
	
	public int authenticate(String email, String password){
		int i = 0;
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		String hql = "FROM Patient pat WHERE pat.email = :patient_email AND pat.password= :patient_password";
		Query query = session.createQuery(hql);
		query.setParameter("patient_email",email);
		query.setParameter("patient_password", password);
		@SuppressWarnings("rawtypes")
		List results = query.list();
		i = results.size();
		session.close();
		return i;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Patient> getAllPatients(){
		ArrayList<Patient> patients = new ArrayList<Patient>(); 
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		String hql = "FROM Patient";
		Query query = session.createQuery(hql);
//		query.setFirstResult(min);
//		query.setMaxResults(max);
		patients = (ArrayList<Patient>) query.list();
		session.close();
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

	public String getName(int id){
		int i = 0;
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		String hql = "FROM Patient pat WHERE pat.id = :patient_id";
		Query query = session.createQuery(hql);
		query.setParameter("patient_id",id);
		@SuppressWarnings("rawtypes")
		ArrayList<Patient> p = (ArrayList<Patient>) query.list();
		String name = p.get(0).getName();
		session.close();
		return name;
	}
	
}
