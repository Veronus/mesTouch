package com.shoplink.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class CheckBill {
		
	private int objectState;
	
	private String checkBillUid;
	private int checkType;
	private String checkTypeDesc;
	private String checkState;
	private String checkStateDesc;
	
	private String billNumber;
	private String drawingId;
	private String partName;
	private String batchnum;
	//工序号
	private String operationNumber;
	//工序名称
	private String operaitonName;
	private String taskUid;
	private String checker;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date checkTime;	
	//本批次零件在制数
	private double planQty;
	//送检数
	private double submitQty;
	//不合格数
	private double defectQty;
	
	@XmlElementWrapper
	@XmlElement(name = "checkBillDetail")
	private List<CheckBillDetail> checkBillDetails;
	
	
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}
	public String getCheckBillUid() {
		return checkBillUid;
	}
	public void setCheckBillUid(String checkBillUid) {
		this.checkBillUid = checkBillUid;
	}
	public int getCheckType() {
		return checkType;
	}
	public void setCheckType(int checkType) {
		this.checkType = checkType;
	}
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public String getDrawingId() {
		return drawingId;
	}
	public void setDrawingId(String drawingId) {
		this.drawingId = drawingId;
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
	public String getTaskUid() {
		return taskUid;
	}
	public void setTaskUid(String taskUid) {
		this.taskUid = taskUid;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public double getPlanQty() {
		return planQty;
	}
	public void setPlanQty(double planQty) {
		this.planQty = planQty;
	}
	public double getSubmitQty() {
		return submitQty;
	}
	public void setSubmitQty(double submitQty) {
		this.submitQty = submitQty;
	}
	public double getDefectQty() {
		return defectQty;
	}
	public void setDefectQty(double defectQty) {
		this.defectQty = defectQty;
	}
	public List<CheckBillDetail> getCheckBillDetails() {
		return checkBillDetails;
	}
	public void setCheckBillDetails(List<CheckBillDetail> checkBillDetails) {
		this.checkBillDetails = checkBillDetails;
	}
	public String getCheckTypeDesc() {
		return checkTypeDesc;
	}
	public void setCheckTypeDesc(String checkTypeDesc) {
		this.checkTypeDesc = checkTypeDesc;
	}
	public String getCheckStateDesc() {
		return checkStateDesc;
	}
	public void setCheckStateDesc(String checkStateDesc) {
		this.checkStateDesc = checkStateDesc;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}


	
	
}
