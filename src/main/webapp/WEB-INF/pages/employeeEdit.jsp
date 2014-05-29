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
	 	
	<body style="padding: 20px; width:60%" leftmargin="10px" topmargin="20px">
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
		          <h3 class="page-header">Edit Employee</h3>
		
					<div class="table-responsive">	 
						<form:form method="POST" commandName="employee" action="${pageContext.request.contextPath}/emplAdmin/update">
							<table class="table-striped table-condensed">  
								<tbody>
									<tr>  
								        <td><form:label path="employeeId">Employee ID:</form:label></td>  
								        <td><form:input path="employeeId"></form:input></td>  
								    </tr>  
									<tr>  
								        <td><form:label path="firstName">First Name:</form:label></td>  
								        <td><form:input path="firstName"></form:input></td>  
								    </tr>  
								    <tr>  
								        <td><form:label path="surname">Last Name:</form:label></td>  
								        <td><form:input path="surname"></form:input></td>  
								    </tr>  
								    <tr>  
								        <td><form:label path="contactPhone">Contact Phone:</form:label></td>  
								        <td><form:input path="contactPhone"></form:input></td>  
								    </tr>  
								    <tr>  
								        <td><form:label path="homeAddress">Address:</form:label></td>  
								        <td><form:input path="homeAddress"></form:input></td>  
								    </tr>  
								    <tr>  
								        <td><form:label path="hourlyRate">Hourly Rate:</form:label></td>  
								        <td><form:input path="hourlyRate"></form:input></td>  
								    </tr>  
								    <tr>  
								        <td colspan="2">  
								            <input type="submit" value="Submit">  
								            <input type="submit" value="Cancel" >
								        </td>  
								        <td></td>  
								        <td></td>  
								    </tr>  
								</tbody>
							</table>    
						</form:form>  
					</div>
				</div>
			</div>
		</div>

	</body>

</html>
