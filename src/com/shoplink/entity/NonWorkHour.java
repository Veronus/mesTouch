package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;
@XmlAccessorType(XmlAccessType.FIELD)
public class NonWorkHour {

	private int objectState;
	
	private String uniqueid;
	private String sn;  //ÐòºÅ
	private String workReason;
	private String manHourType;
	private String checkState;
	private double applyWork;
	private double employeeWork;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date createTime;
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date checkTime;
	
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}
	public String getUniqueid() {
		return uniqueid;
	}
	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getWorkReason() {
		return workReason;
	}
	public void setWorkReason(String workReason) {
		this.workReason = workReason;
	}
	public String getManHourType() {
		return manHourType;
	}
	public void setManHourType(String manHourType) {
		this.manHourType = manHourType;
	}
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	public double getApplyWork() {
		return applyWork;
	}
	public void setApplyWork(double applyWork) {
		this.applyWork = applyWork;
	}
	public double getEmployeeWork() {
		return employeeWork;
	}
	public void setEmployeeWork(double employeeWork) {
		this.employeeWork = employeeWork;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
}
