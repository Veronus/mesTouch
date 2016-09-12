package com.shoplink.dataAccess;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.velocity.runtime.parser.ParseException;
import org.jdom.Document;
import org.jdom.Element;
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
import com.mes.common.model.BasicModel;
import com.shoplink.entity.CheckUpRecFeedback;
import com.shoplink.entity.CheckupRec;
import com.shoplink.entity.Device;
import com.shoplink.entity.DeviceMainTainRec;
import com.shoplink.entity.DeviceStateInfo;
import com.shoplink.entity.Entities;
import com.shoplink.entity.Task;
import com.shoplink.entity.TypesData;
import com.shoplink.entity.DeviceMainTainRec;
import com.shoplink.entity.WorkRec;
import com.shoplink.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Component
public class DeviceDataAccess {
	private String testDeviceUid = "192168100147";
	private String testEmployeeId = "192168100147";
	private String testProblemCode = "192168100147";
	private String testProblemDesc = "192168100147";
	private String testProblemType = "";
	/**
	 * 获取设备故障列表
	 * @return
	 */
	@DataProvider
	public Collection<TypesData> getDeviceProblemList() {
		Collection<TypesData> returnList = new ArrayList();
		//System.out.println("dorado7");
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String returnStr = binding.getDeviceProblemList();
			System.out.println(returnStr);
			
			if(returnStr.length() > 0){
//				XStream xstream = new XStream(new DomDriver());
//				xstream.alias("list", List.class); 
//				returnList = (List)xstream.fromXML(returnStr);
//				System.out.println(returnList.size());
				
				Entities typesdata = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = typesdata.getTypesDataList();
				System.out.println(returnList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	/**
	 * 初步将点检模板字段写入点检记录表
	 * @param params
	 */
	//2014-10-20
	@Expose
	public void writeDeviceCheckupRecord(Map<String, Object> params) {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl;
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>初次写入点检记录");
			try {
				serviceUrl = new URL(wsdlUrl);
				ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
				
				String deviceUid = (String) params.get("deviceUid");
				
				String returnStr = binding.writeDeviceCheckupRecord(deviceUid);
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
	//2014-10-21
	/**
	 * 更新点检记录
	 * @param checkupfeedbacks
	 */
	@DataResolver
	@Transactional
	public void updateDeviceCheckupRecord(List<CheckUpRecFeedback> checkupfeedbacks) {
		String xml = "";
		List<CheckUpRecFeedback> checkup = new ArrayList<CheckUpRecFeedback>();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>更新点检记录");
		for(CheckUpRecFeedback e : checkupfeedbacks){   
			System.out.println(e.getCheckResults());
			CheckUpRecFeedback cu = new CheckUpRecFeedback(); 
			try {
				BeanUtils.copyProperties(e, cu);
				if(EntityState.NEW.equals(EntityUtils.getState(e))){
					cu.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(e))){
					cu.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(e))){
					cu.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				checkup.add(cu);
				
				XStream xstream = new XStream();
				xml = xstream.toXML(checkup);
				System.out.println(xml);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		//System.out.println("---------------------------------------");
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String returnStr = binding.updateDeviceCheckupRecord(xml);
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
	
	/**
	 * 获取点检记录表
	 * @param params
	 * @return
	 */
	@DataProvider
	public Collection<CheckupRec> getDeviceCheckupRecord(Map<String, Object> params){
		Collection<CheckupRec> returnList = new ArrayList();
		
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String deviceUid = (String) params.get("deviceUid");
			String returnStr = binding.getDeviceCheckupRecord(deviceUid);
			System.out.println(returnStr);
			
			if(returnStr.length() > 0){
//				XStream xstream = new XStream(new DomDriver());
//				xstream.alias("list", List.class); 
//				returnList = (List)xstream.fromXML(returnStr);
//				System.out.println(returnList.size());
				
				Entities checkuprecs = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = checkuprecs.getCheckupRecList();
				System.out.println(returnList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	/**
	 * 增减一条故障任务
	 * @param params
	 * @return
	 */
	//2014-10-22
	@Expose
	public Collection<Device> addMaintTask(Map<String, Object> params){
		Collection<Device> returnList = new ArrayList();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>增加维修任务");
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String deviceUid = (String) params.get("deviceUid");
			String employeeId = (String) params.get("employeeUid");
			String problemCode = (String) params.get("problemCode");
			String problemDesc = (String) params.get("problemDesc");
			String returnStr = binding.addMaintTask(deviceUid, employeeId, problemCode, problemDesc);
			System.out.println(returnStr);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	/**
	 * 开始一条故障任务
	 * @param params
	 * @return
	 */
	@Expose
	public String startMaintTask(Map<String, Object> params){
		String returnStr = "";
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<开始维修");
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String deviceUid = (String) params.get("deviceUid");
			String employeeId = (String) params.get("employeeUid");
			returnStr = binding.startMaintTask(deviceUid, employeeId);
			System.out.println(returnStr);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(returnStr);
			return returnStr;
		}
	}
	
	/**
	 * 确定故障的预计修复时间
	 * @param params
	 * @return
	 * @throws ParseException
	 */
	//2014-10-23
	@Expose
	public String updatePlanchangeResumeTime(Map<String, Object> params) throws ParseException{
		String returnStr = "";
		Date date = null;
		Calendar planFinish = null;
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		boolean result = false;
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String deviceUid = (String) params.get("deviceUid");
			String employeeId = (String) params.get("employeeUid");
			String planFinishStr = (String) params.get("planFinish");
			date = format.parse(planFinishStr);
			planFinish = Calendar.getInstance();
			planFinish.setTime(date);
			System.out.println(planFinish);
			//System.out.println(planFinish);
			result = binding.updatePlanResumeTime(deviceUid, employeeId, planFinish);
			System.out.println(result);
			returnStr = "预定恢复时间设定成功";
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(returnStr);
			return returnStr;
		}
	}
	
	/**
	 * 取消一条故障任务
	 * @param params
	 * @return
	 */
	@Expose
	public String cancelMaintTask(Map<String, Object> params){
		String returnStr = "";
		System.out.println("<><><><><><><><><><><><><><><><><><><>");
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String deviceUid = (String) params.get("deviceUid");
			String employeeId = (String) params.get("employeeUid");
			returnStr = binding.cancelMaintTask(deviceUid, employeeId);
			System.out.println(returnStr);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return returnStr;
		}
	}
	
	/**
	 * 完成一条故障任务
	 * @param params
	 * @return
	 */
	@Expose
	public Collection<Device> finishMaintTask(Map<String, Object> params){
		Collection<Device> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String deviceUid = (String) params.get("deviceUid");
			String employeeId = (String) params.get("employeeUid");
			String returnStr = binding.finishMaintTask(deviceUid, employeeId);
			System.out.println(returnStr);
//			
//			Document doc = XmlUtils.string2Doc(returnStr);
//			Element root = doc.getRootElement();
//			Element eTotalCount = root.getChild("totalCount");
//			Element eData = root.getChild("DeviceTaskData");
//			
//			int totalCount = 0;
//			String xml = "";
//			
//			totalCount = Integer.parseInt(eTotalCount.getTextTrim());
//			xml = XmlUtils.ele2String(eData);
			
//			XStream xstream = new XStream(new DomDriver());
//			xstream.alias("DeviceData", List.class); 
//			xstream.alias("Device", Device.class); 
//			returnList = (List)xstream.fromXML(xml);
//			System.out.println(returnList.size());
			if(returnStr.length()>0){
				Entities devices = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = devices.getDeviceList();
				System.out.println(returnList.size());
			}

			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	/**
	 * 获取故障维修记录表
	 * @return
	 */
	@DataProvider
	public Collection<DeviceMainTainRec> getDeviceStateHistroyInfo() {
		Collection<DeviceMainTainRec> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String returnStr = binding.getDeviceStateHistroyInfo(testDeviceUid);
			System.out.println(returnStr);
			
			if(returnStr.length() > 0){
//				XStream xstream = new XStream(new DomDriver());
//				xstream.alias("list", List.class); 
//				returnList = (List)xstream.fromXML(returnStr);
//				System.out.println(returnList.size());
				
				Entities deviceMainTainRecs = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = deviceMainTainRecs.getDeviceMainTainRecList();
				System.out.println(returnList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	/**
	 * 获取设备状态
	 * @return
	 */
	@DataProvider
	public Collection<DeviceStateInfo> getDeviceStateInfo() {
		Collection<DeviceStateInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String returnStr = binding.getDeviceStateInfo(testDeviceUid);
//			returnList.add(str);
			if(returnStr.length() > 0){
				Entities deviceStateInfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = deviceStateInfos.getDeviceStateInfoList();
				System.out.println(returnList.size());
				System.out.println(returnStr);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;	
		}
	}
	
	/**
	 * 更新设备故障（该方法暂时未用到）
	 * @param deviceUid
	 * @return
	 */
	@DataProvider
	public Collection<Device> updateDeviceProblem(String deviceUid){
		Collection<Device> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String returnStr = binding.updateDeviceProblem(testDeviceUid, testEmployeeId, testProblemCode, testProblemType);
			System.out.println(returnStr);
			
			Document doc = XmlUtils.string2Doc(returnStr);
			Element root = doc.getRootElement();
			Element eTotalCount = root.getChild("totalCount");
			Element eData = root.getChild("DeviceTaskData");
			
			int totalCount = 0;
			String xml = "";
			
			totalCount = Integer.parseInt(eTotalCount.getTextTrim());
			xml = XmlUtils.ele2String(eData);
			
//			XStream xstream = new XStream(new DomDriver());
//			xstream.alias("DeviceData", List.class); 
//			xstream.alias("Device", Device.class); 
//			returnList = (List)xstream.fromXML(xml);
//			System.out.println(returnList.size());
			if(returnStr.length()>0){
				Entities devices = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = devices.getDeviceList();
				System.out.println(returnList.size());
			}

			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	/**
	 * 获取设备信息
	 * @return
	 */
	@DataProvider
	public Collection<Device> getDeviceInfoByDeviceUid(String deviceUid) {
		Collection<Device> returnList = new ArrayList();
		//System.out.println("dorado7");
		try {
			
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String returnStr = binding.getDeviceInfoByDeviceUid(deviceUid);
			
			if(returnStr.length() > 0){

				Entities devices = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = devices.getDeviceList();
				//System.out.println(returnList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
}
