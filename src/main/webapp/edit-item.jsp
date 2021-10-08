<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Electric Car</title>
</head>
<body>
<form action = "editItemServlet" method="post">
Range: <input type = "text" name = "range" value = "${itemToEdit.range}">
Make: <input type = "text" name = "make" value = "${itemToEdit.make}">
Model: <input type = "text" name = "model" value = "${itemToEdit.model}">
Price: <input type = "text" name = "price" value = "${itemToEdit.price}">
 <input type = "hidden" name = "id" value = "${itemToEdit.id}">
<input type="submit" value = "Save Edited Item">

</form>

</body>
</html>