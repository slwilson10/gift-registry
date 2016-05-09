<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="curuser" property="name"/>
<div id="cart">
	<div id="cartbubble-container">
		<div style="position: relative;"><img style="width: 100%;" src="<c:url value='/resources/images/bubble.png'/> " >
			<div id="cartbubble">
				<div id="cartbubble-top">
					<a id="cart-x" href="<c:url value='/list?all'/>"> <img style="width: 5%;"  class="cancel" src="<c:url value='/resources/images/x.png'/>"></a>
		        </div>
	     		<div id="cartbubble-middle">
	     			<h3>Items Bought By You:</h3>
					<ul>
						<c:forEach items="${listBoughtByYou}" var="gift">
							<li>
								<img id="gift-img" style="width: 100%;" src="<c:url value='/resources/images/${gift.id}.jpg'/> " >
								<div id="gift-name-cart">${gift.name}</div>
							</li>
						</c:forEach>
					</ul>
	      		</div>
			</div>
		</div>
	</div>
</div>


