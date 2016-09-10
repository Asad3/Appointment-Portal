package com.data;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="tbl_patient")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
	private int id;
	@Column(name="patient_name")
	private String name;
	@Column(name="patient_age")
	private int age;
	@Column(name="patient_address")
	private String address;
	@Column(name="patient_email")
	private String email;
	@Column(name="patient_password")
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="patient")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Appointment> appointment = new ArrayList<Appointment>();
	
	
	
	public Collection<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(Collection<Appointment> appointment) {
		this.appointment = appointment;
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
		
}
