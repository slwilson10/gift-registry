<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"> 
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title><tiles:getAsString name ="title"/></title>
<link rel="stylesheet" href="<c:url value="/resources/css/registry.css"/>" media="all" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="<c:url value="/resources/js/registry.js"/>"></script>
</head>
<body>
	<tiles:insertAttribute name ="cart"/>
	<tiles:insertAttribute name ="buyitem"/>
	<header><tiles:insertAttribute name ="header1"/></header><!--  End Header -->
	<main role="main">
			<div id="left"><tiles:insertAttribute name ="left"/></div> <!--  End Main Left -->
			<div id="middle"><tiles:insertAttribute name ="middle"/></div> <!--  End Main Middle -->
			<div id="right"><tiles:insertAttribute name ="right"/></div> <!--  End Main Right -->
	</main> <!--  End Main -->
	<footer><tiles:insertAttribute name ="footer"/></footer>
</body>
</html>