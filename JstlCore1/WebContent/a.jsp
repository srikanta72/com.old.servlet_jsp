<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
<c:set var="str" value="sathya" scope="request"/>
<c:out value="${str}" default="Hello" />
</h1>

<hr>
<c:if test="${str ne null}" >
<h2> <c:out value="str is not null"/></h2>
</c:if>
<hr>
<h2>
<c:choose>
<c:when test="${str eq 'sathya' }">
<c:out value="str is Sathya"/>
</c:when>
<c:otherwise>
<c:out value="str value is not sathya"></c:out>
</c:otherwise></c:choose>
	<hr>
<c:forEach var="i" begin="1" end="5" step="2">
 <c:out value="value of i is ${i }" />
 </c:forEach>
 	<hr>
 <c:set var="line" value="This is a line of message"/>
 <c:forTokens var="x" items="${line }" delims=" ">
 <c:out value="${x }"/>
 <br>
 
 </c:forTokens>
</h2>
<hr>
<c:import url="https://shop.vodafone.in/shop/prepaid/easy-online-recharge.jsp"/>
