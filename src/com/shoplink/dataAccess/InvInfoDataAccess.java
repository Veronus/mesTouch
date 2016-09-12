package com.shoplink.dataAccess;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.buaa.mes.ShopLinkServiceHttpBindingStub;
import cn.edu.buaa.mes.ShopLinkServiceLocator;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.mes.common.model.BasicModel;
import com.shoplink.entity.*;
import com.shoplink.util.JaxbUtil;


@Component
public class InvInfoDataAccess {

	
	@DataProvider
	public Collection<InvInfo> getStationInvInfo(Map params) {
		Collection<InvInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String deviceUid = (String) params.get("deviceUid");
		    String toolType = (String) params.get("toolType");
			
			String returnStr = binding.getStationInvInfo(deviceUid, toolType);
			//System.out.println(returnStr);
			
			if(returnStr.length() > 0){
				Entities invInfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = invInfos.getInvInfoList();
				//System.out.println(returnList.size());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	@DataProvider
	public Collection<InvInfo> getStationToReturnInvInfo(Map params) {
		Collection<InvInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);

			String deviceUid = (String) params.get("deviceUid");
			String returnStr = binding.getStationToReturnInvInfo(deviceUid);


			if(returnStr.length() > 0){
				Entities invInfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = invInfos.getInvInfoList();
				//System.out.println(returnList.size());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	@DataProvider
	public Collection<Warehouse> getStationWarehouse(Map params) {
		Collection<Warehouse> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);

			String deviceUid = (String) params.get("deviceUid");
			String returnStr = binding.getStationWarehouse(deviceUid);
			
//			XStream xstream = new XStream(new DomDriver());
//			xstream.alias("list", List.class); 
//			returnList = (List)xstream.fromXML(returnStr);
			
			if(returnStr.length() > 0){
				Entities warehouses = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = warehouses.getWarehouseList();
				//System.out.println(returnList.size());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataProvider
	public Collection<WorkStation> getStation(Map params) {
		Collection<WorkStation> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String deviceUid = (String) params.get("deviceUid");
			String returnStr = binding.getStationList(deviceUid);
			
//			XStream xstream = new XStream(new DomDriver());
//			xstream.alias("list", List.class); 
//			returnList = (List)xstream.fromXML(returnStr);
			
			if(returnStr.length() > 0){
				Entities workStations = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = workStations.getWorkStationList();
				//System.out.println(returnList.size());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataProvider
	public Collection<InvIo> getInvIoInfo(Map<String, Object> params) {
		Collection<InvIo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String invIoId = (String) params.get("invIoId");
			
			String returnStr = binding.getInvIoInfo(invIoId);
			
			System.out.println(returnStr);
			
//			XStream xstream = new XStream(new DomDriver());
//			xstream.alias("list", List.class); 
//			returnList = (List)xstream.fromXML(returnStr);
			
			if(returnStr.length() > 0){
				Entities invIos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = invIos.getInvIoList();
				System.out.println(returnList.size());
			}

				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataResolver
	@Transactional
	public void signMaterialResource(Map<String, Object> params) {
		
		
		String invIoId = (String) params.get("invIoId");
		String deviceUid = (String) params.get("deviceUid");
		String employeeId = (String) params.get("employeeId");
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.signMaterialResource(invIoId, deviceUid, employeeId);
			System.out.println(returnStr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@DataResolver
	@Transactional
	public void stationToolOutApply(List<InvInfo> invInfos, Map params) {
				
		String xml = "";
		List<InvInfo> list = new ArrayList<InvInfo>();
		for(InvInfo i : invInfos){   
			InvInfo inv = new InvInfo(); 
			try {
				BeanUtils.copyProperties(i, inv);
				if(EntityState.NEW.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				list.add(inv);
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		try {
			
			Entities toolInvInfos = new Entities();
			toolInvInfos.setInvInfoList(list);
			xml = JaxbUtil.convertToXml(toolInvInfos);
			//System.out.println(xml);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		String deptId = (String) params.get("deptId");
		String deviceUid = (String) params.get("deviceUid");
		String employeeId = (String) params.get("employeeId");
		String destWarehouseId = (String) params.get("destWarehouseId");
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.stationToolOutApply(destWarehouseId, deptId, deviceUid, employeeId, xml);
			System.out.println(returnStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@DataResolver
	@Transactional
	public void taskToolOutApply(List<InvInfo> invInfos, Map params) {
				
		String xml = "";
		List<InvInfo> list = new ArrayList<InvInfo>();
		for(InvInfo i : invInfos){   
			InvInfo inv = new InvInfo(); 
			try {
				BeanUtils.copyProperties(i, inv);
				if(EntityState.NEW.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				list.add(inv);
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}	
		
		try {
			
			Entities toolInvInfos = new Entities();
			toolInvInfos.setInvInfoList(list);
			xml = JaxbUtil.convertToXml(toolInvInfos);
			//System.out.println(xml);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String deptId = (String) params.get("deptId");
		String taskUid = (String) params.get("taskUid");
		String employeeId = (String) params.get("employeeId");
		String deviceUid = (String) params.get("deviceUid");
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.taskToolOutApply(deviceUid, taskUid, deptId, employeeId, xml);
			System.out.println(returnStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@DataProvider
	public Collection<ToolInvInfo> getToolInvDetail(Map params) {
				
		Collection<ToolInvInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String partNumber = (String) params.get("partNumber");
			String returnStr = binding.getToolInvDetail(partNumber);
			
			if(returnStr.length() > 0){
				
				Entities toolInvInfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = toolInvInfos.getToolInvInfoList();
				//System.out.println(returnList.size());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}

	}
	
	@DataProvider
	public Collection<ToolInvInfo> getStationToolInvDetail(Map params) {
				
		Collection<ToolInvInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String deviceUid = (String) params.get("deviceUid");
			String partNumber = (String) params.get("partNumber");
			String returnStr = binding.getStationToolInvDetail(deviceUid, partNumber);
			
			if(returnStr.length() > 0){
				
				Entities toolInvInfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = toolInvInfos.getToolInvInfoList();
				//System.out.println(returnList.size());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}

	}
	
	@DataResolver
	@Transactional
	public void shiftWorkStation(List<InvInfo> invInfos, Map params) {
				
		String xml = "";
		List<InvInfo> list = new ArrayList<InvInfo>();
		for(InvInfo i : invInfos){   
			InvInfo inv = new InvInfo(); 
			try {
				BeanUtils.copyProperties(i, inv);
				if(EntityState.NEW.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				list.add(inv);
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
		try {
			
			Entities toolInvInfos = new Entities();
			toolInvInfos.setInvInfoList(list);
			xml = JaxbUtil.convertToXml(toolInvInfos);
			//System.out.println(xml);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		String deptId = (String) params.get("deptId");
		String deviceUid = (String) params.get("deviceUid");
		String employeeId = (String) params.get("employeeId");
		String destStationId = (String) params.get("destStationId");
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.shiftWorkStation(destStationId, employeeId, deviceUid, xml);
			System.out.println(returnStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Expose
	public void taskWipOutApply(Map params) {
				
	
		String deptId = (String) params.get("deptId");
		String taskUid = (String) params.get("taskUid");
		String employeeId = (String) params.get("employeeId");
		String ioType = (String) params.get("ioType");
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.taskWipOutApply(taskUid, deptId, employeeId, ioType);
			System.out.println(returnStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Expose
	public void taskWipInApply(Map params) {
				
	
		String deptId = (String) params.get("deptId");
		String taskUid = (String) params.get("taskUid");
		String employeeId = (String) params.get("employeeId");
		String ioType = (String) params.get("ioType");
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.taskWipInApply(taskUid, deptId, employeeId, ioType);
			System.out.println(returnStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	@DataResolver
	@Transactional
	public void backToWarehouse(List<InvInfo> invInfos, Map params) {
				
		String xml = "";
		List<InvInfo> list = new ArrayList<InvInfo>();
		for(InvInfo i : invInfos){   
			InvInfo inv = new InvInfo(); 
			try {
				BeanUtils.copyProperties(i, inv);
				if(EntityState.NEW.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				list.add(inv);
				
//				XStream xstream = new XStream();
//				xml = xstream.toXML(list);
//				System.out.println(xml);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		try {
			
			Entities backInvInfos = new Entities();
			backInvInfos.setInvInfoList(list);
			xml = JaxbUtil.convertToXml(backInvInfos);
			//System.out.println(xml);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
				
		String deviceUid = (String) params.get("deviceUid");
		String employeeId = (String) params.get("employeeId");
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.backToWarehouse(deviceUid, employeeId, xml);
			System.out.println(returnStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@DataProvider
	public Collection<ToolClassInfo> getToolsByParentId(String parentId){
		
		Collection<ToolClassInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			//String parentId = (String) params.get("parentId");
			
			if(parentId == null){
				
				parentId = "T";
			}
			String returnStr = binding.getToolsByParentId(parentId);
		
			if(returnStr.length() > 0){
				
				Entities toolClassInfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = toolClassInfos.getToolClassInfoList();
				//System.out.println(returnList.size());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}

	@DataProvider
	public Collection<ToolInvInfo> getToolInvInfoByToolType(Map params){
		
		Collection<ToolInvInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String destWarehouseId = " ";
			String toolType = (String) params.get("toolType");
			int startRow = Integer.parseInt(String.valueOf(params.get("startRow")));
			
			String returnStr = binding.getToolInvInfoByToolType(destWarehouseId, toolType, startRow);
			if(returnStr.length() > 0){
				Entities toolInvInfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = toolInvInfos.getToolInvInfoList();
				System.out.println(returnList.size());
			}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	/**
	 * -------------------------2015-04-06------------------------------
	 */
	
	@DataProvider
	public Collection<BoxDetail> getBoxDetailByBoxId(Map params){
		
		Collection<BoxDetail> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String boxId = (String) params.get("boxId");
			
			String returnStr = binding.getBoxDetailByBoxId(boxId);
			
			if(returnStr.length() > 0){
				Entities boxDetails = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = boxDetails.getBoxDetailList();
				System.out.println(returnList.size());
			}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataResolver
	public void saveBoxDividedResult(List<BoxDetail> box, List<BoxDetail> box2, String boxId) {
				
		String xml = "";
		String xml2 = "";
		
		List<BoxDetail> list = new ArrayList<BoxDetail>();
		List<BoxDetail> list2 = new ArrayList<BoxDetail>();
		
		for(BoxDetail d : box){   
			BoxDetail boxDetail = new BoxDetail(); 
			try {
				BeanUtils.copyProperties(d, boxDetail);
				if(EntityState.NEW.equals(EntityUtils.getState(d))){
					boxDetail.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(d))){
					boxDetail.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(d))){
					boxDetail.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				list.add(boxDetail);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		for(BoxDetail d : box2){   
			BoxDetail boxDetail = new BoxDetail(); 
			try {
				BeanUtils.copyProperties(d, boxDetail);
				if(EntityState.NEW.equals(EntityUtils.getState(d))){
					boxDetail.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(d))){
					boxDetail.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(d))){
					boxDetail.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				list2.add(boxDetail);
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		try {
			
			Entities entities = new Entities();
			entities.setBoxDetailList(list);
			xml = JaxbUtil.convertToXml(entities);
			//System.out.println(xml);
			
			Entities entities2 = new Entities();
			entities2.setBoxDetailList(list2);
			xml2 = JaxbUtil.convertToXml(entities2);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
				
//		String boxId = (String) params.get("boxId");
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.saveBoxDividedResult(xml, xml2);
			System.out.println(returnStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Expose
	public void addBox(){
		
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.addBox();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@DataProvider
	public Collection<Box> getStationBoxByDeviceUid(Map params){
		
		Collection<Box> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String deviceUid = (String) params.get("deviceUid");
			
			String returnStr = binding.getStationBoxByDeviceUid(deviceUid);
			
			if(returnStr.length() > 0){
				Entities entities = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = entities.getBoxList();
				System.out.println(returnList.size());
			}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataProvider
	public Collection<InvInfo> getStationMaterial(Map params) {
		Collection<InvInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String deviceUid = (String) params.get("deviceUid");
			String warehouseId = (String) params.get("warehouseId");
		    String type = (String) params.get("type");
			
			String returnStr = binding.getStationMaterial(deviceUid, warehouseId, type);
			//System.out.println(returnStr);
			
			if(returnStr.length() > 0){
				Entities invInfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = invInfos.getInvInfoList();
				//System.out.println(returnList.size());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataResolver
	public void saveBoxedResult(List<BoxDetail> boxDetails, List<InvInfo> invInfos, Map params) {
				
		String xml = "";
		String xml2 = "";
		
		List<BoxDetail> list = new ArrayList<BoxDetail>();
		for(BoxDetail d : boxDetails){   
			BoxDetail boxDetail = new BoxDetail(); 
			try {
				BeanUtils.copyProperties(d, boxDetail);
				if(EntityState.NEW.equals(EntityUtils.getState(d))){
					boxDetail.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(d))){
					boxDetail.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(d))){
					boxDetail.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				list.add(boxDetail);
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		List<InvInfo> list2 = new ArrayList<InvInfo>();
		for(InvInfo i : invInfos){   
			InvInfo inv = new InvInfo(); 
			try {
				BeanUtils.copyProperties(i, inv);
				if(EntityState.NEW.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(i))){
					inv.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				list2.add(inv);
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		try {
			
			Entities entities = new Entities();
			entities.setBoxDetailList(list);
			xml = JaxbUtil.convertToXml(entities);
			System.out.println(xml);
			
			Entities toolInvInfos = new Entities();
			toolInvInfos.setInvInfoList(list2);
			xml2 = JaxbUtil.convertToXml(toolInvInfos);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
				
		String employeeId = (String) params.get("employeeId");
		String deviceUid = (String) params.get("deviceUid");
		String destStationId = (String) params.get("destStationId");
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.saveBoxedResult(destStationId, employeeId, deviceUid, xml, xml2);
			System.out.println(returnStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Expose
	@Transactional
	public void signBoxMaterial(Map<String, Object> params) {
		
		
		String boxId = (String) params.get("boxId");
		String deviceUid = (String) params.get("deviceUid");
		String employeeId = (String) params.get("employeeId");
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String returnStr = binding.signBoxMaterial(boxId, deviceUid, employeeId);
			System.out.println(returnStr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@DataProvider
	public Collection<InvIo> alertStationSign(Map params) {
		Collection<InvIo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String deviceUid = (String) params.get("deviceUid");
			String returnStr = binding.alertStationSign(deviceUid);
			
			if(returnStr.length() > 0){
				Entities invIos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = invIos.getInvIoList();
				//System.out.println(returnList.size());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataProvider
	public List<SpecialBill> addSpecialPartBillForWip(Map params) {
		
		List<SpecialBill> returnList = new ArrayList<SpecialBill>();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String xml = "";
			Entities entities = new Entities();
			int type = (Integer) params.get("type");
			if (1 == type) {
				ArrayList<InvInfo> wips = new ArrayList<InvInfo>();
				wips = (ArrayList<InvInfo>) params.get("wips");
				entities.setInvInfoList(wips);
				xml = JaxbUtil.convertToXml(entities);
			} else {
				
				ArrayList<CheckBill> bills = new ArrayList<CheckBill>();
				CheckBill bill = (CheckBill) params.get("bills");
				bills.add(bill);
				entities.setCheckBillList(bills);
				xml = JaxbUtil.convertToXml(entities);
			}
			
			String taskUid = (String) params.get("taskUid");
			
			String returnStr = binding.addSpecialPartBillForWip(type, taskUid, xml);
			//System.out.println(returnStr);
			
			if(returnStr.length() > 0){
				
				entities = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = entities.getSpecialPartList();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	@DataProvider
	public List<SpecialBill> getLatestSpecialPartBillForWip(Map params) {
		
		List<SpecialBill> returnList = new ArrayList<SpecialBill>();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String taskUid = (String) params.get("taskUid");
			
			String returnStr = binding.getLatestSpecialPartBillForWip(taskUid);
			//System.out.println(returnStr);
			
			if(returnStr.length() > 0){
				Entities entities = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = entities.getSpecialPartList();				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	@DataResolver
	@Transactional
	public void saveSpecialPartBill(List<SpecialBill> specialBills, Map params) {
		
		String xml = "";
		
		List<SpecialBill> bills = new ArrayList<SpecialBill>();
		for(SpecialBill sp : specialBills){   
			SpecialBill bill = new SpecialBill(); 
			try {
				
				String specialBillUid = sp.getSpecialBillUid();
//				String task = c.getTaskUid();
				
				if(specialBillUid == ""){
					
					String[] s = {"specialPartDetails"};
					BeanUtils.copyProperties(sp, bill, s);
					
					bill.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
									
					List<SpecialBillDetail> details = new ArrayList<SpecialBillDetail>();
					for(SpecialBillDetail d : sp.getSpecialPartDetails()){
						
						SpecialBillDetail detail = new SpecialBillDetail();
						
						BeanUtils.copyProperties(d, detail);
						
						detail.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
						
						details.add(detail);					
					}
					
					bill.setSpecialPartDetails(details);				
					bills.add(bill);
				}else{
					
					String[] s = {"specialPartDetails"};
					BeanUtils.copyProperties(sp, bill, s);
						
					if(EntityState.NEW.equals(EntityUtils.getState(sp))){
						bill.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
					}else if(EntityState.DELETED.equals(EntityUtils.getState(sp))){
						bill.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
					}if(EntityState.MODIFIED.equals(EntityUtils.getState(sp))){
						bill.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
					}
					
									
					List<SpecialBillDetail> details = new ArrayList<SpecialBillDetail>();
					for(SpecialBillDetail d : sp.getSpecialPartDetails()){
						
						SpecialBillDetail detail = new SpecialBillDetail();
						
						BeanUtils.copyProperties(d, detail);
						
						if(EntityState.NEW.equals(EntityUtils.getState(d))){
							detail.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
						}else if(EntityState.DELETED.equals(EntityUtils.getState(d))){
							detail.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
						}if(EntityState.MODIFIED.equals(EntityUtils.getState(d))){
							detail.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
						}
						
						details.add(detail);					
					}
					
					bill.setSpecialPartDetails(details);				
					bills.add(bill);
					
				}												
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		
		try {
			
			Entities entities = new Entities();
			entities.setSpecialPartList(bills);
			xml = JaxbUtil.convertToXml(entities);
			System.out.println(xml);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String trackingType = (String) params.get("trackingType");
			String returnStr = binding.saveSpecialPartBill(trackingType, xml);
			System.out.println(returnStr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@DataProvider
	public List<SpecialBill> getSpecialPartDetailByTaskUid(Map params) {
		
		List<SpecialBill> returnList = new ArrayList<SpecialBill>();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			int taskSquence = (Integer) params.get("taskSquence");
			String taskUid = (String) params.get("taskUid");
			
			
			String returnStr = binding.getSpecialPartDetailByTaskUid(taskUid, taskSquence);
			//System.out.println(returnStr);
			
			if(returnStr.length() > 0){
				
				Entities entities = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = entities.getSpecialPartList();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataProvider
	public Collection<BoxDetail> getBoxDestinationList(Map params){
		
		Collection<BoxDetail> returnList = new ArrayList<BoxDetail>();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String boxId = (String) params.get("boxId");
			
			String returnStr = binding.getBoxDestinationList(boxId);
			
			if(returnStr.length() > 0){
				Entities boxDetails = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = boxDetails.getBoxDetailList();
				System.out.println(returnList.size());
			}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	@DataProvider
	public Collection<TypesData> getSpecialTypeList(Map params){
		
		Collection<TypesData> returnList = new ArrayList<TypesData>();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			
			String returnStr = binding.getSpecialTypeList();
			
			if(returnStr.length() > 0){
				Entities entities = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = entities.getTypesDataList();
				System.out.println(returnList.size());
			}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	@DataProvider
	public Collection<SpecialPartDesc> getSpecialPartDescList(Map params){
		
		Collection<SpecialPartDesc> returnList = new ArrayList<SpecialPartDesc>();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			
			String trackingType = (String) params.get("trackingType");
			String materialUsn = (String) params.get("materialUsn");
			String taskUid = (String) params.get("taskUid");
			
			String returnStr = binding.getSpecialPartDescListByMaterialUsnAndTaskUid(
					trackingType, materialUsn, taskUid);
			
			if(returnStr.length() > 0){
				Entities entities = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = entities.getSpecialPartDescList();
				System.out.println(returnList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
//	@DataProvider
//	public Collection<InvInfo> getTaskWipsSignInfo(Map params){
//		
//		Collection<InvInfo> returnList = new ArrayList<InvInfo>();
//		try {
//			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
//			URL serviceUrl = new URL(wsdlUrl);
//			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
//			
//			String partNumber = (String) params.get("partNumber");
//			String deviceUid = (String) params.get("deviceUid");
//			
//			String returnStr = binding.getTaskWipsSignInfo(partNumber, deviceUid);
//			
//			if(returnStr.length() > 0){
//				Entities entities = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
//				returnList = entities.getInvInfoList();
//				System.out.println(returnList.size());
//			}
//				
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			return returnList;
//		}
//	}

	/**
	 * -------------------------2015-04-06------------------------------
	 */
}
