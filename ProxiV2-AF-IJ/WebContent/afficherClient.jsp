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
					<li class="active"><a href="ListerClients">Lister clients</a></li>
				</ul>
				<p class="navbar-text navbar-right">
					<a href="LogoutServlet">Se deconnecter</a>
				</p>
				<p class="navbar-text navbar-right">
					Connecté en tant que
					<c:out value="${conseiller.nom}" />
				</p>

			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Gestion des clients</h1>
			<h2 class="sub-header">Afficher un client</h2>
			<ul>
				<li><c:out value="${client.nom}" /></li>
				<li><c:out value="${client.prenom}" /></li>
				<li><c:out value="${client.nomEntreprise}" /></li>
				<li><c:out value="${client.adresse}" /></li>
				<li><c:out value="${client.ville}" /></li>
				<li><c:out value="${client.codePostal}" /></li>
				<li><c:out value="${client.telephone}" /></li>
				<li><c:out value="${client.email}" /></li>

				<c:forEach var="c" items="${client.comptes}">
					<li>
						<ul>
							<!-- determiner le type de class fille -->
							<c:if test="${c['class'].simpleName == 'CompteCourant'}">
								<li>Compte Courant</li>
							</c:if>
							<c:if test="${c['class'].simpleName == 'CompteEpargne'}">
								<li>Compte Epargne</li>
							</c:if>
							<li>Numéro : <c:out value="${c.numeroCompte}" /></li>
							<li>Solde : <c:out value="${c.solde}" /></li>
							<li>Date ouverture : <c:out value="${c.dateOuverture}" /></li>
						</ul>
					</li>
				</c:forEach>

			</ul>
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
