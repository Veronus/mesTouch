package com.shoplink.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.shoplink.util.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
public class InvIo {
		
	private int objectState;
	
	private String invIoId;
	private int ioType;
	private String ioTypeDesc;
	private int ioState;
	private String ioStateDesc;
	private String warehouseId;
	//申请者
	private String applyer; 
	private String applyerName; 
	//申请时间
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date applyDate; 
	//库管员
	private String warehouseManager; 
	private String warehouseManagerName; 
	//出库时间
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date ioDate; 
	//周转者
	private String transporter; 
	private String transporterName; 
	//签收者
	private String signer; 
	private String signerName; 
	//签收时间
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	private Date signDate; 
	//接收位置
	private String destinationId;
	
	@XmlElementWrapper
	@XmlElement(name = "invIoDetail")
	private List<InvIoDetail> invIoDetails;
	
	
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}
	public String getInvIoId() {
		return invIoId;
	}
	public void setInvIoId(String invIoId) {
		this.invIoId = invIoId;
	}
	public int getIoType() {
		return ioType;
	}
	public void setIoType(int ioType) {
		this.ioType = ioType;
	}
	public String getIoTypeDesc() {
		return ioTypeDesc;
	}
	public void setIoTypeDesc(String ioTypeDesc) {
		this.ioTypeDesc = ioTypeDesc;
	}
	public int getIoState() {
		return ioState;
	}
	public void setIoState(int ioState) {
		this.ioState = ioState;
	}
	public String getIoStateDesc() {
		return ioStateDesc;
	}
	public void setIoStateDesc(String ioStateDesc) {
		this.ioStateDesc = ioStateDesc;
	}
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getApplyer() {
		return applyer;
	}
	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public String getWarehouseManager() {
		return warehouseManager;
	}
	public void setWarehouseManager(String warehouseManager) {
		this.warehouseManager = warehouseManager;
	}
	public Date getIoDate() {
		return ioDate;
	}
	public void setIoDate(Date ioDate) {
		this.ioDate = ioDate;
	}
	public String getTransporter() {
		return transporter;
	}
	public void setTransporter(String transporter) {
		this.transporter = transporter;
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
	public String getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}
	public String getApplyerName() {
		return applyerName;
	}
	public void setApplyerName(String applyerName) {
		this.applyerName = applyerName;
	}
	public String getWarehouseManagerName() {
		return warehouseManagerName;
	}
	public void setWarehouseManagerName(String warehouseManagerName) {
		this.warehouseManagerName = warehouseManagerName;
	}
	public String getTransporterName() {
		return transporterName;
	}
	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}
	public String getSignerName() {
		return signerName;
	}
	public void setSignerName(String signerName) {
		this.signerName = signerName;
	}
	public List<InvIoDetail> getInvIoDetails() {
		return invIoDetails;
	}
	public void setInvIoDetails(List<InvIoDetail> invIoDetails) {
		this.invIoDetails = invIoDetails;
	}



}
