<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Minha Agenda</title>
<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/exibeAgendaa.css">

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
.vtr {
	margin-left: 320px;
	margin-top: -250px;
}

#calendario1 {
	margin-left: 100px;
	margin-top: -320px;
}

#calendario {
	margin-left: 100px;
	margin-top: -320px;
}

#botaoBuscarAgenda {
	margin-top: 115px;
}
</style>

</head>
<body>
	<img src="./resources/bootstrap/img/portal_sus_online.png" width=100%
		height=280px alt="" />
	<a class="navbar-brand" href="InicialController?action=Login.do">Voltar</a>
	<!-- container -->
	<div class="">

		<h1>
			<span>Exames</span>
		</h1>
		<h3></h3>
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
		</div>


	</div>


	<form class="form-horizontal1" action="agendarConsulta" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="data"></label>

			<div class="col-sm-2">
				<input type="text" class="form-control" id="calendario1"
					placeholder="Data Inicial" name="data">

			</div>

			<div class="col-sm-2">
				<input type="text" class="form-control" id="calendario"
					placeholder="Data Final" name="data">

			</div>
		</div>





	</form>





	<form class="vtr" action="ExamesController?action=irConsultaExame"
		method="get">

		<table border=5>
			<tr>

				<th>Data</th>
				<th>Hora</th>
				<th>Estado</th>
				<th>Cidade</th>
				<th>Posto</th>
				<th>Exame</th>



			</tr>
			<c:forEach var="linha" items="${listaAgendaExame}">
				<tr>

					<td>${linha.data}</td>
					<td>${linha.hora}</td>
					<td>${linha.estado}</td>
					<td>${linha.cidade}</td>
					<td>${linha.ubs}</td>
					<td>${linha.exame}</td>





				</tr>
			</c:forEach>
		</table>
		<br />

		<button type="submit" value="buscarAgenda" class="btn btn-default"
			id="botaoBuscarAgenda">Buscar</button>
	</form>



	<!-- /container -->
</body>
</html>