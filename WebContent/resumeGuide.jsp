<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>简历填写</title>
<link href="css/resumeGuide.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- 网站公共头部 -->
	<jsp:include page="top.jsp"></jsp:include>

	<div class="success_content">
		<div class="success_left">
			<div class=it-pageimg></div>
			<h3 align="center">操作成功！</h3>
		</div>
		<div class="success_right">
			<p class="green16">需要先完善个人信息</p>
			<p>选择以下任意一种方式完善信息</p>
			<p>
				<a href="resume.jsp"><span class="tn-button">填写信息</span></a><a
					href="index.jsp"><span class="tn-button">站点首页</span></a>
			</p>
		</div>
		<div class="clear"></div>
	</div>

</body>
</html>