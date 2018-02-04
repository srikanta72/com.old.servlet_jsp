<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
pageContext.setAttribute("k1","A");
pageContext.setAttribute("k2","B",2);
pageContext.setAttribute("k3","c",3);
pageContext.setAttribute("k4","D",4);
%>

<h1>
${pageScope.k1}<br>
${requestScope.k2}<br>
${sessionScope.k5}<br>
${sessionScope.k3}<br>
${k6}<br>
${applicationScope.k4}<br>
 
  HTTP method:${pageContext.request.method}<br>
  Session Timeout:${pageContext.session.maxInactiveInterval}<br>
  Session id:${pageContext.session.id} 
   
</h1>
</body>
</html>