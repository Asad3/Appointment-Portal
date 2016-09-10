package com.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.dao.PatientDao;
import com.data.Patient;

@ManagedBean(name="patients_all")
@ViewScoped
public class PatientRecords {

	ArrayList<Patient> patients = new ArrayList<Patient>();
	ArrayList<Patient> filterRecords = new ArrayList<Patient>();
	
	
	
	public ArrayList<Patient> getFilterRecords() {
		return filterRecords;
	}
	public void setFilterRecords(ArrayList<Patient> filterRecords) {
		this.filterRecords = filterRecords;
	}
	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	public ArrayList<Patient> getPatients() {
		return patients;
	}
	@PostConstruct
	public void init(){
		PatientDao patientDao = new PatientDao();
		patients = patientDao.getAllPatients();
	}
	
	public void onRowEdit(RowEditEvent event) {
        Patient patient = ((Patient) event.getObject());
        PatientDao patientDao = new PatientDao();
        patientDao.updatePatient(patient);
		FacesMessage msg = new FacesMessage("Patient Edited","");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void removePatient(Patient patient) {
    	PatientDao patientDao = new PatientDao();
    	patientDao.deletePatient(patient);
    	FacesMessage msg = new FacesMessage("Patient is deleted");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    	patients = patientDao.getAllPatients();
     }
    
}
