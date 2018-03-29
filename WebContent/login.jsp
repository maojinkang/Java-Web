<%@page import="com.qst.itoffer.util.CookieEncryptTool"%>
<%-- <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript">
	function validate() {
		var email = document.getElementById("email");
		var password = document.getElementById("password");
		if (email.value == "") {
			alert("账号不能为空！");
			email.focus();
			return false;
		}
		if (password.value == "") {
			alert("密码不能为空！");
			password.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
		<!-- 登录注册公共头部 -->
	<jsp:include page="top.jsp"></jsp:include>
	<% 
	String cookieEmail = "";
	String cookiePwd = "";
	String cookieType = "";
	Cookie[] cookies = request.getCookies();
	
	if(cookies!=null){
		for(Cookie cookie:cookies){
			if("cookieEmail".equals(cookie.getName())){
				cookieEmail = CookieEncryptTool.decodeBase64(cookie.getValue());
			}
			if("cookiePwd".equals(cookie.getName())){
				cookiePwd = CookieEncryptTool.decodeBase64(cookie.getValue());
			}
			if("cookieType".equals(cookie.getName())){
				cookieType = CookieEncryptTool.decodeBase64(cookie.getValue());
			}
		}
	}
	%>
	<div class="row login-box">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-success">
			<div class="panel-heading" align="center">登录</div>
			<div class="panel-body">
			<form action="ApplicantLoginServlet" method="post" class="form-horizontal" onsubmit="return validate();">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">学号</label>
					<div class="col-sm-9">
						<input class="form-control" type="text" name="email" id="email" value="<%=cookieEmail %>">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-9">
						<input class="form-control" type="password" name="password" id="password" value="<%=cookiePwd %>">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<%if(cookieType.equals("teacher")){ %>
						<div class="radio-inline">
							<label>
								<input type="radio" name="userType" checked="checked" value="teacher">教师
							</label>
						</div>
						<div class="radio-inline">
							<label>
								<input type="radio" name="userType" value="student">学生
							</label>
						</div>
						<div class="radio-inline">
							<label>
								<input type="radio" name="userType" value="admin">管理员
							</label>
						</div>
						<%}else if(cookieType.equals("student")){ %>
						<div class="radio-inline">
							<label>
								<input type="radio" name="userType" value="teacher">教师
							</label>
						</div>
						<div class="radio-inline">
							<label>
								<input type="radio" name="userType" checked="checked" value="student">学生
							</label>
						</div>
						<div class="radio-inline">
							<label>
								<input type="radio" name="userType" value="admin">管理员
							</label>
						</div>
						<%}else{ %>
						<div class="radio-inline">
							<label>
								<input type="radio" name="userType" value="teacher">教师
							</label>
						</div>
						<div class="radio-inline">
							<label>
								<input type="radio" name="userType" value="student">学生
							</label>
						</div>
						<div class="radio-inline">
							<label>
								<input type="radio" name="userType" checked="checked" value="admin">管理员
							</label>
						</div>
						<%} %>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="col-sm-4">
							<input type="submit" value="登录" class="btn btn-primary btn-block">
						</div>
						<div class="col-sm-6">
							<input type="checkbox" checked="checked" name="rememberMe" id="rememberMe" value="true">
							<label for="text" class="control-label">记住密码</label>
						</div>
					</div>
				</div>
			</form>
			</div>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<div align="center"><p>还没有注册?<a href="register.jsp">请先注册</a></p>	</div>	
	</div>
</body>
</html>