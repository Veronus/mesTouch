
var deviceUid = "${param['deviceUid']}";
var employeeId = "${param['employeeId']}";

//2014-10-28
//@Bind view.onReady
!function(self, arg, dsCheckUpRecord,dsWorkRec,dsInvInfo,dsShiftInfo,textEditor_exchangeShift,lbl_takeOverEmployee){
//	var deviceuid = "192168100147";
//	var employeeUid="admin";
//	var fromdateStr = new Date().toString();
//	var fromdate = new Date(fromdateStr);
//	var todateStr = new Date().toString();
//	var todate = new Date(fromdateStr);
//	var fromdateStr = fromdate.getFullYear()+"/"+(fromdate.getMonth()+1)+"/"+"01";
//	var month = fromdate.getMonth()+1;
//	if(month=="1"||month=="3"||month=="5"||month=="7"||month=="8"||month=="10"||month=="12"){
//		//formalized yyyy/MM/dd HH:mm:ss
//		var todateStr = fromdate.getFullYear()+"/"+(fromdate.getMonth()+1)+"/"+"31";
//	}else if(month=="4"||month=="6"||month=="9"||month=="11"){
//		var todateStr = fromdate.getFullYear()+"/"+(fromdate.getMonth()+1)+"/"+"30";
//	}else {
//		var todateStr = fromdate.getFullYear()+"/"+(fromdate.getMonth()+1)+"/"+"28";
//	}
//	if(shiftName=="一班"){
//		shiftId="1";
//	}else if(shiftName=="二班"){
//		shiftId="2";
//	}else {
//		shiftId="3";
//	}
	var btnMain = parent.$id("btnMain").objects[0];
	btnMain.set("userData", {
		employeeId : employeeId
		//deptId : deptId
	});
	dsShiftInfo.set("parameter", {
		deviceUid:deviceUid,//"2140004",
		employeeId:employeeId//"admin",//上一班次
	});	
	dsShiftInfo.flush();
	
	//var takeoverEmployeename = dsShiftInfo.getData().getLast().get("takeoverEmployeeName").toString();
	//	lbl_takeOverEmployee.set("text",takeoverEmployeename);
	if(dsShiftInfo.getData().getLast()!=null){
		var fromdateStr1=dsShiftInfo.getData().getLast().get("shiftTime").toString();
		var fromdate = new Date(fromdateStr1);
		var fromdateStr=fromdate.getFullYear()+"/"+(fromdate.getMonth()+1)+"/"+fromdate.getDate()+" "+fromdate.getHours()+":"+fromdate.getMinutes()+":"+fromdate.getSeconds();
		var todateStr1=new Date().toString();
		var todate = new Date(todateStr1);
		var todateStr = todate.getFullYear()+"/"+(todate.getMonth()+1)+"/"+todate.getDate()+" "+todate.getHours()+":"+todate.getMinutes()+":"+todate.getSeconds();
	
		dsWorkRec.set("parameter", {
			employeeUid:employeeId,
			fromDate:fromdateStr,
			toDate:todateStr
		});	
		dsCheckUpRecord.set("parameter", {
			deviceUid:deviceUid,
		});	
	
		dsCheckUpRecord.flush();
		dsWorkRec.flush();
	}else{
		dorado.MessageBox.alert("请上一班次人员重新登陆完成交班！");
	}

}

//@Bind #textEditor_barcode.onPost
!function(self,arg,dsTakeOverEmployeeInfo){
	var employeeId=self.get("text");
	if(employeeId==null){
		dorado.MessageBox.alert("请输入正确的人员编号！");
	}else{
		dsTakeOverEmployeeInfo.set("parameter", {
			employeeId:employeeId,//刷条码
		});
		dsTakeOverEmployeeInfo.flush();
	}
}


//@Bind #btn_shift.onClick
!function(self,arg, dsWorkRec, dsCheckUpRecord, textEditor_barcode,ajax_updateShiftInfo,dsShiftInfo,dsTakeOverEmployeeInfo,textEditor_exchangeShift,lbl_takeOverEmployee){
	var employeeId = textEditor_barcode.get("text");
	if(employeeId!=""){
		var uniqueid=dsShiftInfo.getData().getLast().get("uniqueId");
		//alert(uniqueid);
		var employeeId = textEditor_barcode.get("text");//刷条码
		var shiftName = textEditor_exchangeShift.get("text");
		var shiftId = "";
		if(shiftName=="一班"){
			shiftId="1";
		}else if(shiftName=="二班"){
			shiftId="2";
		}else {
			shiftId="3";
		}
		//alert(shiftName+"/"+shiftId);
		ajax_updateShiftInfo.set("parameter", {
			deviceUid:deviceUid,
			employeeId:employeeId,
			uniqueId:uniqueid,
			shiftId:shiftId
		});
		dsShiftInfo.set("parameter", {
			deviceUid:deviceUid,
			employeeId:employeeId,
		});	
		ajax_updateShiftInfo.execute(function(){dsShiftInfo.flush();});
		
		var takeoverEmployeename = dsTakeOverEmployeeInfo.getData().current.get("employeeName");
//		//设置用户
//		var labelName = parent.$id("labelName").objects[0];				
//		labelName.set("text", takeoverEmployeename);
		var dsShoplink = parent.$id("dsShoplink").objects[0];
		var data = dsShoplink.getData().current;
		data.set("employeeName", takeoverEmployeename);
		//dsShoplink.post();
		
		var btnMain = parent.$id("btnMain").objects[0];
		btnMain.set("userData", {
			employeeId : employeeId
		});
		
		var fromdateStr1=dsShiftInfo.getData().getLast().get("shiftTime").toString();
		var fromdate = new Date(fromdateStr1);
		var fromdateStr=fromdate.getFullYear()+"/"+(fromdate.getMonth()+1)+"/"+fromdate.getDate()+" "+fromdate.getHours()+":"+fromdate.getMinutes()+":"+fromdate.getSeconds();
		var todateStr1=new Date().toString();
		var todate = new Date(todateStr1);
		var todateStr = todate.getFullYear()+"/"+(todate.getMonth()+1)+"/"+todate.getDate()+" "+todate.getHours()+":"+todate.getMinutes()+":"+todate.getSeconds();

		dsWorkRec.set("parameter", {
			employeeUid:employeeId,
			fromDate:fromdateStr,
			toDate:todateStr
		});	
		dsCheckUpRecord.set("parameter", {
			deviceUid:deviceUid,
		});	

		dsCheckUpRecord.flush();
		dsWorkRec.flush();
	}else{
		dorado.MessageBox.alert("请刷下一班次交班人员员工号！");
	}
		

}