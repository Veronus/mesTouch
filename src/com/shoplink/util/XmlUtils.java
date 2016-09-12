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
     * Elementת��Ϊ�ַ���  
     *   
     * @param xmlFilePath XML�ļ�·��  
     * @return xmlStr �ַ���  
     * @throws Exception  
     */  
    public static String ele2String(Element ele) throws Exception {   
        Format format = Format.getPrettyFormat();   
        format.setEncoding("GBK");// ����xml�ļ����ַ�ΪUTF-8�������������   
        XMLOutputter xmlout = new XMLOutputter(format);   
        ByteArrayOutputStream bo = new ByteArrayOutputStream();   
        xmlout.output(ele, bo);  
        return bo.toString();   
    }
    
    
    /**   
     * �ַ���ת��ΪDOCUMENT   
     *    
     * @param xmlStr �ַ���   
     * @return doc JDOM��Document   
     * @throws Exception   
     */    
    public static Document string2Doc(String xmlStr) throws Exception {     
        java.io.Reader in = new StringReader(xmlStr);     
        Document doc = (new SAXBuilder()).build(in);            
        return doc;     
    }   
    
    
}
