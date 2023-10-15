<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Ranks</title>
<style>
body {
	font-size: 40px;
}
p {
	display: inline;
}
input[type="submit"] {
	pointer: cursor;
	height: 50px;
	width: 100px;
}
input[type="submit"]:hover {
	box-shadow: 0px 0px 5px 1px red;
}
</style>
</head>
<body>
	<p><a href="index.html">Home</a> - </p>
	<p>View all ranks</p>
	<form method = "post" action = "navigationServlet">
	<table>
	<c:forEach items="${requestScope.allItems}" var="currentitem">
	<tr>
		<td><input type="radio" name="id" value="${currentitem.id}"></td>
		<td>${currentitem.game}-&nbsp;</td>
		<td>${currentitem.rank}</td>
	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name= "doThisToItem">
	<input type = "submit" value = "delete" name= "doThisToItem">
	<input type = "submit" value = "add" name = "doThisToItem">
	</form>
</body>
</html>