package com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.PatientDao;
import com.data.Patient;

@ManagedBean(name="patient")
public class PatientManageBean {

	Patient patient = new Patient();

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void addPatient(){
		PatientDao patientDao = new PatientDao();
		patientDao.addPatient(patient);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Patient is registered", ""));
	}
	
	
}
