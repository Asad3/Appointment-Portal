package com.wrapper;

import com.data.Vitals;


public class VitalsWrapper {

	private Vitals vitals = new Vitals();
	private int appointmentId;
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Vitals getVitals() {
		return vitals;
	}
	public void setVitals(Vitals vitals) {
		this.vitals = vitals;
	}
	
	
	
}
