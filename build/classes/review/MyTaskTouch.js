//全局变量
var deviceUid = "${param['deviceUid']}";
var employeeId = "${param['employeeId']}";
var deptId = "005260"; //"${param['deptId']}";

var invIoId = "2656961";



// @Bind view.onReady
!function(self, dsTasks){
	
	var btnMain = parent.$id("btnMain").objects[0];
	btnMain.set("userData", {
		employeeId : employeeId,
		deptId : deptId
	});
	
	//alert(employeeId);
	
	view.get("#dsForm").insert();
		
}

//@Bind #carouselTask.onCurrentChange
!function(self, dsTasks, tbTaskInfo){
	
	var index = self.get("currentIndex");
	var currentIndex = self.get("userData");
	
	//var tbShopLink = parent.$id("tbShopLink").objects[0];
	
	if(index > currentIndex){
		dsTasks.getData().next();
		
		var task = dsTasks.getData().current;
		var drawingId = task.get("drawingId");
		var partName = task.get("partName");
		var batchNum = task.get("batchNum");
		var operationIdDesc = task.get("operationIdDesc");
				
		tbTaskInfo.set("caption", drawingId + "/" + partName + "/" + batchNum + "/" + operationIdDesc);
		
	}else if(index < currentIndex){
		dsTasks.getData().previous();
		
		var task = dsTasks.getData().current;
		var drawingId = task.get("drawingId");
		var partName = task.get("partName");
		var batchNum = task.get("batchNum");
		var operationIdDesc = task.get("operationIdDesc");
				
		tbTaskInfo.set("caption", drawingId + "/" + partName + "/" + batchNum + "/" + operationIdDesc);
	}
	self.set("userData", index);

	var c = self.get("currentItem");
	var autoform1 = view.get("#autoForm1");
	c.addChild(autoform1);

}

//@Bind #carouselTask.onReady
!function(self, dsTasks, tbTaskInfo){
	
	dsTasks.set("parameter", {
        deviceUid: deviceUid
	});
	dsTasks.flush();
	
	
	
	var count = dsTasks.getData().entityCount;
	//alert(count);
	var c = new Array();
	var i = 0;

	if(count > 0){
		
		var task = dsTasks.getData().current;
		var drawingId = task.get("drawingId");
		var partName = task.get("partName");
		var batchNum = task.get("batchNum");
		var operationIdDesc = task.get("operationIdDesc");
		
		//var tbShopLink = parent.$id("tbShopLink").objects[0];
		
		tbTaskInfo.set("caption",  drawingId + "/" + partName + "/" + batchNum + "/" + operationIdDesc);
		
		for(i = 0; i < count; i++){
			c[i] = new dorado.widget.Container();
		}
		
	}else{
		
		tbTaskInfo.set("caption",  "当前设备无任务");
		
		c[0] = new dorado.widget.Container();
		self.addItem(c[0]);
	}

	var autoform1 = view.get("#autoForm1");
	autoform1.set("visible", true);
	c[0].addChild(autoform1);

	for(i = 0; i < count; i++){
		self.addItem(c[i]);
	}

	//self.set("userData", 0);
}

// @Bind #btnRatio.onClick
!function(self, arg){
	var btnRatio = view.get("#btnRatio");
	if(btnRatio.get("userData") == "1"){
		btnRatio.set("userData", "0.1");
	}else if(btnRatio.get("userData") == "0.1"){
		btnRatio.set("userData", "0.01");
	}else if(btnRatio.get("userData") == "0.01"){
		btnRatio.set("userData", "1");
	}
	var ratio = btnRatio.get("userData");
	
	view.get("#btnAdd1").set("caption", "+" + 1*ratio);
	view.get("#btnMinus1").set("caption", "-" + 1*ratio);
	view.get("#btnAdd5").set("caption", "+" + 5*ratio);
	view.get("#btnMinus5").set("caption", "-" + 1*ratio);
}

//@Bind #btnAdd1.onClick
//@Bind #btnMinus1.onClick
//@Bind #btnAdd5.onClick
//@Bind #btnMinus5.onClick
!function(self, arg){
	var btnFeedBack = view.get("#btnFeedBack");
	var feedbackQty = btnFeedBack.get("userData");
	if(feedbackQty == null || feedbackQty == ""){
		feedbackQty = 0;
	}
	//alert(feedbackQty);
	feedbackQty = feedbackQty + parseFloat(self.get("caption"));
	btnFeedBack.set("userData", feedbackQty);
	btnFeedBack.set("badgeText", feedbackQty);
}

//@Bind #btnFeedBack.onClick
!function(self, arg){
	feedBackTask(self, 1);
}

// @Bind #menuStartTask.onTap
// @Bind #menuFinishPrepare.onTap
// @Bind #menuFinishFirstWip.onTap
// @Bind #menuFinishFirstCheck.onTap
// @Bind #menuFinishSecondCheck.onTap
// @Bind #menuFinishThirdCheck.onTap
// @Bind #menuNormalProcessing.onTap
//@Bind #btnPauseTask.onClick
//@Bind #btnInterruptTask.onClick
!function(self, arg, touchMenuState){
	//touchMenuState.hide();
	//alert(self.get("userData"));
	feedBackTask(self, self.get("userData"));
		
}

function feedBackTask(control, worktype){
	var btnFeedBack = view.get("#btnFeedBack");
	var dsTasks = view.get("#dsTasks");
	var task = dsTasks.getData().current;
	var dsWorkrec = view.get("#dsWorkRec");
	
	//alert(dsWorkrec.getData().entityCount);
	dsWorkrec.insert();
	var workrec = dsWorkrec.getData().current;
	workrec.set("taskUid", task.get("taskUid"));
	workrec.set("assnUid", task.get("assnUid"));
	workrec.set("worker", employeeId);
	workrec.set("deviceUid", deviceUid);
	workrec.set("workType", worktype);
	
	var feedbackQty = btnFeedBack.get("userData");
	
	if(worktype == 1){
		
		workrec.set("sn", "0");
		workrec.set("completeQty", feedbackQty);
		workrec.set("preOpTime", task.get("preOpTime"));
		workrec.set("runTime", task.get("runTime"));
	}
	
	view.get("#updateFeedBack").execute(function(){
		
		//dsTasks.flush();
		if(control.get("id") == "btnInterruptTask"){
			task.set("taskStateDesc", "中断");
			
		}else if(control.get("id") == "btnPauseTask"){
			task.set("taskStateDesc", "已暂停");
			
		}else if(control.get("id") == "menuStartTask"){
			task.set("taskStateDesc", "已开始");
			
			var dsTasksTemp = view.get("#dsTasksTemp");
			dsTasksTemp.set("parameter", {
		        deviceUid: deviceUid
			});
			dsTasksTemp.flush();
			
			var taskTempList = dsTasksTemp.getData();
			
			taskTempList.each(function(entity){
				
				if(entity.get("taskUid") == task.get("taskUid")){
					
					var actualStart = entity.get("actualStart");
					
					task.set("actualStart", actualStart);

				}
			});
			
//			var startTime = (new Date()).Format("yyyy-MM-dd hh:mm:ss");
//			task.set("actualStart", startTime);
			
		}else if(control.get("id") == "menuFinishPrepare"){
			task.set("taskStateDesc", "已就绪");
			
		}else if(control.get("id") == "menuFinishFirstWip"){
			task.set("taskStateDesc", "首件加工完成");
			
		}else if(control.get("id") == "menuFinishFirstCheck"){
			task.set("taskStateDesc", "一检完成");
			
		}
		else if(control.get("id") == "menuFinishSecondCheck"){
			task.set("taskStateDesc", "二检完成");
			
		}else if(control.get("id") == "menuFinishThirdCheck"){
			task.set("taskStateDesc", "三检完成");
			
		}else if(control.get("id") == "menuNormalProcessing"){
			task.set("taskStateDesc", "预计完工送检");
			
		}else if(control.get("id") == "btnFeedBack"){
			
			var completeQty = task.get("completeQty") + feedbackQty;			
			task.set("completeQty", completeQty);
			
		}
		
	});
	
	
}

//@Bind #updateFeedBack.onSuccess
!function(btnFeedBack){
	btnFeedBack.set("badgeText", 0);
	btnFeedBack.set("userData", 0);
}

//@Bind #btnRefresh.onClick
!function(self, arg, carouselTask){

	var iframe = parent.$id("iframeShopLink").objects[0];	
	if(iframe.get("userData") == 0){
		iframe.set("path","com.mes.shopLink.Task.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);
		iframe.set("userData", 1);
	}
	
}

//@Bind #tabButton2.onClick
!function(dsTaskWip, dsTasks){
	var task = dsTasks.getData().current;
	dsTaskWip.set("parameter", {
		taskUid: task.get("taskUid"),
        assnUid: task.get("assnUid"),
        deviceUid: deviceUid
	});
	dsTaskWip.flush();
}

//@Bind #tabButton3.onClick
!function(dsTaskTool, dsTasks){
	var task = dsTasks.getData().current;
	dsTaskTool.set("parameter", {
		taskUid: task.get("taskUid"),
        deviceUid: deviceUid,
        toolType: "all" //第一次加载为all
	});
	
	dsTaskTool.flush();
}
//@Bind #tabButton4.onClick
!function(self, dsFileInfo, dsTasks){
		
	var task = dsTasks.getData().current;
	dsFileInfo.set("parameter", {
		taskUid: task.get("taskUid"),
        fileType: "all"
	});
	
	dsFileInfo.flush();
	
}

//@Bind #tabButton5.onClick
!function(self, dsMessage){
	dsMessage.set("parameter", {
		employeeId: employeeId
	});
	
	dsMessage.flush();
	
}



//CHECK_TASK

//@Bind #firstCheck.onTap
//@Bind #secondCheck.onTap
//@Bind #thirdCheck.onTap
!function(self, dsCheckBill, dsTasks, dsMaterial, gridCheckBillDetail, touchMenuCheck, formEleSn){
	
	touchMenuCheck.hide();
	
	//MenuItem控件id
	var id = self.get("id");
	
	var task = dsTasks.getData().current;
	dsCheckBill.set("parameter", {
		taskUid: task.get("taskUid"), 
		checkType: 23
	});
	
	
	dsCheckBill.flush();
	if(dsCheckBill.getData().entityCount == 0){
		
		dsCheckBill.set("dataProvider", "taskDataAccess#addCheckBillByTaskUid");
		dsCheckBill.flush();
		//alert(dsCheckBill.getData().entityCount);
		dsCheckBill.set("dataProvider", "taskDataAccess#getCheckBillByTaskUid");
	}
	
	dsMaterial.set("parameter", {
		taskUid: task.get("taskUid") 
	});
	
	dsMaterial.flush();
	
	var checkBillList = dsCheckBill.getData("#.checkBillDetails");
	if(id == "firstCheck"){
		
		if(!checkBillList.isEmpty()){
			
			if(checkBillList.current.get("actualValue1") == null){
				
				checkBillList.each(
						function(entity){
							var standardValue = entity.get("standardValue");
							entity.set("actualValue1",standardValue);
						}
				);
				
			}
		}
		
		
		gridCheckBillDetail.getColumn("actualValue1").set("visible", true);
		gridCheckBillDetail.getColumn("actualValue2").set("visible", false);
		gridCheckBillDetail.getColumn("actualValue").set("visible", false);
		
		gridCheckBillDetail.getColumn("measureToolUid1").set("visible", true);
		gridCheckBillDetail.getColumn("measureToolUid2").set("visible", false);
		gridCheckBillDetail.getColumn("measureToolUid").set("visible", false);
		
		gridCheckBillDetail.getColumn("checker2").set("visible", false);
		gridCheckBillDetail.getColumn("checker1").set("visible", true);
		gridCheckBillDetail.getColumn("checker").set("visible", false);
		
		gridCheckBillDetail.getColumn("checkTime2").set("visible", false);
		gridCheckBillDetail.getColumn("checkTime1").set("visible", true);
		gridCheckBillDetail.getColumn("checkTime").set("visible", false);
		
		
	}else if(id == "secondCheck"){
		
		if(!checkBillList.isEmpty()){
			
			if(checkBillList.current.get("actualValue2") == null){
				
				checkBillList.each(
						function(entity){
												
							var actualValue1 = entity.get("actualValue1");	
							var measureToolUid1 = entity.get("measureToolUid1");
							entity.set("actualValue2",actualValue1);
							entity.set("measureToolUid2",measureToolUid1);
						}
				);
			}
		}
		

		formEleSn.set("readOnly", true);
		
		gridCheckBillDetail.getColumn("actualValue1").set("visible", true);
		gridCheckBillDetail.getColumn("actualValue2").set("visible", true);
		gridCheckBillDetail.getColumn("actualValue").set("visible", false);
		
		gridCheckBillDetail.getColumn("measureToolUid1").set("visible", false);
		gridCheckBillDetail.getColumn("measureToolUid2").set("visible", true);
		gridCheckBillDetail.getColumn("measureToolUid").set("visible", false);
		
		gridCheckBillDetail.getColumn("checker2").set("visible", true);
		gridCheckBillDetail.getColumn("checker1").set("visible", false);
		gridCheckBillDetail.getColumn("checker").set("visible", false);
		
		gridCheckBillDetail.getColumn("checkTime2").set("visible", true);
		gridCheckBillDetail.getColumn("checkTime1").set("visible", false);
		gridCheckBillDetail.getColumn("checkTime").set("visible", false);
		
	}else if(id == "thirdCheck"){
		
		if(!checkBillList.isEmpty()){
			
			if(checkBillList.current.get("actualValue") == null){
				
				checkBillList.each(
						function(entity){
												
							var actualValue1 = entity.get("actualValue2");
							var measureToolUid2 = entity.get("measureToolUid2");
							entity.set("actualValue",actualValue1);
							entity.set("measureToolUid",measureToolUid2);
						}
				);
			}
			
		}
		
		
		gridCheckBillDetail.getColumn("actualValue1").set("visible", true);
		gridCheckBillDetail.getColumn("actualValue2").set("visible", true);
		gridCheckBillDetail.getColumn("actualValue").set("visible", true);
		
		gridCheckBillDetail.getColumn("measureToolUid1").set("visible", false);
		gridCheckBillDetail.getColumn("measureToolUid2").set("visible", false);
		gridCheckBillDetail.getColumn("measureToolUid").set("visible", true);
		
		gridCheckBillDetail.getColumn("checker").set("visible", true);
		gridCheckBillDetail.getColumn("checker2").set("visible", false);
		gridCheckBillDetail.getColumn("checker1").set("visible", false);
		
		gridCheckBillDetail.getColumn("checkTime").set("visible", true);
		gridCheckBillDetail.getColumn("checkTime2").set("visible", false);
		gridCheckBillDetail.getColumn("checkTime1").set("visible", false);
	}
	view.get("#checkBillPanel").show();
}

//@Bind #btnCheckRatio.onClick
!function(self, btnCheckAdd1, btnCheckMinus1, btnCheckAdd5, btnCheckMinus5){
	
	if(self.get("userData") == "1"){
		self.set("userData", "0.1");
	}else if(self.get("userData") == "0.1"){
		self.set("userData", "0.01");
	}else if(self.get("userData") == "0.01"){
		self.set("userData", "1");
	}
	var ratio = self.get("userData");
	
	btnCheckAdd1.set("caption", "+" + 1*ratio);
	btnCheckMinus1.set("caption", "-" + 1*ratio);
	btnCheckAdd5.set("caption", "+" + 5*ratio);
	btnCheckMinus5.set("caption", "-" + 1*ratio);
}


////@Bind #dsCheckBill.onLoadData
//!function(self, dsCheckBill){ //申请状态控制
//	
//	var checkBill = dsCheckBill.getData("#.checkBillDetails");
//	
//	alert(checkBill);
//	checkBill.each(function(entity){
//		
//		var uBound = entity.get("uBound");
//		
//		//alert(spcStandardValue);
//		alert(uBound)
//		
//	});
//	
//
//}

//@Bind #btnCheckAdd1.onClick
//@Bind #btnCheckMinus1.onClick
//@Bind #btnCheckAdd5.onClick
//@Bind #btnCheckMinus5.onClick
!function(self, dsCheckBill, gridCheckBillDetail){
	
	var checkBill = dsCheckBill.getData("#.checkBillDetails").current;	
	
	if(gridCheckBillDetail.getColumn("checker1").get("visible")){
		
		var actualValue1 = parseFloat(checkBill.get("actualValue1"));
		actualValue1 = actualValue1 + parseFloat(self.get("caption"));
		actualValue1 = changeTwoDecimal(actualValue1);
		checkBill.set("actualValue1", actualValue1);


		
	}else if(gridCheckBillDetail.getColumn("checker2").get("visible")){
		
		var actualValue2 = parseFloat(checkBill.get("actualValue2"));
		actualValue2 = actualValue2 + parseFloat(self.get("caption"));	
		checkBill.set("actualValue2", actualValue2);
		
	}if(gridCheckBillDetail.getColumn("checker").get("visible")){
		
		var actualValue = parseFloat(checkBill.get("actualValue"));
		actualValue = actualValue + parseFloat(self.get("caption"));	
		checkBill.set("actualValue", actualValue);
	}
	
	
}

//功能：将浮点数四舍五入，取小数点后2位，如果不足2位则补0,这个函数返回的是字符串的格式
function changeTwoDecimal(floatvar){
	var f_x = parseFloat(floatvar);
	if (isNaN(f_x)){
		alert('function:changeTwoDecimal->parameter error');
		return false;
	}
	f_x = Math.round(f_x*100)/100;
	var s_x = f_x.toString();
	var pos_decimal = s_x.indexOf('.');
	if (pos_decimal < 0){
		pos_decimal = s_x.length;
		s_x += '.';
	}
	while (s_x.length <= pos_decimal + 2){
		s_x += '0';
	}
	return s_x;
}

//@Bind #editorCheckerandTool.onPost
!function(self, dsCheckBill, dsEmployee, dsMeasureTool, gridCheckBillDetail){
	
	var checkBillList = gridCheckBillDetail.get("selection");
	//var checkBill = dsCheckBill.getData("#.checkBillDetails").current;
	
	if(checkBillList == ''){
		
		dorado.widget.NotifyTipManager.notify("请先勾选！");
		
		self.set("text", "");
		return;
	}
	
	
	var id = self.get("text");
	
	dsEmployee.set("parameter", {
		cardId: id
	});
	
	dsMeasureTool.set("parameter", {
		barcode: id
	});

	dsEmployee.flush();	
	dsMeasureTool.flush();
	
	var count1 = dsEmployee.getData().entityCount;
	var count2 = dsMeasureTool.getData().entityCount;
	
	if(count1 == 1){
		
		checker = dsEmployee.getData().current.get("employeeName");
		
		//timeTranslation
		var checkTime = new Date().Format("yyyy-MM-dd");
		
		var checkBill = dsCheckBill.getData().current;
		
		if(gridCheckBillDetail.getColumn("checker1").get("visible")){
			
			checkBillList.each(function(entity){
				
				entity.set("checker1", checker);
				entity.set("checkTime1", checkTime);
				
				autoSetQualityState(entity, checkBill);

			});
			
			
			
		}else if(gridCheckBillDetail.getColumn("checker2").get("visible")){
			
			checkBillList.each(function(entity){
				
				entity.set("checker2", checker);
				entity.set("checkTime2", checkTime);
				autoSetQualityState(entity, checkBill);

			});
			
			
		}if(gridCheckBillDetail.getColumn("checker").get("visible")){
			
			checkBillList.each(function(entity){
				
				entity.set("checker", checker);
				entity.set("checkTime", checkTime);
				autoSetQualityState(entity, checkBill);

			});
		}
		
	}else if(count2 == 1){
		
		var measureToolUid = dsMeasureTool.getData().current.get("materialUsn");
		
		if(gridCheckBillDetail.getColumn("checker1").get("visible")){
			
			checkBillList.each(function(entity){
				
				entity.set("measureToolUid1", measureToolUid);
			});
			
		}else if(gridCheckBillDetail.getColumn("checker2").get("visible")){
			
			checkBillList.each(function(entity){
				
				entity.set("measureToolUid2", measureToolUid);
			});
			
		}if(gridCheckBillDetail.getColumn("checker").get("visible")){
			
			checkBillList.each(function(entity){
				
				entity.set("measureToolUid", measureToolUid);
			});
		}
		
	}else if(count1 !=1 && count2 != 1 && id !=""){
		
		dorado.widget.NotifyTipManager.notify("输入条码错误，请重新输入！");
	}
	
	self.set("text", "");
	

	
}

//根据上下偏差自动计算并设置检验结果状态
function autoSetQualityState(entity, checkBill){
	
	var actualValue1 = parseFloat(entity.get("actualValue1"));
	var spcStandardValue = entity.get("spcStandardValue");
	var uBound = entity.get("upLimit");
	var lBound = entity.get("downLimit");
	var cha = changeTwoDecimal(actualValue1 - spcStandardValue);
//	alert("actualValue1:"+actualValue1);
//	alert("spcStandardValue:"+spcStandardValue);
//	alert(cha);
	if(lBound <= cha && uBound >= cha){
		entity.set("qualityState", 1);
		entity.set("qualityStateDesc", "合格");
	}else{
		entity.set("qualityState", 2);
		entity.set("qualityStateDesc", "不合格");
		
		//设置检验单不合格数
		checkBill.set("defectQty", 1);
	}
}

//@Bind #btnCheckStart.onClick
!function(self, dsTasks, ajaxCheckStart){
	
	var task = dsTasks.getData().current;
	
	ajaxCheckStart.set("parameter", {
		taskUid: task.get("taskUid"),//"4098377",
		checkType:23
	
	});
	
	ajaxCheckStart.execute();

}

//@Bind #undetected.onTap
//@Bind #qualified.onTap
//@Bind #unqualified.onTap
!function(self, dsCheckBill, menuQualityState, gridCheckBillDetail){
	
	menuQualityState.hide();
	
	var checkBillList = gridCheckBillDetail.get("selection");
	//var checkBillDetail = checkBillList.current;
	
	if(checkBillList == ''){
		
		dorado.widget.NotifyTipManager.notify("请先勾选！");
		return;
	}
	
	var checkBill = dsCheckBill.getData().current;
	
	var id = self.get("id");
	if(id == "qualified"){
		
		checkBillList.each(function(entity){
			
			entity.set("qualityState", 1);
			entity.set("qualityStateDesc", "合格");
		});
		
	}else if(id == "unqualified"){
		
		checkBillList.each(function(entity){
			
			entity.set("qualityState", 2);
			entity.set("qualityStateDesc", "不合格");
			
		});
		
		checkBill.set("defectQty", 1);

	}else if(id == "undetected"){
		
		checkBillList.each(function(entity){
			
			entity.set("qualityState", 0);
			entity.set("qualityStateDesc", "未检");
			
		});

	}
	
//	//timeTranslation
//	var checkTime = new Date().Format("yyyy-MM-dd");
//	
//	if(gridCheckBillDetail.getColumn("checker1").get("visible")){
//		
//		checkBillList.each(function(entity){
//			
//			entity.set("checkTime1", checkTime);
//		});
//		
//	}else if(gridCheckBillDetail.getColumn("checker2").get("visible")){
//		
//		checkBillList.each(function(entity){
//			
//			entity.set("checkTime2", checkTime);
//		});
//		
//	}if(gridCheckBillDetail.getColumn("checker").get("visible")){
//		
//		checkBillList.each(function(entity){
//			
//			entity.set("checkTime", checkTime);
//		});
//	}
	
}

//对Date的扩展，将 Date 转化为指定格式的String 
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
//例子： 
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function(fmt) 
{ //author: meizz 
var o = { 
 "M+" : this.getMonth()+1,                 //月份 
 "d+" : this.getDate(),                    //日 
 "h+" : this.getHours(),                   //小时 
 "m+" : this.getMinutes(),                 //分 
 "s+" : this.getSeconds(),                 //秒 
 "q+" : Math.floor((this.getMonth()+3)/3), //季度 
 "S"  : this.getMilliseconds()             //毫秒 
}; 
if(/(y+)/.test(fmt)) 
 fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
for(var k in o) 
 if(new RegExp("("+ k +")").test(fmt)) 
fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
return fmt; 
}

////@Bind #btnQualityState.onClick
//!function(self, dsCheckBill){
//	
//	var checkBillList = dsCheckBill.getData("#.checkBillDetails");
//	var checkBill = checkBillList.current;
//	
//	if(self.get("userData") == 1){
//		
//		checkBill.set("qualityState", 1);
//		checkBill.set("qualityStateDesc", "合格");
//		self.set("userData", 2);
//	}else if(self.get("userData") == 2){
//		
//		checkBill.set("qualityState", 2);
//		checkBill.set("qualityStateDesc", "不合格");
//		self.set("userData", 0);
//	}else if(self.get("userData") == 0){
//		
//		checkBill.set("qualityState", 0);
//		checkBill.set("qualityStateDesc", "未检");
//		self.set("userData", 1);
//	}
//
//}

//@Bind #btnCheckSave.onClick
!function(self, updateCheckBill, dsCheckBill){
	

	updateCheckBill.execute();

}

//@Bind #btnCheckFinish.onClick
!function(self, dsTasks, dsCheckBill, updateCheckBill, ajaxCheckFinish){
	
	var task = dsTasks.getData().current;
	
	var checkBill = dsCheckBill.getData().current;
	if(checkBill.get("checkBillUid") == ""){
		
		dorado.widget.NotifyTipManager.notify("请先保存！");
	}else{
		
		ajaxCheckFinish.set("parameter", {
			taskUid: task.get("taskUid"),//"4098377",
			checkType:23
		
		});
		
		ajaxCheckFinish.execute();
	}
	

}


//@Bind #ajaxCheckStart.onSuccess
//@Bind #updateCheckBill.onSuccess
//@Bind #ajaxCheckFinish.onSuccess
!function(self, dsCheckBill){
	
	var id = self.get("id");
	
	if(id == "ajaxCheckStart"){
		dorado.widget.NotifyTipManager.notify("开始检验！");
	}else if(id == "updateCheckBill"){
		
		dorado.widget.NotifyTipManager.notify("保存成功！");
		dsCheckBill.flush();
		
	}else if(id == "ajaxCheckFinish"){
		dorado.widget.NotifyTipManager.notify("完成检验！");
		dsCheckBill.flush();
	}
	
	
}

//@Bind #dropdownMaterial.onValueSelect
!function(self, dsCheckBill, dsMaterial){
	
	var materialUsn = dsMaterial.getData().current.get("materialUsn");
	var checkBillList = dsCheckBill.getData("#.checkBillDetails");
	
	checkBillList.each(
			function(entity){
				entity.set("materialUsn",materialUsn);
			}
	);
}

//2014-10-17 TaskMessage

//待补充-----liuzhen 
//@Bind #radioGroup1.onValueChange
!function(self, arg, editorDeviceProblem, dsDeviceProblem){
	var problemtype;
	var radiovalue = view.get("#radioGroup1").get("value");
	if(radiovalue == "1"){
		problemtype = "MMMSG_DEPT_TECH";
	}else if(radiovalue == "2"){
		problemtype = "MMMSG_DEPT_MAINT";
	}else if(radiovalue == "3"){
		problemtype = "MMMSG_DEVICE_PREVOP";
	}else if(radiovalue == "4"){
		problemtype = "MMMSG_DEVICE_NEXTOP";
	}
	
	dsDeviceProblem.set("parameter", {
		messageTo: problemtype
	
	});
	
	dsDeviceProblem.flush();
}



//@Bind #btn_sendMessage.onClick
!function(self, arg, dsTasks, editorDeviceProblem, dsMessage, dsDeviceProblem, ajaxSendMessage){
	//var deviceuid = deviceUid;
	//var employeeid = employeeId; //"admin";
	
	var task = dsTasks.getData().current;
	var taskuid = task.get("taskUid"); 
	
	var problemcode = dsDeviceProblem.getData().current.get("problemCode");
	var problemdesc = dsDeviceProblem.getData().current.get("problemDesc");
	var messageuser;
	var radiovalue = view.get("#radioGroup1").get("value");
	if(radiovalue == "1"){
		messageuser = "MMMSG_DEPT_TECH";
	}else if(radiovalue == "2"){
		messageuser = "MMMSG_DEPT_MAINT";
	}else if(radiovalue == "3"){
		messageuser = "MMMSG_DEVICE_PREVOP";
	}else if(radiovalue == "4"){
		messageuser = "MMMSG_DEVICE_NEXTOP";
	}
	
	ajaxSendMessage.set("parameter",{
		deviceUid:deviceUid,
		employeeId:employeeId,
		taskUid:taskuid,
		problemCode:problemcode,
		problemDesc:problemdesc,
		messageUser: messageuser
	});
	dsMessage.set("parameter", {
		employeeId: employeeId
	});
	//alert(employeeId)
	ajaxSendMessage.execute(function(){
		dsMessage.flush();
	});
}

//@Bind #ajaxSendMessage.onSuccess
!function(self, arg){
	dorado.widget.NotifyTipManager.notify("消息发送成功!");
}


//2014-10-23 TaskTool

//@Bind #dsTaskTool.onLoadData
!function(self, dsTaskTool){ //申请状态控制
	
	var taskToolList = dsTaskTool.getData();
	
	taskToolList.each(function(entity){
		
		if(entity.get("ioState") == null){
			entity.set("applyStateDesc", "未申请");
		}else{

			if(entity.get("ioState") < 6){
				entity.set("applyStateDesc", "未结案");
			}else{
				entity.set("applyStateDesc", "已结案");
			}
		}
		
		
	});
	

}

//@Bind #btnAll.onClick
//@Bind #btnTD.onClick
//@Bind #btnTJ.onClick
//@Bind #btnTL.onClick
!function(self, dsTaskTool, dsTasks){
	
	var toolType;
	
	var id = self.get("id");
	switch(id){
		
		case "btnAll": 
			toolType = "all";
			break;
		case "btnTD": 
			toolType = "TD";
			break;
		case "btnTJ": 
			toolType = "TJ";
			break;
		case "btnTL": 
			toolType = "TL";
			break;
	}
	
	var task = dsTasks.getData().current;
	dsTaskTool.set("parameter", {
		taskUid: task.get("taskUid"),
        deviceUid: deviceUid,
        toolType: toolType
	});
	
	dsTaskTool.flush();
	
}

//@Bind #btnTaskToolAdd1.onClick
//@Bind #btnTaskToolMinus1.onClick
!function(self, dsTaskTool){  //工具主页面申请数
	
	var taskTool = dsTaskTool.getData().current;
	var applyQty = taskTool.get("applyQty");
	
	var id = self.get("id");
	switch(id){		
		case "btnTaskToolAdd1": 
			taskTool.set("applyQty", applyQty + 1);
			break;
		case "btnTaskToolMinus1": 
			taskTool.set("applyQty", applyQty - 1);
			break;
	}
	
	
}

//ADD_TOOL

////@Bind #btnAddTool.onClick
//!function(panelToolSelect){
//	
//	panelToolSelect.show();
//}
//
////@Bind #btnToolClose.onClick
//!function(panelToolSelect){
//	
//	panelToolSelect.hide();
//}

////@Bind #dropdownToolWarehouse.onValueSelect
//!function(dsToolWarehouse, dsToolInvInfo, listToolClass){
//	
//	var destWarehouseId = dsToolWarehouse.getData().current.get("warehouseId");
//	var entity = listToolClass.getCurrentItem();	
//	var classId = entity.get("classId");
//	
//	dsToolInvInfo.set("parameter", {
//		toolType: classId,
//		destWarehouseId: destWarehouseId
//
//	});
//	
//	dsToolInvInfo.flush();
//}

////@Bind #btnToolAdd1.onClick
////@Bind #btnToolMinus1.onClick
//!function(self, dsToolInvInfo){ //增加刀具模块申请数
//	
//	var toolInvInfo = dsToolInvInfo.getData().current;
//	var applyQty = toolInvInfo.get("applyQty");
//	
//	var id = self.get("id");
//	switch(id){		
//		case "btnToolAdd1": 
//			toolInvInfo.set("applyQty", applyQty + 1);
//			break;
//		case "btnToolMinus1": 
//			toolInvInfo.set("applyQty", applyQty - 1);
//			break;
//	}
//	
//	
//}

////@Bind #gridToolInvInfo.onDataRowClick
//!function(self, dsToolInvInfo, dsToolInvDetail, panelToolInvDetail){ //增加刀具模块
//
//	var toolInvInfo = dsToolInvInfo.getData().current;
//	var partNumber = toolInvInfo.get("partNumber");
//	
//	dsToolInvDetail.set("parameter", {
//		partNumber: partNumber
//
//	});
//	
//	dsToolInvDetail.flush();
//	
//	panelToolInvDetail.show();
//}

//@Bind #btnToolInvClose.onClick
!function(self, panelToolInvDetail){  //库存明细关闭
	
	panelToolInvDetail.hide();
}

//@Bind #gridToolInvDetail.onDataRowClick
!function(arg, dsToolInvDetail, dsTaskTool, panelToolInvDetail) { //库存明细选择
	
	var invInfos = dsTaskTool.getData().current;
	
	var invInfo = dsToolInvDetail.getData().current;
	var warehouseId = invInfo.get("warehouseId");
	var warehouseName = invInfo.get("warehouseName");
	var invQty = invInfo.get("invQty");
	
	invInfos.set({
		"warehouseId" : warehouseId,
		"warehouseName" : warehouseName,
		"invQty" : invQty
	});	
	
	panelToolInvDetail.hide();
}

////@Bind #btnToolSeleted.onClick
//!function(self, dsTaskTool, dsToolInvInfo, gridToolInvInfo){
//	
//	var toolInvList = gridToolInvInfo.get("selection");
//	var taskToolList = dsTaskTool.getData();
//	
//	var tempList = new dorado.EntityList();
//	var i = 0;  //标记
//	
//	toolInvList.each(
//			function(entity){
//				var materialUsn= entity.get("materialUsn");
//				taskToolList.each(
//						function(entity2){
//							
//							if(entity2.get("materialUsn") == materialUsn){
//								
//								var applyQty = entity2.get("applyQty") + entity.get("applyQty");									
//								entity2.set("applyQty", applyQty);
//								
//								i++;
//							}
//							
//							
//						}
//				);
//				
//				if(i == 0){
//					tempList.insert(entity);
//				}else{
//					i = 0;
//				}
//			}
//	);
//	
//	
//	if(!tempList.isEmpty()){
//		
//		tempList.each(
//				function(entity){
//					
//					taskToolList.insert(entity);
//				}
//		);
//	}
//		
//}

//TOOL_OUT_APPLY..TOOL_IN_APPLY

//@Bind #updateTaskToolOut.onGetUpdateData
//@Bind #updateTaskToolIn.onGetUpdateData
!function(self, arg, dataGridTaskTool){
	// 请注意：如果UpdateAction中定义了多个UpdateItem，那么本事件会针对每一个UpdateItem触发一次,
	// 可能需要在此事件中判断当前触发事件的UpdateItem是哪一个。
	arg.data = dataGridTaskTool.get("selection");
}

//@Bind #btnTaskToolOut.onClick
!function(updateTaskToolOut, dsTasks, dsTaskTool, dsWarehouse){
	
	//var destWarehouseId = dsWarehouse.getData().current.get("warehouseId");
	
	var task = dsTasks.getData().current;		
	updateTaskToolOut.set("parameter", {
		destWarehouseId: " ",
		deptId: deptId,
		taskUid: task.get("taskUid"),
        employeeId:employeeId,
        deviceUid: deviceUid
	});
	
	updateTaskToolOut.execute(function(){dsTaskTool.flush()});
	
}

//@Bind #btnTaskToolIn.onClick
!function(updateTaskToolIn, dsTaskTool){
	
	updateTaskToolIn.set("parameter", {
        deviceUid: deviceUid,
        employeeId:employeeId
	});
	
	updateTaskToolIn.execute(function(){dsTaskTool.flush()});
	
}

//TOOL_SIGN_DISPATCH

//@Bind #editorInvIoId.onPost
!function(self, panelDispatch, dsInvIo){
	
	var invIoId = self.get("text");
	
	dsInvIo.set("parameter", {
		invIoId: invIoId
	});
	
	dsInvIo.flush();
	
	panelDispatch.show();
}

//@Bind #btnSignList.onClick  
//@Bind #btnTaskWipSign.onClick
!function(self, dsInvIo, panelDispatch){
	
	dsInvIo.set("parameter", {
		toBinId: deviceUid
		//toBinId : ""
	});
	
	dsInvIo.flush();
	
	panelDispatch.show();
}

//@Bind #btnDispatchClose.onClick
!function(panelDispatch){
	
	panelDispatch.hide();
}

//@Bind #btnToolSign.onClick
!function(panelDispatch, updateDispatch, dsInvIo, dsTaskTool){
	
	var invIoId = dsInvIo.getData().current.get("invIoId");
	updateDispatch.set("parameter", {
		invIoId: invIoId,
        deviceUid: deviceUid,
        employeeId:employeeId
	});
	
	updateDispatch.execute(function(){dsTaskTool.flush();});
	panelDispatch.hide();
}


//2014-10-28 TaskWip

//@Bind #btnTaskWipOut.onClick
!function(self, dsTasks, ajaxTaskWipOut){
	
	var task = dsTasks.getData().current;
	ajaxTaskWipOut.set("parameter", {
		deptId: deptId,
		taskUid: task.get("taskUid"),
        employeeId:employeeId,
		ioType:"24"
	
	});
	ajaxTaskWipOut.execute();

}

//@Bind #btnTaskWipIn.onClick
!function(self, dsTasks, ajaxTaskWipIn){
	
	var task = dsTasks.getData().current;
	ajaxTaskWipIn.set("parameter", {
		deptId: deptId,
		taskUid: task.get("taskUid"),
        employeeId:employeeId,
		ioType:"102"
	
	});
	
	ajaxTaskWipIn.execute();

}

//@Bind #btnTaskWipFeedback.onClick
//@Bind #btnCancelFeedback.onClick
!function(self, updateTaskWipFeedback, dsTasks, dsTaskWip, dsWipWorkRec, dataGridTaskWip){
	
	var id = self.get("id");
	var task = dsTasks.getData().current;
	
	var selectList = dataGridTaskWip.get("selection");	
	selectList.each(function(entity){
				
		dsWipWorkRec.insert();
		
		var workrec = dsWipWorkRec.getData().current;
		workrec.set("taskUid", task.get("taskUid"));
		workrec.set("assnUid", task.get("assnUid"));
		workrec.set("worker", "admin");
		workrec.set("deviceUid", "2140004");
		workrec.set("workType", 1);
		
		
		//workType=1
		workrec.set("partNumber", entity.get("partNumber"));
		workrec.set("sn", entity.get("sn"));
		//workrec.set("completeQty", 1);
		workrec.set("preOpTime", task.get("preOpTime"));
		workrec.set("runTime", task.get("runTime"));
		
		if(id == "btnTaskWipFeedback"){
				
			workrec.set("completeQty", 1);
		}else{
			
			workrec.set("completeQty", -1);
		}
	});
	
	
	//alert(dsWipWorkRec.getData().entityCount);
	updateTaskWipFeedback.execute(function(){dsTaskWip.flush();});

}


//@Bind #dsTaskWip.onLoadData
!function(self, dsTaskWip, dsTasks, dsWipWorkRec){
	
	var taskWipList = dsTaskWip.getData();
	
	taskWipList.each(function(entity){
		
		if(entity.get("sn") == "0"){
//			taskWipList.remove(entity);
		}else{
			
			entity.set("applyQty", 1);
			
			if(entity.get("completeQty") >= 1){
				entity.set("taskStateDesc", "已完成");
			}else{
				entity.set("taskStateDesc", "未完成");
			}
		}
		
		
	});
	

}

//@Bind #updateShiftStation.onGetUpdateData
!function(self, arg, dataGridTaskWip){
	// 请注意：如果UpdateAction中定义了多个UpdateItem，那么本事件会针对每一个UpdateItem触发一次,
	// 可能需要在此事件中判断当前触发事件的UpdateItem是哪一个。
	arg.data = dataGridTaskWip.get("selection");
}

//@Bind #btnShiftStation.onClick
!function(self, editorStation1, dsWorkStation, dsTaskWip, updateShiftStation){
	
	
	var station = editorStation1.get("text");
	if(station == ""){
		dorado.widget.NotifyTipManager.notify("请选择目标工位!");
		return;

	}else{
		var destStationId = dsWorkStation.getData().current.get("stationId");
	}
	
	updateShiftStation.set("parameter", {
		destStationId:destStationId,
		deviceUid: deviceUid,
        employeeId:employeeId
	});
	
	
	updateShiftStation.execute(function(){dsTaskWip.flush();});
}


//@Bind #btnWipAdd1.onClick
//@Bind #btnWipMinus1.onClick
!function(self, dsTaskWip){
	
	var wip = dsTaskWip.getData().current;
	var applyQty = wip.get("applyQty");
	
	var id = self.get("id");
	switch(id){		
		case "btnWipAdd1": 
			wip.set("applyQty", applyQty + 1);
			break;
		case "btnWipMinus1": 
			wip.set("applyQty", applyQty - 1);
			break;
	}
	
	
}

//TaskFile

//@Bind #btnDrawing.onClick
//@Bind #btnCard.onClick
//@Bind #btnOther.onClick
!function(self, dsFileInfo, dsTasks){
	
	var fileType;
	
	var id = self.get("id");
	switch(id){
		
		case "btnDrawing": 
			fileType = "OP_DRAWING";
			break;
		case "btnCard": 
			fileType = "工序卡片";
			break;
		case "btnOther": 
			fileType = "other";
			break;
	}
	
	var task = dsTasks.getData().current;
	dsFileInfo.set("parameter", {
		taskUid: task.get("taskUid"),
        fileType: fileType
	});
	
	dsFileInfo.flush();
	
}

//@Bind #dataGridFile.onDataRowClick
!function(self, arg, dsFileInfo){
	
	
    var fileUid = dsFileInfo.getData().current.get("fileUid");
	var fileUrl = dsFileInfo.getData().current.get("fileUrl");
	
	//alert(url);
	//var documentURL = "/MesTouch/sample.pdf";
	
	//var documentURL2 = "/MesTouch/jietou_white.smg";
	if(fileUrl.substring(fileUrl.length-4, fileUrl.length).toLowerCase() == ".pdf"){
		
		var jspURL = "/MesTouch/jsp/d.jsp?fileUid=" + fileUid;
		view.get("#iFrame1").set("path",jspURL);
		
	}else{

		open("/MesTouch/jsp/view3DModel.jsp?fileUid=" + fileUid);
		
	}
	

	
}

//@Bind #btnFull.onClick
!function(self, dsFileInfo){
	
	var iframe = parent.$id("iframeShopLink").objects[0];	
    var fileUid = dsFileInfo.getData().current.get("fileUid");
	var url = dsFileInfo.getData().current.get("fileUrl");

	if(url.substring(url.length-4, url.length).toLowerCase() == ".pdf"){
		
		var jspURL = "/MesTouch/jsp/pdfFull.jsp?fileUid=" + fileUid;
		iframe.set("path",jspURL);
		
	}else{
		
		dorado.widget.NotifyTipManager.notify("请选择PDF文档！");
		return;
		
		//open("/MesTouch/jsp/view3DModel.jsp?fileUid=" + fileUid);
//		var jspURL = "/MesTouch/jsp/view3DModel.jsp?fileUid=" + fileUid;
//		iframe.set("path",jspURL);
	}
	
	
//	var documentURL = "/MesTouch/sample.pdf";
//	
//	var documentURL2 = "/MesTouch/jietou_white.smg";
//	
//	if(documentURL.substring(documentURL.length-4, documentURL.length).toLowerCase() == ".pdf"){
//				
//		open(documentURL);
//		
//	}else{
//		
//		open("/MesTouch/jsp/view3DModel.jsp?docurl=" + documentURL2);
//	}


}


//2014-11-5

//@Bind #dropdownStation.onOpen
!function(dsWorkStation){
	dsWorkStation.set("parameter", {
		deviceUid: deviceUid
	});
	dsWorkStation.flush();
}

////@Bind #dropdownWarehouse.onReady
//!function(dsToolWarehouse){
//	dsToolWarehouse.set("parameter", {
//		deviceUid: deviceUid
//	});
//	dsToolWarehouse.flush();
//}

////@Bind #dropdownToolWarehouse.onReady
//!function(dsWarehouse){
//	dsWarehouse.set("parameter", {
//		deviceUid: deviceUid
//	});
//	dsWarehouse.flush();
//}

////@Bind #invDetail.onRenderCell
//!function(self, arg, panelToolInvDetail){
//	$(arg.dom).empty().xCreate({
//
//		tagName : "button",
//		content: "查看",
//		onclick: function(){
//			panelToolInvDetail.show();
//		}
//		});
//}


