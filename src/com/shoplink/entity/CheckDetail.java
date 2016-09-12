package com.shoplink.entity;

import java.sql.Date;

public class CheckDetail {
		

	private String objectState;
	
	private String measureItemUid;
	private String materialUsn;   //零件编号
	private String actualValue;
	private String toolUid;
	
	
	public String getObjectState() {
		return objectState;
	}
	public void setObjectState(String objectState) {
		this.objectState = objectState;
	}
	public String getMeasureItemUid() {
		return measureItemUid;
	}
	public void setMeasureItemUid(String measureItemUid) {
		this.measureItemUid = measureItemUid;
	}
	public String getMaterialUsn() {
		return materialUsn;
	}
	public void setMaterialUsn(String materialUsn) {
		this.materialUsn = materialUsn;
	}
	public String getActualValue() {
		return actualValue;
	}
	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}
	public String getToolUid() {
		return toolUid;
	}
	public void setToolUid(String toolUid) {
		this.toolUid = toolUid;
	}
	

	

	
}