<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  a.jsp -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>
<hr>
<c:set var="str" value="sathya" scope="request"/>
<c:out value="${str}" default="Hello"/>
</h1>
<hr>


<c:if test="${str ne null}">
<h2><c:out value="str is not null"/></h2>
</c:if>
<hr>


<h2>
<c:choose>
  <c:when test="${str eq 'sathya'}">
  <c:out value="str value is sathya"/>
  
  </c:when>
  <c:otherwise>
  <c:out value="str value is not sathya"/>
  </c:otherwise>
  </c:choose>
  <hr>
  
  
  <c:forEach var="i" begin="1" end="5" step="2">
  <c:out value="value of i is ${i}"/><br>
  </c:forEach>
  <hr>
  
  
  <c:set var="line" value="This is a line of message"/>
  <c:forTokens var="x" items="${line}"
          delims=" ">
          <c:out value="${x}"/> <br>
          </c:forTokens>
          </h2>
          <hr>

  
  
  
  
  
  
  





</body>
</html>