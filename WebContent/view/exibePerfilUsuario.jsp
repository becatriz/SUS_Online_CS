
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Perfil</title>
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

	</div>

	<h1>Minha Agenda - Histórico de Exames e Consultas</h1>



	<h4>Exames</h4>

	<div class="col-xs-8">
		<table border=5 class=table>
			<thead>
				<tr>
					<th>Data</th>
					<th>Hora</th>
					<th>Estado</th>
					<th>Cidade</th>
					<th>Posto</th>
					<th>Exame</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="linha" items="${listaAgenda}">
					<tr>
						<td>${linha.data}</td>
						<td>${linha.hora}</td>
						<td>${linha.estado}</td>
						<td>${linha.cidade}</td>
						<td>${linha.ubs}</td>
						<td>${linha.exame}</td>
					</tr>
					<tbody>
				</c:forEach>
		</table>
	</div>
	<br>
	<br>
	<br>
	<div class="col-xs-8">
		<h4>Consultas</h4>
		<table border=5 class=table>
			<thead>
				<tr>
					<th>Data</th>
					<th>Hora</th>
					<th>Estado</th>
					<th>Cidade</th>
					<th>Medico</th>
					<th>Especialidade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="linha" items="${listaAgendaExame}">
					<tr>
						<td>${linha.data}</td>
						<td>${linha.hora}</td>
						<td>${linha.estado}</td>
						<td>${linha.cidade}</td>
						<td>${linha.medico}</td>
						<td>${linha.especialidade}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />

	<div class="navbar"></div>
	<button type="button" onClick="window.print();">Imprimir</button>
</body>
</html>


