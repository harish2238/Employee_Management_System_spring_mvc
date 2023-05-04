<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>
</head>
<body>
<div style="text-align: center; background-color: silver; height: 100%; padding: 250px;">
<h1>Add Employee Details..</h1>
<f:form action="addEmployee" modelAttribute="employee"> 
<f:input path="name" placeholder="Enter Name"/><br><br>
<f:input path="email" placeholder="Enter Email"/><br><br>
<f:input path="phno" placeholder="Enter Ph-No"/><br><br>
<input type="submit" value="Save">
</f:form></div>
</body>
</html>