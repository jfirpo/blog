<!DOCTYPE html>
<%--@elvariable id="entries" type="List<Entries>"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java"%>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymleaf.org">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title th:text="${pageTitle}">Napi furediBLOG</title>

<link rel="stylesheet" th:href="@{css/main.css}"
	href="../static/css/main.css" />
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
					id="bs-example-navbar-collapse-5">
					<p>
						<a href="authors">Authors</a>
					</p>
				</div>
			</div>
		</nav>


		<article>
			<c:forEach items="${entries}" var="entry">
				<header>
					<h1>a Story</h1>
					<p><c:out value="${entry.created}" /></p>
				</header>

				<section>
					<p><c:out value="${entry.content}" /></p>					
				</section>

				<footer>
					<address>
						Beküldte: <span><c:out value="${entry.author}" /></span>
					</address>
				</footer>
				<hr />
			</c:forEach>
		</article>

		<footer>
			<p th:text="#{footerText}">készült a furediBlog megbízásából</p>
		</footer>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>