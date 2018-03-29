<%@page import="com.qst.itoffer.dao.ApplicantDAO"%>
<%@page import="com.qst.itoffer.info.Applicantinfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel=stylesheet href="css/bootstrap/css/bootstrap.css">
</head>
<body>
	<jsp:include page="top.jsp" />
	<jsp:useBean id="studentinfo" scope="request"
		class="com.qst.itoffer.info.Studentinfo"></jsp:useBean>
	<jsp:setProperty property="*" name="studentinfo" />
	<%
	int id = Integer.valueOf(request.getParameter("id"));
	ApplicantDAO dao = new ApplicantDAO();
	String sno = dao.selectEmail(id);
	%>
	<div>
	<div class="col-md-8 col-md-offset-2">
	
		<div class="panel panel-default">
			<!-- 标题 -->
			<div class="panel-heading">
				<h3 class="panel-title">个人信息</h3>
			</div>

			<div class="panel-body">

				<div class="panel-body">
					<!-- 表单 -->
					<form action="#" method="post" class="form-horizontal">
						
						<div class="form-group col-sm-8">
							<label>学号：<%=sno %></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>姓名：<jsp:getProperty property="STUDENT_NAME" name="studentinfo"/></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>院系：<jsp:getProperty property="STUDENT_DEPARTMENT" name="studentinfo"/></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>性别：<jsp:getProperty property="sex" name="studentinfo"/>
							 </label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>专业：<jsp:getProperty property="STUDENT_MAJOR" name="studentinfo"/></label>
						</div>
						
						<div class="form-group col-sm-8">
							<label>班级：<jsp:getProperty property="STUDENT_CLASS" name="studentinfo"/></label>
						</div>
						
						<p><img src="images/person_img.jpg" class="img-rounded"></p>
						<div class="form-group col-sm-8">
							<a href="UpdateInfo.jsp?id=<%=id %>" class="btn btn-primary" role="button">修改信息</a>
						</div>			
					</form>
				</div>
			</div>
		</div>
		
		</div>
		
	</div>
</body>
</html>