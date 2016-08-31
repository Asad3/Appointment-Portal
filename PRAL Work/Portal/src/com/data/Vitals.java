package com.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_vitals1")
public class Vitals {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vitalId;
	@Column(name = "high_blood_pressure")
	private int bpHigh;
	@Column(name = "low_blood_pressure")
	private int bpLow;
	@Column(name = "heart_beat")
	private int heartBeat;
	@Column(name = "respiratory_rate")
	private int respiratoryRate;
	@Column(name = "suger")
	private int suger;
	@Column(name = "temerature")
	private int temperature;
	
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="vitals")
	private Appointment appointment;

	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public int getVitalId() {
		return vitalId;
	}
	public void setVitalId(int vitalId) {
		this.vitalId = vitalId;
	}
	public int getBpHigh() {
		return bpHigh;
	}
	public void setBpHigh(int bpHigh) {
		this.bpHigh = bpHigh;
	}
	public int getBpLow() {
		return bpLow;
	}
	public void setBpLow(int bpLow) {
		this.bpLow = bpLow;
	}
	public int getHeartBeat() {
		return heartBeat;
	}
	public void setHeartBeat(int heartBeat) {
		this.heartBeat = heartBeat;
	}
	public int getRespiratoryRate() {
		return respiratoryRate;
	}
	public void setRespiratoryRate(int respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}
	public int getSuger() {
		return suger;
	}
	public void setSuger(int suger) {
		this.suger = suger;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
}