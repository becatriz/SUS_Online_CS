<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/bootstrap-login.css" />
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">

			<div class="navbar-header" style="padding-top: 20px;">
				<a class="navbar-brand" 
					href="InicialController?action=home_barra_superior" 
					style="margin-left: 100px;" id=home>Home</a>
			</div>


			<div class="wrapper fadeInDown">
				<div id="formContent">
					<!-- Tabs Titles -->

					<!-- Icon -->
					<div class="fadeIn first">
						<img src="https://png.pngtree.com/svg/20161229/e7a5cf5c9e.svg"
							id="icon" alt="User Icon" />
					</div>

					<!-- Login Form -->
					<form>
						<input type="text" id="login" class="fadeIn second" name="login"
							placeholder="Usuário"> <input type="text" id="password"
							class="fadeIn third" name="login" placeholder="Senha"> <input
							type="submit" class="fadeIn fourth" value="Entrar">
					</form>

					<!-- Remind Passowrd -->
					<div id="formFooter">
						<a class="underlineHover" href="#">Esqueci minha senha</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>