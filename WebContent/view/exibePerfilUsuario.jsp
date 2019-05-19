
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

	<c:choose>
		<c:when test="${ user eq null }">
			<jsp:forward page="aviso_nao_tem_conta_criada.jsp" />
		</c:when>
		<c:otherwise>
			<p>Usuário ${ user.nome } logado(a)</p>
		</c:otherwise>

	</c:choose>


	<div class="navbar">
		<div class="row">
			<a class="navbar-brand"
				href="InicialController?action=home_barra_superior">Home</a> <a
				style="margin-right: 5px;" class="navbar-brand"
				href="InicialController?action=iniciar_login_conta" role="button">Sair</a>
			<a class="navbar-brand" href="InicialController?action=Login.do">Voltar</a>

		</div>
	</div>
	<h1>Perfil do Usuário</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-5  toppad  pull-right col-md-offset-3 "></div>
			<div
				class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Perfil do Paciente</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3 col-lg-2 " align="center"></div>

							<div class=" col-md-9 col-lg-10 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td><h3>Informações Pessoais</h3></td>

										</tr>
										<tr>
											<td>Nome Completo:</td>
											<td>Buscar todas a informaçõe do usuario completo do
												Banco de dados</td>
										</tr>
										<tr>
											<td>Idade:</td>
											<td>20</td>
										</tr>

										<tr>
										<tr>
											<td>Sexo:</td>
											<td>Feminino</td>
										</tr>
										<tr>
											<td>Estado Civil</td>
											<td>Solteiro(a)</td>

										</tr>
										<tr>
											<td>Endereço:</td>
											<td>Rua: Jose Antonio n 102 Bairro: Jardim</td>

										</tr>

										<tr>
											<td>Celular:</td>
											<td>67 9999-9999</td>
										</tr>
										<tr>
											<td>Telefone Fixo:</td>
											<td>67 3333-3333</td>
										</tr>

										<tr>
											<td>Tipo Sanguineo:</td>
											<td>O -</td>

										</tr>
										<tr>
											<td><b>Informações de Histórico de Consultas</b></td>
										</tr>
										<tr>
											<td><b>Informações de Histórico de Exames</b></td>
										</tr>
										<tr>
											<td><b>Informações de Medicamentos</b></td>
										</tr>
										<tr>
									</tbody>
								</table>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>