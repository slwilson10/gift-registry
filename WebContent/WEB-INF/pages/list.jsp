<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
	<div id="giftlist">
	<div id="giftlist-header">
		<img style="width: 100%;" src="<c:url value='/resources/images/scroll_top.png'/> " >
	</div>
	<div id="giftlist-body">
		<c:if test="${not empty boughtMsg}">
			<div class="msg">${boughtMsg}</div>
		</c:if>
			<c:if test="${!empty listGifts}">
			 <div class="giftbubble-container">
			 <img style="width: 100%;" src="<c:url value='/resources/images/bubble.png'/> " >
				<c:forEach items="${listGifts}" var="gift">
					<div class="giftbubble giftstatus-${gift.status}" bubbleid="${gift.id}">
						<div class="giftbubble-header" style="overflow:hidden; padding-bottom:2%;">
				        	<div class="giftname">${gift.name}</div>
				        	<div class="cancel"  >X</div>
				        </div>
			     		<div class="giftbubble-body" style="overflow:hidden; padding-bottom:4%;">
							<div class="giftimg"><img style="width: 100%;" src="<c:url value='/resources/images/${gift.id}.jpg'/> " ></div>
							<div class="giftdesc">${gift.desc}</div>
			      		</div>
			     		<div class="giftbubble-footer" style="overflow:hidden;">
					       	<div class="giftstore">${gift.store}</div>
					       	<div class="giftprice">$${gift.price}</div><br>
					       	<div class="buy" url='${pageContext.request.contextPath}' 
				       				giftid='${gift.id}' curuser='${pageContext.request.userPrincipal.name}' 
				       				wholist='${wholist}' status='${gift.status}' user='${gift.username}'>
				       				Buy
				       		</div>
						</div>
					</div>
				</c:forEach>
				</div>
				<div id="giftlist-grid">
				<c:forEach items="${listGifts}" var="gift">					
				    <div class="giftblock" giftid="${gift.id}">
					        
								<div class="gift-top"><img style="width: 100%;" src="<c:url value='/resources/images/gift_top.png'/> " ></div>
								<div class="gift-tag"><img src="<c:url value='/resources/images/tag.png'/> " ><div class="gift-tag-text">${gift.name}</div></div>
								<div class="gift-bottom"><img style="width: 100%;" src="<c:url value='/resources/images/gift_bottom.png'/> " ></div>
				    </div>
				</c:forEach>
				</div>
			</c:if>
		</div>
	<div id="giftlist-footer"><img style="width: 100%;" src="<c:url value='/resources/images/scroll_bottom.png'/> " ></div>
</div>
</body>
</html>