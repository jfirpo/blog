<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@elvariable id="name" type="String"--%>
<head>
<meta charset="ISO-8859-1">
</head>

<body>
	<form action="addEntryToDb" method="POST">

		${author.name}'s  story 		
		<br>
		<textarea name="content" cols="60" rows="6">Here is your story's place... </textarea>
		<input type="hidden" name="id" value="${author.id}" />
		<br> <input type="submit" value="Add entry" />
	</form>

</body>
</html>