package com.shoplink.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class InvInfos {
	
	
	@XmlElementWrapper(name = "invInfoList")
	@XmlElement(name = "invInfo")
	private List<InvInfo> invInfoList;

	public List<InvInfo> getInvInfoList() {
		return invInfoList;
	}

	public void setInvInfoList(List<InvInfo> invInfoList) {
		this.invInfoList = invInfoList;
	}
}
