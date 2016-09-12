package com.shoplink.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialBillDetail {
	
	private int objectState;
	private String uniqueId;
	private String specialBillUid;
	private int seq;
	private String drawingId;
	private String partName;
	private String materialUsn; 
	private String sn;
	private float specialQty;
	
	private String specialBarcode;
	private String boxId;
	
	private int specialType;
	private String materialDesc;
	
	@Override
	public String toString() {
		return partName+" "+drawingId+" "+specialQty;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SpecialBillDetail)) {
			return false;
		}
		SpecialBillDetail o = (SpecialBillDetail) obj;
		if ((materialDesc == null && o.materialDesc!=null) || !materialDesc.equals(o.materialDesc)) {
			return false;
		} 
		return true;
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
	public String getSpecialBillUid() {
		return specialBillUid;
	}
	public void setSpecialBillUid(String specialBillUid) {
		this.specialBillUid = specialBillUid;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getDrawingId() {
		return drawingId;
	}
	public void setDrawingId(String drawingId) {
		this.drawingId = drawingId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
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
	public String getMaterialDesc() {
		return materialDesc;
	}
	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	public float getSpecialQty() {
		return specialQty;
	}

	public void setSpecialQty(float specialQty) {
		this.specialQty = specialQty;
	}

	public String getSpecialBarcode() {
		return specialBarcode;
	}

	public void setSpecialBarcode(String specialBarcode) {
		this.specialBarcode = specialBarcode;
	}

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public int getSpecialType() {
		return specialType;
	}

	public void setSpecialType(int specialType) {
		this.specialType = specialType;
	}
	
	
}
