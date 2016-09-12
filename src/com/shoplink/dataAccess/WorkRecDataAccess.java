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

import org.springframework.stereotype.Component;

import cn.edu.buaa.mes.ShopLinkServiceHttpBindingStub;
import cn.edu.buaa.mes.ShopLinkServiceLocator;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;

import com.shoplink.entity.*;
import com.shoplink.util.JaxbUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Component
public class  WorkRecDataAccess {

	@DataProvider
	public void getDispatchedTasksByDeviceUidWithPage(Page<Task> page) {
		
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String returnStr = binding.getDispatchedTasksByDeviceUid("2140004");
			System.out.println(returnStr);
			
//			String result[] = returnStr.split("@");
			int totalCount = 0;
			String xml = "";
//			if(result.length == 2){
//				totalCount = Integer.parseInt(result[0]);
//				xml = result[1];
//			}
			
			totalCount = 6;
			xml = returnStr;
			
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("DeviceTaskData", List.class); 
			xstream.alias("Task", Task.class); 
//			xstream.alias("dept", Dept.class); 
			List es1 = new ArrayList();
	        es1 = (List)xstream.fromXML(xml);
			System.out.println(es1.size());
			
			page.setEntities(es1);
			page.setEntityCount(totalCount);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
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
	

	
}
