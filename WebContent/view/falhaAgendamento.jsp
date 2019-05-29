
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

	<c:choose>
		<c:when test="${ user eq null }">
			<jsp:forward page="aviso_nao_tem_conta_criada.jsp" />
		</c:when>
		<c:otherwise>
			<h1> ${ mensagem }</h1>
			<a class="navbar-brand" href="InicialController?action=Login.do">Voltar</a>
			
		</c:otherwise>

	</c:choose>


	<div class="navbar">
		<div class="row">
			<a class="navbar-brand"
				href="InicialController?action=home_barra_superior">Home</a> <a
				style="margin-right: 5px;"
				class="btn btn-sm btn-success active navbar-right offset"
				href="InicialController?action=iniciar_login_conta" role="button">Sair</a>
			<a style="margin-right: 5px;"
				class="btn btn-sm btn-success active navbar-right offset"
				href="AgendaController?action=consulta_agenda" role="button">Agenda</a>
			<a style="margin-right: 5px;"
				class="btn btn-sm btn-success active navbar-right offset"
				href="AgendaController?action=agendar_consulta" role="button">Agendamento</a>
		</div>
	</div>

</body>
</html>