package com.data;

import java.sql.Time;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_time")
public class DoctorAppointmentTime {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private ArrayList<Time> times = new ArrayList<Time>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Time> getTimes() {
		return times;
	}

	public void setTimes(ArrayList<Time> times) {
		this.times = times;
	}
	
	
}
