package com.bean;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.AppointmentDao;
import com.dao.TestDao;
import com.data.Appointment;
import com.wrapper.TestWrapper;

@ManagedBean(name = "TestManageBean")
public class TestManageBean {

	private TestWrapper testBean = new TestWrapper();
	private ArrayList<Integer> appointmentIds = new ArrayList<Integer>();
	
	public TestManageBean() {
		AppointmentDao appointmentDao = new AppointmentDao();
		for(Appointment apt : appointmentDao.getAllAppointments()){
			appointmentIds.add(apt.getId());
		}
	}

	
	
	
	public ArrayList<Integer> getAppointmentIds() {
		return appointmentIds;
	}




	public TestWrapper getTestBean() {
		return testBean;
	}

	public void setTestBean(TestWrapper testBean) {
		this.testBean = testBean;
	}
	
	public String addTest(){
		
		TestDao testDal = new TestDao();
		
		testDal.createTest(testBean);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Test is created", ""));
		return "Success";
	}
	
}
