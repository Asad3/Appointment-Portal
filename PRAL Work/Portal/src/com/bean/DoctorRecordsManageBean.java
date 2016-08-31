package com.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.dao.DoctorDao;
import com.data.Doctor;

@ManagedBean(name="doctorrecords")
@ViewScoped
public class DoctorRecordsManageBean {

	ArrayList<Doctor> doctors = new ArrayList<Doctor>();

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}
	
	@PostConstruct
	public void init(){
		DoctorDao doctorDao = new DoctorDao();
		doctors = doctorDao.getAllDoctors();
	}
	
	public void onRowEdit(RowEditEvent event) {
        Doctor doctor = ((Doctor) event.getObject());
        DoctorDao doctorDao = new DoctorDao();
        doctorDao.updateDoctor(doctor);
		FacesMessage msg = new FacesMessage("Doctor Updated","");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void removeDoctor(Doctor doctor) {
    	
    	DoctorDao doctorDao = new DoctorDao();
    	doctorDao.deleteDoctor(doctor);
    	FacesMessage msg = new FacesMessage("Doctor is Deleted");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    	doctors = doctorDao.getAllDoctors();
     }   
}