package com.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Appointment Bean class that is uses for mapping in database table
 * @author Asad Saleem 
 */
@Entity
@Table(name = "tbl_appointment")
public class Appointment {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="appointment_date")
	private Date appointmentDate = new Date();
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Doctor doctor;
	
	@ManyToOne(optional=false, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Patient patient;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="appointment", fetch=FetchType.LAZY)
	private Collection<Test> tests = new ArrayList<Test>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="appointment", fetch=FetchType.LAZY)
	private Collection<FollowUp1> followUp = new ArrayList<FollowUp1>();
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Vitals vitals;
	
	

	public Collection<Test> getTests() {
		return tests;
	}
	public void setTests(Collection<Test> tests) {
		this.tests = tests;
	}
	public Vitals getVitals() {
		return vitals;
	}
	public void setVitals(Vitals vitals) {
		this.vitals = vitals;
	}
	/**
	 * This method is used to get id
	 * @param void
	 * @return id of type int
	 */
	public int getId() {
		return id;
	}
	public Collection<FollowUp1> getFollowUp() {
		return followUp;
	}
	public void setFollowUp(Collection<FollowUp1> followUp) {
		this.followUp = followUp;
	}
	/**
	 * This method is use to set the id
	 * @param id of type int
	 * @return void 
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * This method is use to get Day of the appointment
	 * @param void
	 * @return day of type int
	 */
	/*public int getDay() {
		return Day;
	}
	*//**
	 * This method is use to set the day of aapointment 
	 * @param day of type int
	 * @return void
	 *//*
	public void setDay(int day) {
		Day = day;
	}
	*//**
	 * This method is use to get the month of appointment
	 * @param void
	 * @return month of type int
	 *//*
	public int getMonth() {
		return Month;
	}
	*//**
	 * This method is use to set the month of appointment
	 * @param month of type int 
	 * @return void
	 *//*
	public void setMonth(int month) {
		Month = month;
	}
	*//**
	 * This method is use to get the year of the appointment
	 * @param void
	 * @return year of type int
	 *//*
	public int getYear() {
		return Year;
	}
	*//**
	 * This method is use to set the year of the appointment
	 * @param year of type int
	 * @return void
	 *//*
	public void setYear(int year) {
		Year = year;
	}*/
	
	
	
	/**
	 * This method is use to get the patient object that take the appointment
	 * @param void
	 * @return patient of type int
	 */
	public Patient getPatient() {
		return patient;
	}
	

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}