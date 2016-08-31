package com.data;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tbl_doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private int id;
	@Column(name="doctor_name")
	private String name;
	@Column(name="doctor_age")
	private int age;
	@Column(name="doctor_address")
	private String address;
	@Column(name="doctor_email")
	private String email;
	@Column(name="doctor_password")
	private String password;
	@Column(name="doctor_specialization")
	private String specialization;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="doctor", fetch=FetchType.EAGER)
	private Collection<Appointment> appointments = new ArrayList<Appointment>();
	
	

	public Collection<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(Collection<Appointment> appointments) {
		this.appointments = appointments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	
	
}
