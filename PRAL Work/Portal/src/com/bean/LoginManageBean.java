package com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.PatientDao;

@ManagedBean(name="login")
public class LoginManageBean {

	private String email;
	private String password;
	
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
	
	public String authenticate(){
		PatientDao patientDao = new PatientDao();
		int chk=0;
		chk = patientDao.authenticate(email, password);
		if(chk==1){
			return "patient?faces-redirect=true";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sorry email or password is incorrect", ""));
			return "ivalid";
		}
	}
	
}
