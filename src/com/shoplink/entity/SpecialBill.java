package com.shoplink.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialBill {
	
	private int objectState;
	
	private String specialBillUid;
	private String taskUid;
	private String batchNum;
	//工序号
	private float operationNumber;
	//工序名称
	private String operationName;
	//数量
	private float specialQty;
	
	private String deviceUid;
	
	private String boxId;
	
	@XmlElementWrapper
	@XmlElement(name = "specialPartDetail")
	private List<SpecialBillDetail> specialPartDetails;

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

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public float getOperationNumber() {
		return operationNumber;
	}

	public void setOperationNumber(float operationNumber) {
		this.operationNumber = operationNumber;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
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

	public List<SpecialBillDetail> getSpecialPartDetails() {
		return specialPartDetails;
	}

	public void setSpecialPartDetails(List<SpecialBillDetail> specialPartDetails) {
		this.specialPartDetails = specialPartDetails;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	
	
}
