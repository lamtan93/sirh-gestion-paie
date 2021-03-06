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
 	 
	


</head>
<body>


	<div class="well">
		<div id="myBorder" class="col-lg-offset-4">
			<span id="labelNewCollab" class="label label-default ">New
				Employer</span>
			 
							<c:if test="${ not empty message }">
									<span id="labelMessage" class="label label-default ">${message}</span>
									
							</c:if>	
							
				 
			<div id="myForm">

				<form method="POST" accept-charset="UTF-8">

					<div class="row">
						<div class="col-lg-10 col-lg-offset-1 ">
							<input class="form-control" type="text" id="matricule"
								name="matricule" placeholder="Matricule*"
								required="required">
						</div>
					</div>

					<div class="row">
						<div class="col-lg-10 col-lg-offset-1 ">
							<br>
							<select class="form-control selectpicker show-tick" id="entreprise" name="entreprise">
								<option value="" selected="hidden">Choisir Entreprise</option>
								<c:if test="${ not empty listEntreprises }">
									<c:forEach var="e" items="${listEntreprises}">
										<option value="${e.id }">${e.denomination }</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>




					<div class="row">
						<div class="col-lg-10 col-lg-offset-1 ">
							<br> <select class="form-control selectpicker show-tick" id="profil" name="profil">
								<option value="" >Profil</option>
								<c:if test="${ not empty listProfils }">
									<c:forEach var="p" items="${listProfils}">
										<option value="${p.id }">${p.code }</option>
									</c:forEach>
								</c:if>
							</select>

						</div>
					</div>

					<div class="row">
						<div class="col-lg-10 col-lg-offset-1 ">
							<br> <select class="form-control selectpicker show-tick" id="grade" name="grade">
								<option value="" selected="hidden">Grade</option>
								<c:if test="${ not empty listGrades }">
									<c:forEach var="g" items="${listGrades}">
										<option value="${g.id }">${g.code }</option>
									</c:forEach>
								</c:if>
							</select>

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