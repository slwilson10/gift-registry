<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<div id="giftlist-grid">
	<c:forEach items="${listGifts}" var="gift">					
	    <a href="<c:url value='/buy/${gift.id}'/>" class="giftblock">      
			<img class="gift-top" style="width: 100%;" src="<c:url value='/resources/images/gift_top.png'/>" >
			<img class="gift-bottom" style="width: 100%;" src="<c:url value='/resources/images/gift_bottom.png'/>" >
			<div style="overflow:hidden; text-align:center; font-size: 120%;">${gift.name}&nbsp &nbsp|&nbsp &nbsp$${gift.price}</div>
	    </a>
	</c:forEach>
</div>

