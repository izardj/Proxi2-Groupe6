<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Liste des clients</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/starter-template.css" rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">ProxiBanque</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Lister clients</a></li>
					<li>Test</li>
					<li><a href="LoginServlet?action=logout">Se deconnecter</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Gestion des clients</h1>
				<h2 class="sub-header">Liste des clients</h2>
				<c:if test="${! empty clients}">
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>NOM</th>
									<th>PRENOM</th>
									<th>NOM ENTREPRISE</th>
									<th>RUE</th>
									<th>VILLE</th>
									<th>CODE POSTAL</th>
									<th>TELEPHONE</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="c" items="${clients}">
									<tr>
										<td><c:out value="${c.id}"></c:out></td>
										<td><c:out value="${c.nom}"></c:out></td>
										<td><c:out value="${c.prenom}"></c:out></td>
										<td><c:out value="${c.nomEntreprise}"></c:out></td>
										<td><c:out value="${c.coordonnee.rue}"></c:out></td>
										<td><c:out value="${c.coordonnee.ville}"></c:out></td>
										<td><c:out value="${c.coordonnee.codePostal}"></c:out></td>
										<td><c:out value="${c.coordonnee.telephone}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
		</div>

	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
