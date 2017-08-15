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

<title>List Employe</title>


</head>
<body>
	<div class="container">
		<c:if test="${not empty listEmployes  }">
			<h2>List d'Employés</h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Date de création</th>
						<th>Matricule</th>
						<th>Grade</th>
					</tr>
				</thead>
				<tbody>


					<tr>
						<c:forEach var="emp" items="${listEmployes}">
							<td>12/08/2017</td>
							<td>${emp.matricule}</td>
							<td>${emp.grade.code}</td>
						</c:forEach>
					</tr>


				</tbody>
			</table>
		</c:if>

		<c:if test="${empty listEmployes}">
			<h2>Aucun employé trouvé :(</h2>
		</c:if>
	</div>
</body>
</html>