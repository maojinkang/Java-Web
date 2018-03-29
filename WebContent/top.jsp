<%@page import="com.qst.itoffer.info.Applicantinfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网站头部文件</title>
</head>
<body>
	<%
		if(session.getAttribute("applicantinfo")!=null){//已登录
			Applicantinfo user = (Applicantinfo)session.getAttribute("applicantinfo");
			if(user.getAPPLICANT_TYPE().equals("student")){
				//学生登录
	%>
			<jsp:include page="TopFiles/top1.jsp"></jsp:include>
  			<%}else if(user.getAPPLICANT_TYPE().equals("teacher")){
  				//老师登录
  	%>
  			<jsp:include page="TopFiles/top2.jsp"></jsp:include>
  			<%}else{ 
  			//管理员登录%>
  			<jsp:include page="TopFiles/top3.jsp"></jsp:include>
  			<%}
		}else{//未登录 %>
  		<jsp:include page="TopFiles/top4.jsp"></jsp:include>
  		<%} %>
</body>
</html>