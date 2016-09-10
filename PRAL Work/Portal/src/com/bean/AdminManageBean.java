package com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.AdminDao;
import com.data.Admin;

@ManagedBean(name="admin")
public class AdminManageBean {

	Admin admin	= new Admin();

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void addAdmin(){
		AdminDao adminDao = new AdminDao();
		adminDao.addAdmin(admin);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Admin is registered", ""));
	}
	
}
