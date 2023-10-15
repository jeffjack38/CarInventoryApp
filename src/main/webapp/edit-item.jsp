<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-size: 40px;
}
p {
	display: inline;
}
input[type="submit"] {
	pointer: cursor;
	height: 30px;
	width: 150px;
	box-shadow: 0px 0px 5px 1px red;
	position: relative;
	top: -8px;
}
input[type="submit"]:hover {
	box-shadow: 0px 0px 5px 1px green;
}
input[type="text"] {
	height: 25px;
	width: 200px;
	position: relative;
	top: -8px;
}
</style>
</head>
<body>
	<p><a href="index.html">Home</a> - </p>
	<p><a href = "viewAllItemsServlet">View all ranks</a></p>
	<form action = "editItemServlet" method="post">
	Game: <input type ="text" name = "game" value= "${itemToEdit.game}">
	Rank: <input type = "text" name = "rank" value= "${itemToEdit.rank}">
	<input type = "hidden" name = "id" value="${itemToEdit.id}">
	<input type = "submit" value="Save Edited Item">
	</form>
</body>
</html>