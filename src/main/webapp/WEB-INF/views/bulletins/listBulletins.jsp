<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/monStyle.css">
<script src="<%=request.getContextPath()%>/js/monJs.js"></script>


<c:import url="/index.html" />

</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="css/monStyle.css">
<link rel="stylesheet" href="js/monJs.js">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>


<title>List de Bulletin</title>

</head>
<body>
	<div class="container">
		<c:if test="${not empty listBulletins  }">
			<h2>List d'Employés</h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Date de création</th>
						<th>Periode</th>
						<th>Matricule</th>
						<th>Salaire brut</th>
						<th>Net Imposable</th>
						<th>Net A Payer</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="bull" items="${listBulletins}">
						<tr>

								<td>16/08/2017</td>
								<td>${bull.key.periode.dateDebut} - ${bulletin.key.periode.dateFin}</td>
								<td>${bull.key.remunerationEmploye.matricule}</td>
								<td>${bull.value.salaireBrut}</td>
								<td>${bull.value.netImposable}</td>
								<td>${bull.value.netAPayer}</td>
								<td><a href="/paie/mvc/bulletins/visualiserBulletin?bulletinId=${bull.key.id}">Visualiser</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:if>

		<c:if test="${empty listBulletins}">
			<h2>Aucun Bulletin trouvé :(</h2>
		</c:if>
	</div>
</body>
</html>