package com.shoplink.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialPart {
	
	private int objectState;
	
	private String specialBillUid;
	private String taskUid;
	private String batchnum;
	//工序号
	private float operationNumber;
	//工序名称
	private String operaitonName;
	//数量
	private float specialQty;
	
	private String deviceUid;
	
	@XmlElementWrapper
	@XmlElement(name = "specialPartDetail")
	private List<SpecialPartDetail> specialPartDetails;

	public int getObjectState() {
		return objectState;
	}

	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}

	public String getSpecialBillUid() {
		return specialBillUid;
	}

	public void setSpecialBillUid(String specialBillUid) {
		this.specialBillUid = specialBillUid;
	}

	public String getTaskUid() {
		return taskUid;
	}

	public void setTaskUid(String taskUid) {
		this.taskUid = taskUid;
	}

	public String getBatchnum() {
		return batchnum;
	}

	public void setBatchnum(String batchnum) {
		this.batchnum = batchnum;
	}

	public float getOperationNumber() {
		return operationNumber;
	}

	public void setOperationNumber(float operationNumber) {
		this.operationNumber = operationNumber;
	}

	public String getOperaitonName() {
		return operaitonName;
	}

	public void setOperaitonName(String operaitonName) {
		this.operaitonName = operaitonName;
	}

	public float getSpecialQty() {
		return specialQty;
	}

	public void setSpecialQty(float specialQty) {
		this.specialQty = specialQty;
	}

	public String getDeviceUid() {
		return deviceUid;
	}

	public void setDeviceUid(String deviceUid) {
		this.deviceUid = deviceUid;
	}

	public List<SpecialPartDetail> getSpecialPartDetails() {
		return specialPartDetails;
	}

	public void setSpecialPartDetails(List<SpecialPartDetail> specialPartDetails) {
		this.specialPartDetails = specialPartDetails;
	}
	
	
	
}
