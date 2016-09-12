/**
 * ShopLinkServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.edu.buaa.mes;

public interface ShopLinkServicePortType extends java.rmi.Remote {
    public java.lang.String getDeviceStateInfo(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String taskWipInApply(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException;
    public java.lang.String getSpecialTypeList() throws java.rmi.RemoteException;
    public java.lang.String getToolsByParentId(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getEmployeeByCardId(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String finishCheckTask(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String getDeviceStateHistroyInfo(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String startMaintTask(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String sendShoplinkMessage(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException;
    public java.lang.String getStationWarehouse(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getMaterialListByTaskUid(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String sendMessage(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5) throws java.rmi.RemoteException;
    public java.lang.String getBoxSpecialPartDetail(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getCheckBillByTaskUid(java.lang.String in0, int in1) throws java.rmi.RemoteException;
    public java.lang.String getDispatchedTasksByDeviceUid(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String saveBoxedResult(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException;
    public java.lang.String login(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String taskWipOutApply(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException;
    public java.lang.String saveBoxDividedResult(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String getTaskTools(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException;
    public java.lang.String getStationBoxByDeviceUid(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getStationToReturnInvInfo(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String updateMessageState(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getUnReadMessagesByEmployeeId(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String updateDeviceCheckupRecord(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getWorkType() throws java.rmi.RemoteException;
    public java.lang.String getStationToolInvDetail(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String getNonWorkHourByMonth(java.lang.String in0, java.util.Calendar in1, java.util.Calendar in2) throws java.rmi.RemoteException;
    public java.lang.String updateNonWorkHourApplyInfo(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException;
    public java.lang.String getProblemType(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getTaskWipsSignInfo(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String feedbackTask(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getPersonalOvertimeWork(java.lang.String in0, java.util.Calendar in1, java.util.Calendar in2) throws java.rmi.RemoteException;
    public java.lang.String alertStationSign(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String updateDeviceProblem(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException;
    public java.lang.String startCheckTask(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String getToolInvInfoByToolType(java.lang.String in0, java.lang.String in1, int in2) throws java.rmi.RemoteException;
    public java.lang.String getInvIoInfo(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getTaskProcessFiles(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String getDeviceCheckupRecord(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String stationToolOutApply(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException;
    public java.lang.String shiftWorkStation(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException;
    public java.lang.String addSpecialPartBillForWip(int in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException;
    public java.lang.String getShiftInfo(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String getWorkReason(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String finishMaintTask(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String getDeviceProblemList() throws java.rmi.RemoteException;
    public java.lang.String getBoxDetailByBoxId(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String addBox() throws java.rmi.RemoteException;
    public java.lang.String getStationInvInfo(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String getQualityRecByMonth(java.lang.String in0, java.util.Calendar in1, java.util.Calendar in2) throws java.rmi.RemoteException;
    public java.lang.String saveCheckBills(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String backToWarehouse(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException;
    public java.lang.String saveSpecialPartBill(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String getLatestSpecialPartBillForWip(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getSpecialPartDescListByMaterialUsnAndTaskUid(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException;
    public java.lang.String writeDeviceCheckupRecord(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String updateShiftInfo(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException;
    public java.lang.String getFileUrl(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String signMaterialResource(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException;
    public java.lang.String getStationList(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String cancelMaintTask(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String updateCheckTaskPlanSend(java.lang.String in0, int in1) throws java.rmi.RemoteException;
    public java.lang.String signBoxMaterial(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException;
    public java.lang.String getSpecialPartDetailByTaskUid(java.lang.String in0, int in1) throws java.rmi.RemoteException;
    public java.lang.String getDeviceInfoByDeviceUid(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String addCheckBillByTaskUid(java.lang.String in0, int in1) throws java.rmi.RemoteException;
    public java.lang.String getBoxDestinationList(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getMaterialByBarcode(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String getToolInvDetail(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String addMaintTask(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException;
    public java.lang.String getTaskWips(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException;
    public java.lang.String getMessageByDeviceUid(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String taskToolOutApply(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException;
    public boolean updatePlanResumeTime(java.lang.String in0, java.lang.String in1, java.util.Calendar in2) throws java.rmi.RemoteException;
    public java.lang.String getStationMaterial(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException;
    public java.lang.String getEmployeeWorkrecByMonth(java.lang.String in0, java.util.Calendar in1, java.util.Calendar in2) throws java.rmi.RemoteException;
    public java.lang.String getTakeOverEmployee(java.lang.String in0) throws java.rmi.RemoteException;
}
