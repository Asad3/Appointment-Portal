package com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.AdminDao;

@ManagedBean(name="admin_login")
public class AdminLogin {

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
	
	public String authenticateAdmin(){
		AdminDao adminDao = new AdminDao();
		int i = adminDao.authenticate(email, password);
		if(i==1){
			return "home?faces-redirect=true";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sorry email or password is incorrect", ""));
			FacesContext.getCurrentInstance().validationFailed();
			return ""; 
		}
	}
}