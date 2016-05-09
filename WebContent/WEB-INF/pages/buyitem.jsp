<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<div id="buyitem">
	<div id="giftbubble-container">
		<div style="position: relative;"><img style="width: 100%;" src="<c:url value='/resources/images/bubble.png'/> " >
				<div class="giftbubble giftstatus-${gift.status}" >
					<div class="giftbubble-left">
						<div class="giftimg"><img style="width: 100%;" src="<c:url value='/resources/images/${gift.id}.jpg'/> " ></div>
			        </div>
		     		<div class="giftbubble-right">
		     			<div style="text-align: right;"><a href="<c:url value='/list?all'/>"><img class="cancel" src="<c:url value='/resources/images/x.png'/>"></a></div>
		     			<div style="overflow:hidden; padding: 1.5% 0; border-bottom: 1px solid black; margin-bottom:2%;">
		     				<div id="gift-name" style="float: left;">${gift.name}</div>
		     				<div id="gift-price" style="float: right;">$${gift.price}</div>
		     			</div>
						<div id="gift-desc">${gift.desc}</div>
						<div id="gift-store" style="margin-top: 15%;">${gift.store}</div>
						${gift.status}
						<div style="text-align: right; overflow:hidden;">
							<div class="buy" url='${pageContext.request.contextPath}' 
				       			giftid='${gift.id}' curuser='${pageContext.request.userPrincipal.name}' 
				       			wholist='${gift.whofor}' status='${gift.status}' user='${gift.username}'>
				       			<img style="width:20%;"src="<c:url value='/resources/images/buy.png'/> " >
				       		</div>
				       	</div>
		      		</div>
				</div>
		</div>
	</div>
</div>

