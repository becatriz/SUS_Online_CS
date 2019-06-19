
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Vacinas</title>
<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/logado.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/perfil.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>


	<img src="./resources/bootstrap/img/portal_sus_online.png" width=100%
		height=280px alt="" />

	
	<div class="row">
		<a class="navbar-brand"
			href="InicialController?action=home_barra_superior">Home</a> <a
			style="margin-right: 5px;" class="navbar-brand"
			href="InicialController?action=iniciar_login_conta" role="button">Sair</a>
		<a class="navbar-brand" href="InicialController?action=Login.do">Voltar</a>
	<br>
	<h1>Vacinas</h1>
	
	
			<div class="col-xs-8">
				<table border=5 class="table">
					<thead>
						<tr >
							<th>Tipo Vacina</th>
							<th>Data Aplicação</th>
							<th>Lote Validade</th>
							<th>Validade Vacina</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="linha" items="${listaVacinas}">
							<tr>
								<td>${linha.tipoVacina}</td>
								<td>${linha.dataApli}</td>
								<td>${linha.loteValidade}</td>
								<td>${linha.validadeImune}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
</div>
	
</body>

</html>