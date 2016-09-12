package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

public class QualityRec {
	private int objectState;
	
	private String sn;
	private String drawingId;
	private String partName;
	private String batchnum;
	//工序号
	private String operationNumber;
	//工序名称
	private String operaitonName;
	//返工单号
	private String reworkinfo;
	//让步单号
	private String repairinfo;
	//报废单号
	private String rejectinfo;
	
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
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
	public String getBatchnum() {
		return batchnum;
	}
	public void setBatchnum(String batchnum) {
		this.batchnum = batchnum;
	}
	public String getOperationNumber() {
		return operationNumber;
	}
	public void setOperationNumber(String operationNumber) {
		this.operationNumber = operationNumber;
	}
	public String getOperaitonName() {
		return operaitonName;
	}
	public void setOperaitonName(String operaitonName) {
		this.operaitonName = operaitonName;
	}
	public String getReworkinfo() {
		return reworkinfo;
	}
	public void setReworkinfo(String reworkinfo) {
		this.reworkinfo = reworkinfo;
	}
	public String getRepairinfo() {
		return repairinfo;
	}
	public void setRepairinfo(String repairinfo) {
		this.repairinfo = repairinfo;
	}
	public String getRejectinfo() {
		return rejectinfo;
	}
	public void setRejectinfo(String rejectinfo) {
		this.rejectinfo = rejectinfo;
	}
}
