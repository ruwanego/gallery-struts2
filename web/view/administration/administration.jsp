<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Administration</title>
	</head>
	<body>
		<h1>Administration</h1>

		<ul>
			<s:iterator value="albums" var="album">
				<li>
					(${album.id}) ${album.name}: ${album.description}
				</li>
			</s:iterator>
		</ul>

		<form enctype="multipart/form-data">
			<input type="file" name="upload"/>
			<input type="submit" value="Upload Image"/>
		</form>
	</body>
</html>