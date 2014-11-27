<!DOCTYPE html>

<html>

	<head>
		<title>SEO-AN</title>
		<meta charset="utf-8" />
		<meta http-equiv="content-type" content="text/html;charset=utf-8" />
		<link rel="shortcut icon" href="favicon.ico" />
		<meta name="viewport" content="width=device-width"/>
		<link rel="stylesheet" href="./../../resources/css/pure-min.css" />
		<link rel="stylesheet" href="./../../resources/css/style.css" />
		<script src="./../../resources/js/jquery-1.11.1.min.js"></script>
		<script src="./../../resources/js/script.js"></script>
		<!--[if IE]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

	</head>

	<body>

<!--NAVIGATION-->
		<div id="side_bar">
			<a href="#" class="logo"><img src="./../../resources/images/logo.png" alt="SEO-AN" /></a>
			<nav class="pure-menu pure-menu-open">
				<ul>
					<li><a href="/">Home</a></li>
					<li><a href="/position">Pozice</a></li>
					<li><a href="#">Přihlášení</a></li>
					<li><a href="#">Zjištění pozice</a></li>
					<li><a href="#">Validátor</a></li>
					<li><a href="#">Expirace domény</a></li>
					<li><a href="#">Další</a></li>
				</ul>
			</nav>
		</div>


<!--CONTENT-->
			<section id="content">
			

				<article>
                    <jsp:include page="${pageName}.jsp" flush="true"/>
				</article>
			</section>
		

<!--FOOTER-->	

	</body>

</html>
