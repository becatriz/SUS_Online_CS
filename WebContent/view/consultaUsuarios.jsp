<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Logado</title>
<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/logado.css">
</head>
<body>


	<img src="./resources/bootstrap/img/portal_sus_online.png" width=100%
		height=280px alt="" />
	<a class="navbar-brand"
		href="InicialController?action=home_barra_superior">Voltar</a>

	<h1>Lista de Usuários do Sistema</h1>

	<form class="vt" action="InicialController?action=irParaExibirUsuarios"
		method="get">
		
		<table border=3>
			<tr>

				<th>ID</th>
				<th>Nome</th>
				<th>Usuario</th>
			



			</tr>
			<c:forEach var="linha" items="${listaUsuarios}">
				<tr>

					<td>${linha.id}</td>
					<td>${linha.nome}</td>
					<td>${linha.usuario}</td>
				




				</tr>
			</c:forEach>

		</table>
	</form>

</body>
</html>