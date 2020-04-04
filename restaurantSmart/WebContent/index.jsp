<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">

	<title>WELCOME</title>
	
	<!-- reference our style sheet -->
	
	<link type="text/css"
		  rel="stylesheet"
		  href="./resources/css/style.css" />
	
</head>
<body>
	<div id ="wrapper">
		<div id = "header">
			<h2>Welcome to Smart Restaurant App!</h2>
		</div>
	</div>
	<div id ="container">
		<div id = "content">
			
			
			<input type="button" onclick="window.location.href='security/showMyLoginPage';" value="Log IN" class="add-button" />
				<br>
			<!-- Button to meniu -->
			<input type="button" onclick="window.location.href='produse/list';" value="La Meniu" class="add-button" /> 
		</div>
	</div>	
</body>
</html>