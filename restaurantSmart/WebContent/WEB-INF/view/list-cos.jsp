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
		
			<!-- put new button:Trimite Comanda -->
			
		    <input type="button" value="Trimite Comanda" onclick="location.href='trimiteComanda'; return false;" class="add-button"/> 
				
				
				
			<!-- Button to meniu -->
			<input type="button" onclick="window.location.href='list';" value="La Meniu" class="add-button" /> 
			
			
			<h3 class="add-button">Total: ${totalCos} RON</h3>
			
			<!-- add out html table here -->
			
			<table>
				<tr>
					<th>Nume Produs</th>
					<th>Descriere Produs</th>
					<th>Pret Unitar</th>
					<th>Numar Produse ${nrPortiiTotal}</th>
				</tr>
				<c:forEach var="theProdus" items="${produse}">
				
					<c:url var="adaugaPortie" value="/produse/adaugaPortie">
						<c:param name="IdProdus" value="${theProdus.idProdus}" />
					</c:url>
					
					<c:url var="stergePortie" value="/produse/stergePortie">
						<c:param name="IdProdus" value="${theProdus.idProdus}" />
					</c:url>
					
					<tr>
						<td>${theProdus.getNumeProdus()}</td>
						<td>${theProdus.getDescriereProdus()}</td>
						<td>${theProdus.getPretUnitar()}</td>
						<td><a href="${adaugaPortie}">Adauga</a>|<a href="${stergePortie}">Sterge</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>	
</body>
</html>