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
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;

import com.mes.common.model.BasicModel;
import com.shoplink.entity.Entities;
import com.shoplink.entity.FileInfo;
import com.shoplink.entity.Task;
import com.shoplink.entity.WorkRec;
import com.shoplink.util.JaxbUtil;
import com.shoplink.util.XmlUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import org.jdom.Document;
import org.jdom.Element;

@Component
public class  FileInfoDataAccess {

	
	@DataProvider
	public Collection<FileInfo> getTaskProcessFiles(Map params ) {
		Collection<FileInfo> returnList = new ArrayList();
		try {
			String wsdlUrl ="http://127.0.0.1:9000/mm/services/shopLinkService"; 
			URL serviceUrl = new URL(wsdlUrl);
			ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);
			
			String fileType = (String) params.get("fileType");
			String taskUid = (String) params.get("taskUid");
			
			String returnStr = binding.getTaskProcessFiles(taskUid, fileType);
			//System.out.println(returnStr);
			
//			XStream xstream = new XStream(new DomDriver());
//			xstream.alias("list", List.class); 
//			returnList = (List)xstream.fromXML(returnStr);
//	
//			System.out.println(returnList.size());
			if(returnStr.length() > 0){
				Entities files = JaxbUtil.converyToJavaBean(returnStr, Entities.class);
				returnList = files.getFileInfoList();
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
	
	

	

	

    
}
