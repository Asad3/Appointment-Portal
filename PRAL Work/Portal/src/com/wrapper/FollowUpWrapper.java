package com.wrapper;

import com.data.FollowUp1;


public class FollowUpWrapper {

	private FollowUp1 followUp = new FollowUp1();
	private int appointmentId;
	
	public FollowUp1 getFollowUp() {
		return followUp;
	}
	public void setFollowUp(FollowUp1 followUp) {
		this.followUp = followUp;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	
	
}
