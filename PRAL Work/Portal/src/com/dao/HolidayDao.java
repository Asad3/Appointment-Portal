package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.data.Doctor;
import com.data.Holiday;
import com.wrapper.HolidayWrapper;

public class HolidayDao {

	public void createHoliday(HolidayWrapper holidayWrapper){
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Holiday holiday = new Holiday();
		Doctor doctor = new Doctor();
		
		int id = holidayWrapper.getDoctorId();
		doctor = (Doctor)session.get(Doctor.class, id);
		
		holiday = holidayWrapper.getHoliday();
		//doctor.getHolidays().add(holiday);
		holiday.setDoctor(doctor);
		
		session.beginTransaction();
		session.save(holiday);
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
		
	}
	
}
