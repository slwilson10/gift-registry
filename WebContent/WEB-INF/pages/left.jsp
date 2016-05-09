<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<img style="width: 80%;" src="<c:url value='/resources/images/sign.png'/> ">
<div id="sign-interior">
	<div class="sign-title" style="width:100%; text-align:center; font-size: 130%; margin-bottom: 8%;;">Filters</div>
	<div class="sign-title">Who For:</div>
	<a class="sign-icon" style="text-decoration: none;"href="<c:url value='/list'/>" >All</a>
	<c:forEach items="${whoforlist}" var="who">
	<a class="sign-icon" style="text-decoration: none;"href="<c:url value='/list?whofor=${who.name}'/>" >${who.name}</a>
	</c:forEach>


	<div class="sign-title">Store:</div>
	<c:forEach items="${storeslist}" var="store">
	<a class="sign-icon" style="text-decoration: none;"href="<c:url value='/list?store=${store.name}'/>" >${store.name}</a>
	</c:forEach>


	<div class="sign-title">Price:</div>
	<a class="sign-icon" style="text-decoration: none;"href="<c:url value='/list?price=$'/>" >$</a>	
	<a class="sign-icon" style="text-decoration: none;"href="<c:url value='/list?price=$$'/>" >$$</a>
	<a class="sign-icon" style="text-decoration: none;"href="<c:url value='/list?price=$$$'/>" >$$$</a>

</div>