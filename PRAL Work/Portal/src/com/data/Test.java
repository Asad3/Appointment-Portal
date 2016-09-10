package com.data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "tbl_test")
public class Test {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int testId;
	private int testFee;
	private String testName;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Appointment appointment;
	
	//private ArrayList<Integer> appointmentIds = new ArrayList<Integer>();
	
	
	



	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getTestFee() {
		return testFee;
	}
	public void setTestFee(int testFee) {
		this.testFee = testFee;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	
	
}
