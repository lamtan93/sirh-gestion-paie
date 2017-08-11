<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie - App</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-
dist/css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/monStyle.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/monJs.js">

</head>
<body class="container">
	<h1>Connexion</h1>
	<!-- Spring Security s'attend aux param�tres "username" et "password" -->
	<form method="post">
		<input name="username"> <input name="password" > 
		<input class="btn btn-primary btn-success" type="submit" value="Se connecter">
		
		<sec:csrfInput/>
	</form>
	<!-- en cas d'erreur un param�tre "error" est cr�� par Spring Security -->
	<c:if test="${param.error !=null}">
		Erreur d'authentification
	</c:if>

</body>
</html>