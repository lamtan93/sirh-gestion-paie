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
<title>Visualiser Bulletin</title>
</head>
<body>
<h1>Bulletin Salaire</h1>

<span>Entreprise</span>: ${bulletinSalaire.remunerationEmploye.entreprise.denomination}<br>
<span>Siret</span>: ${bulletinSalaire.remunerationEmploye.entreprise.siret}<br>
<span>Periode</span>: ${bulletinSalaire.periode.dateDebut}--${bulletinSalaire.periode.dateFin}<br>
<span>Matricule</span>: ${bulletinSalaire.remunerationEmploye.matricule}<br>
</body>
</html>