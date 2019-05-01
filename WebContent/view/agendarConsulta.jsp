<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agendar Consultas</title>

<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/logado.css">
<meta charset="utf-8">
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


<!-- Bootstrap para Calendario -->
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet">


<style>
p>input {
	margin-top: 50px;
	margin-right: 70%;
}

#horario {
	margin-top: -20px;
	margin-right: 50%;
}
</style>



<!-- JavaScript para Calendario da escolha da Data de Agendamento -->
<script>
	$(function() {
		$("#calendario").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Ter�a', 'Quarta',
							'Quinta', 'Sexta', 'S�bado', 'Domingo' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'S�b', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Mar�o', 'Abril',
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



</head>
<body>
	<img src="./resources/bootstrap/img/portal_sus_online.png" width=100%
		height=280px alt="" />
<a class="navbar-brand" href="InicialController?action=Login.do">Voltar</a>

	<div class="container">
		<h2>Agendar Consultas</h2><hr><hr>
		
		<form class="form-horizontal" action="agendarConsulta">
			<div class="form-group">
				<label class="control-label col-sm-2" for="data">Data:</label>

				<div class="col-sm-3">
					<input type="text" class="form-control" id="calendario"
						placeholder="Escolha uma data" name="data">
				</div>

				<label class="control-label col-sm-1" for="data">Hora:</label>

				<div class="col-sm-3">
					<input type="text" class="form-control" id="hora"
						placeholder="Horario" name="hora">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Cidade</label>
				<div class="col-sm-3">
					<select id="inputCidade" class="form-control">
						<option selected>Selecionar</option>
						<option>Campo Grande</option>

					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Estado</label>
				<div class="col-sm-3">
					<select id="inputEstado" class="form-control">
						<option selected>Selecionar</option>
						<option>Mato Grosso do Sul</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">UBS - Unidade B�sica
					de Sa�de</label>
				<div class="col-sm-3">
					<select id="inputEstado" class="form-control">
						<option selected>Selecionar</option>
						<option>Posto Coronel Antonino</option>
						<option>Posto Nova Bahia</option>
						<option>Posto Tiradentes</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Especialidade</label>
				<div class="col-sm-3">
					<select id="inputEstado" class="form-control">
						<option selected>Selecionar</option>
						<option>Clinico Geral</option>
						<option>Oftalmologista</option>
						<option>Endocrino</option>
						<option>Ginecologista</option>
						<option>Otorrinolaringologista</option>
					</select>
				</div>
			</div>

	
			<div class="form-group">
				<label class="control-label col-sm-2">M�dicos</label>
				<div class="col-sm-3">
					<select id="inputEstado" class="form-control">
						<option selected>Selecionar</option>
						<option>Dr. Paulo Oka</option>
						<option>Dr. Marcelo Pereira</option>
						<option>Dra. Sandra Mesquita</option>
						<option>Dra. Rebeca Lopes</option>
						
					</select>
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10"></div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Agendar</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>