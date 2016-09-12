package com.shoplink.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class InvInfo {
	
	private int objectState;
	private String materialUsn;
	private String partNumber;
	private String partType;
	private String partTypeDesc;
	private String drawingId;
	private String partName;
	private String partDescription;
	private String batchNum;
	private String sn;   
	private float reqQty;
	private float receivedQty;
	private String taskStateDesc;
	private String applyStateDesc;
	private String position;
	private float applyQty;
	private String boxName;
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date planReturnDate;
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date signDate;
	
	//针对任务的需求清单相关属性
	private String invDemandId;
	private String invDemandSeq;
	
	//在制品完成数
	private float completeQty;
	
	//出库申请单状态
	private String ioState;
	
	//库存数
	private float invQty;
	private String warehouseId;
	private String warehouseName;
	private String isWarehouseOK;
	private String binId;
	
	//前置特殊物料描述
	private String materialDesc;
	
	//跟踪类型
	private String trackingType;
	
	//前置任务物料进度
	private float preTaskCompleteQty;
	
	
	
	
	
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
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
	public String getPartType() {
		return partType;
	}
	public void setPartType(String partType) {
		this.partType = partType;
	}
	public String getPartTypeDesc() {
		return partTypeDesc;
	}
	public void setPartTypeDesc(String partTypeDesc) {
		this.partTypeDesc = partTypeDesc;
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
	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public float getReqQty() {
		return reqQty;
	}
	public void setReqQty(float reqQty) {
		this.reqQty = reqQty;
	}
	public float getReceivedQty() {
		return receivedQty;
	}
	public void setReceivedQty(float receivedQty) {
		this.receivedQty = receivedQty;
	}
	public String getTaskStateDesc() {
		return taskStateDesc;
	}
	public void setTaskStateDesc(String taskStateDesc) {
		this.taskStateDesc = taskStateDesc;
	}
	public String getApplyStateDesc() {
		return applyStateDesc;
	}
	public void setApplyStateDesc(String applyStateDesc) {
		this.applyStateDesc = applyStateDesc;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public float getApplyQty() {
		return applyQty;
	}
	public void setApplyQty(float applyQty) {
		this.applyQty = applyQty;
	}
	public String getBoxName() {
		return boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	public Date getPlanReturnDate() {
		return planReturnDate;
	}
	public void setPlanReturnDate(Date planReturnDate) {
		this.planReturnDate = planReturnDate;
	}
	public Date getSignDate() {
		return signDate;
	}
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	public String getInvDemandId() {
		return invDemandId;
	}
	public void setInvDemandId(String invDemandId) {
		this.invDemandId = invDemandId;
	}
	public String getInvDemandSeq() {
		return invDemandSeq;
	}
	public void setInvDemandSeq(String invDemandSeq) {
		this.invDemandSeq = invDemandSeq;
	}
	public float getCompleteQty() {
		return completeQty;
	}
	public void setCompleteQty(float completeQty) {
		this.completeQty = completeQty;
	}
	public String getIoState() {
		return ioState;
	}
	public void setIoState(String ioState) {
		this.ioState = ioState;
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
	public String getMaterialDesc() {
		return materialDesc;
	}
	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}
	public String getTrackingType() {
		return trackingType;
	}
	public void setTrackingType(String trackingType) {
		this.trackingType = trackingType;
	}
	public float getPreTaskCompleteQty() {
		return preTaskCompleteQty;
	}
	public void setPreTaskCompleteQty(float preTaskCompleteQty) {
		this.preTaskCompleteQty = preTaskCompleteQty;
	}
	public String getIsWarehouseOK() {
		return isWarehouseOK;
	}
	public void setIsWarehouseOK(String isWarehouseOK) {
		this.isWarehouseOK = isWarehouseOK;
	}
	public String getBinId() {
		return binId;
	}
	public void setBinId(String binId) {
		this.binId = binId;
	}   
	
	

	

	


}
