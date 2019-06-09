<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Minha Agenda</title>
<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/exibeAgenda.css">

<!-- jQuery CDN -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<!-- Bootstrap CDN -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>

<!-- Font Awesome CDN -->
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Example style -->
<link rel="stylesheet" type="text/css"
	href="//zabuto.com/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="style.css">

<!-- Bootstrap e JavaScript para o calendario de consulta -->
<script src="./resources/bootstrap/js/zabuto_calendar.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/zabuto_calendar.min.css">

<!-- Bootstrap para Calendario -->
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet">
<!-- JavaScript para Calendario da escolha da Data de Agendamento -->

<style>
/* .vtr { */
/* 	margin-left: 320px; */
/* 	margin-top: -250px; */
/* } */
	
/* #calendario1 { */
/* 	margin-left: 100px; */
/* 	margin-top: -320px; */
/* } */

/* #calendario { */
/* 	margin-left: 100px; */
/* 	margin-top: -320px; */
/* } */

/* #botaoBuscarAgenda { */
/* 	margin-top: 110px; */
/* } */
</style>


</head>
<body>
	<img src="./resources/bootstrap/img/portal_sus_online.png" width=100%
		height=280px alt="" />
	<a class="navbar-brand" href="InicialController?action=Login.do">Voltar</a>
	<!-- container -->
	<div class="" col-sm-24>

		<h1 align="center">
			<span>Consultas</span>
		</h1>
		<hr>
		<div id="divMensagem">
		<h4 id="mensagem" style="color: red;">${mensagem}</h4>
		</div>
		
		
		
		<div  >
			<form action="ConsultasController?action=consulta_agenda" method="post" >

			<div class="form-group" align="center">
				
	
				<div class="col-sm-2" align="center">
					<input type="text" class="form-control" id="calendario1"
						placeholder="Data Inicial" name="dataIni">
	
				</div>
	
				<div class="col-sm-2">
					<input type="text" class="form-control" id="calendario"
						placeholder="Data Final" name="dataFim">
				</div>
			</div>

			
			<button type="submit" value="buscarAgenda" class="btn btn-default"
				id="botaoBuscarAgenda" onclick="return validar()">Buscar</button>

			</form>
		</div>
		
		
		
		
		<hr>

		<div class="row">
			<div class="col-xs-3">

				<div id="my-calendar"></div>

				<script type="application/javascript">
								
                $(document).ready(function () {
                    $("#my-calendar").zabuto_calendar({
                    	language: "pt",
                        cell_border: true,
                        today: true,
                        show_days: true,
                        weekstartson: 0,
                        nav_icon: {
                            prev: '<i class="fa fa-chevron-circle-left"></i>',
                            next: '<i class="fa fa-chevron-circle-right"></i>'
                        }
                    });
                });
            	
				
                $(function() {
            		$("#calendario").datepicker(
            		{
            				dateFormat : 'dd/mm/yy',
            				dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta',
            						'Quinta', 'Sexta', 'Sábado', 'Domingo' ],
            				dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
            				dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
            						'Sáb', 'Dom' ],
            				monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
            						'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
            						'Outubro', 'Novembro', 'Dezembro' ],
            				monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
            						'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
            				changeMonth : true,
            				changeYear : true,
            				showOtherMonths : true,
            				selectOtherMonths : true,
            		});
            	});

                $(document).ready(function () {
                    $("#my-calendar").zabuto_calendar({
                    	language: "pt",
                        cell_border: true,
                        today: true,
                        show_days: true,
                        weekstartson: 0,
                        nav_icon: {
                            prev: '<i class="fa fa-chevron-circle-left"></i>',
                            next: '<i class="fa fa-chevron-circle-right"></i>'
                        }
                    });
                });

				
                $(function() {
            		$("#calendario1").datepicker(
            			{
            				dateFormat : 'dd/mm/yy',
            				dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta',
            					'Quinta', 'Sexta', 'Sábado', 'Domingo' ],
            				dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
            				dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
            					'Sáb', 'Dom' ],
            				monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
            					'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
            					'Outubro', 'Novembro', 'Dezembro' ],
            				monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
            						'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
            				changeMonth : true,
            				changeYear : true,
            				showOtherMonths : true,
            				selectOtherMonths : true,

            			});
            	});	
				</script>
			</div>
			<div class="col-xs-8">
				<table border=5 class="table">
					<thead>
						<tr >
							<th>Data</th>
							<th>Hora</th>
							<th>Posto</th>
							<th>Medico</th>
							<th>Especialidade</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="linha" items="${listaAgenda}">
							<tr>
								<td>${linha.data}</td>
								<td>${linha.hora}</td>
								<td>${linha.ubs}</td>
								<td>${linha.medico}</td>
								<td>${linha.especialidade}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
				
		</div>
	</div>


	<script type="text/javascript">
		function ocultar() {
			if (document.getElementById('mensagem').textContent.length == 0) {
				document.getElementById('divMensagem').style.display = 'none';
			} else
				document.getElementById('divMensagem').style.display = 'block';
		}

		function validar() {
			var dataIni = document.getElementById('calendario1').value;
			var dataFim = document.getElementById('calendario').value;
			if (dataIni != null){
				var dataI = new Date(dataIni.split('/')[2],dataIni.split('/')[1],dataIni.split('/')[0]);
// 				if (dataI < Date.now){
// 					document.getElementById('mensagem').textContent = "Para buscar por período, preencha ambas as datas.";
// 					ocultar();
// 					return false;
// 				}
				if (dataFim != null){
					var dataF = new Date(dataFim.split('/')[2],dataFim.split('/')[1],dataFim.split('/')[0]);
					if (dataF < dataI){
						document.getElementById('mensagem').textContent = "Data Final deve ser maior que a Data Inicial.";
						ocultar();
						return false;
					}
				}
			}
			if ((dataIni != "" && dataFim == "")
				|| (dataIni == "" && dataFim != "")) {
				document.getElementById('mensagem').textContent = "Para buscar por período, preencha ambas as datas.";
				ocultar();
				return false;
			} else if(dataIni != "" && dataFim != ""){
				
			} else {
				document.getElementById("form").submit();
			}
		}
	</script>


	<!-- /container -->
</body>
</html>