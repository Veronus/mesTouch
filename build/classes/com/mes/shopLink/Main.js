

var deviceUid = "${param['deviceUid']}";
var employeeId = "${param['employeeId']}";
var deptId = "${param['deptId']}";

var iframe = parent.$id("iframeShopLink").objects[0];
var toolBar = parent.$id("tbShopLink").objects[0];
var btnGridorDetail = parent.$id("btnGridorDetail").objects[0];

// @Bind #btnTask.onClick
!function(self, arg){

	//btnGridorDetail.set("visible", true);
	toolBar.set("caption","�ҵ�����");
	iframe.set("path","com.mes.shopLink.MyTaskTouch.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);
}


//@Bind #btnMaterial.onClick
!function(self, arg){
	
	toolBar.set("caption","��λ��Դ");
	iframe.set("path","com.mes.shopLink.StationMaterialInfo.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);

}


//@Bind #btnDevice.onClick
!function(self, arg){
	toolBar.set("caption","��λ�豸");
	iframe.set("path","com.mes.shopLink.StationDeviceInfo.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);

}


//@Bind #btnShift.onClick
!function(self, arg){

	toolBar.set("caption","�������");
	iframe.set("path","com.mes.shopLink.Shift.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);

	
}


//@Bind #btnPerformance.onClick
!function(self, arg){
	
	toolBar.set("caption","��Ա��Ч");
	iframe.set("path","com.mes.shopLink.EmployeePerformance.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);

}