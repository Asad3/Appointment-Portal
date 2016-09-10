package com.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dao.FollowUpDao;
import com.data.FollowUp1;

@ManagedBean(name="followuprecords")
@ViewScoped
public class FollowUpRecords {

	private ArrayList<FollowUp1> followUps = new ArrayList<FollowUp1>();

	public ArrayList<FollowUp1> getFollowUps() {
		return followUps;
	}
	
	@PostConstruct
	public void init(){
		FollowUpDao followUpDao = new FollowUpDao();
		followUps = followUpDao.getAllFollowUps();
	}
	
}
