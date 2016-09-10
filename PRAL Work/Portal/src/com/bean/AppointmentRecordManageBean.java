package com.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dao.AppointmentDao;
import com.data.Appointment;

@ManagedBean(name="appointmentrecords")
@ViewScoped
public class AppointmentRecordManageBean {

	ArrayList<Appointment> appointments = new ArrayList<Appointment>();

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
	
	@PostConstruct
	public void init(){
		AppointmentDao appointmentDao = new AppointmentDao();
		appointments = appointmentDao.getAllAppointments();
	}
	
	
	
}
