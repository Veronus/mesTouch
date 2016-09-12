package com.shoplink.entity;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ToolClassInfo {
		
	
	private String objectState;
	
	private String classId;
	private String className;
	
	public String getObjectState() {
		return objectState;
	}
	public void setObjectState(String objectState) {
		this.objectState = objectState;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	

	

}
