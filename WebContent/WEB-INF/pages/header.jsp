<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="header-container">
	<div style="float:right; margin: 0 1% 1% 1%;" id="logout-block">
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<!-- csrt for log out-->
		<form action="${logoutUrl}" method="post" id="logoutForm">
		  <input type="hidden" 
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		</form>
	 
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
	 
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<div>
				Welcome : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</div>
		</c:if>
	</div>
	<div id="logo"><img style="width: 20%;" src="<c:url value='/resources/images/logo.png'/> "></div>
</div>