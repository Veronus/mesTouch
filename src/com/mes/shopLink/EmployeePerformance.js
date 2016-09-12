var deviceUid ="${param['deviceUid']}";
var employeeId = "${param['employeeId']}";
var deptId = "";
////@view
//var year=2013;
//var deviceUid = "192168100147";
//var employeeId = "admin";
var invIoId = "2656961";

//@Bind view.onCreate
!function(self,arg){
//	设置：
//	view.set("userData", {strUsername:xxxx});
//	获取：
//	var value = view.get("userData").strUsername;
	var fromdateStr = new Date().toString();
	var fromdate = new Date(fromdateStr);
	var year = fromdate.getFullYear();
	var month = fromdate.getMonth()+1;
	self.set("userData",{year:year,month:month});
}


//2014-10-29
//@Bind view.onReady
!function(self, arg, ajax_workRec, ajax_sumWork, ajax_nonWorkHour, ajax_qualityRec, dsWorkRec,dsSumWork,dsQualityRec,toolBar_employeePerformance,dsNonWorkHour,tabCtrl_employeePerformance){
	
	var btnMain = parent.$id("btnMain").objects[0];
	btnMain.set("userData", {
		employeeId : employeeId,
		deptId : deptId
	});
	
	//	var employeeUid="";
	
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
	var userDataYear=view.get("userData").year;
	var userDataMonth=view.get("userData").month;
	var fromdateStr = userDataYear+"/"+userDataMonth+"/"+"01"+" 00:00:00";
	//formalized yyyy/MM/dd HH:mm:ss
	if(userDataMonth=="1"||userDataMonth=="3"||userDataMonth=="5"||userDataMonth=="7"||userDataMonth=="8"||userDataMonth=="10"||userDataMonth=="12"){
		var todateStr = userDataYear+"/"+userDataMonth+"/"+"31"+" 23:59:59";
	}else if(userDataMonth=="4"||userDataMonth=="6"||userDataMonth=="9"||userDataMonth=="11"){
		var todateStr = userDataYear+"/"+userDataMonth+"/"+"30"+" 23:59:59";
	}else {
		var todateStr =userDataYear+"/"+userDataMonth+"/"+"28"+" 23:59:59";
	}
	toolBar_employeePerformance.set("caption",userDataYear+"年"+userDataMonth+"月工时完成情况");
	dsWorkRec.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
	dsSumWork.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
	dsQualityRec.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
	dsNonWorkHour.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
		//alert(employeeId);
		dsSumWork.flush();
		dsWorkRec.flush();
		dsNonWorkHour.flush();
		dsQualityRec.flush();
//		var shopAveCompleteWork=dsSumWork.getData().current.get("shopAveCompleteWork");
//		shopAveCompleteWork=changeTwoDecimal(dsSumWork.getData().current.get("shopAveCompleteWork"));
//		
		
//	ajax_workRec.set("parameter", {
//		employeeUid:employeeId,
//		fromDate:fromdateStr,
//		toDate:todateStr
//	});	
//	ajax_sumWork.set("parameter", {
//		employeeUid:employeeId,
//		fromDate:fromdateStr,
//		toDate:todateStr
//	});	
//	ajax_nonWorkHour.set("parameter", {
//		employeeUid:employeeId,
//		fromDate:fromdateStr,
//		toDate:todateStr
//	});	
//	ajax_qualityRec.set("parameter", {
//		employeeUid:employeeId,
//		fromDate:fromdateStr,
//		toDate:todateStr
//	});	
//		ajax_sumWork.execute(function(){dsSumWork.flush();});
//		ajax_workRec.execute(function(){dsWorkRec.flush();});
//		ajax_nonWorkHour.execute(function(){dsNonWorkHour.flush();});
//		ajax_qualityRec.execute(function(){dsQualityRec.flush();});
		
		
}

//2014-10-30
//@Bind #preMonth.onClick
!function(self,arg,dsWorkRec,dsSumWork,dsQualityRec,toolBar_employeePerformance,dsNonWorkHour,tabCtrl_employeePerformance){
//	var employeeUid="198203104";
	
	var userDataYear=view.get("userData").year;
//	userDataYear = parseFloat(userDataYear)-1;
	var userDataMonth=view.get("userData").month;
	userDataMonth = parseFloat(userDataMonth)-1;
//	view.set("userData", {year:userDataYear,month:userDataMonth});
	//老一版方法
//	var fromdateStr = new Date().toString();
//	var fromdate = new Date(fromdateStr);
//	var todateStr = new Date().toString();
//	var todate = new Date(fromdateStr);
//	var year = fromdate.getFullYear();
//	var month = fromdate.getMonth()+1-userData;
	if(userDataMonth=="0"){
		userDataYear = userDataYear-1;
		userDataMonth="12";
	}
	//
	view.set("userData", {year:userDataYear,month:userDataMonth});
	var fromdateStr = userDataYear+"/"+userDataMonth+"/"+"01"+" 00:00:00";
	//formalized yyyy/MM/dd HH:mm:ss
	if(userDataMonth=="1"||userDataMonth=="3"||userDataMonth=="5"||userDataMonth=="7"||userDataMonth=="8"||userDataMonth=="10"||userDataMonth=="12"){
		var todateStr = userDataYear+"/"+userDataMonth+"/"+"31"+" 23:59:59";
	}else if(userDataMonth=="4"||userDataMonth=="6"||userDataMonth=="9"||userDataMonth=="11"){
		var todateStr = userDataYear+"/"+userDataMonth+"/"+"30"+" 23:59:59";
	}else {
		var todateStr =userDataYear+"/"+userDataMonth+"/"+"28"+" 23:59:59";
	}
	toolBar_employeePerformance.set("caption",userDataYear+"年"+userDataMonth+"月工时完成情况");
	dsWorkRec.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
	dsSumWork.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
	dsQualityRec.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
	dsNonWorkHour.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
//	alert(tabCtrl_employeePerformance.currentTab);
//	if(tabCtrl_employeePerformance.currentTab="0"){
//		dsWorkRec.flush();
//	}else if(tabCtrl_employeePerformance.currentTab="1"){
//		dsNonWorkHour.flush();
//	}else {
//		dsQualityRec.flush();
//	}
		
		dsSumWork.flush();
		dsWorkRec.flush();
		dsNonWorkHour.flush();
		dsQualityRec.flush();
//		var shopAveCompleteWork=dsSumWork.getData().current.get("shopAveCompleteWork");
//		shopAveCompleteWork=changeTwoDecimal(dsSumWork.getData().current.get("shopAveCompleteWork"));
//		alert(shopAveCompleteWork);
		
}

//@Bind #nextMonth.onClick
!function(self,arg,dsWorkRec,dsSumWork,dsQualityRec,toolBar_employeePerformance,dsNonWorkHour,tabCtrl_employeePerformance){
//	var employeeUid="198203104";
	
	var userDataYear=view.get("userData").year;
//	userDataYear = parseFloat(userDataYear)-1;
	var userDataMonth=view.get("userData").month;
	userDataMonth = parseFloat(userDataMonth)+1;
//	view.set("userData", {year:userDataYear,month:userDataMonth});
	//老一版方法
//	var fromdateStr = new Date().toString();
//	var fromdate = new Date(fromdateStr);
//	var todateStr = new Date().toString();
//	var todate = new Date(fromdateStr);
//	var year = fromdate.getFullYear();
//	var month = fromdate.getMonth()+1-userData;
	if(userDataMonth=="13"){
		userDataYear = userDataYear+1;
		userDataMonth="1";
	}
	//
	view.set("userData", {year:userDataYear,month:userDataMonth});
	var fromdateStr = userDataYear+"/"+userDataMonth+"/"+"01"+" 00:00:00";
	//formalized yyyy/MM/dd HH:mm:ss
	if(userDataMonth=="1"||userDataMonth=="3"||userDataMonth=="5"||userDataMonth=="7"||userDataMonth=="8"||userDataMonth=="10"||userDataMonth=="12"){
		var todateStr = userDataYear+"/"+userDataMonth+"/"+"31"+" 23:59:59";
	}else if(userDataMonth=="4"||userDataMonth=="6"||userDataMonth=="9"||userDataMonth=="11"){
		var todateStr = userDataYear+"/"+userDataMonth+"/"+"30"+" 23:59:59";
	}else {
		var todateStr =userDataYear+"/"+userDataMonth+"/"+"28"+" 23:59:59";
	}
	toolBar_employeePerformance.set("caption",userDataYear+"年"+userDataMonth+"月工时完成情况");

	dsWorkRec.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
	dsSumWork.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
	dsQualityRec.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
	dsNonWorkHour.set("parameter", {
		employeeUid:employeeId,
		fromDate:fromdateStr,
		toDate:todateStr
	});	
		dsSumWork.flush();
		dsWorkRec.flush();
		dsNonWorkHour.flush();
		dsQualityRec.flush();
//		var shopAveCompleteWork=dsSumWork.getData().current.get("shopAveCompleteWork");
//		shopAveCompleteWork=changeTwoDecimal(dsSumWork.getData().current.get("shopAveCompleteWork"));
}


//2014-11-08
//@Bind #tabButton2.onTapHold
!function(self,arg,floatPanel_nonWorkHour){
	floatPanel_nonWorkHour.show();
}
////@Bind #btn_apply.onClick
//!function(self,arg,floatPanel_nonWorkHour){
//	floatPanel_nonWorkHour.show();
//}

//2014-11-15
//@Bind #btn_submit.onClick
!function(self,arg,dsNonWorkHour,dsWorkType,dsWorkReason,textEditor_type,textEditor_hour,textEditor_reason,floatPanel_nonWorkHour,ajax_workHourApply){
//	var employeeid="198203104";
//	var deviceuid="";
	
	var userDataYear=view.get("userData").year;
	var userDataMonth=view.get("userData").month;
	var fromdateStr = userDataYear+"/"+userDataMonth+"/"+"01"+" 00:00:00";
	//formalized yyyy/MM/dd HH:mm:ss
	if(userDataMonth=="1"||userDataMonth=="3"||userDataMonth=="5"||userDataMonth=="7"||userDataMonth=="8"||userDataMonth=="10"||userDataMonth=="12"){
		var todateStr = userDataYear+"/"+userDataMonth+"/"+"31"+" 23:59:59";
	}else if(userDataMonth=="4"||userDataMonth=="6"||userDataMonth=="9"||userDataMonth=="11"){
		var todateStr = userDataYear+"/"+userDataMonth+"/"+"30"+" 23:59:59";
	}else {
		var todateStr =userDataYear+"/"+userDataMonth+"/"+"28"+" 23:59:59";
	}
	
	if(textEditor_type.get("text")==""||textEditor_hour.get("text")==""){
		dorado.MessageBox.alert("请确认申请信息！ ");
	}else if(textEditor_reason.get("text")==""){
		var applytype=dsWorkType.getData().current.get("typeValue");
		var applyhour=textEditor_hour.get("text");
		var applyreason=dsWorkReason.getData().current.get("typeValue");
		dorado.MessageBox.alert("请确认申请信息！ ");
	}else {
		var applytype=dsWorkType.getData().current.get("typeValue");
		var applyhour=textEditor_hour.get("text");
		var applyreason=dsWorkReason.getData().current.get("typeValue");
		floatPanel_nonWorkHour.hide();
		ajax_workHourApply.set("parameter",{
			employeeId:employeeId,
	//		deviceUid:deviceuid,
			applyType:applytype,
			applyHour:applyhour,
			applyReason:applyreason
		});
		dsNonWorkHour.set("parameter", {
			employeeUid:employeeId,
			fromDate:fromdateStr,
			toDate:todateStr
		});	
		ajax_workHourApply.execute(function(){
			dsNonWorkHour.flush();
		});
	}

}
//@Bind #btn_cancel.onClick
!function(self,arg,floatPanel_nonWorkHour){ 
	floatPanel_nonWorkHour.hide();
}


//@Bind #textEditor_type.onPost
!function(self,arg,dsWorkType,dsWorkReason){
	var typeValue = dsWorkType.getData().current.get("typeValue");
	dsWorkReason.set("parameter",{
		typeValue:typeValue
	});
	dsWorkReason.flush();
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