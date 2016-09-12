package com.shoplink.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ToolInvInfo {
	
	
	private String objectState;
	
	private String materialUsn;
	private String partNumber;
	private String partTypeDesc; //类型
	private String partName;
	private String drawingId;
	private String partDescription; //规格
	
	private float reqQty; 
	private float borrowedQty;   
	
	private String applyStatus;
	private float applyQty;
	private String boxUid;
	
	private String toolUid; 
	
	private float invQty; 
	
	private String warehouseId;
	private String warehouseName;
	
	private String totalCount;
	
	private String binId;
	private String binName;
	
	
	public String getObjectState() {
		return objectState;
	}
	public void setObjectState(String objectState) {
		this.objectState = objectState;
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
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getPartTypeDesc() {
		return partTypeDesc;
	}
	public void setPartTypeDesc(String partTypeDesc) {
		this.partTypeDesc = partTypeDesc;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getDrawingId() {
		return drawingId;
	}
	public void setDrawingId(String drawingId) {
		this.drawingId = drawingId;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public float getReqQty() {
		return reqQty;
	}
	public void setReqQty(float reqQty) {
		this.reqQty = reqQty;
	}
	public float getBorrowedQty() {
		return borrowedQty;
	}
	public void setBorrowedQty(float borrowedQty) {
		this.borrowedQty = borrowedQty;
	}
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	public float getApplyQty() {
		return applyQty;
	}
	public void setApplyQty(float applyQty) {
		this.applyQty = applyQty;
	}
	public String getBoxUid() {
		return boxUid;
	}
	public void setBoxUid(String boxUid) {
		this.boxUid = boxUid;
	}
	public String getToolUid() {
		return toolUid;
	}
	public void setToolUid(String toolUid) {
		this.toolUid = toolUid;
	}
	public float getInvQty() {
		return invQty;
	}
	public void setInvQty(float invQty) {
		this.invQty = invQty;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getBinId() {
		return binId;
	}
	public void setBinId(String binId) {
		this.binId = binId;
	}
	public String getBinName() {
		return binName;
	}
	public void setBinName(String binName) {
		this.binName = binName;
	}
	
	
	

	
	

	

	


}
