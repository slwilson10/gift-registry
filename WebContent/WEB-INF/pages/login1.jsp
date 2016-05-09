<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>
<div id="login-box" onload='document.loginForm.username.focus();'>
	<img style="width: 45%;" src="<c:url value='/resources/images/logo-login.png'/> ">
	<c:if test="${not empty error}">
		<div class="msg">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	<c:if test="${not empty createSuccessMsg}">
		<div class="msg">${createSuccessMsg}</div>
	</c:if>
	<c:if test="${not empty createFailMsg}">
		<div class="msg">${createFailMsg}</div>
	</c:if>
	<form id='loginForm' name='loginForm'
  		action="<c:url value='/j_spring_security_check' />" method='POST'>

  		<table id="login-table">	
			<tr>
				<td><input class="login-box-text" type='text' name='username' value='' placeholder="Username"></td>
			</tr>
			<tr>
				<td><input  class="login-box-text" type='password' name='password' placeholder="Password"/></td>
			</tr>
			<tr>
				<td colspan='2'>
				<input class="login-box-button" name="submit" type="submit" value="Login" />
			</td>
			</tr>
  		</table>

 	 	<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

<c:url var="addAction" value="/user/add" ></c:url>
<form:form action="${addAction}" commandName="user" id='registerForm' style='display:none;' >

  <table id="login-table">
	<tr>
		<td><form:label path="username"/><form:input class="login-box-text" path="username" placeholder="Username"/></td>
	</tr>
	<tr>
		<td><form:label path="password"/><form:input class="login-box-text" path="password" placeholder="Password"/></td>
	</tr>
	<tr>
		<td colspan='2'>
		<input class="login-box-button" name="submit" type="submit" value="Create" />
		</td>
	</tr>
  </table>

  <input type="hidden" name="${_csrf.parameterName}"
	value="${_csrf.token}" />
</form:form>
<div id="register-button"><p>Create Login</p><p style='display: none;'>Cancel</p></div>
</div>
