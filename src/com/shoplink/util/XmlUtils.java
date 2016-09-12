package com.shoplink.util;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public abstract class XmlUtils {

    /**  
     * Element转换为字符串  
     *   
     * @param xmlFilePath XML文件路径  
     * @return xmlStr 字符串  
     * @throws Exception  
     */  
    public static String ele2String(Element ele) throws Exception {   
        Format format = Format.getPrettyFormat();   
        format.setEncoding("GBK");// 设置xml文件的字符为UTF-8，解决中文问题   
        XMLOutputter xmlout = new XMLOutputter(format);   
        ByteArrayOutputStream bo = new ByteArrayOutputStream();   
        xmlout.output(ele, bo);  
        return bo.toString();   
    }
    
    
    /**   
     * 字符串转换为DOCUMENT   
     *    
     * @param xmlStr 字符串   
     * @return doc JDOM的Document   
     * @throws Exception   
     */    
    public static Document string2Doc(String xmlStr) throws Exception {     
        java.io.Reader in = new StringReader(xmlStr);     
        Document doc = (new SAXBuilder()).build(in);            
        return doc;     
    }   
    
    
}
