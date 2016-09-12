package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShiftInfo {
	private int objectState;
	
	private String uniqueId;
	private String shiftId;
	private String shiftName;
	private String deviceUid;
	private String handoverEmployeedUid;
	private String takeoverEmployeedUid;
	private String takeoverEmployeeName;
	private String shiftContent;
	private String note;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date lastShiftTime;	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date shiftTime;
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getShiftId() {
		return shiftId;
	}
	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}
	public String getShiftName() {
		return shiftName;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
	public String getDeviceUid() {
		return deviceUid;
	}
	public void setDeviceUid(String deviceUid) {
		this.deviceUid = deviceUid;
	}
	public String getHandoverEmployeedUid() {
		return handoverEmployeedUid;
	}
	public void setHandoverEmployeedUid(String handoverEmployeedUid) {
		this.handoverEmployeedUid = handoverEmployeedUid;
	}
	public String getTakeoverEmployeedUid() {
		return takeoverEmployeedUid;
	}
	public void setTakeoverEmployeedUid(String takeoverEmployeedUid) {
		this.takeoverEmployeedUid = takeoverEmployeedUid;
	}
	public String getTakeoverEmployeeName() {
		return takeoverEmployeeName;
	}
	public void setTakeoverEmployeeName(String takeoverEmployeeName) {
		this.takeoverEmployeeName = takeoverEmployeeName;
	}
	public String getShiftContent() {
		return shiftContent;
	}
	public void setShiftContent(String shiftContent) {
		this.shiftContent = shiftContent;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getLastShiftTime() {
		return lastShiftTime;
	}
	public void setLastShiftTime(Date lastShiftTime) {
		this.lastShiftTime = lastShiftTime;
	}
	public Date getShiftTime() {
		return shiftTime;
	}
	public void setShiftTime(Date shiftTime) {
		this.shiftTime = shiftTime;
	}	

}
