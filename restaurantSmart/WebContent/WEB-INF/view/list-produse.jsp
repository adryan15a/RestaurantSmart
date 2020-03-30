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
			<h2>Meniul Restaurantului</h2>
		</div>
	</div>
	<div id ="container">
		<div id = "content">
		
			<!-- put new button:Add Customer -->
			
			<input type="button" value="COS"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"/>
			
			<!--  add a search box -->
            <form:form action="search" method="POST">
                Cauta produs: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<!-- add out html table here -->
			
			<table>
				<tr>
					<th>Nume Produs</th>
					<th>Descriere Produs</th>
					<th>Pret Unitar</th>
					<th>Alege cantitatea</th>
					<th>Adauga in cos</th>
				</tr>
				<c:forEach var="listProduse" items="${produse}">
					<tr>
						<td>${listProduse.getNumeProdus()}</td>
						<td>${listProduse.getDescriereProdus()}</td>
						<td>${listProduse.getPretUnitar()}</td>
						<td><input type ="number" id="cant${listProduse.getIdProdus()}" name="cant${listProduse.getIdProdus()}" min="1" max="${listProduse.getNivelExistent()}"></td>
						<td><button onclick = 'this.disabled=true;document.getElementById("productId").value="${listProduse.getIdProdus()}";form.submit();'>Adauga</button></td>
					</tr>
				</c:forEach>
			</table>
			</div>
	</div>	
</body>
</html>