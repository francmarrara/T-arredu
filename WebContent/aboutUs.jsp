<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="it">

<head>
<title>About us</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="css/slick.css" />
<link rel="stylesheet" type="text/css" href="css/slick-theme.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" href="css/Footer-with-social-icons.css">

<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<!-- Smartsupp Live Chat script -->
<script type="text/javascript">
	var _smartsupp = _smartsupp || {};
	_smartsupp.key = '58229b18ee887d3746828189216580bbcf663a18';
	window.smartsupp || (function(d) {
		var s, c, o = smartsupp = function() {
			o._.push(arguments)
		};
		o._ = [];
		s = d.getElementsByTagName('script')[0];
		c = d.createElement('script');
		c.type = 'text/javascript';
		c.charset = 'utf-8';
		c.async = true;
		c.src = 'https://www.smartsuppchat.com/loader.js?';
		s.parentNode.insertBefore(c, s);
	})(document);
</script>

<script>
	window.onload = function() {
		fb_share.href = 'https://www.facebook.com/sharer/sharer.php?text=vieni a trovarci su Tarredu arredamenti&u='
				+ encodeURIComponent(location.href);

		tw_share.href = 'http://twitter.com/share?text=vieni a trovarci su Tarredu arredamenti&url='
				+ encodeURIComponent(location.href)
				+ '&hashtags=#tarredu,#unical,#ingsw,#ricca';

		go_share.href = 'https://plus.google.com/share?text=vieni a trovarci su Tarredu arredamenti&u='
				+ encodeURIComponent(location.href);
	}
</script>

<link rel="stylesheet" href="css/aboutUs.css">
<link rel="stylesheet" href="css/snackbar.css">
<script src="js/Js/aboutUs.js"></script>

<link rel="shortcut icon" href="images/TarreduLogo.png">

</head>

<body>

	<!-- Sfondo -->
	<div id="bg">
		<img class="img img-responsive" src="images/sfondoLegno.png" alt="">
	</div>

	<!-- Header -->
	<header class="container-fluid headerImage" name="top">
		<div class="headerContainer">
			<img src="images/headerImage.png" alt="headerImage" width="1318px"
				height="50px">
		</div>
	</header>

	<!-- Menu di navigazione principale -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="navbarOggetto"><img id="logoButton"
					src="images/TarreduLogo.png" width="50" height="50"></li>
				<li class="navbarOggetto"><a href="index.jsp">Home</a></li>

				<li class="navbarOggetto"><a href="prodotti">Catalogo
						Prodotti</a></li>
				<li class="navbarOggetto"><a href="aboutUs.html">About us</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right menuDestra">

				<c:if test="${utenteLoggato == true}">

					<li class="navbarOggetto"><a onclick="effettuaLogout()"
						class="nomeUtente" style="cursor: pointer;"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>

					<li class="navbarOggetto"><a href="utente" class="nomeUtente"><span
							class="glyphicon glyphicon-user user"></span> Benvenuto,
							${nomeUtente}</a></li>

					<li class="carrello navbarOggetto"><a href="carrello"><span
							class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>

				</c:if>

				<c:if test="${utenteLoggato == false}">

					<li class="navbarOggetto">
						<!-- Form per il login --> <a href="#login"
						onclick="document.getElementById('login').style.display='block'">
							<span class="glyphicon glyphicon-log-in"></span> Login
					</a>

						<div id="login" class="modal">

							<form class="modal-content animate" method="post"
								action="validaCredenzialiLogin">
								<div class="imgcontainer">
									<span
										onclick="document.getElementById('login').style.display='none'"
										class="close" title="Chiudi Login">&times;</span> <img
										src="images/userLogin.jpg" alt="Avatar" class="avatar"
										width=150 height=150>
								</div>

								<div class="containerModal">
									<label><b>Email Utente</b></label> <input
										class="inputLogIn EmailUtenteLogin" type="text"
										placeholder="Inserire Indirizzo Email" name="emailUtente"
										required> <label><b>Password</b></label> <input
										class="inputLogIn passwordLogin" type="password"
										placeholder="Inserire Password" name="psw" required>

									<button class="buttonLog" type="submit">Login</button>
									<div class="containerCheckbox">
										<label>Ricordami <input type="checkbox"
											id="checkRicordami" onclick="controlla()"></label>
									</div>
								</div>

								<div class="containerModalBottom"
									style="background-color: #ffffff">
									<button type="button"
										onclick="document.getElementById('login').style.display='none'"
										class="cancelbtn">Cancel</button>
								</div>
							</form>
						</div>
					</li>
					<li class="navbarOggetto">
						<!-- Form per la registrazione --> <a href="#registrazione"
						onclick="document.getElementById('registrazione').style.display='block'">
							<span class="glyphicon glyphicon-user user"></span> Registrati
					</a>

						<div id="registrazione" class="modal">

							<form class="modal-content animateReg" method="post"
								action="registrazione">
								<div class="imgcontainerReg">
									<span
										onclick="document.getElementById('registrazione').style.display='none'"
										class="closeReg" title="Chiudi Registrazione">&times;</span>
								</div>
								<h1>Registrazione</h1>
								<p>Compila questo modulo per creare un account.</p>
								<hr>
								<div class="containerReg">

									<label><b>Nome</b></label> <input type="text"
										placeholder="Inserire Nome" name="nome" required> <label><b>Cognome</b></label>
									<input type="text" placeholder="Inserire Cognome"
										name="cognome" required> <label><b>Data di
											Nascita</b></label> <input type="date"
										placeholder="Inserire Data di Nascita" name="dataDiNascita"
										required> <label><b>Numero di Telefono</b></label> <input
										type="text" placeholder="Inserire Numero di Telefono"
										name="numeroDiTelefono" required> <label><b>Email</b></label>
									<input id="emailUtente" type="text"
										placeholder="Inserire Indirizzo Email" name="email" required>
									<label><b>Password</b></label> <input id="psw" type="password"
										placeholder="Inserire Password" name="psw" required> <label><b>Ripetere
											Password</b></label> <input id="psw-repeat" type="password"
										placeholder="Reinserire Password" name="psw-repeat" required>
								</div>
								<div class="containerRegButton"
									style="background-color: #ffffff">
									<button type="button"
										onclick="document.getElementById('registrazione').style.display='none'"
										class="cancelbtnReg">Cancel</button>
									<button class="buttonReg" type="submit">Registrati</button>
								</div>
							</form>

						</div>
					</li>
					<li class="carrello navbarOggetto"><a onclick="chiediLogin()"
						style="cursor: pointer"><span
							class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>
				</c:if>


			</ul>
		</div>
	</nav>

	<br>
	<br>

	<!-- Bottone laterale a scomparsa -->
	<div id="mySidenav" class="sidenav">
		<a href="#top" id="backToTopMenu">Torna su</a>
	</div>

	<div class="container" style="margin-top: 8%;">
		<div style="background-color: white; margin-bottom: 5%;">
			<div class="containerSezioneSuperiore">
				<h2>Chi siamo</h2>
				<hr>
				<div class="row">

					<div class="col-md-4 immagine" style="padding-left: 20%;">
						<img class="img img-responsive" id="logoButton"
							src="images/TarreduLogo.png" width="80%" height="80%">
					</div>

					<div class="col-md-8 descrizione">
						<h3>T'ARREDU (Ti Arredo)</h3>
						<p>Web App che permette allâUtente di poter scegliere,
							configurare, richiedere un preventivo.</p>
						<p>Scelto il prodotto da acquistare l'utente potrà
							richiedere un preventivo o contattare il venditore per
							l'acquisto.</p>
						<p>L'utente può lasciare feedback sul singolo prodotto o sul
							venditore dopo aver effettuato l'acquisto. Il sito prevede</p>
						<p>anche una chat live per assistenza e supporto.</p>
					</div>

				</div>
				<div class="containerSezioneInferiore">
					<h2>Sviluppatori</h2>
					<hr>
					<div class="row">

						<p>Hanno creato il sito:</p>

						<div class="col-md-6 immagineComponente">
							<div class="card">
								<img class="img img-responsive" src="images/fotoFrancesco.jpg" alt="Francesco Marrara">
								<h2>Francesco Marrara</h2>
								<p class="title">Sviluppatore/Studente</p>
								<p>Università della Calabria</p>
								<div style="background-color: black; padding-top: 2%;">
									<a href="https://twitter.com/francmarrara"><i
										class="fa fa-twitter"></i></a> <a
										href="https://www.linkedin.com/in/francesco-marrara-34985253/"><i
										class="fa fa-linkedin"></i></a> <a
										href="https://www.facebook.com/francmarrara"><i
										class="fa fa-facebook"></i></a>
								</div>
								<p>
									<button>
										<a href="mailto:francmarrara@gmail.com"
											class="componentiContatti">E-mail</a>
									</button>
								</p>
								<p>
									<button>
										<a class="componentiContatti">Tel: 347 31 39 840</a>
									</button>
								</p>
							</div>
						</div>

						<div class="col-md-6 immagineComponente">
							<div class="card">
								<img class="img img-responsive" src="images/fotoSimone.jpg" alt="Simone Crisafi">
								<h2>Simone Crisafi</h2>
								<p class="title">Sviluppatore/Studente</p>
								<p>Università della Calabria</p>
								<div style="background-color: black; padding-top: 2%;">
									<a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
										class="fa fa-linkedin"></i></a> <a
										href="https://www.facebook.com/simon.cris"><i
										class="fa fa-facebook"></i></a>
								</div>
								<p>
									<button>
										<a href="mailto:xblack90@hotmail.it"
											class="componentiContatti">E-mail</a>
									</button>
								</p>
								<p>
									<button>
										<a class="componentiContatti">Tel: 347 73 53 491</a>
									</button>
								</p>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>

	<button type="button" class="btn btn-primary bottoneTornaSu">
		<a href="#top" style="color: #ffffff">Torna su...</a>
	</button>

	<!-- Footer -->
	<footer id="myFooter">
		<div class="container" style="text-align: center">
			<div class="row">
				<div class="col-sm-3 myCols"></div>
				<div class="col-sm-3 myCols">
					<h5>Contatti</h5>
					<ul id="contattiFooter">
						<li><a>Francesco Marrara</a></li>
						<li><a>francmarrara@gmail.com</a></li>
						<li><a>Tel. 347 31 39 840</a></li>
						<li><a>Simone Crisafi</a></li>
						<li><a>xblack90@hotmail.it</a></li>
						<li><a>Tel: 347 73 53 491</a></li>
					</ul>
				</div>

				<div class="col-sm-3 myCols">
					<h5>Supporto</h5>
					<ul>
						<li><a href="#">FAQ</a></li>
						<li><a href="aboutUs.html">Help desk</a></li>
					</ul>
				</div>
				<div class="col-sm-3 myCols"></div>

			</div>
		</div>
		<div class="social-networks">
			<a href="" id="tw_share" class="twitter"><i class="fa fa-twitter"></i></a>
			<a href="" id="fb_share" class="facebook"><i
				class="fa fa-facebook-official"></i></a> <a href="" id="go_share"
				class="google"><i class="fa fa-google-plus"></i></a>
		</div>
	</footer>

	<div id="snackbar"></div>

</body>

</html>