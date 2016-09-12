package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class FileInfo {
	

	private String objectState;
	
	private String fileName;
	private String fileType;
	private String fileUrl;
	
	private boolean isMustRead;
	private boolean isReaded;
	private String state;
	private String fileUid;
	private String signer;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date signDate;

	public String getObjectState() {
		return objectState;
	}
	public void setObjectState(String objectState) {
		this.objectState = objectState;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public boolean isMustRead() {
		return isMustRead;
	}
	public void setMustRead(boolean isMustRead) {
		this.isMustRead = isMustRead;
	}
	public boolean isReaded() {
		return isReaded;
	}
	public void setReaded(boolean isReaded) {
		this.isReaded = isReaded;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFileUid() {
		return fileUid;
	}
	public void setFileUid(String fileUid) {
		this.fileUid = fileUid;
	}
	public String getSigner() {
		return signer;
	}
	public void setSigner(String signer) {
		this.signer = signer;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	


}
