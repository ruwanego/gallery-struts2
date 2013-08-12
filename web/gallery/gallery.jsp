<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gallery - ${album.slug}</title>
    </head>
    <body>
        <h1>${album.type} (${album.id}): ${album.name}</h1>
        ${album.description}

        <form action="<s:url action="Gallery" method="save" />" method="POST">
            <input type="submit" value="Save" />
        </form>

        <form action="<s:url action="Gallery" method="revert" />" method="POST">
            <input type="submit" value="Revert" />
        </form>
    </body>
</html>