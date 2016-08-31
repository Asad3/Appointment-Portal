package com.bean;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.DoctorDao;
import com.dao.HolidayDao;
import com.data.Doctor;
import com.wrapper.HolidayWrapper;

@ManagedBean(name = "holiday")
public class HolidayBean {

	private HolidayWrapper holidayWrapper = new HolidayWrapper();
	//private List lists = new List();
	private ArrayList<Integer> doctorIds = new ArrayList<Integer>();
	
	public HolidayBean() {
		DoctorDao doctorDao = new DoctorDao();
		for(Doctor doctor : doctorDao.getAllDoctors()){
			doctorIds.add(doctor.getId());
		}
	}
	

	
	
	public ArrayList<Integer> getDoctorIds() {
		return doctorIds;
	}




	/*public List getLists() {
		return lists;
	}

	public void setLists(List lists) {
		this.lists = lists;
	}*/

	public HolidayWrapper getHolidayWrapper() {
		return holidayWrapper;
	}

	public void setHolidayWrapper(HolidayWrapper holidayWrapper) {
		this.holidayWrapper = holidayWrapper;
	}
	
	public void createHolidays(){
		HolidayDao holidayDao = new HolidayDao();
		holidayDao.createHoliday(holidayWrapper);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Your Leave", ""));
	}
	
}
