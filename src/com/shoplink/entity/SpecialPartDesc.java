package com.shoplink.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialPartDesc {
	
	private int objectState;
	
	private String uniqueId;
	private String specialDetailUid;
	private String materialUsn; 
	private String specialBarcode;
	
	private String specialPartDesc;

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

	public String getSpecialDetailUid() {
		return specialDetailUid;
	}

	public void setSpecialDetailUid(String specialDetailUid) {
		this.specialDetailUid = specialDetailUid;
	}

	public String getMaterialUsn() {
		return materialUsn;
	}

	public void setMaterialUsn(String materialUsn) {
		this.materialUsn = materialUsn;
	}

	public String getSpecialBarcode() {
		return specialBarcode;
	}

	public void setSpecialBarcode(String specialBarcode) {
		this.specialBarcode = specialBarcode;
	}

	public String getSpecialPartDesc() {
		return specialPartDesc;
	}

	public void setSpecialPartDesc(String specialPartDesc) {
		this.specialPartDesc = specialPartDesc;
	} 
	
	
	
}
