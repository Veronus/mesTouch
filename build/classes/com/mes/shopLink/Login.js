
var deviceUid = "${param['deviceUid']}";

//@Bind #editorCardId.onPost
!function(editorCardId, dsEmployee, dsDevice){
	
	var cardId = editorCardId.get("text");
	
	
	dsEmployee.set("parameter", {
		cardId: cardId
		
	});
	
	dsDevice.set("parameter", {
		deviceUid: deviceUid
	});
	dsDevice.flush();
	dsEmployee.flush();	
	var count = dsEmployee.getData().entityCount;
	
	if(count == 1){
		
		var employee = dsEmployee.getData().current;
		var employeeId = employee.get("employeeId");
		var deptId = employee.get("deptId");
		
		var iframe = parent.$id("iframeShopLink").objects[0];
		iframe.set("path","com.mes.shopLink.Main.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);
		
		var btnMain = parent.$id("btnMain").objects[0];
		btnMain.set("visible",true);
		
		//var btnMessage = parent.$id("btnMessage").objects[0];
		//btnMessage.set("visible",true);
		
		var labelDevice = parent.$id("labelDevice").objects[0];
		labelDevice.set("visible",true);
		
		var labelUser = parent.$id("labelUser").objects[0];
		labelUser.set("visible",true);
		
		var labelDate_1 = parent.$id("labelDate_1").objects[0];
		labelDate_1.set("visible",true);
		
		var dsShoplink = parent.$id("dsShoplink").objects[0];
		dsShoplink.insert({
			
			employeeName:employee.get("employeeName"),
			deviceName:dsDevice.getData().current.get("deviceName")
			
		});
		
//		//���õ�ǰ�豸
//		var labelDeviceUid = parent.$id("labelDeviceUid").objects[0];	
//		var deviceName = dsDevice.getData().current.get("deviceName");
//		labelDeviceUid.set("text", deviceName);
//		//labelDeviceUid.set("text", deviceUid);
//		
//		//�����û�
//		var labelName = parent.$id("labelName").objects[0];				
//		labelName.set("text", employee.get("employeeName"));
		
		//��������
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		var dateStr = year + "��" + month + "��" + day + "��";
		var labelDate_2 = parent.$id("labelDate_2").objects[0];
		labelDate_2.set("text", dateStr);
		
	}else{
		
		dorado.MessageBox.alert("Sorry���Ƿ��û�������");
	}
}



//@Bind view.onReady
!function(editorCardId){
	
	editorCardId.setFocus();
	
	
}

//@Bind #btnEnter.onClick
!function(self, formLogin, ajaxLogin){
	
	var infos = formLogin.get("entity");
	
	var employeeId = infos["employeeId"];
	var password = infos["password"];
	
	//alert(password);
	ajaxLogin.set("parameter", {
		employeeId : employeeId,
		password : password
		
	});
	
	ajaxLogin.execute();	
}

//@Bind #eleEmployeeId.onMouseDown
!function(self, formLogin, ajaxLogin){
	
	var infos = formLogin.get("entity");
	
	var employeeId = infos["employeeId"];
	var password = infos["password"];
	
	alert(employeeId);
	
}

//@Bind #ajaxLogin.onSuccess
!function(self, formLogin, dsEmployee, dsDevice){
	
	var result = self.get("returnValue");

	if(result){
		
		var infos = formLogin.get("entity");
		
		var employeeId = infos["employeeId"];		
		dsEmployee.set("parameter", {
			cardId: employeeId
		});
		dsEmployee.flush();	
		
		dsDevice.set("parameter", {
			deviceUid: deviceUid
		});
		dsDevice.flush();
		
		var iframe = parent.$id("iframeShopLink").objects[0];
		iframe.set("path","com.mes.shopLink.Main.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId);
		
		var btnMain = parent.$id("btnMain").objects[0];
		btnMain.set("visible",true);
		
		var labelDevice = parent.$id("labelDevice").objects[0];
		labelDevice.set("visible",true);
		
		var labelUser = parent.$id("labelUser").objects[0];
		labelUser.set("visible",true);
		
		var labelDate_1 = parent.$id("labelDate_1").objects[0];
		labelDate_1.set("visible",true);
		
		//���õ�ǰ�豸
		var labelDeviceUid = parent.$id("labelDeviceUid").objects[0];		
		var deviceName = dsDevice.getData().current.get("deviceName");
		labelDeviceUid.set("text", deviceName);
		
		//��������
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		var dateStr = year + "��" + month + "��" + day + "��";
		var labelDate_2 = parent.$id("labelDate_2").objects[0];
		labelDate_2.set("text", dateStr);
		
		//�����û�
		var labelName = parent.$id("labelName").objects[0];
		var employee = dsEmployee.getData().current;		
		labelName.set("text", employee.get("employeeName"));
		
	}else{
		dorado.widget.NotifyTipManager.notify("�û������������");
	}
	
}