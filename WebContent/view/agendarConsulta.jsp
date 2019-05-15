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

<!-- Script para os options a cada seleção selecionar diferente -->
<script>
	function teste() {
		valorSelecionado = $('#ubs').val();

		//quando tiver visualizando o formulário o valor fica no campo text;
		if (!valorSelecionado) {
			valorSelecionado = $('#ubs').text();
		}
		switch (valorSelecionado) {
		case "Posto Nova Bahia":
			$('#Sandra').show();
			$('#Rebeca').hide();
			$('#Paulo').hide();
			$('#Marcelo').show();
			$('#Clinico Geral').show();
			$('#Oftalmologista').hide();
			$('#Cardiologista').hide();
		

			break;

		case "Posto Coronel Antonino":
			$('#Sandra').hide();
			$('#Rebeca').show();
			$('#Paulo').show();
			$('#Clinico Geral').hide();
			$('#Oftalmologista').hide();
			$('#Cardiologista').show();
		
		

			break;

		case "Posto Tiradentes":
			$('#Sandra').hide();
			$('#Rebeca').show();
			$('#Paulo').hide();
			$('#Marcelo').show();
			$('#Clinico Geral').hide();
			$('#Oftalmologista').hide();
			$('#resultado7').show();
			$('#Cardiologista').show();

			break;
		default:

		}
	}
</script>


</head>
<body>
	<img src="./resources/bootstrap/img/portal_sus_online.png" width=100%
		height=280px alt="" />
	<a class="navbar-brand" href="InicialController?action=Login.do">Voltar</a>

	<div class="container">
		<h2>Agendar Consultas</h2>
		<hr>
		<hr>

		<form class="form-horizontal" action="agendarConsulta"  method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="data">Data:</label>

				<div class="col-sm-3">
					<input type="text" class="form-control" id="calendario"
						placeholder="Escolha uma data" name="data">
				</div>

				<label class="control-label col-sm-1" for="data">Hora:</label>
				<div class="col-sm-3">
					<select name="hora" id="inputCidade" class="form-control" >
						<option selected>Hora</option>
						<option>13:00</option>
						<option>14:00</option>
						<option>15:00</option>
						<option>16:00</option>
						<option>17:00</option>

					</select>
				</div>

			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Cidade</label>
				<div class="col-sm-3">
					<select name="cidade" id="inputCidade" class="form-control">
						<option selected>Selecionar</option>
						<option>Campo Grande</option>

					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Estado</label>
				<div class="col-sm-3">
					<select required name="estado" id="inputEstado" class="form-control">
						<option selected >Selecionar</option>
						<option>Mato Grosso do Sul</option>
					</select>
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-2">UBS - Unidade Básica
					de Saúde</label>
				<div class="col-sm-3">
					<select name="ubs" class="form-control" id="ubs"
						onchange="teste();">
						<option selected>Selecionar</option>
						<option value="Posto Nova Bahia ">Posto Nova Bahia</option>
						<option value="Posto Coronel Antonino">Posto Coronel Antonino</option>
						<option value="Posto Tiradentes">Posto Tiradentes</option>
					</select> <br> <label class="">Médico(a)</label> 
					
					<select
						name="medico" id="medico" class="form-control">

						<option selected>Selecionar</option>
						<option value="Sandra" id="resultado1">Drª Sandra
							Mesquita</option>
						<option value="Rebeca" id="resultado2">Drª Rebeca
							Lopes</option>
						<option value="Paulo" id="resultado3">Dr Paulo Oka</option>
						<option value="Marcelo" id="resultado4">Dr Marcelo
							Pereira</option>
					</select> <label class="">Especialidade</label> <select name="especialidade"
						id="especialidade" class="form-control">

						<option selected>Selecionar</option>
						<option value="Clinico Geral" id="resultado5">Clinico Geral</option>
						<option value="Oftalmologista" id="resultado6">Oftalmologista</option>
						<option value="Cardiologista" id="resultado8">Cardiologista</option>
					</select>

				</div>
			</div>




			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" value="salvar" class="btn btn-default">Agendar</button>
				</div>
			</div>
		</form>
	</div>










</body>
</html>