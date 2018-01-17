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
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=basePath%>/js/base/jquery-ui-1.12.1.custom/jquery-ui.min.css">
<script type="text/javascript"
	src="<%=basePath%>/js/base/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/base/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
</head>
<body>
	<!-- 传值 -->
	<h1>hello: ${user.userName }</h1>
	
	<!-- 弹框 -->
	<p>
		<button id="opener">弹框</button>
	</p>
	<div id="dialog" title="Basic dialog">
		<p>这是一个动画显示的对话框，用于显示信息。对话框窗口可以移动，调整尺寸，默认可通过 'x' 图标关闭。</p>
	</div>
	
	<!-- 图片上传 -->
	<form action="user/addFile.action" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit" value="提交">
	</form>
	
	<!-- 文件下载 -->
	<p>
		<a href="user/fileDownload.action?id=1">下载文件</a>
	</p>
	
<%-- 	<s:form action="user/addFile.action" method="post" enctype="multipart/form-data"> --%>
<%--           <s:textfield name="detailed" label="图片详细"></s:textfield> --%>
<%--           <s:file name="file" label="图片"></s:file> --%>
<%--           <s:submit label="上传"/> --%>
<%--     </s:form>  --%>
	
	<script type="text/javascript">
		$(function() {
			$("#dialog").dialog({
				autoOpen : false,
				bgiframe : false,
				buttons : {
					"Ok" : function() {
						alert("ok");
					},
					"Cancel" : function() {
						$("#dialog").dialog("close");
					}
				},
				closeOnEscape : false,//按esc退出默认的true  

				draggable : false, //拖拽默认是true  
				resizable : false, // 改变大小，默认是true

				//       hide:"toggle",//关闭窗口的效果  

				modal : true, //遮罩效果默认是false不遮住  

			//       position:"left", //对话框弹出的位置，top,left,right,center,默认是center  

			//       show:"slide",//打开窗口的效果  

			//       title:"对话框遮罩效果的实现"//设置对话框的标题  
			});

			$("#opener").click(function() {
				$("#dialog").dialog("open");
			});
		});
	</script>
</body>
</html>