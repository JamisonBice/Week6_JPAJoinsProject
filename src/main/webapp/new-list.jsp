<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new  Car list</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
Car List Name: <input type="text" name = "listName"><br />
Order Date: <input type="text" name = "month" placeholder="mm" size="4">
<input type="text" name = "day" placeholder="dd" size="4">
<input type="text" name = "year" placeholder="yyyy" size="4">
Dealership Name: <input type="text" name = "dealerName"><br />

Available Items:<br />
<select name = "allItemsToAdd" multiple size = "6">
<c:forEach items = "${requestScope.allItems}" var="currentitem">
<option value = "${currentitem.id}"> ${currentitem.range} | ${currentitem.make} | ${currentitem.model} | ${currentitem.price}</option>
</c:forEach>
</select>
<br />
<input type="submit" value="Create list and Add Items">

</form>
<a href="index.html">Go add new items instead</a>
</body>
</html>