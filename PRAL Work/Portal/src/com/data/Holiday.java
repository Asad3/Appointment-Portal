package com.data;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_holiday")
public class Holiday {
	
	@Column(name = "id")
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/*@Column(name = "start_day")
	private int startDay;
	@Column(name = "start_month")
	private int startMonth;
	@Column(name = "start_year")
	private int startYear;
	@Column(name = "end_day")
	private int endDay;
	@Column(name = "end_month")
	private int endMonth;
	@Column(name = "end_year")
	private int endYear;*/
	@Column(name="start_date")
	private Date startDate = new Date();
	@Column(name="end_date")
	private Date endDate = new Date();
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Doctor doctor = new Doctor();
	
	//private ArrayList<Integer> doctorIds = new ArrayList<Integer>();
	
	
	
	/*public ArrayList<Integer> getDoctorIds() {
		return doctorIds;
	}
*/
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	public int getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
	public int getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}*/

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
