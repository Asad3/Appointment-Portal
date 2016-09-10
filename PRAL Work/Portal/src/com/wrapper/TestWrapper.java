package com.wrapper;

import com.data.Test;


public class TestWrapper {

	private Test test = new Test();
	private int appointmentId;
	
	
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}	
}