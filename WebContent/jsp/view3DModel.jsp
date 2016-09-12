<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" 
    import="cn.edu.buaa.mes.ShopLinkServiceHttpBindingStub, cn.edu.buaa.mes.ShopLinkServiceLocator, java.net.URL"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%


String fileUid = request.getParameter("fileUid");
//String docurl =  MMUtils.getFileUrl(fileUid);

//String docurl = request.getParameter("docurl");
//docurl = "http://192.168.100.109:8088" + docurl;

String wsdlUrl ="http://192.168.100.109:9000/mm/services/shopLinkService"; 
URL serviceUrl = new URL(wsdlUrl);
ShopLinkServiceHttpBindingStub binding = (ShopLinkServiceHttpBindingStub) new ShopLinkServiceLocator().getshopLinkServiceHttpPort(serviceUrl);

String fileUrl = binding.getFileUrl(fileUid);
//System.out.println(fileUrl);


//test for 3d
//String fileUrl = "/MesTouch/jietou_white.smg";

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
	

</script>
</head>
<body>
	
	
		<object id="_3DVIAPlayerActiveX" height="100%" width="100%"
			classid="CLSID:410B702D-FCFC-46B7-A954-E876C84AE4C0"
			>
				<param name="FileName" value="<%=fileUrl%>">
				<!-- 服务器下载模型参考getcheckinfo_via.jsp-->
				
				<param name="RenderGroundShadow" value="0"/>
				<param name="RenderMode" value="1"/>  <!-- 打底模式 实线加粗-->
				<param name="CameraPlayMode" value="0"/>
				<param name="AntiAliasingOnIdle" value="0"/>
				<param name="GroundGrid" value="1"/>  <!-- 底面打网格-->
				<param name="AutoPlay" value="0"/>
				<param name="ShowViewBar" value="0"/>
				<param name="ShowDiapoBar" value="0"/>
				<param name="ShowMarkerBar" value="0"/>
				<param name="ShowStandardToolBar" value="1"/>  <!-- 显示标准工具条-->
				<param name="ShowTimeLineBar" value="0"/>    <!-- 显示时间条-->
				<param name="ShowMain3DToolBar" value="0"/>   <!-- 显示主工具条-->
				<param name="ShowCollabToolBar" value="0"/>
				<param name="ShowPropertyBar" value="0">    <!-- 显示右侧属性设置区域-->
				<param name="UseGUID" value="0"/>
				<param name="ShowAssemblyTreeBar" value="0"/> <!-- 显示装配树-->
				<param name="ShowAnnotationToolBar" value="0"/> <!-- 显示注释工具条-->
            
           
            
		</object>
		
</body>
</html>