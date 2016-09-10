package com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.DoctorDao;

@ManagedBean(name="login_doctor")
public class DoctorLoginManageBean {

	String email;
	String password;
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
	
	public String login(){
		DoctorDao doctorDao = new DoctorDao();
		int chk = doctorDao.authenticate(email, password);
		if(chk==1){
			return "doctor?faces-redirect=true";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sorry email or password is incorrect", ""));
			return "";
		}
	}
	
}
