<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="insert.js" language="javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name=f action='./insert' method='post' onSubmit="return isValid(this)">
<table border=1 cellpadding=7 cellspacing=7 align=center>
<caption><i><font size=4><u>Insert Records</u></font></i></caption>
	<tr><th>Student ID<th><input type="text" name="sid"></tr>
	<tr><th>Student Name<th><input type="text" name="sname"></tr>
	<tr><th>Student Address<th><input type="text" name="sadd"></tr>
	<tr><th>Click<th><input type="submit" value=" INSERT "></tr>
</table>
</form>
</body>
</html>