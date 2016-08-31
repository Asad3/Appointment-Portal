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
	Patient updatePateint = new Patient();
	Patient newPatient = new Patient();
	
	

	
	public Patient getNewPatient() {
		return newPatient;
	}
	public void setNewPatient(Patient newPatient) {
		this.newPatient = newPatient;
	}
	
	public void updatepatient1(Patient pat){
		this.updatePateint = pat;
	}
	public void setUpdatePateint(Patient updatePateint) {
		this.updatePateint = updatePateint;
	}
	public Patient getUpdatePateint() {
		return updatePateint;
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
    
    public void updatePatient(){
        PatientDao patientDao = new PatientDao();
        patientDao.updatePatient(updatePateint);
		FacesMessage msg = new FacesMessage("Patient Edited","");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void addNewPatient(){
    	PatientDao patientDao = new PatientDao();
    	patientDao.addPatient(newPatient);
    	init();
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Patient is added", ""));
    }
    
}
