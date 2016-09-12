package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class SumWorkRec {
	
	private String objectState;  
	
	private String workType;
	private String drawingId;
	private String partName;
	private String batchNum;
	private String operationIdDesc;
	private float completeQty;
	private double completeWork;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date workDate;
	public String getObjectState() {
		return objectState;
	}
	public void setObjectState(String objectState) {
		this.objectState = objectState;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
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
	public float getCompleteQty() {
		return completeQty;
	}
	public void setCompleteQty(float completeQty) {
		this.completeQty = completeQty;
	}
	public double getCompleteWork() {
		return completeWork;
	}
	public void setCompleteWork(double completeWork) {
		this.completeWork = completeWork;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	

	


}
