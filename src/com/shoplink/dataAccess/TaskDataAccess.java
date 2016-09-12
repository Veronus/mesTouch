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
import com.shoplink.entity.CheckBill;
import com.shoplink.entity.CheckBillDetail;
import com.shoplink.entity.Employee;
import com.shoplink.entity.Entities;
import com.shoplink.entity.InvInfo;
import com.shoplink.entity.Material;
import com.shoplink.entity.Task;
import com.shoplink.entity.WorkRec;
import com.shoplink.util.JaxbUtil;
import com.shoplink.util.XmlUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import org.jdom.Document;
import org.jdom.Element;

@Component
public class  TaskDataAccess {

//	private String testDeviceUid = "192168100147";
//	private String testTaskUid = "2074878";
//	private String testAssin = "3834277";
	
	
	@DataProvider
	public void getDispatchedTasksByDeviceUidWithPage(Page<Task> page) {
		
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String testDeviceUid = "192168100147";
			
			String returnStr = binding.getDispatchedTasksByDeviceUid(testDeviceUid);
			System.out.println(returnStr);
			
			Document doc = XmlUtils.string2Doc(returnStr);
			Element root = doc.getRootElement();
			Element eTotalCount = root.getChild("totalCount");
			Element eData = root.getChild("data");
			
			int totalCount = 0;
			String xml = "";
			
			totalCount = Integer.parseInt(eTotalCount.getTextTrim());
			xml = XmlUtils.ele2String(eData);
			
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("DeviceTaskData", List.class); 
			xstream.alias("Task", Task.class); 
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@DataProvider
	public Collection<Task> getDispatchedTasksByDeviceUid(Map params) {
		Collection<Task> returnList = new ArrayList<Task>();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String deviceUid = (String)params.get("deviceUid");
			String returnStr = binding.getDispatchedTasksByDeviceUid(deviceUid);
			//System.out.println(returnStr);
			
			Entities tasks = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
			returnList = tasks.getTaskList();
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
	public Collection<InvInfo> getTaskWips(Map<String, Object> params) {
		Collection<InvInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);

			String taskUid = (String) params.get("taskUid");
			String assnUid = (String) params.get("assnUid");
			String deviceUid = (String) params.get("deviceUid");
			String returnStr = binding.getTaskWips(taskUid, assnUid, deviceUid);
			System.out.println(returnStr);
			
			if(returnStr.length() > 0){
//				XStream xstream = new XStream(new DomDriver());
//				xstream.alias("list", List.class); 
//				returnList = (List)xstream.fromXML(returnStr);
//				System.out.println(returnList.size());
				
				Entities invInfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = invInfos.getInvInfoList();
				System.out.println(returnList.size());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataProvider
	public Collection<InvInfo> getTaskTools(Map<String, Object> params) {
		Collection<InvInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String taskUid = (String) params.get("taskUid");
			String deviceUid = (String) params.get("deviceUid");
			String toolType = (String) params.get("toolType");
			
			String returnStr = binding.getTaskTools(taskUid, deviceUid, toolType);
			System.out.println(returnStr);
			
			if(returnStr.length() > 0){
//				XStream xstream = new XStream(new DomDriver());
//				xstream.alias("list", List.class); 
//				returnList = (List)xstream.fromXML(returnStr);
//				System.out.println(returnList.size());
				
				Entities invInfos = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = invInfos.getInvInfoList();
				System.out.println(returnList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataProvider
	public List<CheckBill> getCheckBillByTaskUid(Map<String, Object> params) {
		List<CheckBill> returnList = new ArrayList<CheckBill>();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String taskUid = (String) params.get("taskUid");
			int checkType = Integer.parseInt(String.valueOf(params.get("checkType")));
			String returnStr = binding.getCheckBillByTaskUid(taskUid, checkType);
			//System.out.println(returnStr);
			
			if(returnStr.length() > 0){
//				XStream xstream = new XStream(new DomDriver());
//				xstream.alias("list", List.class); 
//				returnList = (List)xstream.fromXML(returnStr);
//				System.out.println(returnList.size());
				
				Entities checkBills = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				
				returnList = checkBills.getCheckBillList();
				
				
				
				//System.out.println(returnList.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
	@DataProvider
	public List<CheckBill> addCheckBillByTaskUid(Map<String, Object> params) {
		List<CheckBill> returnList = new ArrayList<CheckBill> ();
			try {
				String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
				URL serviceUrl = new URL(wsdlUrl);
				ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
				String taskUid = (String) params.get("taskUid");
				int checkType = Integer.parseInt(String.valueOf(params.get("checkType")));
				String returnStr = binding.addCheckBillByTaskUid(taskUid, checkType);
				//System.out.println(returnStr);
				
				if(returnStr.length() > 0){
					
					Entities checkBills = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
					returnList = checkBills.getCheckBillList();
					
					//System.out.println(returnList.get(0).getCheckBillDetails().get(0).getLBound());
					//System.out.println(returnList.size());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				return returnList;
			}
		}
		
	
	@DataProvider
	public Collection<Material> getMaterialListByTaskUid(Map<String, Object> params) {
		Collection<Material> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String taskUid = (String) params.get("taskUid");
			String returnStr = binding.getMaterialListByTaskUid(taskUid);
			//System.out.println(returnStr);
			
			if(returnStr.length() > 0){
				
				Entities materials = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = materials.getMaterialList();
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
	public void feedBackTask(List<WorkRec> workrecs) {
		String xml = "";
		List<WorkRec> wcs = new ArrayList<WorkRec>();
		for(WorkRec e : workrecs){   
			WorkRec wc = new WorkRec(); 
			try {
				BeanUtils.copyProperties(e, wc);
				if(EntityState.NEW.equals(EntityUtils.getState(e))){
					wc.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(e))){
					wc.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(e))){
					wc.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				wcs.add(wc);

			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		try {
			
			Entities workRecs = new Entities();
			workRecs.setWorkrecList(wcs);
			xml = JaxbUtil.convertToXml(workRecs);
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
			String returnStr = binding.feedbackTask(xml);
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
	public void applyToolOut(List<InvInfo> invInfos) {
		String xml = "";
		List<InvInfo> iis = new ArrayList<InvInfo>();
		for(InvInfo e : invInfos){   
			InvInfo ii = new InvInfo(); 
			try {
				BeanUtils.copyProperties(e, ii);
				
				if(EntityState.NEW.equals(EntityUtils.getState(e))){
					ii.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
				}else if(EntityState.DELETED.equals(EntityUtils.getState(e))){
					ii.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
				}if(EntityState.MODIFIED.equals(EntityUtils.getState(e))){
					ii.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
				}
				iis.add(ii);
				
				XStream xstream = new XStream();
				xml = xstream.toXML(iis);
				System.out.println(xml);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			String returnStr = "";//binding.applyToolOut(xml);
			System.out.println(returnStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Expose
	public void startCheckTask(Map params) {

		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String taskUid = (String) params.get("taskUid");
			String checkType = params.get("checkType").toString();
			
			String returnStr = binding.startCheckTask(taskUid, checkType);
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
	public void saveCheckBills(List<CheckBill> checkBills) {
		
		String xml = "";
		
		List<CheckBill> bills = new ArrayList<CheckBill>();
		for(CheckBill c : checkBills){   
			CheckBill bill = new CheckBill(); 
			try {
				
				String checkBillUid = c.getCheckBillUid();
				String task = c.getTaskUid();
				
				if(checkBillUid == ""){
					
					String[] s = {"checkBillDetails"};
					BeanUtils.copyProperties(c, bill, s);
					
					bill.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
									
					List<CheckBillDetail> details = new ArrayList<CheckBillDetail>();
					for(CheckBillDetail d : c.getCheckBillDetails()){
						
						CheckBillDetail detail = new CheckBillDetail();
						
						BeanUtils.copyProperties(d, detail);
						
						detail.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
						
						details.add(detail);					
					}
					
					bill.setCheckBillDetails(details);				
					bills.add(bill);
				}else{
					
					String[] s = {"checkBillDetails"};
					BeanUtils.copyProperties(c, bill, s);
						
					if(EntityState.NEW.equals(EntityUtils.getState(c))){
						bill.setObjectState(BasicModel.OBJECTSTATE_TOBEADDED);
					}else if(EntityState.DELETED.equals(EntityUtils.getState(c))){
						bill.setObjectState(BasicModel.OBJECTSTATE_TOBEDELETED);
					}if(EntityState.MODIFIED.equals(EntityUtils.getState(c))){
						bill.setObjectState(BasicModel.OBJECTSTATE_TOBEUPDATED);
					}
					
									
					List<CheckBillDetail> details = new ArrayList<CheckBillDetail>();
					for(CheckBillDetail d : c.getCheckBillDetails()){
						
						CheckBillDetail detail = new CheckBillDetail();
						
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
					
					bill.setCheckBillDetails(details);				
					bills.add(bill);
					
				}												
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		
		try {
			
			
			Entities taskCheckBills = new Entities();
			taskCheckBills.setCheckBillList(bills);
			xml = JaxbUtil.convertToXml(taskCheckBills);
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
			String returnStr = binding.saveCheckBills(xml);
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
	public void finishCheckTask(Map params) {

		
		String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
		URL serviceUrl;
		try {
			serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String taskUid = (String) params.get("taskUid");
			String checkType = params.get("checkType").toString();
			
			String returnStr = binding.finishCheckTask(taskUid, checkType);
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
	public Collection<Material> getMaterialByBarcode(Map params){
		
		Collection<Material> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String barcode = (String) params.get("barcode");
			String returnStr = binding.getMaterialByBarcode(barcode);
			System.out.println(returnStr);
		
			if(returnStr.length() > 0){
				Entities materials = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = materials.getMaterialList();
				System.out.println(returnList.size());
			}
			

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return returnList;
		}
	}
	
	
}
