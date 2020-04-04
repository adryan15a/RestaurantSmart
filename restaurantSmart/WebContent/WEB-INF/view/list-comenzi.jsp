<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">

	<title>Lista de produse</title>
	
	<!-- reference our style sheet -->
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>
<body>
	<div id ="wrapper">
		<div id = "header">
			<h2>Produse in COS</h2>
		</div>
	</div>
	<div id ="container">
		<div id = "content">

			<h3 class="add-button">Numar Comenzi Active: ${nrComenzi} </h3>
			
			<!-- add out html table here -->
			
			<table>
				<tr>
					<th>Numar Comanda</th>
					<th>De platit</th>
					<th>Numar Produse</th>
					<th>Continut Comanda(id produse)</th>
					<th>Data livrare</th>
					<th>Actiuni Ospatar</th>
				</tr>
				<c:forEach var="listaComenzi" items="${comenzi}">
				
					<c:url var="livrat" value="/produse/livrat">
						<c:param name="IdComanda" value="${listaComenzi.idComanda}" />
					</c:url>
					
					<c:url var="incasat" value="/produse/incasat">
						<c:param name="IdComanda" value="${listaComenzi.idComanda}" />
					</c:url>
					
					<tr>
						<td>${listaComenzi.getIdComanda()}</td>
						<td>${listaComenzi.getPretTotalComanda()}</td>
						<td>${listaComenzi.getNumarProduse()}</td>
						<td>${listaComenzi.getContinutComanda()}</td>
						<td>${listaComenzi.getDataIncasare()}</td>
						<td><a href="${livrat}">Livrat</a>|<a href="${incasat}">Incasat</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>	
</body>
</html>