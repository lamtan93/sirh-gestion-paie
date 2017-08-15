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
 	 
	
<title>Créer Bulletin</title>

</head>
<body>


	<div class="well">
		<div id="myBorder" class="col-lg-offset-4">
			<span id="labelNewCollab" class="label label-default ">New
				Bulletin</span>
			 
							<c:if test="${ not empty message }">
									<span id="labelMessage" class="label label-default ">${message}</span>
							</c:if>	
							
				 
			<div id="myForm">

				<form method="POST" accept-charset="UTF-8">

					<div class="row">
						<div class="col-lg-10 col-lg-offset-1 ">
							<br>
							<select class="form-control selectpicker show-tick" id="periode" name="periode">
								<option value="" selected="hidden">Choisir Periode*</option>
								<c:if test="${ not empty listPeriodes }">
									<c:forEach var="e" items="${listPeriodes}">
										<option value="${e.id }">${e.dateDebut}--${e.dateFin}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>




					<div class="row">
						<div class="col-lg-10 col-lg-offset-1 ">
							<br> <select class="form-control selectpicker show-tick" id="remunerationEmploye" name="remunerationEmploye">
								<option value="" >Matricule</option>
								<c:if test="${ not empty listRemunerationEmployes }">
									<c:forEach var="p" items="${listRemunerationEmployes}">
										<option value="${p.id }">${p.matricule }</option>
									</c:forEach>
								</c:if>
							</select>

						</div>
					</div>


					<div class="row">
						<div class="col-lg-10 col-lg-offset-1 ">
						<br><input class="form-control" type="text" id="primeExceptionnelle"
								name="primeExceptionnelle" placeholder="Prime exceptionnelle*"
								required="required">
						</div>
					</div>


					<div class="row">
						<div class="col-lg-offset-3 ">

							<input id="buttonCreate" class="btn btn-default-outline  "
								type="submit" name="" value="Créer">
						</div>


					</div>
					
				</form>
			</div>
		</div>
	</div>
</body>
</html>