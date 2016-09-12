package com.shoplink.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SumWork {
	
	private String objectState;
	
	private float personalCompleteWork;
	private float shopAveCompleteWork;
	private float shopMaxCompleteWork;	
	private float shopMinCompleteWork;
	private float personalOvertimeWork;	
	private float personalAbsenceWork;	
	private float personalShutdownWork;
	private float personalRejectWork;
	
	public String getObjectState() {
		return objectState;
	}
	public void setObjectState(String objectState) {
		this.objectState = objectState;
	}
	public float getPersonalCompleteWork() {
		return personalCompleteWork;
	}
	public void setPersonalCompleteWork(float personalCompleteWork) {
		this.personalCompleteWork = personalCompleteWork;
	}
	public float getShopAveCompleteWork() {
		return shopAveCompleteWork;
	}
	public void setShopAveCompleteWork(float shopAveCompleteWork) {
		this.shopAveCompleteWork = shopAveCompleteWork;
	}
	public float getShopMaxCompleteWork() {
		return shopMaxCompleteWork;
	}
	public void setShopMaxCompleteWork(float shopMaxCompleteWork) {
		this.shopMaxCompleteWork = shopMaxCompleteWork;
	}
	public float getShopMinCompleteWork() {
		return shopMinCompleteWork;
	}
	public void setShopMinCompleteWork(float shopMinCompleteWork) {
		this.shopMinCompleteWork = shopMinCompleteWork;
	}
	public float getPersonalOvertimeWork() {
		return personalOvertimeWork;
	}
	public void setPersonalOvertimeWork(float personalOvertimeWork) {
		this.personalOvertimeWork = personalOvertimeWork;
	}
	public float getPersonalAbsenceWork() {
		return personalAbsenceWork;
	}
	public void setPersonalAbsenceWork(float personalAbsenceWork) {
		this.personalAbsenceWork = personalAbsenceWork;
	}
	public float getPersonalShutdownWork() {
		return personalShutdownWork;
	}
	public void setPersonalShutdownWork(float personalShutdownWork) {
		this.personalShutdownWork = personalShutdownWork;
	}
	public float getPersonalRejectWork() {
		return personalRejectWork;
	}
	public void setPersonalRejectWork(float personalRejectWork) {
		this.personalRejectWork = personalRejectWork;
	}   
	
	
	

	


}
