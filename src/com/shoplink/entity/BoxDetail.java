package com.shoplink.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class BoxDetail {
	
	private int objectState;
	
	private String uniqueId;		
	private String boxId;
	private String warehouseId;
	private String binId;
	public String materialUsn;
	public String ioQty;
	public String barcode;
	
	private int transferQty;
	private String materialDesc;
	
	private String toBinId;
	private String invIoId;
	
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}
	public int getTransferQty() {
		return transferQty;
	}
	public void setTransferQty(int transferQty) {
		this.transferQty = transferQty;
	}
	public String getUniqueId() {
		return uniqueId;
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
	public String getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
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
	public String getIoQty() {
		return ioQty;
	}
	public void setIoQty(String ioQty) {
		this.ioQty = ioQty;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public String getMaterialDesc() {
		return materialDesc;
	}
	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}
	public String getToBinId() {
		return toBinId;
	}
	public void setToBinId(String toBinId) {
		this.toBinId = toBinId;
	}
	public String getInvIoId() {
		return invIoId;
	}
	public void setInvIoId(String invIoId) {
		this.invIoId = invIoId;
	}
}
