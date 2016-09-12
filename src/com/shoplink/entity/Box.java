package com.shoplink.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.mes.basicdata.persistence.domain.ClassInformation;

@XmlAccessorType(XmlAccessType.FIELD)
public class Box {
	
	private int objectState;
	
	private String uniqueId;		
	private String boxId;
	private String boxName;
	private String type;
	private String typeDesc;
	public String areaId;
	public String areaName;
	public String boxSize;
	public String boxState;
	
	private String currentBinId;
	
	public int getObjectState() {
		return objectState;
	}

	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getBoxId() {
		return boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public String getBoxName() {
		return boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}


	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getBoxSize() {
		return boxSize;
	}
	public void setBoxSize(String boxSize) {
		this.boxSize = boxSize;
	}

	public String getBoxState() {
		return boxState;
	}

	public void setBoxState(String boxState) {
		this.boxState = boxState;
	}

	public String getCurrentBinId() {
		return currentBinId;
	}

	public void setCurrentBinId(String currentBinId) {
		this.currentBinId = currentBinId;
	}
}
