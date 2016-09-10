package com.bean;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.AppointmentDao;
import com.dao.FollowUpDao;
import com.data.Appointment;
import com.wrapper.FollowUpWrapper;

@ManagedBean(name = "followUpBean")
public class FollowUpManageBean {
	
	private FollowUpWrapper followUpWrapper = new FollowUpWrapper();
	private ArrayList<Integer> appointmentIds = new ArrayList<Integer>();
	
	
	public FollowUpManageBean() {
		AppointmentDao appointmentDao = new AppointmentDao();
		for(Appointment appointment: appointmentDao.getAllAppointments()){
			appointmentIds.add(appointment.getId());
		}
	}
	
	public ArrayList<Integer> getAppointmentIds() {
		return appointmentIds;
	}




	

	public FollowUpWrapper getFollowUpWrapper() {
		return followUpWrapper;
	}

	public void setFollowUpWrapper(FollowUpWrapper followUpWrapper) {
		this.followUpWrapper = followUpWrapper;
	}
	
	public void createFollowUp(){
		
		FollowUpDao followUpDao = new FollowUpDao();
		String ret = followUpDao.createFollowUp(followUpWrapper);
		if(ret.equals("leave")){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sorry Doctor is on leave on this day...", ""));
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Your Follow Up is created...", ""));
		}
	}

	
}
