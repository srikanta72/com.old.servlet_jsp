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
	String captcha=(String)session.getAttribute("captcha");
	String typed=request.getParameter("human");
	
	if (captcha.equals("human"))
	{
		out.println("captcha test sucess");
	}
	else
	{
		out.println("captcha test failed");
	}
	out.println("<a href='index.html'> try again</a>");

%>
</body>
</html>