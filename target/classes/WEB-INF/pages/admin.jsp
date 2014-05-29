<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
<body>
 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | 
		</h2>
	</c:if>
	<h1>Title : ${title}</h1>
 		<c:url var="logoutUrl" value="/logout"><c:param name="logout" value="logout"/> </c:url>
		<div style="float:right">
			<a href="${logoutUrl}"> Logout</a>
		</div>
	 <a href="${pageContext.request.contextPath}/emplAdmin/all">Employee Admin</a>
	
	
</body>
</html>