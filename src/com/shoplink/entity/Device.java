package com.shoplink.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Device {
	
	private int objectState;
	
	private String deviceUid;
	private String deviceName;
	private String deviceModel;
	
	private String deviceState;
	private String deviceStateDesc;
	
	private String deptId;	
	private String deptName;   
	
	private String currentOperator;   
	private String currentOperatorName;
	

	
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}
	public String getDeviceUid() {
		return deviceUid;
	}
	public void setDeviceUid(String deviceUid) {
		this.deviceUid = deviceUid;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceState() {
		return deviceState;
	}
	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}
	public String getDeviceStateDesc() {
		return deviceStateDesc;
	}
	public void setDeviceStateDesc(String deviceStateDesc) {
		this.deviceStateDesc = deviceStateDesc;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getCurrentOperator() {
		return currentOperator;
	}
	public void setCurrentOperator(String currentOperator) {
		this.currentOperator = currentOperator;
	}
	public String getCurrentOperatorName() {
		return currentOperatorName;
	}
	public void setCurrentOperatorName(String currentOperatorName) {
		this.currentOperatorName = currentOperatorName;
	}


}
