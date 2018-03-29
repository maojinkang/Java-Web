<%@page import="com.qst.itoffer.info.Classinfo"%>
<%@page import="com.qst.itoffer.info.Majorinfo"%>
<%@page import="java.util.List"%>
<%@page import="com.qst.itoffer.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="col-md-6 col-md-offset-3">
	<c:forEach items="${list_D}" var="department">
		<div class="col-sm-3">
			<a class="btn btn-info btn-xs" href="selectallStuendt.jsp?d_id=${department.department_id }&&page=two">${department.name }</a>
		</div>
	</c:forEach>
	</div>
	 	<%if(request.getParameter("page").equals("two")){
			int d_id = Integer.valueOf(request.getParameter("d_id"));
			StudentDAO dao = new StudentDAO();
			List<Majorinfo> list = dao.selectM(d_id);
			request.setAttribute("list_M", list);
		%>
	<div class="col-md-6 col-md-offset-3">	
	<c:forEach items="${list_M}" var="major">
		<div class="col-sm-3">
			<a class="btn btn-info btn-xs" href="selectallStuendt.jsp?m_id=${major.major_id }&&page=three">${major.name }</a>
		</div>
	</c:forEach>
	</div><%} %>
	
		<%if(request.getParameter("page").equals("three")){
			int m_id = Integer.valueOf(request.getParameter("m_id"));
			StudentDAO dao = new StudentDAO();
			List<Classinfo> list = dao.selectC(m_id);
			request.setAttribute("list_C", list);
		%>
	<div class="col-md-6 col-md-offset-3">
	<c:forEach items="${list_C}" var="classs">
		<div class="col-sm-3">
			<a class="btn btn-info btn-xs" href="SelectStudentServlet?class_id=${classs.class_id }">${classs.name }</a>
		</div>
	</c:forEach>
	</div><%} %>
</body>
</html>