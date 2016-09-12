package com.shoplink.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class CheckUpRecFeedback {
	private int objectState;
	
	private String uniqueid;
	private String sn;  
	private String content;
	private String method;
	private String checker;
	private String checkTime;
	
	private String checkResults;


	public int getObjectState() {
		return objectState;
	}

	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}

	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}


	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckResults() {
		return checkResults;
	}

	public void setCheckResults(String checkResults) {
		this.checkResults = checkResults;
	}

	
}
