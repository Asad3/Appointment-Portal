package com.wrapper;

import com.data.Holiday;

public class HolidayWrapper {

	private Holiday holiday = new Holiday();
	private int doctorId;
	
	public Holiday getHoliday() {
		return holiday;
	}
	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	
	
}
