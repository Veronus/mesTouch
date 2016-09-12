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
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import org.jdom.Document;
import org.jdom.Element;

@Component
public class  EmployeeDataAccess {
		
	@DataProvider
	public Collection<Employee> getEmployeeByCardId(Map<String, Object> params) {
		Collection<Employee> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String cardId = (String) params.get("cardId");
			//System.out.println(cardId);
			String returnStr = binding.getEmployeeByCardId(cardId);
			//System.out.println(returnStr);
			
			if(returnStr.length()>0){
				Entities employee = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = employee.getEmployeeList();
				//System.out.println(returnList.size());
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
	
	@Expose
	public boolean login(Map params) {
		boolean result = false;
		
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String employeeId = (String) params.get("employeeId");
			String password = (String) params.get("password");
			
			String returnStr = binding.login(employeeId, password);
			System.out.println(returnStr);
			
			if(returnStr.equals("true")){
				result = true;
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
			return result;
		}
		
	}
	
	
	@Expose
	@DataProvider
	public Collection<SumWorkRec> getEmployeeWorkrecByMonth(Map<String, Object> params) {
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
			String employeeId = (String) params.get("employeeUid");
			String fromDateStr = (String) params.get("fromDate");
			String toDateStr = (String) params.get("toDate");
			
			_fromDate = format.parse(fromDateStr);
			_toDate = format.parse(toDateStr);
			fromDate = Calendar.getInstance();
			fromDate.setTime(_fromDate);
			System.out.println(fromDate);
			toDate = Calendar.getInstance();
			toDate.setTime(_toDate);
			//System.out.println(planFinish);
			String returnStr = binding.getEmployeeWorkrecByMonth(employeeId, fromDate, toDate);
			System.out.println(returnStr);
			if(returnStr.length()>0){
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
	
	@Expose
	@DataProvider
	public Collection<QualityRec> getQualityRecByMonth(Map<String, Object> params) {
		Collection<QualityRec> returnList = new ArrayList();
		Date _fromDate = null;
		Date _toDate = null;
		Calendar fromDate = null;
		Calendar toDate = null;
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String employeeId = (String) params.get("employeeUid");
			String fromDateStr = (String) params.get("fromDate");
			String toDateStr = (String) params.get("toDate");
			
			_fromDate = format.parse(fromDateStr);
			_toDate = format.parse(toDateStr);
			fromDate = Calendar.getInstance();
			fromDate.setTime(_fromDate);
			System.out.println(fromDate);
			toDate = Calendar.getInstance();
			toDate.setTime(_toDate);
			//System.out.println(planFinish);
			String returnStr = binding.getQualityRecByMonth(employeeId, fromDate, toDate);
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
			if(returnStr.length()>0){
				Entities qualities = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = qualities.getQualityRecList();
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
	@Expose
	@DataProvider
	public Collection<NonWorkHour> getNonWorkHourByMonth(Map<String, Object> params) {
		Collection<NonWorkHour> returnList = new ArrayList();
		Date _fromDate = null;
		Date _toDate = null;
		Calendar fromDate = null;
		Calendar toDate = null;
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String employeeId = (String) params.get("employeeUid");
			String fromDateStr = (String) params.get("fromDate");
			String toDateStr = (String) params.get("toDate");
			
			_fromDate = format.parse(fromDateStr);
			_toDate = format.parse(toDateStr);
			fromDate = Calendar.getInstance();
			fromDate.setTime(_fromDate);
//			System.out.println(fromDate);
			toDate = Calendar.getInstance();
			toDate.setTime(_toDate);
			//System.out.println(planFinish);
			String returnStr = binding.getNonWorkHourByMonth(employeeId, fromDate, toDate);
			System.out.println(returnStr);
//			判断，如果后台返回的数据是否为空，分情况处理以免处理层报错，同时前台也弹出窗口提示
//			if(returnStr==""||returnStr==null){
//				
//			}
			if(returnStr.length()>0){
				Entities nonworkhours = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = nonworkhours.getNonWorkHourList();
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
	
	@Expose
	@DataProvider
	public void updateNonWorkHourApplyInfo(Map<String, Object> params){
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		System.out.println("**************更新非加工工时申请信息******************");
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
//			String deviceUid = (String) params.get("deviceUid");
			String employeeId = (String) params.get("employeeId");
			String applyType = (String) params.get("applyType");
			String applyHour = (String) params.get("applyHour");
			String applyReason = (String) params.get("applyReason");
			
			String returnStr = binding.updateNonWorkHourApplyInfo(employeeId, applyType, applyHour, applyReason);
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
	 * 获取非加工工时类型
	 * @return
	 */
	@DataProvider
	public Collection<TypesData> getWorkType(){
		Collection<TypesData> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String returnStr = binding.getWorkType();
			System.out.println(returnStr);
			if(returnStr.length() > 0){
				Entities typesdata = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = typesdata.getTypesDataList();
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
	/**
	 * 获取非加工工时事由
	 * @param params
	 * @return
	 */
	@DataProvider
	public Collection<TypesData> getWorkReason(Map<String, Object> params){
		Collection<TypesData> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String typeValue = (String) params.get("typeValue");
			String returnStr = binding.getWorkReason(typeValue);
			System.out.println(returnStr);
			if(returnStr.length() > 0){
				Entities typesdata = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = typesdata.getTypesDataList();
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
	
	/**
	 * 获取非加工工时统计信息
	 * @param params
	 * @return
	 */
	@Expose
	@DataProvider
	public Collection<SumWork> getPersonalOvertimeWork(Map<String, Object> params) {
		Collection<SumWork> returnList = new ArrayList();
		Date _fromDate = null;
		Date _toDate = null;
		Calendar fromDate = null;
		Calendar toDate = null;
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String employeeId = (String) params.get("employeeUid");
			String fromDateStr = (String) params.get("fromDate");
			String toDateStr = (String) params.get("toDate");
			
			_fromDate = format.parse(fromDateStr);
			_toDate = format.parse(toDateStr);
			fromDate = Calendar.getInstance();
			fromDate.setTime(_fromDate);
			System.out.println(fromDate);
			toDate = Calendar.getInstance();
			toDate.setTime(_toDate);
			//System.out.println(planFinish);
			String returnStr = binding.getPersonalOvertimeWork(employeeId, fromDate, toDate);
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
			if(returnStr.length()>0){
				Entities sumworks = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = sumworks.getSumWorkList();
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
	

    
}
