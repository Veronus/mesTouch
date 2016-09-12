package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class CheckBillDetail {

	private int objectState;
	
	private String uniqueId;
	private String checkBillUid;
	private int seq;
	
	private String dimensionUid;
	private String dimensionType;
	private String dimensionTypeDesc;
	private String standardValue;
	private double upLimit;
	private double downLimit;
	
	private String materialUsn;  
	private String sn; 
	
	private String actualValue1;
	private String measureToolUid1;
	private String checker1;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date checkTime1;
	
	private String actualValue2;
	private String measureToolUid2;
	private String checker2;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date checkTime2;
	
	private String actualValue;
	private String measureToolUid;
	private String checker;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date checkTime;
	
	private long defectQty;
	private int qualityState;
	private String qualityStateDesc;
	
	private double spcStandardValue;
	
	public double getSpcStandardValue() {
		return spcStandardValue;
	}
	public void setSpcStandardValue(double spcStandardValue) {
		this.spcStandardValue = spcStandardValue;
	}
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
	public String getCheckBillUid() {
		return checkBillUid;
	}
	public void setCheckBillUid(String checkBillUid) {
		this.checkBillUid = checkBillUid;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getDimensionUid() {
		return dimensionUid;
	}
	public void setDimensionUid(String dimensionUid) {
		this.dimensionUid = dimensionUid;
	}
	public String getDimensionType() {
		return dimensionType;
	}
	public void setDimensionType(String dimensionType) {
		this.dimensionType = dimensionType;
	}
	public String getDimensionTypeDesc() {
		return dimensionTypeDesc;
	}
	public void setDimensionTypeDesc(String dimensionTypeDesc) {
		this.dimensionTypeDesc = dimensionTypeDesc;
	}
	public String getStandardValue() {
		return standardValue;
	}
	public void setStandardValue(String standardValue) {
		this.standardValue = standardValue;
	}

	public String getMaterialUsn() {
		return materialUsn;
	}
	public void setMaterialUsn(String materialUsn) {
		this.materialUsn = materialUsn;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getActualValue1() {
		return actualValue1;
	}
	public void setActualValue1(String actualValue1) {
		this.actualValue1 = actualValue1;
	}
	public String getMeasureToolUid1() {
		return measureToolUid1;
	}
	public void setMeasureToolUid1(String measureToolUid1) {
		this.measureToolUid1 = measureToolUid1;
	}
	public String getChecker1() {
		return checker1;
	}
	public void setChecker1(String checker1) {
		this.checker1 = checker1;
	}
	public Date getCheckTime1() {
		return checkTime1;
	}
	public void setCheckTime1(Date checkTime1) {
		this.checkTime1 = checkTime1;
	}
	public String getActualValue2() {
		return actualValue2;
	}
	public void setActualValue2(String actualValue2) {
		this.actualValue2 = actualValue2;
	}
	public String getMeasureToolUid2() {
		return measureToolUid2;
	}
	public void setMeasureToolUid2(String measureToolUid2) {
		this.measureToolUid2 = measureToolUid2;
	}
	public String getChecker2() {
		return checker2;
	}
	public void setChecker2(String checker2) {
		this.checker2 = checker2;
	}
	public Date getCheckTime2() {
		return checkTime2;
	}
	public void setCheckTime2(Date checkTime2) {
		this.checkTime2 = checkTime2;
	}
	public String getActualValue() {
		return actualValue;
	}
	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}
	public String getMeasureToolUid() {
		return measureToolUid;
	}
	public void setMeasureToolUid(String measureToolUid) {
		this.measureToolUid = measureToolUid;
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
	public long getDefectQty() {
		return defectQty;
	}
	public void setDefectQty(long defectQty) {
		this.defectQty = defectQty;
	}
	public int getQualityState() {
		return qualityState;
	}
	public void setQualityState(int qualityState) {
		this.qualityState = qualityState;
	}
	public String getQualityStateDesc() {
		return qualityStateDesc;
	}
	public void setQualityStateDesc(String qualityStateDesc) {
		this.qualityStateDesc = qualityStateDesc;
	}
	public double getUpLimit() {
		return upLimit;
	}
	public void setUpLimit(double upLimit) {
		this.upLimit = upLimit;
	}
	public double getDownLimit() {
		return downLimit;
	}
	public void setDownLimit(double downLimit) {
		this.downLimit = downLimit;
	}


	
	
	

	

	
}