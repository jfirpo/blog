<html>
<%--@elvariable id="entries" type="List<Entries>"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java"%>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Napi furediBLOG</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
</head>
<body>
	<div class="sidebar">
		<a href="../"><i class="fa fa-fw fa-home"></i>Home</a>
		 <a href="./authors"><i class="fa fa-fw fa-user"></i> Authors</a>		
	</div>					
					
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
						Beküldte: <span><c:out value="${entry.author.name}" /></span>
					</address>
				</footer>
				<hr />
			</c:forEach>
		</article>
</body>
</html>