<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = path + "/";
%>

<base href="<%=basePath%>">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片展示</title>
<style type="text/css">
img {
	max-width: 200px;
}
</style>
</head>
<body>
	<c:forEach items="${fileImgslist }" var="file">
		<a href="user/fileDownload.action?id=${file.id }"><img alt=""
			src="${file.path }/${file.saveName}"></a>
	</c:forEach>
</body>
</html>