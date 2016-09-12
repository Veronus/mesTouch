/**
 * ---------------------����websocket---------------------------
 */
var ws;
var isConnect = false;

function connectServer(host){
	window.WebSocket = window.WebSocket || window.MozWebSocket;
	if (!window.WebSocket) {	// ��������֧��
		alert("Error: WebSocket is not supported .");
		isConnect = false;
		return;
	}else{
		ws = new WebSocket(host);
		isConnect = true;
	}				
}

function sendMessage(message){
	if(isConnect){
		ws.send(message);
	}else{
		alert("please connect to the server first !!!");
	}
}

function startServer(deviceUid){
	var url = (window.location.protocol == 'http:') ? 'ws://' : 'wss://' ;
	url += window.location.host + '/MesTouch/com/shoplink/websocket?deviceUid=' + deviceUid;
	connectServer(url);
	
	if(isConnect){
		ws.onclose = function(){isConnect = false;};
		ws.onmessage = function(message) {
			//btn1.set("caption", message.data);
//			alert(message.data);
			var btnMessage = view.get("#btnMessage");
			var dsMessage = view.get("#dsMessage");
			dsMessage.set("parameter", {
				deviceUid: deviceUid
			});
			dsMessage.flush();
			var unRead = dsMessage.getData().entityCount;
			btnMessage.set("badgeText", unRead);
			//dorado.widget.NotifyTipManager.notify(message.data);
		};
	}
}

/**
 * ---------------------����websocket---------------------------
 */

var deviceUid = "${param['deviceUid']}";

//@Bind view.onReady
!function(self, arg, iframeShopLink, dsMessage, btnMessage){
	iframeShopLink.set("path","com.mes.shopLink.Login.d?deviceUid=" + deviceUid);
	
	//����ϵͳ������websocket����
	//startServer(deviceUid);
	
	//fresh();
	//ϵͳ��Ϣ����
	function fresh(){
		
		dsMessage.set("parameter", {
			deviceUid: deviceUid
		});
		dsMessage.flush();
		var unRead = dsMessage.getData().entityCount;
		console.log(unRead);
		btnMessage.set("badgeText", unRead);
		
//		if(ioNum > 0){
//			dorado.widget.NotifyTipManager.notify("��׼������ǩ��!");
//		}
//		dorado.widget.NotifyTipManager.notify("���µ���Ϣ!");
		setTimeout(fresh, 5000);
	}
}

// @Bind #btnMain.onClick
!function(self, arg, labelTaskInfo){

	var iframe = view.get("#iframeShopLink");
	var toolBar = view.get("#tbShopLink");
	var btnGridorDetail = view.get("#btnGridorDetail");	
	
	var employeeId = self.get("userData.employeeId");
	var deptId = self.get("userData.deptId");
	var taskUid = self.get("userData.taskUid"); //��ʱ�Ȳ��øò���
	
	btnGridorDetail.set("visible",false);
	toolBar.set("caption","ShopLink");
	iframe.set("path","com.mes.shopLink.Main.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);
	
	iframe.set("userData", 0);

}

//@Bind #btnMessage.onClick
!function(self, arg, panelMessage, dsMessage){
	
	//Ӧ���жϽ�ȥ��ʱ����û����Ϣ����Ϣ�Ķ������Ҫ��
	//self.set("badgeText", 1);
	panelMessage.show();
	dsMessage.set("parameter", {
		deviceUid: deviceUid
	});
	dsMessage.flush();
	
}

//@Bind #dropdownStation.onOpen
!function(dsWorkStation){
	dsWorkStation.set("parameter", {
		deviceUid: deviceUid
	});
	dsWorkStation.flush();
}

//@Bind #btnSendMessage.onClick
!function(self, arg, editorProblem, dsWorkStation, ajaxSendMessage){
	
	var topic = editorProblem.get("text"); 
	var toDeviceUid = dsWorkStation.getData().current.get("stationId");
	ajaxSendMessage.set("parameter", {
		topic: topic,
		fromDeviceUid: deviceUid,
		toDeviceUid: toDeviceUid
	});
	
	ajaxSendMessage.execute(function(){
		//sendMessage("sss+2601007");
	});
}

//@Bind #btnHandleMessage.onClick
!function(self, arg, updateMessage, dsMessage, gridMessage, btnMessage, panelBoxed, dsStationMaterial, btnTool){
	
	var messages = gridMessage.get("selection");
	if(messages == ""){
		dorado.widget.NotifyTipManager.notify("���ȹ�ѡ!");
		return;
	}
	
	messages.each(
			function(entity){
				if(entity.get("topic") == "������ת"){
					panelBoxed.show();
					btnTool.set("exClassName", "btn-highlight");
					
					dsStationMaterial.set("parameter", {
						deviceUid: deviceUid,
						warehouseId: "MM_WIP",
						type: 'T'
					});
					dsStationMaterial.flush();
					
				}
			}
	);
	
	updateMessage.execute(function(){
		dsMessage.set("parameter", {
			deviceUid: deviceUid
		});
		dsMessage.flush();
		var unRead = dsMessage.getData().entityCount;
		btnMessage.set("badgeText", unRead);
	});
}


//@Bind #updateMessage.onGetUpdateData
!function(self, arg, gridMessage){
	// ��ע�⣺���UpdateAction�ж����˶��UpdateItem����ô���¼������ÿһ��UpdateItem����һ��,
	// ������Ҫ�ڴ��¼����жϵ�ǰ�����¼���UpdateItem����һ����
	arg.data = gridMessage.get("selection");
}

//@Bind #btnCloseMessage.onClick
!function(self, arg, panelMessage, btnMessage){
	panelMessage.hide();
	//btnMessage.set("badgeText", 0);
}


/**
 * --------------------����ҵ��--------------------------------------
 */

//@Bind #btnBoxed.onClick
!function(self, panelBoxed, dsStationMaterial, btnTool){

	panelBoxed.show();
	btnTool.set("exClassName", "btn-highlight");
	
	dsStationMaterial.set("parameter", {
		deviceUid: deviceUid,
		warehouseId: "MM_WIP",
		type: 'T'
	});
	dsStationMaterial.flush();
}

//@Bind #btnTool.onClick
//@Bind #btnPart.onClick
!function(self, dsStationMaterial, btnTool, btnPart){  
	
	var id = self.get("id");
	switch(id){		
		case "btnTool": 
			btnTool.set("exClassName", "btn-highlight");
			btnPart.set("exClassName", "");
			break;
		case "btnPart": 
			btnTool.set("exClassName", "");
			btnPart.set("exClassName", "btn-highlight");
			break;
	}
}

//@Bind #btnBoxedAdd1.onClick
//@Bind #btnBoxedMinus1.onClick
!function(self, dsStationMaterial){  
	
	var material = dsStationMaterial.getData().current;
	var applyQty = material.get("applyQty");
	
	var id = self.get("id");
	switch(id){		
		case "btnBoxedAdd1": 
			material.set("applyQty", applyQty + 1);
			break;
		case "btnBoxedMinus1": 
			material.set("applyQty", applyQty - 1);
			break;
	}
}

//@Bind #btnToBox.onClick
!function(self, dsBoxedDetail, dsStationMaterial, gridStationMaterial){
	
	var materials = gridStationMaterial.get("selection");
	var boxDetail = dsBoxedDetail.getData();
	
	var materialEntityList = dsStationMaterial.getData();
	
	
	if(materials == ""){
		dorado.widget.NotifyTipManager.notify("���ȹ�ѡ!");
		return;
	}	
	
	materials.each(
			function(entity){
				
				var detail = {
						$dataType : "BoxDetail",
						materialUsn : entity.get("materialUsn"),
						ioQty : entity.get("applyQty"),						
						binId : entity.get("binId"),
						warehouseId : entity.get("warehouseId")
				}
				
//				var newEntity = new dorado.Entity();
//				newEntity.set("materialUsn", entity.get("materialUsn"));
//				newEntity.set("ioQty", "2");
//				newEntity.set("binId", entity.get("binId"));
//				newEntity.set("warehouseId", entity.get("warehouseId"));
				
				boxDetail.insert(detail);
				
				var total = entity.get("receivedQty");
				var applyQty =  entity.get("applyQty");
				
				if(applyQty < total){ 
					//�Ȳ�����ǩ�պ�ϵͳ����
					//entity.set("receivedQty", entity.get("receivedQty") - entity.get("applyQty"));
					
				}else{ 
					
					materialEntityList.remove(entity);
				}
			}
	);	
}

//@Bind #editorEmptyBoxId.onPost
!function(self, dsBoxedDetail){
	
	var boxId = self.get("text");
	
	var boxDetail = dsBoxedDetail.getData();
	boxDetail.each(
			function(entity){
				entity.set("boxId", boxId);
			}
	);
	
	
	
}

//@Bind #editorSpecialPartForBoxed.onPost
!function(self, editorSpecialPart, dsBoxDetail){ //������
	
	var materialDesc = editorSpecialPart.get("text");
	
	var boxDetail = dsBoxDetail.getData();
	boxDetail.each(
			function(entity){
					
				entity.set("materialDesc", materialDesc);
			}
	);
}

//@Bind #updateSaveBoxed.onGetUpdateData
!function(self, arg, gridStationMaterial){
	// ��ע�⣺���UpdateAction�ж����˶��UpdateItem����ô���¼������ÿһ��UpdateItem����һ��,
	// ������Ҫ�ڴ��¼����жϵ�ǰ�����¼���UpdateItem����һ����
	arg.data = gridStationMaterial.get("selection");
}

//@Bind #btnSaveBoxedResult.onClick
!function(updateSaveBoxed, dsWorkStation){
	
//	var boxId = editorBoxId2.get("text");
	var destStationId = dsWorkStation.getData().current.get("stationId");
	updateSaveBoxed.set("parameter", {
		destStationId: destStationId,
		employeeId: "admin",//employeeId,
		deviceUid: deviceUid
	});
	
	updateSaveBoxed.execute();
	
}

//@Bind #btnCloseBoxed.onClick
!function(panelBoxed, dsBoxDetail){
	
	panelBoxed.hide();
	//dsBoxDetail.clear();
}




/**
 * --------------------����ҵ��--------------------------------------
 */


//@Bind #btnGridorDetail.onClick
!function(self, arg){

	var frameWindow = view.get("#iframeShopLink").get("iFrameWindow");
	var cardBook = frameWindow.$id("taskCardBook").objects[0];

	if(self.get("caption") == "�б���ʾ"){
		cardBook.set("currentIndex", 1);
		self.set("caption","��ϸ��ʾ");
	}else{
		cardBook.set("currentIndex", 0);
		self.set("caption","�б���ʾ");
	}

}