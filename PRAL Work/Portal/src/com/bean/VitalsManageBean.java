package com.bean;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.AppointmentDao;
import com.dao.VitalDao;
import com.data.Appointment;
import com.wrapper.VitalsWrapper;

@ManagedBean(name = "vitals")
public class VitalsManageBean {

	private VitalsWrapper vitalsBean = new VitalsWrapper();
	private ArrayList<Integer> appointmentIds = new ArrayList<Integer>();
	
	public VitalsManageBean() {
		AppointmentDao appointmentDao = new AppointmentDao();
		for(Appointment apt: appointmentDao.getAllAppointments()){
			appointmentIds.add(apt.getId());
		}
	}

	
	
	public ArrayList<Integer> getAppointmentIds() {
		return appointmentIds;
	}



	public VitalsWrapper getVitalsBean() {
		return vitalsBean;
	}

	public void setVitalsBean(VitalsWrapper vitalsBean) {
		this.vitalsBean = vitalsBean;
	}


	public void addVitals(){
		
		VitalDao vitalsDal = new VitalDao();
		vitalsDal.addVitals(vitalsBean);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vitals is added", ""));
		//return "Success";
	}
	
}
