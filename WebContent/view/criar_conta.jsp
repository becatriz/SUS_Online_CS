
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>

<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/bootstrap.min.css" />

<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/bootstrap-theme.min.css" />

<script src="./resources/bootstrap/js/bootstrap.min.js"></script>


</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">

			<div class="navbar-header">
				<a class="navbar-brand"
					href="InicialController?action=home_barra_superior">Home</a>
			</div>
		</div>
	</div>
	<div class="container" style="padding-top: 25px;">
		<div class="row">
			<div class="container">
				<div class="col-md-8">
					<h1>Criar conta no Portal SUS Online</h1>
					<p>Criando sua conta você poderá consultar prontuario, médicos,
						medicamentos, agendar consultas e muito mais .</p>
					<br />
					<form class="form-horizontal" method="post" action="" role="form">
						<div class="form-group">
							<label for="email" class="col-sm-3 control-label">Email</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="email" name="email"
									placeholder="Digite aqui seu email" />
							</div>
						</div>
						<div class="form-group">
							<label for="nome" class="col-sm-3 control-label">Nome</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="nome" name="nome"
									placeholder="Digite aqui seu usuário" />
							</div>
						</div>
						<div class="form-group">
							<label for="senha" class="col-sm-3 control-label">Senha</label>
							<div class="col-sm-6">
								<input type="password" id="senha" class="form-control"
									name="password" placeholder="Digite aqui sua senha" />
							</div>
						</div>
						<div class="form-group">
							<label for="senha2" class="col-sm-3 control-label">Confirma
								senha</label>
							<div class="col-sm-6">
								<input type="password" id="senha2" class="form-control"
									placeholder="Confirme aqui sua senha" />
							</div>
						</div>

						<div class="row" style="padding-top: 20px;">
							<a href="" style="margin-left: 30px;"
								class="btn btn-sm btn-success active navbar-right offset"
								role="button">Criar Conta</a>
						</div>


					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>