package com.shoplink.entity;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class DispatchBill {
	
	
	private int objectState;
	
	private String dispatcher;
	private String dispatcherName;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date dispatchDate;
	
	
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}
	public String getDispatcher() {
		return dispatcher;
	}
	public void setDispatcher(String dispatcher) {
		this.dispatcher = dispatcher;
	}
	public String getDispatcherName() {
		return dispatcherName;
	}
	public void setDispatcherName(String dispatcherName) {
		this.dispatcherName = dispatcherName;
	}
	public Date getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	



}
