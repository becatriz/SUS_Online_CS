<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/login.css">


<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- JavaScript Para o recaptcha -->
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<!-- Se nao preenche o Captcha exibe alerta para preencher -->
 <script>
    window.onload = function() {
    var recaptcha = document.forms["Meu_form"]["g-recaptcha-response"];
    recaptcha.required = true;
    recaptcha.oninvalid = function(e) {
    // fazer algo, no caso to dando um alert
    alert("Por favor complete o Captcha");
      }
   }
   </script>


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
					<form id="Meu_form" action="Login.do" method="post">

						<input type="text" id="password" class="fadeIn second"
							name="username" placeholder="Usuário" required> <input
							type="password" id="password" class="fadeIn third"
							name="password" placeholder="Senha" required>

						<!-- Div para o recaptcha -->
						<div class="g-recaptcha" style="margin-left: 75px;"
							data-sitekey="6LffsZkUAAAAAK8jd-EMK9CG_99WOup2TX4GSgkk"></div>


						<input type="submit" class="fadeIn fourth" value="Entrar"
>
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