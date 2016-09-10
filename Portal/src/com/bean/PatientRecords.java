package com.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.dao.PatientDao;
import com.data.Patient;

@ManagedBean(name="patients_all")
@ViewScoped
public class PatientRecords {

	ArrayList<Patient> patients = new ArrayList<Patient>();
	Patient updatePateint = new Patient();
	Patient newPatient = new Patient();
	/*int min = 0;
	int max = 3;*/
	

	
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
	
	

    public void removePatient(Patient patient) {
    	
    	PatientDao patientDao = new PatientDao();
    	patientDao.deletePatient(patient);
    	FacesMessage msg = new FacesMessage("Patient is deleted");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    	patients = patientDao.getAllPatients();
     }
    
    public void updatePatient(){
        PatientDao patientDao = new PatientDao();
        //updatePateint.setPassword("123");
        patientDao.updatePatient(updatePateint);
		FacesMessage msg = new FacesMessage("Patient Edited","");
        FacesContext.getCurrentInstance().addMessage(null, msg);
//        patients.add(updatePateint);
    }
    
    public void addNewPatient(){
    	PatientDao patientDao = new PatientDao();
    	patientDao.addPatient(newPatient);
    	init();
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Patient is added", ""));
    }
    
    public void test(){
    	
    	PatientDao patientDao = new PatientDao();
    	patients = new ArrayList<Patient>();
		patients = patientDao.getAllPatients();
    }
}
