package com.shoplink.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.shoplink.entity.InvInfo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Entities {
	
	
	@XmlElementWrapper(name = "invInfoList")
	@XmlElement(name = "invInfo")
	private List<InvInfo> invInfoList;
	
	@XmlElementWrapper(name = "checkBillList")
	@XmlElement(name = "checkBill")
	private List<CheckBill> checkBillList;
	
	@XmlElementWrapper(name = "employeeList")
	@XmlElement(name = "employee")
	private List<Employee> employeeList;
	
	@XmlElementWrapper(name = "fileInfoList")
	@XmlElement(name = "fileInfo")
	private List<FileInfo> fileInfoList;
	
	@XmlElementWrapper(name = "invIoList")
	@XmlElement(name = "invIo")
	private List<InvIo> invIoList;
	
	@XmlElementWrapper(name = "materialList")
	@XmlElement(name = "material")
	private List<Material> materialList;
	
	@XmlElementWrapper(name = "messageList")
	@XmlElement(name = "message")
	private List<Message> messageList;
	
	@XmlElementWrapper(name = "taskList")
	@XmlElement(name = "task")
	private List<Task> taskList;
	
	@XmlElementWrapper(name = "takeoveremployeeList")
	@XmlElement(name = "takeoveremployee")
	private List<TakeOverEmployeeInfo> takeoveremployeeList;
	
	@XmlElementWrapper(name = "toolClassInfoList")
	@XmlElement(name = "toolClassInfo")
	private List<ToolClassInfo> toolClassInfoList;
	
	@XmlElementWrapper(name = "toolInvInfoList")
	@XmlElement(name = "toolInvInfo")
	private List<ToolInvInfo> toolInvInfoList;
	
	@XmlElementWrapper(name = "warehouseList")
	@XmlElement(name = "warehouse")
	private List<Warehouse> warehouseList;
	
	@XmlElementWrapper(name = "workStationList")
	@XmlElement(name = "workStation")
	private List<WorkStation> workStationList;
	
	@XmlElementWrapper(name = "checkupRecList")
	@XmlElement(name = "checkupRec")
	private List<CheckupRec> checkupRecList;
	
	@XmlElementWrapper(name = "checkupRecFeedbackList")
	@XmlElement(name = "checkupRecFeedback")
	private List<CheckUpRecFeedback> checkupRecFeedbackList;
	
	@XmlElementWrapper(name = "deviceList")
	@XmlElement(name = "device")
	private List<Device> deviceList;
	
	@XmlElementWrapper(name = "deviceMainTainRecList")
	@XmlElement(name = "deviceMainTainRec")
	private List<DeviceMainTainRec> deviceMainTainRecList;
	
	@XmlElementWrapper(name = "deviceProblemList")
	@XmlElement(name = "deviceProblem")
	private List<DeviceProblem> deviceProblemList;
	
	@XmlElementWrapper(name = "deviceStateInfoList")
	@XmlElement(name = "deviceStateInfo")
	private List<DeviceStateInfo> deviceStateInfoList;
	
	@XmlElementWrapper(name = "maintainTaskList")
	@XmlElement(name = "maintainTask")
	private List<MaintainTask> maintainTaskList;
	
	@XmlElementWrapper(name = "sumWorkList")
	@XmlElement(name = "sumWork")
	private List<SumWork> sumWorkList;
	
	@XmlElementWrapper(name = "sumWorkRecList")
	@XmlElement(name = "sumWorkRec")
	private List<SumWorkRec> sumWorkRecList;
	
	@XmlElementWrapper(name = "typesDataList")
	@XmlElement(name = "typesData")
	private List<TypesData> typesDataList;
	
	@XmlElementWrapper(name = "workrecList")
	@XmlElement(name = "workRec")
	private List<WorkRec> workrecList;
	
	@XmlElementWrapper(name = "qualityRecList")
	@XmlElement(name = "qualityRec")
	private List<QualityRec> qualityRecList;
	
	@XmlElementWrapper(name = "nonWorkHourList")
	@XmlElement(name = "nonWorkHour")
	private List<NonWorkHour> nonWorkHourList;
	
	@XmlElementWrapper(name = "shiftInfoList")
	@XmlElement(name = "shiftInfo")
	private List<ShiftInfo> shiftInfoList;
	
	@XmlElementWrapper(name = "boxDetailList")
	@XmlElement(name = "boxDetail")
	private List<BoxDetail> boxDetailList;
	
	@XmlElementWrapper(name = "boxList")
	@XmlElement(name = "box")
	private List<Box> boxList;
	
	@XmlElementWrapper(name = "specialPartList")
	@XmlElement(name = "specialPart")
	private List<SpecialBill> specialPartList;
	
	@XmlElementWrapper(name = "specialPartDescList")
	@XmlElement(name = "specialPartDesc")
	private List<SpecialPartDesc> specialPartDescList;

	public List<InvInfo> getInvInfoList() {
		return invInfoList;
	}

	public void setInvInfoList(List<InvInfo> invInfoList) {
		this.invInfoList = invInfoList;
	}
	

	public List<CheckBill> getCheckBillList() {
		return checkBillList;
	}

	public void setCheckBillList(List<CheckBill> checkBillList) {
		this.checkBillList = checkBillList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<FileInfo> getFileInfoList() {
		return fileInfoList;
	}

	public void setFileInfoList(List<FileInfo> fileInfoList) {
		this.fileInfoList = fileInfoList;
	}

	public List<InvIo> getInvIoList() {
		return invIoList;
	}

	public void setInvIoList(List<InvIo> invIoList) {
		this.invIoList = invIoList;
	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public List<TakeOverEmployeeInfo> getTakeoveremployeeList() {
		return takeoveremployeeList;
	}

	public void setTakeoveremployeeList(
			List<TakeOverEmployeeInfo> takeoveremployeeList) {
		this.takeoveremployeeList = takeoveremployeeList;
	}

	public List<ToolClassInfo> getToolClassInfoList() {
		return toolClassInfoList;
	}

	public void setToolClassInfoList(List<ToolClassInfo> toolClassInfoList) {
		this.toolClassInfoList = toolClassInfoList;
	}

	public List<ToolInvInfo> getToolInvInfoList() {
		return toolInvInfoList;
	}

	public void setToolInvInfoList(List<ToolInvInfo> toolInvInfoList) {
		this.toolInvInfoList = toolInvInfoList;
	}

	public List<Warehouse> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<Warehouse> warehouseList) {
		this.warehouseList = warehouseList;
	}

	public List<WorkStation> getWorkStationList() {
		return workStationList;
	}

	public void setWorkStationList(List<WorkStation> workStationList) {
		this.workStationList = workStationList;
	}

	public List<CheckupRec> getCheckupRecList() {
		return checkupRecList;
	}

	public void setCheckupRecList(List<CheckupRec> checkupRecList) {
		this.checkupRecList = checkupRecList;
	}

	public List<CheckUpRecFeedback> getCheckupRecFeedbackList() {
		return checkupRecFeedbackList;
	}

	public void setCheckupRecFeedbackList(
			List<CheckUpRecFeedback> checkupRecFeedbackList) {
		this.checkupRecFeedbackList = checkupRecFeedbackList;
	}

	public List<Device> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}

	public List<DeviceMainTainRec> getDeviceMainTainRecList() {
		return deviceMainTainRecList;
	}

	public void setDeviceMainTainRecList(
			List<DeviceMainTainRec> deviceMainTainRecList) {
		this.deviceMainTainRecList = deviceMainTainRecList;
	}

	public List<DeviceProblem> getDeviceProblemList() {
		return deviceProblemList;
	}

	public List<DeviceStateInfo> getDeviceStateInfoList() {
		return deviceStateInfoList;
	}

	public void setDeviceStateInfoList(List<DeviceStateInfo> deviceStateInfoList) {
		this.deviceStateInfoList = deviceStateInfoList;
	}

	public void setDeviceProblemList(List<DeviceProblem> deviceProblemList) {
		this.deviceProblemList = deviceProblemList;
	}

	public List<MaintainTask> getMaintainTaskList() {
		return maintainTaskList;
	}

	public void setMaintainTaskList(List<MaintainTask> maintainTaskList) {
		this.maintainTaskList = maintainTaskList;
	}

	public List<SumWork> getSumWorkList() {
		return sumWorkList;
	}

	public void setSumWorkList(List<SumWork> sumWorkList) {
		this.sumWorkList = sumWorkList;
	}

	public List<SumWorkRec> getSumWorkRecList() {
		return sumWorkRecList;
	}

	public void setSumWorkRecList(List<SumWorkRec> sumWorkRecList) {
		this.sumWorkRecList = sumWorkRecList;
	}

	public List<TypesData> getTypesDataList() {
		return typesDataList;
	}

	public void setTypesDataList(List<TypesData> typesDataList) {
		this.typesDataList = typesDataList;
	}

	public List<WorkRec> getWorkrecList() {
		return workrecList;
	}

	public void setWorkrecList(List<WorkRec> workrecList) {
		this.workrecList = workrecList;
	}

	public List<QualityRec> getQualityRecList() {
		return qualityRecList;
	}

	public void setQualityRecList(List<QualityRec> qualityRecList) {
		this.qualityRecList = qualityRecList;
	}

	public List<NonWorkHour> getNonWorkHourList() {
		return nonWorkHourList;
	}

	public void setNonWorkHourList(List<NonWorkHour> nonWorkHourList) {
		this.nonWorkHourList = nonWorkHourList;
	}

	public List<ShiftInfo> getShiftInfoList() {
		return shiftInfoList;
	}

	public void setShiftInfoList(List<ShiftInfo> shiftInfoList) {
		this.shiftInfoList = shiftInfoList;
	}

	public List<BoxDetail> getBoxDetailList() {
		return boxDetailList;
	}

	public void setBoxDetailList(List<BoxDetail> boxDetailList) {
		this.boxDetailList = boxDetailList;
	}

	public List<Box> getBoxList() {
		return boxList;
	}

	public void setBoxList(List<Box> boxList) {
		this.boxList = boxList;
	}
	
	public List<SpecialBill> getSpecialPartList() {
		return specialPartList;
	}

	public void setSpecialPartList(List<SpecialBill> specialPartList) {
		this.specialPartList = specialPartList;
	}

	public List<SpecialPartDesc> getSpecialPartDescList() {
		return specialPartDescList;
	}

	public void setSpecialPartDescList(List<SpecialPartDesc> specialPartDescList) {
		this.specialPartDescList = specialPartDescList;
	}



}
