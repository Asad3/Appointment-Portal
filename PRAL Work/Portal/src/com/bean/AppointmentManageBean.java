package com.bean;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.AppointmentDao;
import com.dao.DoctorDao;
import com.dao.PatientDao;
import com.data.Doctor;
import com.data.Patient;
import com.wrapper.AppointmentWrapper;

@ManagedBean(name="ManageAppointment")
public class AppointmentManageBean {

	private AppointmentWrapper appointmentBean = new AppointmentWrapper();
	//private List lists = new List();

	private ArrayList<Integer> patientIds = new ArrayList<Integer>();
	private ArrayList<Integer> doctorIds = new ArrayList<Integer>();
	
	public AppointmentManageBean() {
		
		PatientDao patientDao = new PatientDao();
		for(Patient pat:patientDao.getAllPatients()){
			patientIds.add(pat.getId());
		}
		
		DoctorDao doctorDao = new DoctorDao();
		for(Doctor doctor:doctorDao.getAllDoctors()){
			doctorIds.add(doctor.getId());
		}
	}


	public ArrayList<Integer> getPatientIds() {
		return patientIds;
	}



	public ArrayList<Integer> getDoctorIds() {
		return doctorIds;
	}



	public AppointmentWrapper getAppointmentBean() {
		return appointmentBean;
	}



	public void setAppointmentBean(AppointmentWrapper appointmentBean) {
		this.appointmentBean = appointmentBean;
	}



	public void createAppointment(){
		AppointmentDao appointmentDao = new AppointmentDao();
		String ret = appointmentDao.createAppoinment(appointmentBean);
		if(ret.equals("Leave")){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sorry Doctor is on leave on this day", ""));
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Your appointment is created", ""));
		}
		
	}
}