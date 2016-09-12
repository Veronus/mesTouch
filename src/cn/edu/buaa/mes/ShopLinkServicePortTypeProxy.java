package cn.edu.buaa.mes;

public class ShopLinkServicePortTypeProxy implements cn.edu.buaa.mes.ShopLinkServicePortType {
  private String _endpoint = null;
  private cn.edu.buaa.mes.ShopLinkServicePortType shopLinkServicePortType = null;
  
  public ShopLinkServicePortTypeProxy() {
    _initShopLinkServicePortTypeProxy();
  }
  
  public ShopLinkServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initShopLinkServicePortTypeProxy();
  }
  
  private void _initShopLinkServicePortTypeProxy() {
    try {
      shopLinkServicePortType = (new cn.edu.buaa.mes.ShopLinkServiceLocator()).getshopLinkServiceHttpPort();
      if (shopLinkServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)shopLinkServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)shopLinkServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (shopLinkServicePortType != null)
      ((javax.xml.rpc.Stub)shopLinkServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.edu.buaa.mes.ShopLinkServicePortType getShopLinkServicePortType() {
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType;
  }
  
  public java.lang.String getDeviceStateInfo(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getDeviceStateInfo(in0);
  }
  
  public java.lang.String taskWipInApply(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.taskWipInApply(in0, in1, in2, in3);
  }
  
  public java.lang.String getSpecialTypeList() throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getSpecialTypeList();
  }
  
  public java.lang.String getToolsByParentId(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getToolsByParentId(in0);
  }
  
  public java.lang.String getEmployeeByCardId(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getEmployeeByCardId(in0);
  }
  
  public java.lang.String finishCheckTask(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.finishCheckTask(in0, in1);
  }
  
  public java.lang.String getDeviceStateHistroyInfo(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getDeviceStateHistroyInfo(in0);
  }
  
  public java.lang.String startMaintTask(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.startMaintTask(in0, in1);
  }
  
  public java.lang.String sendShoplinkMessage(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.sendShoplinkMessage(in0, in1, in2, in3);
  }
  
  public java.lang.String getStationWarehouse(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getStationWarehouse(in0);
  }
  
  public java.lang.String getMaterialListByTaskUid(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getMaterialListByTaskUid(in0);
  }
  
  public java.lang.String sendMessage(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.sendMessage(in0, in1, in2, in3, in4, in5);
  }
  
  public java.lang.String getBoxSpecialPartDetail(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getBoxSpecialPartDetail(in0);
  }
  
  public java.lang.String getCheckBillByTaskUid(java.lang.String in0, int in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getCheckBillByTaskUid(in0, in1);
  }
  
  public java.lang.String getDispatchedTasksByDeviceUid(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getDispatchedTasksByDeviceUid(in0);
  }
  
  public java.lang.String saveBoxedResult(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.saveBoxedResult(in0, in1, in2, in3, in4);
  }
  
  public java.lang.String login(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.login(in0, in1);
  }
  
  public java.lang.String taskWipOutApply(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.taskWipOutApply(in0, in1, in2, in3);
  }
  
  public java.lang.String saveBoxDividedResult(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.saveBoxDividedResult(in0, in1);
  }
  
  public java.lang.String getTaskTools(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getTaskTools(in0, in1, in2);
  }
  
  public java.lang.String getStationBoxByDeviceUid(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getStationBoxByDeviceUid(in0);
  }
  
  public java.lang.String getStationToReturnInvInfo(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getStationToReturnInvInfo(in0);
  }
  
  public java.lang.String updateMessageState(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.updateMessageState(in0);
  }
  
  public java.lang.String getUnReadMessagesByEmployeeId(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getUnReadMessagesByEmployeeId(in0);
  }
  
  public java.lang.String updateDeviceCheckupRecord(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.updateDeviceCheckupRecord(in0);
  }
  
  public java.lang.String getWorkType() throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getWorkType();
  }
  
  public java.lang.String getStationToolInvDetail(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getStationToolInvDetail(in0, in1);
  }
  
  public java.lang.String getNonWorkHourByMonth(java.lang.String in0, java.util.Calendar in1, java.util.Calendar in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getNonWorkHourByMonth(in0, in1, in2);
  }
  
  public java.lang.String updateNonWorkHourApplyInfo(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.updateNonWorkHourApplyInfo(in0, in1, in2, in3);
  }
  
  public java.lang.String getProblemType(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getProblemType(in0);
  }
  
  public java.lang.String getTaskWipsSignInfo(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getTaskWipsSignInfo(in0, in1);
  }
  
  public java.lang.String feedbackTask(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.feedbackTask(in0);
  }
  
  public java.lang.String getPersonalOvertimeWork(java.lang.String in0, java.util.Calendar in1, java.util.Calendar in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getPersonalOvertimeWork(in0, in1, in2);
  }
  
  public java.lang.String alertStationSign(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.alertStationSign(in0);
  }
  
  public java.lang.String updateDeviceProblem(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.updateDeviceProblem(in0, in1, in2, in3);
  }
  
  public java.lang.String startCheckTask(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.startCheckTask(in0, in1);
  }
  
  public java.lang.String getToolInvInfoByToolType(java.lang.String in0, java.lang.String in1, int in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getToolInvInfoByToolType(in0, in1, in2);
  }
  
  public java.lang.String getInvIoInfo(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getInvIoInfo(in0);
  }
  
  public java.lang.String getTaskProcessFiles(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getTaskProcessFiles(in0, in1);
  }
  
  public java.lang.String getDeviceCheckupRecord(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getDeviceCheckupRecord(in0);
  }
  
  public java.lang.String stationToolOutApply(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.stationToolOutApply(in0, in1, in2, in3, in4);
  }
  
  public java.lang.String shiftWorkStation(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.shiftWorkStation(in0, in1, in2, in3);
  }
  
  public java.lang.String addSpecialPartBillForWip(int in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.addSpecialPartBillForWip(in0, in1, in2);
  }
  
  public java.lang.String getShiftInfo(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getShiftInfo(in0, in1);
  }
  
  public java.lang.String getWorkReason(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getWorkReason(in0);
  }
  
  public java.lang.String finishMaintTask(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.finishMaintTask(in0, in1);
  }
  
  public java.lang.String getDeviceProblemList() throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getDeviceProblemList();
  }
  
  public java.lang.String getBoxDetailByBoxId(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getBoxDetailByBoxId(in0);
  }
  
  public java.lang.String addBox() throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.addBox();
  }
  
  public java.lang.String getStationInvInfo(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getStationInvInfo(in0, in1);
  }
  
  public java.lang.String getQualityRecByMonth(java.lang.String in0, java.util.Calendar in1, java.util.Calendar in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getQualityRecByMonth(in0, in1, in2);
  }
  
  public java.lang.String saveCheckBills(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.saveCheckBills(in0);
  }
  
  public java.lang.String backToWarehouse(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.backToWarehouse(in0, in1, in2);
  }
  
  public java.lang.String saveSpecialPartBill(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.saveSpecialPartBill(in0, in1);
  }
  
  public java.lang.String getLatestSpecialPartBillForWip(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getLatestSpecialPartBillForWip(in0);
  }
  
  public java.lang.String getSpecialPartDescListByMaterialUsnAndTaskUid(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getSpecialPartDescListByMaterialUsnAndTaskUid(in0, in1, in2);
  }
  
  public java.lang.String writeDeviceCheckupRecord(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.writeDeviceCheckupRecord(in0);
  }
  
  public java.lang.String updateShiftInfo(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.updateShiftInfo(in0, in1, in2, in3);
  }
  
  public java.lang.String getFileUrl(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getFileUrl(in0);
  }
  
  public java.lang.String signMaterialResource(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.signMaterialResource(in0, in1, in2);
  }
  
  public java.lang.String getStationList(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getStationList(in0);
  }
  
  public java.lang.String cancelMaintTask(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.cancelMaintTask(in0, in1);
  }
  
  public java.lang.String updateCheckTaskPlanSend(java.lang.String in0, int in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.updateCheckTaskPlanSend(in0, in1);
  }
  
  public java.lang.String signBoxMaterial(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.signBoxMaterial(in0, in1, in2);
  }
  
  public java.lang.String getSpecialPartDetailByTaskUid(java.lang.String in0, int in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getSpecialPartDetailByTaskUid(in0, in1);
  }
  
  public java.lang.String getDeviceInfoByDeviceUid(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getDeviceInfoByDeviceUid(in0);
  }
  
  public java.lang.String addCheckBillByTaskUid(java.lang.String in0, int in1) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.addCheckBillByTaskUid(in0, in1);
  }
  
  public java.lang.String getBoxDestinationList(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getBoxDestinationList(in0);
  }
  
  public java.lang.String getMaterialByBarcode(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getMaterialByBarcode(in0);
  }
  
  public java.lang.String getToolInvDetail(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getToolInvDetail(in0);
  }
  
  public java.lang.String addMaintTask(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.addMaintTask(in0, in1, in2, in3);
  }
  
  public java.lang.String getTaskWips(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getTaskWips(in0, in1, in2);
  }
  
  public java.lang.String getMessageByDeviceUid(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getMessageByDeviceUid(in0);
  }
  
  public java.lang.String taskToolOutApply(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.taskToolOutApply(in0, in1, in2, in3, in4);
  }
  
  public boolean updatePlanResumeTime(java.lang.String in0, java.lang.String in1, java.util.Calendar in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.updatePlanResumeTime(in0, in1, in2);
  }
  
  public java.lang.String getStationMaterial(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getStationMaterial(in0, in1, in2);
  }
  
  public java.lang.String getEmployeeWorkrecByMonth(java.lang.String in0, java.util.Calendar in1, java.util.Calendar in2) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getEmployeeWorkrecByMonth(in0, in1, in2);
  }
  
  public java.lang.String getTakeOverEmployee(java.lang.String in0) throws java.rmi.RemoteException{
    if (shopLinkServicePortType == null)
      _initShopLinkServicePortTypeProxy();
    return shopLinkServicePortType.getTakeOverEmployee(in0);
  }
  
  
}