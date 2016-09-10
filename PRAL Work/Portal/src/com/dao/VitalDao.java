package com.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




import com.data.Appointment;
import com.data.Vitals;
import com.wrapper.VitalsWrapper;

public class VitalDao {

	public void addVitals(VitalsWrapper vitalsWrapper){
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Vitals vitals = new Vitals();
		Appointment appointment = new Appointment();
		appointment = (Appointment) session.get(Appointment.class, vitalsWrapper.getAppointmentId());
		vitals = vitalsWrapper.getVitals();
		appointment.setVitals(vitals);
		vitals.setAppointment(appointment);
		
		session.beginTransaction();
		session.save(vitals);
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Vitals> getAllVitals(){
		ArrayList<Vitals> vitals = new ArrayList<Vitals>();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		vitals = (ArrayList<Vitals>) session.createCriteria(Vitals.class).list();
		session.close();
		sessionFactory.close();
		return vitals;
	}
	
}
