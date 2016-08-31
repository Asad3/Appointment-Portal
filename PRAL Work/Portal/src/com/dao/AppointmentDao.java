package com.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.joda.time.DateTime;

import com.data.Appointment;
import com.data.Doctor;
import com.data.Holiday;
import com.data.Patient;
import com.single.admin.SessionFactoryInstance;
import com.wrapper.AppointmentWrapper;

public class AppointmentDao {

	/*
	 * 
	 * 
	 * 
	 * 
	 * */
@SuppressWarnings("unchecked")
public String createAppoinment(AppointmentWrapper appointment){
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Patient patient = new Patient();
		Appointment appointment1 = new Appointment();
		Doctor doctor = new Doctor();
		
		
		appointment1 = appointment.getAppointment();
		
		
		ArrayList<Holiday> holidays = new ArrayList<Holiday>();
		holidays = (ArrayList<Holiday>) session.createCriteria(Holiday.class).list();
		
		for(Holiday holiday: holidays){
			DateTime startingDate = new DateTime(holiday.getStartDate());
			DateTime endingDate = new DateTime(holiday.getEndDate());
			DateTime appointmentDate = new DateTime(appointment.getAppointment().getAppointmentDate());
			if(appointmentDate.getDayOfYear()>=startingDate.getDayOfYear() &&
					appointmentDate.getDayOfYear()<=endingDate.getDayOfYear()){
				session.close();
				sessionFactory.close();
				return "Leave";
			}
		}
		
		int id = appointment.getPatientId();
		patient = (Patient) session.get(Patient.class, id);
		
		id = appointment.getDoctorId();
		doctor = (Doctor) session.get(Doctor.class, id);
		
		appointment1 = appointment.getAppointment();
		
		patient.getAppointment().add(appointment1);
		doctor.getAppointments().add(appointment1);
		appointment1.setPatient(patient);  
		appointment1.setDoctor(doctor);
		
		session.beginTransaction();
		session.save(appointment1);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		return "Success";
		
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Appointment> getAllAppointments(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		ArrayList<Appointment> appointments = new ArrayList<Appointment>();
		appointments = (ArrayList<Appointment>) session.createCriteria(Appointment.class).list();
		session.close();
		sessionFactory.close();
		return appointments;
	}
	
	public void updateAppointment(AppointmentWrapper appointmentWrapper){
		Session session = SessionFactoryInstance.getSessionFactory().openSession();
		session.beginTransaction();
		
		//session.update(appointment);
		
		session.getTransaction().commit();
		session.close();
	}
	
} 
