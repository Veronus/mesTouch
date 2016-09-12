package com.shoplink.entity;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class OperationMeasurement {
		
	
	private String objectState;
	
	private String id;
	private String type;	
	private String measureBase;
	
	private float standardValue;	
	private float uBound;      
	private float lBound;      
	private float spcStandardValue;	
	private String uom;   
	
	
	
	public String getObjectState() {
		return objectState;
	}
	public void setObjectState(String objectState) {
		this.objectState = objectState;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMeasureBase() {
		return measureBase;
	}
	public void setMeasureBase(String measureBase) {
		this.measureBase = measureBase;
	}
	public float getStandardValue() {
		return standardValue;
	}
	public void setStandardValue(float standardValue) {
		this.standardValue = standardValue;
	}
	public float getuBound() {
		return uBound;
	}
	public void setuBound(float uBound) {
		this.uBound = uBound;
	}
	public float getlBound() {
		return lBound;
	}
	public void setlBound(float lBound) {
		this.lBound = lBound;
	}
	public float getSpcStandardValue() {
		return spcStandardValue;
	}
	public void setSpcStandardValue(float spcStandardValue) {
		this.spcStandardValue = spcStandardValue;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	

	

}
