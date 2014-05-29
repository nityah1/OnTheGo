<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@page session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=80%, initial-scale=0.6">
	    
    	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
	 </head>
	 	
	<body style="padding-left: 20px; width:60%" leftmargin="10px">
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script type="text/css" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script type="text/css" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" ></script>
		<c:url var="logoutUrl" value="/logout"><c:param name="logout" value="logout"/> </c:url>
		<div style="float:right">
			<a href="${logoutUrl}"> Logout</a>
		</div>
		<div class="container-fluid">
			<div class="row">
		        <h:adminSidebar />
		        
		        <div class="col-sm-9 col-md-10 main">
		          <h3 class="page-header">Dashboard</h3>
		
		          <h4 class="sub-header" />
					<p>Here you can see the list of the employees, edit them, remove or update.</p>
					
					<div class="table-responsive">
						<table class="table table-striped table-condensed" style="text-align: left;" >
							<thead>
								<tr>
									<th width="15%">Employee ID</th><th width="30%">Name</th><th width="10%">Phone</th><th width="10%">actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${employeeList}" var="empl">
									<tr>
										<td>${empl.employeeId}</td>
										<td>${empl.firstName} ${empl.surname}</td>
										<td>${empl.contactPhone}</td>
										<td>
										<a href="${pageContext.request.contextPath}/emplAdmin/edit/${empl.employeeId}">Edit</a><br>
										<a href="${pageContext.request.contextPath}/emplAdmin/delete/${empl.employeeId}">Delete</a><br>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>