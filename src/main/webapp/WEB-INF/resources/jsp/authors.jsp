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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
</head>
<body>
	<div class="sidebar">
		<a href="../"><i class="fa fa-fw fa-home"></i>Home</a>
		 <a href="./stories"><i class="fa fa-newspaper-o"></i> Stories</a>		
	</div>

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
</body>
</html>