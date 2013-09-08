<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
	<head>
		<title>Gallery</title>
	</head>
	<body>
		<s:iterator value="albums" var="album">
			<h1>${album.type} (${album.id}): ${album.name}</h1>

			<p>${album.description}</p>
		</s:iterator>

		<a href="<s:url action="Login" />">Login</a>
	</body>
</html>