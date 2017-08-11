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
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-
dist/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/monStyle.css">
<script src="<%=request.getContextPath()%>/js/monJs.js"></script>

<title>Creation de collaborateur</title>


<!--<c:import url="/index.html" />-->

</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="css/monStyle.css">
<link rel="stylesheet" href="js/monJs.js">

<title>Creer Employe</title>
</head>
<body>

	<h1>Créer Employer</h1>
	<div class="well">
			<div id="myBorder"  class="col-lg-offset-4" >
				<span id="labelNewCollab" class="label label-default ">New Employer</span>
				<!-- 
							<c:if test="${ not empty message }">
									<span id="labelMessage" class="label label-default ">${message}</span>
									
							</c:if>	
							
				 -->			
				<div id="myForm">
				
					<form method="POST" accept-charset="UTF-8"   >
					
						<div class="row" >
							<div class="col-lg-5 col-lg-offset-1 " >
								<input class="form-control" type="text" id="inputNom" name="inputNom" placeholder="Nom*" required="required">
							</div>
							<div class="col-lg-5  " >
								<input class="form-control" type="text" id="inputPrenom" name="inputPrenom" placeholder="Prenom*" required="required">
							</div>
						</div>
						<br>

						<div class="row">
								<div class="col-lg-10 col-lg-offset-1"><br>
									<input class="form-control" type="date" id="inputDateNaissance" name="inputDateNaissance" placeholder="Date de naissance*" required="required"><br>
								</div>
						</div>

							<div class="row">
								<div class="col-lg-10 col-lg-offset-1">
									<input class="form-control" type="text" id="inputAdresse" name="inputAdresse" placeholder="Adresse*" required="required">
								</div>
							</div>
							
							<div class="row">
								<div class="col-lg-10 col-lg-offset-1"><br>
									<input class="form-control" type="date" id="inputNumeroSecure" name="inputNumeroSecure" placeholder="Numéro de sécurité sociale*" required="required"><br>
								</div>
							</div>
							
							<div class="row">
								<div class="col-lg-offset-3 " >
									
									<input id="buttonCreate" class="btn btn-default  " type="submit" name="" value="Créer">
								</div>
								
								
							</div>
				
					</form>
				</div>
		</div>	
	</div>
	
</body>
</html>