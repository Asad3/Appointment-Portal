package com.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.joda.time.DateTime;

import com.data.Appointment;
import com.data.FollowUp1;
import com.data.Holiday;
import com.wrapper.FollowUpWrapper;

public class FollowUpDao {
	
	@SuppressWarnings("unchecked")
	public String createFollowUp(FollowUpWrapper followUpWrapper){
		
		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		FollowUp1 followUp = new FollowUp1();
		Appointment appointment = new Appointment();
		
		ArrayList<Holiday> holidays = new ArrayList<Holiday>();
		holidays = (ArrayList<Holiday>) session.createCriteria(Holiday.class).list();
		
		for(Holiday holiday: holidays){
			DateTime startingDate = new DateTime(holiday.getStartDate());
			DateTime endingDate = new DateTime(holiday.getEndDate());
			DateTime appointmentDate = new DateTime(followUpWrapper.getFollowUp().getFollowUpDate());
			if(appointmentDate.getDayOfYear()>=startingDate.getDayOfYear() &&
					appointmentDate.getDayOfYear()<=endingDate.getDayOfYear()){
				session.close();
				sessionFactory.close();
				return "leave";
			}
		}
		
		
		int id = followUpWrapper.getAppointmentId();
		appointment = (Appointment) session.get(Appointment.class, id);
		
		followUp = followUpWrapper.getFollowUp();
		appointment.getFollowUp().add(followUp);
		followUp.setAppointment(appointment);
		
		session.beginTransaction();
		session.save(followUp);
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<FollowUp1> getAllFollowUps(){
		ArrayList<FollowUp1> followUps = new ArrayList<FollowUp1>();
		
		SessionFactory sessionFactory  = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		followUps = (ArrayList<FollowUp1>) session.createCriteria(FollowUp1.class).list();
		session.close();
		sessionFactory.close();
		return followUps;
	}
	
}