<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>
</head>
<body>
<div style="text-align: center; height: 100%; padding: 50px;">
<h1>Employee List</h1>
<table style="padding-left: 500px; justify-content: space-around;">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>PhNo</th>
<th>Action</th>
</tr>
<c:forEach  var="employee" items="${employees}">
<tr>
<td>${employee.getId()}</td>
<td>${employee.getName()}</td>
<td>${employee.getEmail()}</td>
<td>${employee.getPhno()}</td>
<td><a href="updateEmployee?id=${employee.getId()}">Edit</a> <a href="deleteEmployee?id=${employee.getId()}">Delete</a></td>
<td></td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>