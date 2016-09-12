

var deviceUid = "${param['deviceUid']}";
var employeeId = "${param['employeeId']}";
var deptId = "${param['deptId']}";

var iframe = parent.$id("iframeShopLink").objects[0];
var toolBar = parent.$id("tbShopLink").objects[0];
var btnGridorDetail = parent.$id("btnGridorDetail").objects[0];

// @Bind #btnTask.onClick
!function(self, arg){

	//btnGridorDetail.set("visible", true);
	toolBar.set("caption","我的任务");
	iframe.set("path","com.mes.shopLink.MyTaskTouch.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);
}


//@Bind #btnMaterial.onClick
!function(self, arg){
	
	toolBar.set("caption","工位资源");
	iframe.set("path","com.mes.shopLink.StationMaterialInfo.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);

}


//@Bind #btnDevice.onClick
!function(self, arg){
	toolBar.set("caption","工位设备");
	iframe.set("path","com.mes.shopLink.StationDeviceInfo.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);

}


//@Bind #btnShift.onClick
!function(self, arg){

	toolBar.set("caption","交班管理");
	iframe.set("path","com.mes.shopLink.Shift.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);

	
}


//@Bind #btnPerformance.onClick
!function(self, arg){
	
	toolBar.set("caption","人员绩效");
	iframe.set("path","com.mes.shopLink.EmployeePerformance.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);

}