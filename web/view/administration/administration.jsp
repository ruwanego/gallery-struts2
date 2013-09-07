<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Administration</title>
	</head>
	<body>
		<h1>Administration</h1>

		<ul>
			<s:iterator value="images" var="image_container">
				<s:url action="ImageLoader" method="image" var="image_data">
					<s:param name="imageId">
						${image_container.id}
					</s:param>
				</s:url>
				<li>${image_container.name}</li>
				<li><img src="${image_data}"></li>
			</s:iterator>
		</ul>

		<form action="<s:url action="Administration" method="saveAlbum" />" method="post">
			<label>Name: <input type="text" name="form.album_name"></label>
			<label>Description: <textarea name="form.album_description"></textarea></label>
			<input type="submit" value="Save Album">
		</form>

		<form action="<s:url action="Administration" method="upload" />" enctype="multipart/form-data" method="post">
			<select name="albumId">
				<s:iterator value="albums" var="album">
					<option value="${album.id}">
							${album.name}
					</option>
				</s:iterator>
			</select>
			<label>Image description: <textarea name="form.image_description"></textarea></label>
			<input type="file" name="upload">
			<input type="submit" value="Upload Image">
		</form>
	</body>
</html>