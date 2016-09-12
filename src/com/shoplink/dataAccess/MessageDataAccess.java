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
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import org.jdom.Document;
import org.jdom.Element;

@Component
public class  MessageDataAccess {
	
	@DataProvider
	public Collection<Message> getUnReadMessagesByEmployeeId(Map<String, Object> params) {
		Collection<Message> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String employeeId = (String) params.get("employeeId");
			//System.out.println(cardId);
			String returnStr = binding.getUnReadMessagesByEmployeeId(employeeId);
			System.out.println(returnStr);
			
//			XStream xstream = new XStream(new DomDriver());
//			xstream.alias("list", List.class); 
//			returnList = (List)xstream.fromXML(returnStr);
			if(returnStr.length()>0){
				Entities messages = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = messages.getMessageList();
				System.out.println(returnList.size());
			}
			System.out.println(returnList.size());
			
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
	
	
	
	@DataProvider
	public Collection<DeviceProblem> getProblemType(Map<String, Object> params) {
		Collection<DeviceProblem> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String messageTo = (String) params.get("messageTo");
			//System.out.println(cardId);
			String returnStr = binding.getProblemType(messageTo);
			System.out.println(returnStr);
			
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("list", List.class);
			returnList = (List)xstream.fromXML(returnStr);
	
			System.out.println(returnList.size());
			
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
	

	//2014-10-17---liuzhen
	@Expose
	public void sendMessage(Map<String, Object> params) {		
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl;
			System.out.println(params);
			
			try {
				serviceUrl = new URL(wsdlUrl);
				ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
				String deviceUid = (String) params.get("deviceUid");
				String employeeId = (String) params.get("employeeId");
				String taskUid = (String) params.get("taskUid");
				String problemCode = (String) params.get("problemCode");
				String problemDesc = (String) params.get("problemDesc");
				String messageUser = (String) params.get("messageUser");
				String returnStr = binding.sendMessage(deviceUid, employeeId, taskUid, problemCode,
						problemDesc, messageUser);
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
	
	
	@Expose
	public void sendShoplinkMessage(Map params) {		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		System.out.println(params);
		
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String fromDeviceUid = (String) params.get("fromDeviceUid");
			String toDeviceUid = (String) params.get("toDeviceUid");
			String topic = (String) params.get("topic");
			String returnStr = binding.sendShoplinkMessage(topic, fromDeviceUid, toDeviceUid, "");
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
	public void sendShoplinkMessageTool(InvInfo invInfo, Map params) {
				
		String xml = "";
		List<InvInfo> list = new ArrayList<InvInfo>();
		InvInfo inv = new InvInfo(); 
		try {
			BeanUtils.copyProperties(invInfo, inv);
			if(EntityState.NEW.equals(EntityUtils.getState(invInfo))){
				inv.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
			}else if(EntityState.DELETED.equals(EntityUtils.getState(invInfo))){
				inv.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
			}if(EntityState.MODIFIED.equals(EntityUtils.getState(invInfo))){
				inv.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
			}
			list.add(inv);
			
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
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
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String fromDeviceUid = (String) params.get("fromDeviceUid");
			String toDeviceUid = (String) params.get("toDeviceUid");
			String topic = (String) params.get("topic");
			String returnStr = binding.sendShoplinkMessage(topic, fromDeviceUid, toDeviceUid, xml);
			System.out.println(returnStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@DataProvider
	public Collection<Message> getMessageByDeviceUid(Map params) {
		Collection<Message> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String deviceUid = (String) params.get("deviceUid");
			//System.out.println(cardId);
			String returnStr = binding.getMessageByDeviceUid(deviceUid);
			System.out.println(returnStr);
			if(returnStr.length()>0){
				Entities messages = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = messages.getMessageList();
//				System.out.println(returnList.size());
			}
			System.out.println(returnList.size());
			
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

	@DataResolver
	@Transactional
	public void updateMessageState(List<Message> messages) {
		
		String xml = "";
		
		List<Message> messageList = new ArrayList<Message>();
		for(Message m : messages){   
			Message message = new Message(); 
			BeanUtils.copyProperties(m, message);
			messageList.add(message);
		}
		
		
		try {
			Entities entities = new Entities();
			entities.setMessageList(messageList);
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
			
			String returnStr = binding.updateMessageState(xml);
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
