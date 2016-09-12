package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class Message {

	private String messageUid;
	private String topic;
	private String content;
	private int messageState;
	private String messageStateDesc;
	private int messageType;
	private String messageTypeDesc;
	private int messagePriority;
	private String messagePriorityDesc;
	private String sender;
	private String senderName;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date sendTime;
	private String deptId;
	private String deptName;
	
	private String fromDeviceUid;
	
	
	public String getMessageUid() {
		return messageUid;
	}
	public void setMessageUid(String messageUid) {
		this.messageUid = messageUid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMessageState() {
		return messageState;
	}
	public void setMessageState(int messageState) {
		this.messageState = messageState;
	}
	public String getMessageStateDesc() {
		return messageStateDesc;
	}
	public void setMessageStateDesc(String messageStateDesc) {
		this.messageStateDesc = messageStateDesc;
	}
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	public String getMessageTypeDesc() {
		return messageTypeDesc;
	}
	public void setMessageTypeDesc(String messageTypeDesc) {
		this.messageTypeDesc = messageTypeDesc;
	}
	public int getMessagePriority() {
		return messagePriority;
	}
	public void setMessagePriority(int messagePriority) {
		this.messagePriority = messagePriority;
	}
	public String getMessagePriorityDesc() {
		return messagePriorityDesc;
	}
	public void setMessagePriorityDesc(String messagePriorityDesc) {
		this.messagePriorityDesc = messagePriorityDesc;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getFromDeviceUid() {
		return fromDeviceUid;
	}
	public void setFromDeviceUid(String fromDeviceUid) {
		this.fromDeviceUid = fromDeviceUid;
	}
	
}
