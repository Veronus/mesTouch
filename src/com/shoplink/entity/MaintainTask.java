package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class MaintainTask {
	
	
	private String objectState;
	
	private String uuid;
	private String problemDesc;
	private String worker;
	
	private String workerName;
	private String repairWorker;
	private float repairWorkerName;
	
	private String notes;  
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date createTime;
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date actualFinish;
	

	public String getObjectState() {
		return objectState;
	}
	public void setObjectState(String objectState) {
		this.objectState = objectState;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getProblemDesc() {
		return problemDesc;
	}
	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getRepairWorker() {
		return repairWorker;
	}
	public void setRepairWorker(String repairWorker) {
		this.repairWorker = repairWorker;
	}
	public float getRepairWorkerName() {
		return repairWorkerName;
	}
	public void setRepairWorkerName(float repairWorkerName) {
		this.repairWorkerName = repairWorkerName;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getActualFinish() {
		return actualFinish;
	}
	public void setActualFinish(Date actualFinish) {
		this.actualFinish = actualFinish;
	}


}
