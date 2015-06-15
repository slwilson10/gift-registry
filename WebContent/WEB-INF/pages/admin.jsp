<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>
<html>
	<body>
		<h1>Add a Gift</h1>
	<c:url var="addAction" value="/admin/add" ></c:url>
	<form:form action="${addAction}" commandName="gift">
	<table>
	    <c:if test="${!empty gift.name}">
	    <tr>
	        <td>
	            <form:label path="id">
	                <spring:message text="ID"/>
	            </form:label>
	        </td>
	        <td>
	            <form:input path="id" readonly="true" size="8"  disabled="true" />
	            <form:hidden path="id" />
	        </td> 
	    </tr>
	    </c:if>
	    <tr>
	        <td>
	            <form:label path="name">
	                <spring:message text="Name"/>
	            </form:label>
	        </td>
	        <td>
	            <form:input path="name" />
	        </td> 
	        <td>
	            <form:label path="price">
	                <spring:message text="Price"/>
	            </form:label>
	        </td>
	        <td>
	            <form:input path="price" />
	        </td>
	        <td>
	            <form:label path="pubdate">
	                <spring:message text="Pubdate"/>
	            </form:label>
	        </td>
	        <td>
	            <form:input path="pubdate" />
	        </td>
	        </tr>
	        <tr>
	        <td>
	            <form:label path="desc">
	                <spring:message text="Description"/>
	            </form:label>
	        </td>
	        <td>
	            <form:input path="desc" />
	        </td>
	        <td>
	        <form:label path="status">
	                <spring:message text="Status"/>
	            </form:label>
	        </td>
	       
	        <td>
	            <form:input path="status" />
	        </td>
	        <td>
	            <form:label path="whofor">
	                <spring:message text="Whofor"/>
	            </form:label>
	        </td>
	        <td>
	            <form:select path="whofor" items="${listWhoFors}" />
	        </td>
	        <td>
	            <form:label path="store">
	                <spring:message text="Store"/>
	            </form:label>
	        </td>
	        <td>
	            <form:select path="store" items="${listStores}" />
	        </td>
	     </tr>
	    <tr>
	        <td colspan="2">
	            <c:if test="${!empty gift.name}">
	                <input type="submit"
	                    value="<spring:message text="Edit Gift"/>" />
	            </c:if>
	            <c:if test="${empty gift.name}">
	                <input type="submit"
	                    value="<spring:message text="Add Gift"/>" />
	            </c:if>
	        </td>
	    </tr>
	</table>  
	</form:form>
	
	<h3>Gifts List</h3>
		<c:if test="${!empty listGifts}">
		    <table class="tg">
		    <tr>
		        <th width="80">Gift ID</th>
		        <th width="120">Gift Name</th>
		        <th width="120">Gift Pubdate</th>
		        <th width="120">Gift Description</th>
		        <th width="120">Gift Price</th>
		        <th width="120">Gift WhoFor</th>
		        <th width="120">Gift Store</th>
		        <th width="120">Gift Status</th>
		        <th width="120">Gift Bought By</th>
		        <th width="60">Edit</th>
		        <th width="60">Delete</th>
		    </tr>
		    <c:forEach items="${listGifts}" var="gift">
		        <tr>
		            <td>${gift.id}</td>
		            <td>${gift.name}</td>
		            <td>${gift.pubdate}</td>
		            <td>${gift.desc}</td>
		            <td>${gift.price}</td>
		            <td>${gift.whofor}</td>
		            <td>${gift.store}</td>
		            <td>${gift.status}</td>
		            <td>${gift.username}</td>
		            <td><a href="<c:url value='/admin/edit/${gift.id}' />" >Edit</a></td>
		            <td><a href="<c:url value='/admin/remove/${gift.id}' />" >Delete</a></td>
		        </tr>
    </c:forEach>
    </table>
</c:if>
 
 
</body>
</html>