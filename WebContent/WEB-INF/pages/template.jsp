<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name ="title"/></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registry-stylesheet.css"    
 type="text/css" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/registry-javascript.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="header"><tiles:insertAttribute name ="header"/></div>
		<div id="body">
			<div id="content">
				<div id="snowflakes"></div>
				<tiles:insertAttribute name ="body"/>
				<div id="navbar"><tiles:insertAttribute name ="navbar"/></div>
			</div>
		</div>
		<div id="footer"><tiles:insertAttribute name ="footer"/></div>
	</div>

</body>
</html>