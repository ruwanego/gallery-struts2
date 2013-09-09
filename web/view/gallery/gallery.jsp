<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
	<head>
		<title>Gallery</title>
	</head>
	<body>
		<div class="row">
			<s:iterator value="albums" var="album">
				<div class="col-md-<s:property value="%{12 / albums.size()}" />">
					<h1 class="text-center">${album.type} (${album.id}): ${album.name}</h1>

					<p class="lead">${album.description}</p>

					<s:iterator value="#album.images" var="album_image">
						<s:url action="ImageLoader" method="thumbnail" var="album_image_url">
							<s:param name="slug">
								${album_image.slug}
							</s:param>
						</s:url>
						<img src="${album_image_url}" alt="${album_image.name}">
					</s:iterator>
				</div>
			</s:iterator>
		</div>
	</body>
</html>