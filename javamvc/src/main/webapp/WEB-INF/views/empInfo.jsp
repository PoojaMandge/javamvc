<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>


<html>
<head>
	<title>EmpInfo Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Emp
</h1>



<form:form action="http://localhost:8080/javamvc/addemp/" modelAttribute="empob" method="post">
<table>
	<c:if test="${!empty empob.empName}">
	<tr>
		<td>
			<form:label path="empId">
				<spring:message text="empId"/>
			</form:label>
		</td>
		<td>
			<form:input path="empId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="empId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="empName">
				<spring:message text="empName"/>
			</form:label>
		</td>
		<td>
			<form:input path="empName" />
		</td> 
	</tr>
	
	<tr>
		<td>
			<form:label path="empAddress">
				<spring:message text="empAddress"/>
			</form:label>
		</td>
		<td>
			<form:input path="empAddress" />
		</td>
	</tr>
	
	<tr>
		<td>
			<form:label path="empAge">
				<spring:message text="empAge"/>
			</form:label>
		</td>
		<td>
			<form:input path="empAge" />
		</td>
	</tr>
	
	
	<tr>
		<td>
			<form:label path="empSalary">
				<spring:message text="empSalary"/>
			</form:label>
		</td>
		<td>
			<form:input path="empSalary" />
		</td>
	</tr>
	
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty empob.empName}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty empob.empName}">
				<input type="submit"	value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>

<hr><hr>
<h3>Emp List</h3>
<c:if test="${!empty listemps}">
	<table class="tg">
	<tr>
		<th width="80">Emp ID</th>
		<th width="120">Emp Name</th>
		<th width="120">Emp Address</th>
		<th width="120">Emp Age</th>
		<th width="120">Emp Salary</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listemps}" var="eob">
		<tr>
			<td>${eob.empId}</td>
			<td>${eob.empName}</td>
			<td>${eob.empAddress}</td>
			<td>${eob.empAge}</td>
			<td>${eob.empSalary}</td>
			<td><a href="<c:url value='/edit/${eob.empId}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${eob.empId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>


</body>
</html>

