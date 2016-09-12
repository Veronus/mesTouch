/**
 * ---------------------用于websocket---------------------------
 */
var ws;
var isConnect = false;

function connectServer(host){
	window.WebSocket = window.WebSocket || window.MozWebSocket;
	if (!window.WebSocket) {	// 检测浏览器支持
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
 * ---------------------用于websocket---------------------------
 */

var deviceUid = "${param['deviceUid']}";

//@Bind view.onReady
!function(self, arg, iframeShopLink, dsMessage, btnMessage){
	iframeShopLink.set("path","com.mes.shopLink.Login.d?deviceUid=" + deviceUid);
	
	//进入系统，启动websocket连接
	//startServer(deviceUid);
	
	//fresh();
	//系统消息推送
	function fresh(){
		
		dsMessage.set("parameter", {
			deviceUid: deviceUid
		});
		dsMessage.flush();
		var unRead = dsMessage.getData().entityCount;
		console.log(unRead);
		btnMessage.set("badgeText", unRead);
		
//		if(ioNum > 0){
//			dorado.widget.NotifyTipManager.notify("请准备物资签收!");
//		}
//		dorado.widget.NotifyTipManager.notify("有新的消息!");
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
	var taskUid = self.get("userData.taskUid"); //暂时先不用该参数
	
	btnGridorDetail.set("visible",false);
	toolBar.set("caption","ShopLink");
	iframe.set("path","com.mes.shopLink.Main.d?deviceUid=" + deviceUid + "&employeeId=" + employeeId + "&deptId=" + deptId);
	
	iframe.set("userData", 0);

}

//@Bind #btnMessage.onClick
!function(self, arg, panelMessage, dsMessage){
	
	//应当判断进去的时候有没有消息（消息的定义很重要）
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
		dorado.widget.NotifyTipManager.notify("请先勾选!");
		return;
	}
	
	messages.each(
			function(entity){
				if(entity.get("topic") == "工具周转"){
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
	// 请注意：如果UpdateAction中定义了多个UpdateItem，那么本事件会针对每一个UpdateItem触发一次,
	// 可能需要在此事件中判断当前触发事件的UpdateItem是哪一个。
	arg.data = gridMessage.get("selection");
}

//@Bind #btnCloseMessage.onClick
!function(self, arg, panelMessage, btnMessage){
	panelMessage.hide();
	//btnMessage.set("badgeText", 0);
}


/**
 * --------------------组箱业务--------------------------------------
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
		dorado.widget.NotifyTipManager.notify("请先勾选!");
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
					//先不减，签收后系统控制
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
!function(self, editorSpecialPart, dsBoxDetail){ //已弃用
	
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
	// 请注意：如果UpdateAction中定义了多个UpdateItem，那么本事件会针对每一个UpdateItem触发一次,
	// 可能需要在此事件中判断当前触发事件的UpdateItem是哪一个。
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
 * --------------------组箱业务--------------------------------------
 */


//@Bind #btnGridorDetail.onClick
!function(self, arg){

	var frameWindow = view.get("#iframeShopLink").get("iFrameWindow");
	var cardBook = frameWindow.$id("taskCardBook").objects[0];

	if(self.get("caption") == "列表显示"){
		cardBook.set("currentIndex", 1);
		self.set("caption","详细显示");
	}else{
		cardBook.set("currentIndex", 0);
		self.set("caption","列表显示");
	}

}