<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'downloadFile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
  </head>
  
  <body>
 	 <%
		response.setContentType("text/html");
		javax.servlet.ServletOutputStream ou = response.getOutputStream();
		//String filepath=request.getParameter("filePath");
		String fileName = "F://OAGISv9.pdf";
		//String filename=new String(request.getParameter(fileName).getBytes("ISO8859_1"),"GB2312").toString();
		String filename=new String(fileName.getBytes("ISO8859_1"),"GB2312").toString();
		//System.out.println("DownloadFile filepath:" + filepath);
		System.out.println("DownloadFile filename:" + filename);
		java.io.File file = new java.io.File(filename);

		//java.io.File file = new java.io.File(filepath + filename);
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath() + " file not exists!");
			return;
		}
		
		java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
		if (filename != null && filename.length() > 0) {
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(filename.getBytes("gb2312"),"iso8859-1") + "");
			if (fileInputStream != null) {
				int filelen = fileInputStream.available();
				byte a[] = new byte[filelen];
				fileInputStream.read(a);
				ou.write(a);
			}
			fileInputStream.close();
			ou.close();
		}
	 %>
  

  </body>
</html>
