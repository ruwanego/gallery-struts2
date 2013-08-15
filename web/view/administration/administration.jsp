<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Administration</title>
	</head>
	<body>
		<h1>Administration</h1>

		<s:iterator value="images" var="image">
			<li>
					${image.album.name}: ${image.name}
			</li>
		</s:iterator>

		<form action="<s:url action="Administration" method="upload" />" enctype="multipart/form-data" method="post">
			<select name="albumId">
				<s:iterator value="albums" var="album">
					<option value="${album.id}">
							${album.name}
					</option>
				</s:iterator>
			</select>
			<input type="file" name="upload"/>
			<input type="submit" value="Upload Image"/>
		</form>
	</body>
</html>