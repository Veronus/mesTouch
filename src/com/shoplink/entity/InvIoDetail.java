package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class InvIoDetail {

	private int objectState;
	private String uniqueId;
	private String invIoId;
	private int seq;
	private String binId;
	private String materialUsn;
	private String partNumber;
	private String drawingId;
	private String partName;
	private String partDescription;
	private String batchnum;
	private String sn;
	private float applyQty;
	private float ioQty;
	
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date planReturnDate;
	private float returnQty;
	private String turnBoxId;
	private String turnBoxName;
	
	
	
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getInvIoId() {
		return invIoId;
	}
	public void setInvIoId(String invIoId) {
		this.invIoId = invIoId;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getBinId() {
		return binId;
	}
	public void setBinId(String binId) {
		this.binId = binId;
	}
	public String getMaterialUsn() {
		return materialUsn;
	}
	public void setMaterialUsn(String materialUsn) {
		this.materialUsn = materialUsn;
	}
	public String getPartNumber() {
		return partNumber;
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
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getBatchnum() {
		return batchnum;
	}
	public void setBatchnum(String batchnum) {
		this.batchnum = batchnum;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public float getApplyQty() {
		return applyQty;
	}
	public void setApplyQty(float applyQty) {
		this.applyQty = applyQty;
	}
	public float getIoQty() {
		return ioQty;
	}
	public void setIoQty(float ioQty) {
		this.ioQty = ioQty;
	}
	public Date getPlanReturnDate() {
		return planReturnDate;
	}
	public void setPlanReturnDate(Date planReturnDate) {
		this.planReturnDate = planReturnDate;
	}
	public float getReturnQty() {
		return returnQty;
	}
	public void setReturnQty(float returnQty) {
		this.returnQty = returnQty;
	}
	public String getTurnBoxId() {
		return turnBoxId;
	}
	public void setTurnBoxId(String turnBoxId) {
		this.turnBoxId = turnBoxId;
	}
	public String getTurnBoxName() {
		return turnBoxName;
	}
	public void setTurnBoxName(String turnBoxName) {
		this.turnBoxName = turnBoxName;
	}
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}

	
}
