package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
	
	
	private String objectState;
	
	private String drawingId;
	private String partName;
	private String batchNum;
	private String operationIdDesc;
	private String operationName;
	
	private float planQty;
	private double dispatchQty;
	
	private double preOpTime;
	private double runTime;
	
	private float priority;
	private String priorityDesc;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date planStart;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date planFinish;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date actualStart;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date actualFinish;
	
	private String taskStateDesc;
	private float completeQty;
	
	private String taskUid;
	private String assnUid;
	
	private String predTaskStateDesc;
	private String succTaskStateDesc;
	
	public String getObjectState() {
		return objectState;
	}
	public void setObjectState(String objectState) {
		this.objectState = objectState;
	}

	public String getDrawingId() {
		return drawingId;
	}
	public void setDrawingId(String drawingId) {
		this.drawingId = drawingId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	public String getOperationIdDesc() {
		return operationIdDesc;
	}
	public void setOperationIdDesc(String operationIdDesc) {
		this.operationIdDesc = operationIdDesc;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public float getPlanQty() {
		return planQty;
	}
	public void setPlanQty(float planQty) {
		this.planQty = planQty;
	}
	public double getDispatchQty() {
		return dispatchQty;
	}
	public void setDispatchQty(double dispatchQty) {
		this.dispatchQty = dispatchQty;
	}
	public double getPreOpTime() {
		return preOpTime;
	}
	public void setPreOpTime(double preOpTime) {
		this.preOpTime = preOpTime;
	}
	public double getRunTime() {
		return runTime;
	}
	public void setRunTime(double runTime) {
		this.runTime = runTime;
	}
	public float getPriority() {
		return priority;
	}
	public void setPriority(float priority) {
		this.priority = priority;
	}
	public String getPriorityDesc() {
		return priorityDesc;
	}
	public void setPriorityDesc(String priorityDesc) {
		this.priorityDesc = priorityDesc;
	}
	public Date getPlanStart() {
		return planStart;
	}
	public void setPlanStart(Date planStart) {
		this.planStart = planStart;
	}
	public Date getPlanFinish() {
		return planFinish;
	}
	public void setPlanFinish(Date planFinish) {
		this.planFinish = planFinish;
	}
	public Date getActualStart() {
		return actualStart;
	}
	public void setActualStart(Date actualStart) {
		this.actualStart = actualStart;
	}
	public Date getActualFinish() {
		return actualFinish;
	}
	public void setActualFinish(Date actualFinish) {
		this.actualFinish = actualFinish;
	}
	public String getTaskStateDesc() {
		return taskStateDesc;
	}
	public void setTaskStateDesc(String taskStateDesc) {
		this.taskStateDesc = taskStateDesc;
	}
	public float getCompleteQty() {
		return completeQty;
	}
	public void setCompleteQty(float completeQty) {
		this.completeQty = completeQty;
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
	public String getPredTaskStateDesc() {
		return predTaskStateDesc;
	}
	public void setPredTaskStateDesc(String predTaskStateDesc) {
		this.predTaskStateDesc = predTaskStateDesc;
	}
	public String getSuccTaskStateDesc() {
		return succTaskStateDesc;
	}
	public void setSuccTaskStateDesc(String succTaskStateDesc) {
		this.succTaskStateDesc = succTaskStateDesc;
	}


}
