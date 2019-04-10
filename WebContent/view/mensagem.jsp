
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>

<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/login_nao_existe.css">
<title>Usuario nao cadastrado</title>
</head>
<body>
	<h1>Login ou senha incorretos</h1>
<br><br>
	<section class="container">
		<div>
			<h1 id="mensagem" style="color:red;">${mensagem}</h1>
		</div>


	</section>

	<p>
		<button class="btn btn-info">
			<a href="InicialController?action=home_barra_superior">Voltar</a>
		</button>
	</p>


</body>
</body>
</html>