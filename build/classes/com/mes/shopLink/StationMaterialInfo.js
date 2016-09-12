
var deviceUid = "${param['deviceUid']}";
var employeeId = "${param['employeeId']}";
var deptId = "005260"; //"${param['deptId']}";
//var invIoId = "2656961";

//���ӵ���ģ�����
var startRow = 1; //��ҳ
var i = 1; //ҳ��

//editor������
var signByInvIoId = "a";
var signByBoxId = "b";
var feedback = "c";
var specialBillCheck = "d";

//@Bind view.onReady
!function(dsInvInfo, btnAll){
	
	btnAll.set("exClassName", "btn-highlight");
	//alert(employeeId);
	var btnMain = parent.$id("btnMain").objects[0];
	btnMain.set("userData", {
		employeeId : employeeId,
		deptId : deptId
	});
	
	view.get("#dsForm").insert();
	
	dsInvInfo.set("parameter", {
		deviceUid: deviceUid,
		toolType: "all"
	});
	dsInvInfo.flush();
		
}

//@Bind #btnStationToReturnMaterialInfo.onClick
!function(dsInvInfo){
	dsInvInfo.set("dataProvider", "invInfoDataAccess#getStationToReturnInvInfo");
	dsInvInfo.set("parameter", {
		deviceUid: deviceUid
	});
	dsInvInfo.flush();
	
	
	
}

//@Bind #btnStationMaterialInfo.onClick
!function(dsInvInfo){
	dsInvInfo.set("dataProvider", "invInfoDataAccess#getStationInvInfo");
	dsInvInfo.set("parameter", {
		deviceUid: deviceUid,
		toolType: "all"
	});
	dsInvInfo.flush();
}

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


//@Bind #dropdownWarehouse.onValueSelect
!function(dsWarehouse, dsForm){
	var formData = dsForm.getData().current;
	formData.set("warehouseId", dsWarehouse.getData().current.get("warehouseId"));
}

//@Bind #editorInvIoId.onPost
!function(self, panelSignByInvIoId, panelSignByBox, dsBoxDetail, dsInvIo){
	
	var invIoId = self.get("text");
	dsInvIo.set("parameter", {
		invIoId: invIoId 
	});
	dsInvIo.flush();
	
	var count = dsInvIo.getData().entityCount;
	if(count > 0){
		panelSignByInvIoId.show();
	}else{
		dorado.widget.NotifyTipManager.notify("���뵥�Ŵ���δ�ҵ����͵���");
	}
	self.set("text", "");
}

//@Bind #btnSignInvIo.onClick
!function(dsInvIo, dsInvInfo, updateDispatch, panelSignByInvIoId){
	
	var invIoId = dsInvIo.getData().current.get("invIoId");
	updateDispatch.set("parameter", {
		invIoId: invIoId,
        deviceUid: deviceUid,
        employeeId:employeeId
	});
	
	updateDispatch.execute(function(){dsInvInfo.flush();});
	panelSignByInvIoId.hide();
	
}

//@Bind #btnCloseSignInvIo.onClick
!function(panelSignByInvIoId){
	panelSignByInvIoId.hide();
}

//*****************2015-04-07***************************************************


//*****************2015-04-07***************************************************



////@Bind #btnSignList.onClick
//!function(self, dsInvIo, panelDispatch){ //������
//	
//	//var invIoId = self.get("text");
//	
//	dsInvIo.set("parameter", {
//		toBinId: deviceUid
//		//toBinId : ""
//	});
//	
//	dsInvIo.flush();
//	
//	panelDispatch.show();
//}


//@Bind #btnToolSign.onClick
!function(panelDispatch, updateDispatch, dsInvIo, dsInvInfo){ //������
	
	var invIoId = dsInvIo.getData().current.get("invIoId");
	updateDispatch.set("parameter", {
		invIoId: invIoId,
        deviceUid: deviceUid,
        employeeId:employeeId
	});
	
	updateDispatch.execute(function(){dsInvInfo.flush();});
	panelDispatch.hide();
}

//@Bind #btnDispatchClose.onClick
!function(panelDispatch){
	
	panelDispatch.hide();
}

//@Bind #btnToolClose.onClick
!function(panelToolSelect){
	
	panelToolSelect.hide();
}


//@Bind #btnToolOut.onClick
!function(updateToolOut, dsInvInfo, dsWarehouse, dataGridInvInfo){
	
	//var destWarehouseId = dsWarehouse.getData().current.get("warehouseId");
	
	var select = dataGridInvInfo.get("selection");	
	var l = select.length;
	
	if(l == 0){
		dorado.widget.NotifyTipManager.notify("����ѡ�����Ͻ�������!");
		return;
	}
	
	var warehouseId = select[0].get("warehouseId");
	
	for(var i = 1; i < l; i++){
		
		var nextWarehouseId = select[i].get("warehouseId");
		if(warehouseId != nextWarehouseId){
			dorado.widget.NotifyTipManager.notify("��ѡ����ͬ�ⷿ���Ͻ�������!");
			return;
		}
	}

	
//	var iterator = selectList.iterator(false);
//	alert(iterator.first());
//	var warehouseId = iterator.first().get("warehouseId");
//	while(iterator.hasNext()){
//		var nextWarehouseId = iterator.next().get("warehouseId");
//		if(warehouseId != nextWarehouseId){
//			alert("11");
//			return;
//		}
//	}
	
	
	updateToolOut.set("parameter", {
		destWarehouseId: " ",//destWarehouseId,
		deptId: deptId,
        deviceUid: deviceUid,
        employeeId:employeeId
	});
	
	updateToolOut.execute(function(){dsInvInfo.flush();dorado.widget.NotifyTipManager.notify("��������ɹ�!");});
	
}

//@Bind #btnToolIn.onClick
!function(updateToolIn, dsInvInfo){
	
	updateToolIn.set("parameter", {
        deviceUid: deviceUid,
        employeeId:employeeId
	});
	
	updateToolIn.execute(function(){dsInvInfo.flush();dorado.widget.NotifyTipManager.notify("�黹����ɹ�!");});
	
}

//@Bind #updateToolOut.onGetUpdateData
//@Bind #updateToolIn.onGetUpdateData  
//@Bind #updateShiftStation.onGetUpdateData
!function(self, arg, dataGridInvInfo){
	// ��ע�⣺���UpdateAction�ж����˶��UpdateItem����ô���¼������ÿһ��UpdateItem����һ��,
	// ������Ҫ�ڴ��¼����жϵ�ǰ�����¼���UpdateItem����һ����
	arg.data = dataGridInvInfo.get("selection");
}

//@Bind #btnAddTool.onClick
!function(panelToolSelect){
	
	panelToolSelect.show();
}

//2014-10-08

//@Bind #btnAdd1.onClick
//@Bind #btnMinus1.onClick
!function(self, dsInvInfo){
	
	var invInfo = dsInvInfo.getData().current;
	var applyQty = invInfo.get("applyQty");
	
	var id = self.get("id");
	switch(id){		
		case "btnAdd1": 
			invInfo.set("applyQty", applyQty + 1);
			break;
		case "btnMinus1": 
			invInfo.set("applyQty", applyQty - 1);
			break;
	}
	
	
}


//2014-10-13

//@Bind #btnAll.onClick
//@Bind #btnTD.onClick
//@Bind #btnTJ.onClick
//@Bind #btnTL.onClick
!function(self, dsInvInfo, btnAll, btnTD, btnTJ, btnTL){
	
	
	var toolType;
	
	var id = self.get("id");
	switch(id){
		
	case "btnAll": 
		toolType = "all";
		btnAll.set("exClassName", "btn-highlight");
		btnTD.set("exClassName", "");
		btnTJ.set("exClassName", "");
		btnTL.set("exClassName", "");
		break;
	case "btnTD": 
		toolType = "TD";
		btnAll.set("exClassName", "");
		btnTD.set("exClassName", "btn-highlight");
		btnTJ.set("exClassName", "");
		btnTL.set("exClassName", "");
		break;
	case "btnTJ": 
		toolType = "TJ";
		btnAll.set("exClassName", "");
		btnTD.set("exClassName", "");
		btnTJ.set("exClassName", "btn-highlight");
		btnTL.set("exClassName", "");
		break;
	case "btnTL": 
		toolType = "TL";
		btnAll.set("exClassName", "");
		btnTD.set("exClassName", "");
		btnTJ.set("exClassName", "");
		btnTL.set("exClassName", "btn-highlight");
		break;
	}
	
	dsInvInfo.set("parameter", {
		deviceUid: deviceUid,
		toolType: toolType

	});
	
	dsInvInfo.flush();
	
}

//@Bind #btnToolSeleted.onClick
!function(self, dsInvInfo, dsToolInvInfo, gridToolInvInfo){
	
	var toolInvList = gridToolInvInfo.get("selection");
	var invInfoList = dsInvInfo.getData();
	
	//alert(toolInvList);
	if(toolInvList == ""){
		dorado.widget.NotifyTipManager.notify("���ȹ�ѡ����!");
		return;
	}
	
	toolInvList.each(
			function(entity){
				
				var invInfo = {
						$dataType : "InvInfo",
						partNumber : entity.get("partNumber"),
						partTypeDesc : entity.get("partTypeDesc"),
						drawingId : entity.get("drawingId"),
						partName : entity.get("partName"),
						partDescription : entity.get("partDescription"),
						invQty : entity.get("invQty"),
						applyQty : entity.get("applyQty"),
						warehouseName : entity.get("warehouseName"),
						warehouseId : entity.get("warehouseId"),
						applyStateDesc : "δ����"
				}
				
				invInfoList.insert(invInfo);

			}
	);
	
	
}


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

//@Bind #listToolClass.onItemTap
!function(self, dsToolInvInfo, dsToolWarehouse, btnPage){
		
	
	
	var entity = self.getCurrentItem();	
	var classId = entity.get("classId");
	
	startRow = 1;
	
	//alert(classId);
	dsToolInvInfo.set("parameter", {
		toolType: classId,
		destWarehouseId: " ",//destWarehouseId
		startRow : startRow

	});
	
	dsToolInvInfo.flush();
	
	if(dsToolInvInfo.getData().entityCount != 0){
		
		//�������ͺ�����ҳ��
		var toolInvInfo = dsToolInvInfo.getData().current;
		var totalCount = toolInvInfo.get("totalCount");
		
		
		var pageSize = Math.ceil(totalCount/10);
		i = 1;
		btnPage.set("caption", "1 / " + pageSize);
	}else{
		
		i = 1;
		btnPage.set("caption", "1 / " + 1);
	}
	
	
}

var classIds = new Array();
classIds[0] = "T";

var classNames = new Array();
classNames[0] = "��������";

//@Bind #btnUp.onClick
//@Bind #btnDown.onClick
!function(self, dsToolClassInfo, listToolClass, btnClassName){
	
	var id = self.get("id");
	var classId;
	
	switch(id){		
		case "btnUp": 
			if(classIds.length == 1){
				
				classId = "T";
				btnClassName.set("caption", "��������");
				dorado.widget.NotifyTipManager.notify("�Ѿ��Ƕ���!");
			}else{
				
				classIds.pop();
				classNames.pop();
				classId = classIds[classIds.length-1];
				className = classNames[classNames.length-1];
				
				btnClassName.set("caption", className);
			}

			break;
		case "btnDown": 
			
			var entity = listToolClass.getCurrentItem();	
			classId = entity.get("classId");
			className = entity.get("className");
			
			btnClassName.set("caption", className);
			classIds.push(classId);
			classNames.push(className);
			
			//alert(classId);
			
			break;
	}
	
	dsToolClassInfo.set("parameter", {
		
		parentId: classId
	});
	
	dsToolClassInfo.flush();
	
	
}

//@Bind #btnPage.onReady
!function(self, dsToolInvInfo){
	
	
	var toolInvInfo = dsToolInvInfo.getData().current;
	var totalCount = toolInvInfo.get("totalCount");
	var pageSize = Math.ceil(totalCount/10);
	
	//alert(totalCount);
	
	self.set("caption", "1 / " + pageSize);
	
	
}


//@Bind #btnToolAdd1.onClick
//@Bind #btnToolMinus1.onClick
!function(self, dsToolInvInfo){
	
	var toolInvInfo = dsToolInvInfo.getData().current;
	var applyQty = toolInvInfo.get("applyQty");
	
	var id = self.get("id");
	switch(id){		
		case "btnToolAdd1": 
			toolInvInfo.set("applyQty", applyQty + 1);
			break;
		case "btnToolMinus1": 
			toolInvInfo.set("applyQty", applyQty - 1);
			break;
	}
	
	
}



//@Bind #btnPrevious.onClick
//@Bind #btnNext.onClick
!function(self, dsToolInvInfo, listToolClass, btnPage){
	
	var toolInvInfo = dsToolInvInfo.getData().current;
	var totalCount = toolInvInfo.get("totalCount");
	var pageSize = Math.ceil(totalCount/10);
	
	var entity = listToolClass.getCurrentItem();	
	var classId = entity.get("classId");
	
	//alert(classId);
	var id = self.get("id");
	switch(id){		
		case "btnPrevious": 
			
			startRow = startRow - 10;
			if(startRow < 1){
				startRow = 1;
				i = 2;
				dorado.widget.NotifyTipManager.notify("�Ѿ��ǵ�һҳ!");
			}
			
			i--;
			btnPage.set("caption", i + " / " + pageSize);
			
			//alert(startRow);
			break;
		case "btnNext": 
			
			
			if(i < pageSize){
				startRow = startRow + 10;
				i++;
				btnPage.set("caption", i + " / " + pageSize);
			}else{
				
				dorado.widget.NotifyTipManager.notify("�Ѿ������һҳ!");
			}
			
			//alert(startRow);
			break;
	}
	
	dsToolInvInfo.set("parameter", {
		
		toolType: classId,
		destWarehouseId: " ",//destWarehouseId
		startRow : startRow
	});
	
	dsToolInvInfo.flush();
	
	
}


//2014-11-1

//@Bind #btnShiftStation.onClick
!function(self, editorStation, dsWorkStation, dsInvInfo, updateShiftStation){
	
	
	var station = editorStation.get("text");
	if(station == ""){
		dorado.widget.NotifyTipManager.notify("��ѡ��Ŀ�깤λ!");
		return;

	}else{
		var destStationId = dsWorkStation.getData().current.get("stationId");
	}
	
	updateShiftStation.set("parameter", {
		destStationId:destStationId,
		deviceUid: deviceUid,
        employeeId:employeeId
	});
	
	
	updateShiftStation.execute(function(){dsInvInfo.flush();});
}


//@Bind #btnToolInvClose.onClick
!function(self, panelToolInvDetail){ //��ҳ������ϸ�ر�
	
	panelToolInvDetail.hide();
}

//@Bind #btnSelectToolInvClose.onClick
!function(self, panelSelectToolInvDetail){ //���ӵ��߿����ϸ�ر�
	
	panelSelectToolInvDetail.hide();
}


//@Bind #gridToolInvDetail.onDataRowClick
!function(arg, dsToolInvDetail, dsInvInfo, panelToolInvDetail) { //��ҳ������ϸѡ��
	
	var invInfos = dsInvInfo.getData().current;
	
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


//@Bind #gridSelectToolInvDetail.onDataRowClick
!function(arg, dsSelectToolInvDetail, dsToolInvInfo, panelSelectToolInvDetail) { //���ӵ��߿����ϸѡ��
	
	var invInfos = dsToolInvInfo.getData().current;
	
	var invInfo = dsSelectToolInvDetail.getData().current;
	var warehouseId = invInfo.get("warehouseId");
	var warehouseName = invInfo.get("warehouseName");
	var invQty = invInfo.get("invQty");
	
	invInfos.set({
		"warehouseId" : warehouseId,
		"warehouseName" : warehouseName,
		"invQty" : invQty
	});	
	
	panelSelectToolInvDetail.hide();
}


////@Bind #dataGridInvInfo.onCurrentChange
//!function(self, dsInvInfo, dsToolInvDetail, panelToolInvDetail){
//	
//	if(self.get("userData") == 1){
//		
//		var invInfo = dsInvInfo.getData().current;
//		//alert(invInfo.get("drawingId"));
//		var partNumber = invInfo.get("partNumber");
//		
//		dsToolInvDetail.set("parameter", {
//			partNumber: partNumber
//
//		});
//		
//		dsToolInvDetail.flush();
//		
//		panelToolInvDetail.show();
//		
//		self.set("userData", 0);
//	}
//	
//	
//	
//}


