
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
			<p>Bem-vindo(a) ${ user.nome }</p>
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
				href="ConsultasController?action=consulta_agenda" role="button">Consultas Agendadas</a> 
				<a style="margin-right: 5px;"
				class="btn btn-sm btn-success active navbar-right offset"
				href="ExamesController?action=consultar_exames" role="button">Exames Agendados</a>
				<a style="margin-right: 5px;"
				class="btn btn-sm btn-success active navbar-right offset"
				href="ConsultasController?action=agendar_consulta" role="button">Agendar
				Consultas</a> <a style="margin-right: 5px;"
				class="btn btn-sm btn-success active navbar-right offset"
				href="ExamesController?action=agendar_exames" role="button">Agendar
				Exames</a>
				<a style="margin-right: 5px;"
				class="btn btn-sm btn-success active navbar-right offset"
				href="InicialController?action=exibir_perfil" role="button">Exibir Perfil
				</a>
		</div>
	</div>

</body>
</html>