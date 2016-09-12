<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" autoFlush="false"
    import="cn.edu.buaa.mes.ShopLinkServiceHttpBindingStub, cn.edu.buaa.mes.ShopLinkServiceLocator, java.net.URL"%>

<%
//String path = request.getContextPath();
//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//String docurl = request.getParameter("docurl");


String fileUid = request.getParameter("fileUid");

String wsdlUrl ="http://192.168.100.109:9000/mm/services/shopLinkService"; 
URL serviceUrl = new URL(wsdlUrl);
ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);

String fileUrl = binding.getFileUrl(fileUid);


//test for PDF
//String fileUrl = "/MesTouch/sample.pdf";
		
%>


<html>
  <head>
  </head> 
  <body >
   <iframe name = "dociframe" width = "100%" height = "100%"  frameborder="no" border="0" margin = "0" src = "<%=fileUrl%>"></iframe>
	
  </body>
</html>