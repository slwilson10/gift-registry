<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="filter-window">
	<ul>
		<c:forEach items="${whoforlist}" var="who">
			<li><a style="text-decoration: none;"href="<c:url value='/list?${who.name}'/>" >${who.name}</a></li>
		</c:forEach>
	</ul>
</div>

