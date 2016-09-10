package com.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.data.Appointment;
import com.data.Test;
import com.wrapper.TestWrapper;

public class TestDao {

	public void createTest(TestWrapper testWrapper){
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Test test = new Test();
		Appointment appointment = new Appointment();
		appointment = (Appointment) session.get(Appointment.class, testWrapper.getAppointmentId());
		//appointment.getVitals();
		test = testWrapper.getTest();
		appointment.getTests().add(test);
		test.setAppointment(appointment);
		
		session.beginTransaction();
		session.save(test);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Test> getAllTests(){
		ArrayList<Test> tests = new ArrayList<Test>();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		tests = (ArrayList<Test>) session.createCriteria(Test.class).list();
		session.close();
		sessionFactory.close();
		return tests;
	}
	
	
}
