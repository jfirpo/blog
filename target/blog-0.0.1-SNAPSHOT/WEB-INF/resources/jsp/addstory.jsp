<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%--@elvariable id="name" type="String"--%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
</head>
<body>
	<div class="sidebar">
		<a href="../"><i class="fa fa-fw fa-home"></i>Home</a>
		 <a href="./authors"><i class="fa fa-fw fa-user"></i> Authors</a>		
	</div>					
<body>
	<form action="addEntryToDb" method="POST">

		${author.name}'s  story 		
		<br>
		<textarea name="content" cols="60" rows="6">Here is your story's place... </textarea>
		<input type="hidden" name="author" value="${author.id}" />
		<br> <input type="submit" value="Add entry" />
	</form>

</body>
</html>