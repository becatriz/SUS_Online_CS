<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Minha Agenda</title>
<link rel="stylesheet" type="text/css"
	href="./resources/bootstrap/css/logado.css">

<!-- jQuery CDN -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<!-- Bootstrap CDN -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="//oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="//oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

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

</head>
<body>
	<img src="./resources/bootstrap/img/portal_sus_online.png" width=100%
		height=280px alt=""  />
	<a class="navbar-brand" href="InicialController?action=Login.do">Voltar</a>
	<!-- container -->
	<div class="container example">

		<h1>
			<span>Suas Consultas</span>

		</h1>

		<hr>

		<div class="row">
			<div class="col-xs-5">

				<div id="my-calendar"></div>

				<script type="application/javascript">
					
					
					
                $(document).ready(function () {
                    $("#my-calendar").zabuto_calendar({
                    	language: "pt",
                        cell_border: true,
                        today: false,
                        show_days: true,
                        weekstartson: 0,
                        nav_icon: {
                            prev: '<i class="fa fa-chevron-circle-left"></i>',
                            next: '<i class="fa fa-chevron-circle-right"></i>'
                        }
                    });
                });
            
				
				
				</script>

			</div>

		</div>

	</div>
	<!-- /container -->

</body>
</html>