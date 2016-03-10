<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <p>
  测试字符串：<br />
  [{"BeanName":"yan","Attribute":"condition","Elements":{"s2":["0.2","0.5"],"s1":["1.6","0.5"]},"YouduValue":"-100"},{"BeanName":"si","Attribute":"condition","Elements":{"wuyan":["2.0","0.5"],"jinzhu":["-0.5","0.5"]},"YouduValue":"-100"}]
  </p>
  	<s:form action="Youdu">
     <s:textfield name="jsonString" label="json字符串:"/>
     <s:submit name="Youdu" value="优度评价" />
    </s:form>
  </body>
</html>
