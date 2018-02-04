<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="ds" driver="
oracle.jdbc.driver.OracleDriver"
url="jdbc:oracle:thin:@localhost:1521:orcl"
user="system" passward="tiger"/>


<sql:update var="i" dataSource="${ds}">
insert into emp values(?,?,?,?)
<sql:param value="${param.empno}"/>
<sql:param value="${param.ename}"/>
<sql:param value="${param.sal}"/>
<sql:param value="${param.deptno}"/>
</sql:update>
<h2>${i} row inserted. </h2>

</body>
</html>