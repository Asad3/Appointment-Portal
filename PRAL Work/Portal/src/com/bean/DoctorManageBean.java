package com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.dao.DoctorDao;
import com.data.Doctor;

@ManagedBean(name="doctor")
@ViewScoped
public class DoctorManageBean {

	Doctor doctor =  new Doctor();

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public void addDoctor(){
		DoctorDao doctorDao = new DoctorDao();
		doctorDao.addDoctor(doctor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Doctor is registered", ""));
	}
}
