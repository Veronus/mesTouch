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
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Component;

import cn.edu.buaa.mes.ShopLinkServiceHttpBindingStub;
import cn.edu.buaa.mes.ShopLinkServiceLocator;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
import com.shoplink.entity.CheckupRec;
import com.shoplink.entity.Entities;
import com.shoplink.entity.ShiftInfo;
import com.shoplink.entity.SumWorkRec;
import com.shoplink.entity.TakeOverEmployeeInfo;
import com.shoplink.util.JaxbUtil;

@Component
public class ShiftDataAccess {

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
	 * 本班加工记录
	 * @param params
	 * @return
	 */
	@DataProvider
	public Collection<SumWorkRec> getEmployeeWorkrecByShift(Map<String, Object> params) {
		Collection<SumWorkRec> returnList = new ArrayList();
		Date _fromDate = null;
		Date _toDate = null;
		Calendar fromDate = null;
		Calendar toDate = null;
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			//由于数据库的原因暂时使用固定的参数
			String employeeId = (String) params.get("employeeUid");//"admin021";
			String fromDateStr = (String) params.get("fromDate");//"2012/11/1";
			String toDateStr = (String) params.get("toDate");//"2012/11/30";
			_fromDate = format.parse(fromDateStr);
			_toDate = format.parse(toDateStr);
			fromDate = Calendar.getInstance();
			fromDate.setTime(_fromDate);
			System.out.println(fromDate);
			toDate = Calendar.getInstance();
			toDate.setTime(_toDate);
			String returnStr = binding.getEmployeeWorkrecByMonth(employeeId, fromDate, toDate);
			System.out.println(returnStr);
			
//			String result[] = returnStr.split("@");
//			int totalCount = 0;
//			String xml = "";
//			totalCount = 6;
//			xml = returnStr;
//			XStream xstream = new XStream(new DomDriver());
//			xstream.alias("DeviceTaskData", List.class); 
//			xstream.alias("Task", Task.class); 
//			returnList = new ArrayList();
//			returnList = (List)xstream.fromXML(xml);
//			System.out.println(returnList.size());
			if(returnStr.length() > 0){
				Entities sumworkrecs = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = sumworkrecs.getSumWorkRecList();
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
		} finally {
			return returnList;
		}
		
	}
	
	@DataProvider
	public Collection<TakeOverEmployeeInfo> getTakeOverEmployee(Map<String, Object> params){
		Collection<TakeOverEmployeeInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String employeeId = (String) params.get("employeeId");
//			String shiftId = (String) params.get("shiftId");
			String returnStr = binding.getTakeOverEmployee(employeeId);
			System.out.println(returnStr);
			
			if(returnStr.length() > 0){
				Entities takeoveremployeeinfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = takeoveremployeeinfos.getTakeoveremployeeList();
				System.out.println(returnList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	/**
	 * 获取交班信息
	 * @param params
	 * @return
	 */
	@DataProvider
	public Collection<ShiftInfo> getShiftInfo(Map<String, Object> params){
		Collection<ShiftInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String employeeId = (String) params.get("employeeId");
			String deviceUid = (String) params.get("deviceUid");
//			String shiftId = (String) params.get("shiftId");
			String returnStr = binding.getShiftInfo(employeeId, deviceUid);
			System.out.println(returnStr);
			
			if(returnStr.length() > 0){
				Entities shiftinfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = shiftinfos.getShiftInfoList();
				System.out.println(returnList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	/**
	 * 更新交班信息
	 * @param params
	 */
	@Expose
	public void updateShiftInfo(Map<String, Object> params){
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		System.out.println("**************更新交班信息******************");
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String deviceUid = (String) params.get("deviceUid");
			String employeeId = (String) params.get("employeeId");
			String uniqueId = (String) params.get("uniqueId");
			String shiftId = (String) params.get("shiftId");
			String returnStr = binding.updateShiftInfo(employeeId, deviceUid, shiftId, uniqueId);
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
	
}
