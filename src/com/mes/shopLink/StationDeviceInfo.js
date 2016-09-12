var deviceUid = "${param['deviceUid']}";
var employeeId = "${param['employeeId']}";


//@Bind view.onReady
!function(self,arg, dsCheckUpRecord, dataGrid_checkupRec, ajaxCheckupRec, dsDeviceStateInfo){
	
	var btnMain = parent.$id("btnMain").objects[0];
	btnMain.set("userData", {
		employeeId : employeeId
	});
	
	ajaxCheckupRec.set("parameter", {
		deviceUid:deviceUid
	});
	ajaxCheckupRec.execute();
	
	setTimeout(function(){
		dsCheckUpRecord.set("parameter", {
			deviceUid:deviceUid
		});
		dsCheckUpRecord.flush();
	}, 500);
	
	//dataGrid_checkupRec.set("dataSet","dsCheckUpRecord");
//	var dsDeviceStateInfo = view.get("#dsDeviceStateInfo");
//	var lblDeviceState = view.get("#lblDeviceState");
//	dsDeviceStateInfo.flush();
//	var DeviceState = dsDeviceStateInfo.getData();
//	lblDeviceState.set("text",DeviceState);
}

//2014-10-22
//@Bind #tabControl_device.onCurrentChange
!function(self, arg, btnToRepair, btnRepair, btnObtainCheckUpRecord){
	//alert(self.get("currentTab"))
	//alert(self.get("currentIndex"));
	if(self.get("currentIndex")=="1"){
		btnToRepair.set("visible",true);
		btnRepair.set("visible",true);
		//btnObtainCheckUpRecord.set("visible",false);
		
	}else if(self.get("currentIndex")=="0"){
		btnToRepair.set("visible",false);
		btnRepair.set("visible",false);
		//btnObtainCheckUpRecord.set("visible",true);
	}
//	else {
//		btnToRepair.set("visible",false);
//		btnRepair.set("visible",false);
//		btnObtainCheckUpRecord.set("visible",false);
//	}
}

//@Bind #dsDeviceStateInfo.onLoadData
!function(self, arg, dsDeviceStateInfo, imageDeviceState){
	
	setTimeout(function(){
		var deviceState = dsDeviceStateInfo.getData().current.get("deviceState");
		
		if(deviceState=="运行中"){
			imageDeviceState.set("blankImage", "image/TaskStart.png");
		}else if(deviceState=="暂停中"){
			imageDeviceState.set("blankImage", "image/TaskPause.png");
		}else if(deviceState=="故障中"){
			imageDeviceState.set("blankImage", "image/DeviceFault.png");
		}else if(deviceState=="维修中"){
			imageDeviceState.set("blankImage", "image/DeviceRepair.png");
		}
	}, 200);

	
}

//2014-10-22
//@Bind #btnToRepair.onClick
!function(self,arg){
	view.get("#maintainTypeFloatPanel").show();
}

//2014-11-12
//@Bind #dsDeviceProblem.onLoadData
!function(self,arg){
	self.insert({typeValue:"others",typeDesc:"其它"});
}

//2014-10-22
//增加一条报修记录
//@Bind #maintainTypeConfirm.onClick
!function(self, arg, lblDeviceState,dsDeviceProblem, dsDeviceMainTainRec,dsDeviceStateInfo, ajaxAddMaintainTask, maintainTypeFloatPanel, textEditor_MaintainType){
	var deviceUid ="192168100147";
	var employeeUid=employeeId;//"198107102";
	var problemCode;
	var problemDesc;
	problemCode = dsDeviceProblem.getData().current.get("typeValue");
	problemDesc = dsDeviceProblem.getData().current.get("typeDesc");
//	var DeviceState;
	
	if(textEditor_MaintainType.get("text")!=""){
		ajaxAddMaintainTask.set("parameter", {
		deviceUid:deviceUid,
		employeeUid:employeeUid,
		problemCode:problemCode,
		problemDesc:problemDesc
	});
		
	maintainTypeFloatPanel.hide();
	ajaxAddMaintainTask.execute(function(){
		dsDeviceMainTainRec.flush();
		dsDeviceStateInfo.flush();
		});
	
	}else {
		dorado.MessageBox.alert("请选择正确的故障类型！");
	}
	
}
////2014-10-22
////@Bind #ajaxAddMaintainTask.onSuccess
//!function(self, arg){
//	dorado.MessageBox.alert("maintain task added successfully");
//}

//2014-10-19
//@Bind #maintainTypeCancel.onClick
!function(self, arg, maintainTypeFloatPanel){
	maintainTypeFloatPanel.hide();
}



//2014-10-22
//@Bind #menuStartMaintain.onTap
!function(){
	view.get("#repairFloatPanel").show();
}


//2015-01-16
//@Bind #textEditor_operatorBarCode.onPost
!function(self,arg,lblDeviceState,dsDeviceStateInfo,ajaxStartMaintainTask,ajaxChangeResumeTime,textEditor_operatorBarCode,dateTimePicker_expectedRepair,dsDeviceMainTainRec){
	var employeeUid = textEditor_operatorBarCode.get("text");
	var planFinishStr = dateTimePicker_expectedRepair.get("value").toString();
	var planFinish = new Date(planFinishStr);
	var fromdateStr=planFinish.getFullYear()+"/"+(planFinish.getMonth()+1)+"/"+planFinish.getDate()+" "+planFinish.getHours()+":"+planFinish.getMinutes()+":"+planFinish.getSeconds();
	//alert(fromdateStr);
	if(employeeUid==""){
		dorado.MessageBox.alert("请刷维修人员条码！");
	}else {
		view.get("#repairFloatPanel").hide();
		ajaxStartMaintainTask.set("parameter",{
			deviceUid: deviceUid,
			employeeUid: employeeUid
		});
		ajaxChangeResumeTime.set("parameter",{
			deviceUid: deviceUid,
			employeeUid: employeeUid,
			planFinish: fromdateStr
		})
		ajaxChangeResumeTime.execute(function(){dsDeviceMainTainRec.flush();});
		ajaxStartMaintainTask.execute(function(){
			dsDeviceMainTainRec.flush();
			dsDeviceStateInfo.flush();
		});
	}
}

//2014-10-22
//@Bind #btnStartMaintain.onClick
!function(self,arg,lblDeviceState,dsDeviceStateInfo,ajaxStartMaintainTask,ajaxChangeResumeTime,textEditor_operatorBarCode,dateTimePicker_expectedRepair,dsDeviceMainTainRec){
	var deviceUid = "192168100147";
	//var employeeUid="198210104";
//	var DeviceState;
	var employeeUid = textEditor_operatorBarCode.get("text");
	var planFinishStr = dateTimePicker_expectedRepair.get("value").toString();
	var planFinish = new Date(planFinishStr);
	var fromdateStr=planFinish.getFullYear()+"/"+(planFinish.getMonth()+1)+"/"+planFinish.getDate()+" "+planFinish.getHours()+":"+planFinish.getMinutes()+":"+planFinish.getSeconds();
	//alert(fromdateStr);
	if(employeeUid==""){
		dorado.MessageBox.alert("请刷维修人员条码！");
	}else {
		view.get("#repairFloatPanel").hide();
		ajaxStartMaintainTask.set("parameter",{
			deviceUid: deviceUid,
			employeeUid: employeeUid
		});
		ajaxChangeResumeTime.set("parameter",{
			deviceUid: deviceUid,
			employeeUid: employeeUid,
			planFinish: fromdateStr
		})
		ajaxChangeResumeTime.execute(function(){dsDeviceMainTainRec.flush();});
		ajaxStartMaintainTask.execute(function(){
			dsDeviceMainTainRec.flush();
			dsDeviceStateInfo.flush();
		});
	}
}
//2014-10-23
//完成维修
//@Bind #menuCompleteMaintain.onTap
!function(self,arg,lblDeviceState,ajaxFinishMaintTask,dsDeviceMainTainRec,dsDeviceStateInfo){
	var deviceUid = "192168100147";
	var employeeUid=employeeId;;
	var deviceMainTainRec = dsDeviceMainTainRec.getData().current;
	var maintainer = deviceMainTainRec.get("maintainer");
	if(maintainer!=null){
		ajaxFinishMaintTask.set("parameter",{
			deviceUid: deviceUid,
			employeeUid:employeeUid
		});
		ajaxFinishMaintTask.execute(function(){
			dsDeviceMainTainRec.flush();
			dsDeviceStateInfo.flush();
		});
	}else {
		dorado.MessageBox.alert("请指定维修人员");
	}
	
}
//2014-10-22
//取消维修
//@Bind #menuCancelMaintain.onTap
!function(self,arg,dsDeviceMainTainRec,dsDeviceStateInfo,ajaxCancelMaintainTask){
	var deviceUid = "192168100147";
	var employeeUid=employeeId;;

	ajaxCancelMaintainTask.set("parameter",{
		deviceUid: deviceUid,
		employeeUid: employeeUid
	});
	ajaxCancelMaintainTask.execute(function(){
		dsDeviceStateInfo.flush();
		dsDeviceMainTainRec.flush();
	});
}


////@Bind #ajaxChangeResumeTime.onSuccess
//!function(){
//	dorado.MessageBox.alert("Plan maintainTme ");
//}
////@Bind #ajaxStartMaintainTask.onSuccess
//!function(){
//	dorado.MessageBox.alert("maintain task started ");
//}

//@Bind #btnCancelMaintain.onClick
!function(self,arg){
	view.get("#repairFloatPanel").hide();
}
////@Bind #ajaxCancelMaintainTask.onSuccess
//!function(){
//	dorado.MessageBox.alert("maintain task cancelled ");
//}

//2014-10-20
//@Bind #btnObtainCheckUpRecord.onClick
!function(self, arg, dsCheckUpRecord, dataGrid_checkupRec, ajaxCheckupRec){
	var deviceuid = "192168100147";
	
	dsCheckUpRecord.set("parameter", {
		deviceUid:deviceuid
	});
	
	ajaxCheckupRec.set("parameter", {
		deviceUid:deviceuid
	});
	ajaxCheckupRec.execute();
	dsCheckUpRecord.flush();
	dataGrid_checkupRec.set("dataSet","dsCheckUpRecord");
	
}
////2014-10-20
////@Bind #ajaxCheckupRec.onSuccess
//!function(self, arg, dsCheckUpRecord){
//	dorado.MessageBox.alert("Checkup Tasks Inserted ");
//}

////2014-10-24
////@Bind #dataGrid_checkupRec.onCreate
//!function(self,arg,dataGrid_checkupRec, dsCheckUpRecord, dsCheckupRecFeedback, updateCheckupRec){
//	self.getColumn("op").set("renderer", new dorado.SmartRenderer({
//		template: "<button d-on='tap: changeNormal()'>normal</button><button d-on='tap: changeAbnormal()'>abnormal</button>",
//		listener: {
//			changeNormal: function() {
//				this.entity.set("checkResults", "normal");
//				var deviceUid = "192168100147";
//				var employeeUid="198107102";
//				var checkupDateStr = new Date().toString();
//				var checkupDate = new Date(checkupDateStr);
//				//formalized yyyy/MM/dd HH:mm:ss
//				var checkupTimeStr = checkupDate.getFullYear()+"/"+(checkupDate.getMonth()+1)+"/"+checkupDate.getDate()+" "+checkupDate.getHours()+":"+checkupDate.getMinutes()+":"+checkupDate.getSeconds();
//				//dsCheckUpRecord.flush();
//				dsCheckupRecFeedback.insert();
//				var checkUpRecordFeedback = dsCheckupRecFeedback.getData().current;
//				checkUpRecordFeedback.set("checkResults", "0");
//				checkUpRecordFeedback.set("checker",employeeUid);
//				checkUpRecordFeedback.set("checkTime",checkupTimeStr);
//				checkUpRecordFeedback.set("uniqueid",dsCheckUpRecord.getData().current.get("uniqueid"));
//				alert(dsCheckUpRecord.getData().current.get("uniqueid"));
//				
//				dsCheckUpRecord.set("parameter", {
//					deviceUid:deviceUid
//				});
//				//updateCheckupRec.execute(function(){dsCheckUpRecord.flush();});
//				dsCheckUpRecord.flush();
//				alert(dsCheckUpRecord.getData().current.get("checkResults"));
//				dataGrid_checkupRec.set("dataSet","dsCheckUpRecord");
//			},
//			changeAbnormal: function() {
//				this.entity.set("checkResults", "abnormal"); 
//			}
//		}
//	}));
//}

//2014-10-21
//@Bind #btn_normal.onClick
//@Bind #btn_abnormal.onClick
!function(self, arg, dsEmployeeInfo, dataGrid_checkupRec, dsCheckUpRecord, dsCheckupRecFeedback, updateCheckupRec){
	
	dsEmployeeInfo.set("parameter", {
		employeeId:employeeId
	});
	dsEmployeeInfo.flush();
//	dsCheckUpRecord.set("parameter", {
//		deviceUid:deviceUid
//	});
//	dsCheckUpRecord.flush();
	var checkerName = dsEmployeeInfo.getData().current.get("employeeName");
	var checkupDateStr = new Date().toString();
	var checkupDate = new Date(checkupDateStr);
	//formalized yyyy/MM/dd HH:mm:ss
	var checkupTimeStr = checkupDate.getFullYear()+"-"+(checkupDate.getMonth()+1)+"-"+checkupDate.getDate()+" "+checkupDate.getHours()+":"+checkupDate.getMinutes()+":"+checkupDate.getSeconds();
	//dsCheckUpRecord.flush();
	dsCheckupRecFeedback.insert();
	
	var checkUpRecordFeedback = dsCheckupRecFeedback.getData();
	//checkUpRecordFeedback.clearData();
	var checkuprecordlist = dsCheckUpRecord.getData();//getData()返回一个EntityList，没有set方法
	var checkResults;
	var checkResultsFeedBack;
	
//	if(self.get("userData")=="1"){
//		checkResults="正常";
//		checkResultsFeedBack="1";
//		checkUpRecordFeedback.set("checkResults", checkResultsFeedBack);
//		checkuprecord.set("checkResults",checkResults);
//	}else {
//		checkResults="异常";
//		checkResultsFeedBack="0";
//		checkUpRecordFeedback.set("checkResults", checkResultsFeedBack);
//		checkuprecord.set("checkResults",checkResults);
//	}
//	checkuprecord.set("checker",checkerName);
//	checkuprecord.set("checkTime",checkupTimeStr);

	/**********************************批处理方法**********************************/
	var checkupRecList = dataGrid_checkupRec.get("selection");
	
	if(checkupRecList == ""){
		dorado.widget.NotifyTipManager.notify("请先勾选需要点检的设备!");
		return;
	}else{
		checkupRecList.each(
				function(entity){
					
					if(self.get("userData")=="1"){
						checkResults="正常";
						checkResultsFeedBack="1";
						//checkUpRecordFeedback.set("checkResults", checkResultsFeedBack);
						entity.set("checkResults",checkResults);
					}else {
						checkResults="异常";
						checkResultsFeedBack="0";
						//checkUpRecordFeedback.set("checkResults", "0");
						entity.set("checkResults",checkResults);
					}
//					alert(checkResultsFeedBack);
					
					entity.set("checker",checkerName);
					entity.set("checkTime",checkupTimeStr);

					var checkUpRecFeedback = {
							$dataType : "CheckUpRecFeedback",
							checker:employeeId,
							checkTime:checkupTimeStr,
							checkResults:checkResultsFeedBack,
							uniqueid:entity.get("uniqueid")
					};
					checkUpRecordFeedback.insert(checkUpRecFeedback);
				}
		);
//		alert(checkUpRecordFeedback);
	}
	updateCheckupRec.execute(function(){
	});
	//dataGrid_checkupRec.set("dataSet","dsCheckUpRecord");
	
}

////@Bind #updateCheckupRec.onSuccess
//!function(self,arg){
//	dorado.MessageBox.alert("update successfully");
//}

