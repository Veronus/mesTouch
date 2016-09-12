package com.shoplink.entity;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class WorkRec {
		
	
	private int objectState;
	
	private String taskUid;
	private String assnUid;	
	private String workType;
	private String worker;	
	private String deviceUid;
	private String sn;
	private float completeQty;
	private float preOpTime;
	private float runTime;
	
	private String materialUsn;
	private String partNumber;
	private String boxId;
	
	
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}
	public String getTaskUid() {
		return taskUid;
	}
	public void setTaskUid(String taskUid) {
		this.taskUid = taskUid;
	}
	public String getAssnUid() {
		return assnUid;
	}
	public void setAssnUid(String assnUid) {
		this.assnUid = assnUid;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getDeviceUid() {
		return deviceUid;
	}
	public void setDeviceUid(String deviceUid) {
		this.deviceUid = deviceUid;
	}
	public float getCompleteQty() {
		return completeQty;
	}
	public void setCompleteQty(float completeQty) {
		this.completeQty = completeQty;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public float getPreOpTime() {
		return preOpTime;
	}
	public void setPreOpTime(float preOpTime) {
		this.preOpTime = preOpTime;
	}
	public float getRunTime() {
		return runTime;
	}
	public void setRunTime(float runTime) {
		this.runTime = runTime;
	}
	public String getMaterialUsn() {
		return materialUsn;
	}
	public void setMaterialUsn(String materialUsn) {
		this.materialUsn = materialUsn;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getBoxId() {
		return boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	

	

}
