<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>登录页面</title>
</head>
<body>
	<%
		String error = (String) request
				.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		if (error != null) {
	%>
	<div class="alert alert-error controls input-large">
		<button class="close" data-dismiss="alert">×</button>
		<%
			if (error.contains("DisabledAccountException")) {
					out.print("用户已被屏蔽,请登录其他用户");
				} else if (error.contains("UnknownAccountException")) {
					out.print("用户名错误");
				} else {
					out.print(error);
				}
		%>
	</div>
	<%
		}
	%>
	<form action="" method="post">
		<table>
			<tr>
				<td>账号</td>
				<td><input id="username" name="username" value="${username}" onfocus="this.select()"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" id="password" value="${password}" onfocus="this.select()"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="登录" onclick="return login();" /></td>
			</tr>
		</table>
	</form>
	<jsp:include page="${ctx}/view/fw/comm/IncludeCommJs.jsp" />
</body>
</html>

<script>
	$(function() {
		$("#username").focus();
	});

	function login() {
		var token_val = $("#username").val();
		var hash_val = CryptoJS.MD5($("#password").val());
		$.ajax({
			type : "post",
			url : "${ctx}/authc/login",
			data : "username=" + token_val + "&password=" + hash_val,
			async : false,
			error : function(request) {
				alert("服务器无响应，请检查是否网络问题");
			},
			success : function(data) {
				if (data === '登录成功') {
					location.href = "${ctx}/";
					return;
				}
				alert(data);
				if (data === '密码错误')
					$("#password").focus();
				else
					$("#username").focus();

			}
		});
		return false;
	}
</script>