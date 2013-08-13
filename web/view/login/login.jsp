<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<h1>Login</h1>

		<s:if test="hasActionMessages()">
			<s:iterator value="actionMessages">

			</s:iterator>
		</s:if>

		<form action="<s:url action="Login" method="login" />" method="POST">
			<label for="login_form_login">Login:</label>
			<input type="text" id="login_form_login" name="form.login" />

			<label for="login_form_password">Password:</label>
			<input type="password" id="login_form_password" name="form.password" />

			<input type="submit" value="Login"/>
		</form>
	</body>
</html>