<html>
<%--@elvariable id="name" type="String"--%>
<%--@elvariable id="authors" type="List<Authors>"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java"%>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Napi furediBLOG</title>

<link rel="stylesheet" href="../static/css/main.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />

<link href='https://fonts.googleapis.com/css?family=Calibri'
	rel='stylesheet' type='text/css' />
<link href='https://fonts.googleapis.com/css?family=Exo'
	rel='stylesheet' type='text/css' />

<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-5"
						aria-expanded="false">
						<span class="sr-only"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">furediblog.com</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-5"></div>
			</div>
		</nav>

		${name} <br>
		<form action="./addAuthor" method="POST">
			Name: <input type="text" name="name" /> <br> <input
				type="submit" value="Add author" />
		</form>


		<p></p>
		<table>
			<c:forEach items="${authors}" var="author">
				<tr>
					<td><c:out value="${author.id}" /></td>
					<td><c:out value="${author.name}" /></td>
					<td>
						<form action="deleteAuthor" method="GET">
							<input type="hidden" name="id" value="${author.id}" /> <input
								type="submit" value="Delete" />
						</form>
					</td>
					<td>
						<form action="editAuthor" method="POST">
							Name: <input type="text" name="name" /> <input type="hidden"
								name="id" value="${author.id}" /> <input type="submit"
								value="Edit author" />
						</form>
					</td>
					<td>
						<form action="addEntryBox" method="GET">
							<input type="hidden" name="id" value="${author.id}" /> <input
								type="submit" value="Add entry" />
						</form>
					</td>
					<td>
						<form action="authorDetails" method="GET">
							<input type="hidden" name="id" value="${author.id}" /> <input
								type="submit" value="Author's stories" />
						</form>
					</td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<p>
		<a href="stories">All of the stories</a>
	</p>
</body>
</html>