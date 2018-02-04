<!--  sample.jsp -->
<% 
	pageContext.setAttribute("k1","A");
	pageContext.setAttribute("k2","B",2);
	pageContext.setAttribute("k3","C",3);
	pageContext.setAttribute("k4","D",4);
%>

<h2>
${pageScope.k1} <br>
${requestScope.k2} <br>
${sessionScope.k5} <br>
${sessionScope.k3} <br>
${k6} <br>
${applicationScope.k4} <br>

</h3>