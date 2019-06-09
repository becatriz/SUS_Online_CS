<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agendar Exames</title>

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



</head>
<body>
	<img src="./resources/bootstrap/img/portal_sus_online.png" width=100%
		height=280px alt="" />
	<a class="navbar-brand" href="InicialController?action=Login.do">Voltar</a>

	<div class="container">
		<h2>Agendar Exames</h2>
		<hr>
		<hr>
		<div id="divMensagem">
			<h4 id="mensagem" style="color: red;">${mensagem}</h4>
		</div>
		<form class="form-horizontal" id="form" action="agendarExames"
			method="post">
			<div class="form-group"></div>
			<div class="form-group">
				<label class="control-label col-sm-2">Estado</label>
				<div class="col-sm-3">
					<select onChange="Change('inputCidade')" name="estado" id="inputEstado" class="form-control">
						<option value="null" selected>Selecionar</option>
						<option>Mato Grosso do Sul</option>

					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Cidade</label>
				<div class="col-sm-3">
					<select onChange="Change('exame')" required name="cidade" id="inputCidade"
						class="form-control">
						<option value ="null"selected>Selecionar</option>
						<option>Campo Grande</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Exame</label>
				<div class="col-sm-3">
					<select onChange="Change('ubs')" name="exame" class="form-control" id="exame">
						<option value="null "selected>Selecionar</option>
						<option value="Tomografia ">Tomografia</option>
						<option value="Radiologia">Radiologia</option>
						<option value="Urina">Urina</option>
						<option value="Sangue ">Sangue</option>
					</select>
				</div>

			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">UBS - Unidade Básica
					de Saúde</label>
				<div class="col-sm-3">
					<select  onChange="Change('calendario')" name="ubs" class="form-control" id="ubs">
						<option value="null" selected>Selecionar</option>
						<option value="Posto Nova Bahia ">Posto Nova Bahia</option>
						<option value="Posto Coronel Antonino">Posto Coronel
							Antonino</option>
						<option value="Posto Tiradentes">Posto Tiradentes</option>
					</select>
				</div>

			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="data">Data:</label>

				<div class="col-sm-3">
					<input onChange="Change('inputHora')" type="text" class="form-control" id="calendario"
						placeholder="Escolha uma data" name="data" required>
				</div>

				<label class="control-label col-sm-1" for="hora">Hora:</label>
				<div class="col-sm-3">
					<select name="hora" id="inputHora" class="form-control" required>
						<option selected value="null">Hora</option>
						<option>13:00</option>
						<option>14:00</option>
						<option>15:00</option>
						<option>16:00</option>
						<option>17:00</option>

					</select>
				</div>

			</div>



			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" id="salvarExame" value="salvarExame"
						onclick="return validar()" class="btn btn-default">Agendar</button>
				</div>
			</div>
		</form>
	</div>


	<script type="text/javascript">
	$(document).ready(function () {
		document.getElementById('inputCidade').disabled = true;
		document.getElementById('exame').disabled = true;
		document.getElementById('ubs').disabled = true;
		document.getElementById('calendario').disabled = true;
		document.getElementById('inputHora').disabled = true;
	});
	
	function Change(id){
		document.getElementById(id).disabled = false;	
	}
	
		function ocultar() {
			if (document.getElementById('mensagem').textContent.length == 0) {
				document.getElementById('divMensagem').style.display = 'none';
			} else {
				document.getElementById('divMensagem').style.display = 'block';
			}
		}
	</script>

	<script type="text/javascript">
		function validar() {
			var estado = document.getElementById('inputEstado').value;
			var cidade = document.getElementById('inputCidade').value;
			var exame = document.getElementById('exame').value;
			var ubs = document.getElementById('ubs').value;
			var data = document.getElementById('calendario').value;
			var hora = document.getElementById('inputHora').value;

			var strData = data;
			var partesData = strData.split("/");
			var data = new Date(partesData[2], partesData[1] - 1, partesData[0]);
			data.setHours(23, 59, 59);
			if (data < new Date(Date.now())) {
				document.getElementById('mensagem').textContent = "A data da consulta não pode ser anterior à data atual.";
				ocultar();
				return false;
			}

			if (data == "null" || hora == "null" || estado == "null"
					|| cidade == "null" || ubs == "null"
					|| calendario == "null" || exame == "null") {
				document.getElementById('mensagem').textContent = "Todos os campos devem estar preenchidos.";
				ocultar();
				return false;

			} else {
				document.getElementById("form").submit();
			}
		}
	</script>







</body>
</html>