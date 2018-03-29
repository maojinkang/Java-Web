<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册</title>
	<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<script type="text/javascript">
	function validate() {
		var email = document.getElementById("email");
		var password = document.getElementById("password");
		var password1 = document.getElementById("password1");
		var agree = document.getElementById("agree");
		var pattern = /^[1-9]{1}(\d+){7}/;

		if (email.value == "") {
			alert("学号不能为空！");
			email.focus();
			return false;
		} else if (!pattern.test(email.value)) {
			alert("请输入正确的学号格式！");
			email.focus();
			return false;
		}
		if (password.value == "") {
			alert("密码不能为空！");
			password.focus();
			return false;
		} else if (password.length<6 || password.length>12) {
			alert("密码长度不符合要求，请输入6-12位密码!");
			password.focus();
			return false;
		}
		if (password.value != password1.value) {
			alert("两次输入密码不相同！");
			password.focus();
			return false;
		}
		return true;
	}
	
	
	function changeValidateCode() {
		document.getElementById("validateCode").src = "ValidateCodeServlet?rand="
				+ Math.random();
	}
</script>

<body>
	<!-- 登录注册公共头部 -->
	<jsp:include page="top.jsp"></jsp:include>
<div class="row login-box">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-success">
			<div class="panel-heading" align="center">注册</div>
			<div class="panel-body">
			<form action="ApplicantRegisterServlet" method="post" class="form-horizontal" onsubmit="return validate();">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">学号</label>
					<div class="col-sm-9">
						<input class="form-control" type="text" name="email" id="email">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-9">
						<input class="form-control" type="password" name="password" id="password">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">再次输入</label>
					<div class="col-sm-9">
						<input class="form-control" type="password" name="password1" id="password1">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
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
					</div>
				</div> 
				<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-3">
						<input class="form-control" type="text" name="verifyCode">
					</div>
					<div class="col-sm-4" >
						<img src="ValidateCodeServlet" id="validateCode" title="点击换一换" onclick="changeValidateCode()">
						<a href="javascript:changeValidateCode();">看不清？</a>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="col-sm-4">
							<input type="submit" value="注册" class="btn btn-primary btn-block">
						</div>
					</div>
				</div>
			</form>
			</div>
			</div>
		</div>
	</div>
		<div class="col-md-12">
		<div align="center"><p>已有账号?<a href="login.jsp">登录</a></p>	</div>	
	</div>
</body>
</html>