<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<html lang="it">

<head>
<title>T-arredu HomePage</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">


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
	_smartsupp.key = '21b19ab74e96a08f193732a37ad89bc04bed9b7d';
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
				+ '&hashtags=#tarredu,#unical,#siw,#grasso,#reale';

		go_share.href = 'https://plus.google.com/share?text=vieni a trovarci su Tarredu arredamenti&u='
				+ encodeURIComponent(location.href);
	}
</script>

<link rel="stylesheet" href="css/snackbar.css">
<link rel="stylesheet" href="css/index.css">
<script src="js/Js/lateralButtons.js"></script>
<script src="js/Js/login.js"></script>
<script src="js/Js/snackbar.js"></script>
<link rel="shortcut icon" href="images/TarreduLogo.png">

</head>

<body>
	<!-- Sfondo -->

	<img class="img img-responsive" src="images/sfondoLegno.png" id="bg">

	<c:if test="${passwordCorretta == false}">
		<script type=text/javascript>
			$(document).ready(function() {

				$("#snackbar").css({
					'background-color' : 'red'
				});
				$("#snackbar").text("PASSWORD O INDIRIZZO ERRATO");
				showSnackbar();
			});
		</script>
	</c:if>

	<!-- Header -->
	<header class="container-fluid headerImage row" name="top">
		<div class="headerContainer col-md-12" style="text-align: center;">
			<img class="img img-responsive" src="images/headerImage.png"
				alt="headerImage" width="100%" height="100%">
		</div>
	</header>

	<div class="row">

		<!-- Menu di navigazione principale -->
		<nav class="navbar navbar-inverse col-md-12" style="width: 100%;">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li class="navbarOggetto"><img id="logoButton"
						src="images/TarreduLogo.png" width="50" height="50"></li>
					<li class="navbarOggetto"><a href="index.jsp">Home</a></li>

					<li class="navbarOggetto"><a href="prodotti">Catalogo
							Prodotti</a></li>

					<li class="navbarOggetto"><a href="aboutUs.jsp">About us</a></li>
					<li class="dropdown navbarOggetto"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Venditori </a>
						<ul class="dropdown-menu">
							<c:forEach var="venditore" items="${listaVenditori}">

								<li><a class="nomeNegozio"
									href="venditore?id=${venditore.emailVenditore}"
									style="color: red;">${venditore.nomeNegozio}</a></li>

							</c:forEach>

						</ul></li>

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

					<c:if
						test="${utenteLoggato == false || empty utenteLoggato}">

						<li class="navbarOggetto">
							<!-- Form per il login --> <a href="#loginVenditore"
							onclick="document.getElementById('loginVenditore').style.display='block'">
								<span class="glyphicon glyphicon-log-in"></span> Login
								Venditore
						</a>
						</li>

						<li class="navbarOggetto">
							<!-- Form per il login --> <a href="#login"
							onclick="document.getElementById('login').style.display='block'">
								<span class="glyphicon glyphicon-log-in"></span> Login Utente
						</a>
						</li>
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

								</div>

								<div class="containerModalBottom"
									style="background-color: #ffffff">
									<button type="button"
										onclick="document.getElementById('login').style.display='none'"
										class="cancelbtn">Cancel</button>
								</div>
							</form>
						</div>

						<div id="loginVenditore" class="modal">

							<form class="modal-content animate" method="post"
								action="validaCredenzialiVenditoreLogin">
								<div class="imgcontainer">
									<span
										onclick="document.getElementById('loginVenditore').style.display='none'"
										class="close" title="Chiudi Login">&times;</span> <img
										src="images/userLogin.jpg" alt="Avatar" class="avatar"
										width=150 height=150>
								</div>

								<div class="containerModal">
									<label><b>Email Venditore</b></label> <input
										class="inputLogIn EmailUtenteLogin" type="text"
										placeholder="Inserire Indirizzo Email" name="emailVenditore"
										required> <label><b>Password</b></label> <input
										class="inputLogIn passwordLogin" type="password"
										placeholder="Inserire Password" name="passwordVenditore"
										required>

									<button class="buttonLog" type="submit">Login</button>

								</div>

								<div class="containerModalBottom"
									style="background-color: #ffffff">
									<button type="button"
										onclick="document.getElementById('loginVenditore').style.display='none'"
										class="cancelbtn">Cancel</button>
								</div>
							</form>
						</div>

						<li class="navbarOggetto">
							<!-- Form per la registrazione --> <a
							href="#registrazioneVenditore"
							onclick="document.getElementById('registrazioneVenditore').style.display='block'">
								<span class="glyphicon glyphicon-user user"></span> SignUp Venditore
						</a>
						</li>

						<li class="navbarOggetto">
							<!-- Form per la registrazione --> <a href="#registrazione"
							onclick="document.getElementById('registrazione').style.display='block'">
								<span class="glyphicon glyphicon-user user"></span> SignUp Utente
						</a>
						</li>

						<div id="registrazioneVenditore" class="modal">

							<form class="modal-content animateReg" method="post"
								action="registrazioneVenditore">
								<div class="imgcontainerReg">
									<span
										onclick="document.getElementById('registrazioneVenditore').style.display='none'"
										class="closeReg" title="Chiudi Registrazione">&times;</span>
								</div>
								<h1>Registrazione</h1>
								<p>Compila questo modulo per creare un account.</p>
								<hr>
								<div class="containerReg">

									<label><b>Nome</b></label> <input type="text"
										placeholder="Inserire Nome" name="nomeVenditore" required>
									<label><b>Cognome</b></label> <input type="text"
										placeholder="Inserire Cognome" name="cognomeVenditore"
										required> <label><b>Nome Negozio</b></label> <input
										type="text" placeholder="Inserire Nome Negozio"
										name="nomeNegozio" required><label><b>Numero
											di Telefono</b></label> <input type="text"
										placeholder="Inserire Numero di Telefono"
										name="numeroDiTelefonoVenditore" required> <label><b>Indirizzo
											Negozio</b></label> <input type="text"
										placeholder="Inserire Indirizzo Negozio"
										name="indirizzoVenditore" required> <label><b>Descrizione
											Venditore</b></label>
									<div style="margin-bottom: 1.5%;">
										<textarea name="descrizioneVenditore" class="form-control"
											rows="5"></textarea>
									</div>
									<label><b>Email</b></label> <input id="emailVenditore"
										type="text" placeholder="Inserire Indirizzo Email"
										name="emailVenditore" required> <label><b>Password</b></label>
									<input id="psw" type="password" placeholder="Inserire Password"
										name="pswVenditore" required> <label><b>Ripetere
											Password</b></label> <input id="psw-repeat" type="password"
										placeholder="Reinserire Password" name="psw-repeat-Venditore"
										required>
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
						<li class="carrello navbarOggetto"><a onclick="chiediLogin()"
							style="cursor: pointer"><span
								class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>
					</c:if>


				</ul>
			</div>
		</nav>
	</div>

	<!-- Bottone laterale a scomparsa -->
	<div id="mySidenav" class="sidenav">
		<a href="#top" id="backToTopMenu">Torna Su</a> <a
			href="javascript:history.back()" id="backToPage">Torna Indietro</a>
	</div>


	<!-- Slider centrale -->

	<div class="container" style="">
		<div class="row">
			<div class="jumbotron col-md-12">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
						<li data-target="#myCarousel" data-slide-to="4"></li>
						<li data-target="#myCarousel" data-slide-to="5"></li>

					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" style="width: 100%; height: 100%">



						<div class="item">
							<a href="prodotto?id=85"> <img class="img img-responsive"
								src="images/productImages/Rivo_01.jpg" alt="Rivo"
								style="height: 100%; width: 100%;">
							</a>
							<div class="carousel-caption">
								<h3 class="nomeProdottoCarousel">Rivo</h3>
							</div>
						</div>

						<div class="item active">
							<a href="prodotto?id=56"> <img class="img img-responsive"
								src="images/productImages/Artika_01.jpg" alt="Artika"
								style="height: 100%; width: 100%;">
							</a>
							<div class="carousel-caption">
								<h3 class="nomeProdottoCarousel">Artika</h3>
							</div>
						</div>

						<div class="item">
							<a href="prodotto?id=53"> <img class="img img-responsive"
								src="images/productImages/Sax_01.jpg" alt="Sax"
								style="height: 100%; width: 100%;">
							</a>
							<div class="carousel-caption">
								<h3 class="nomeProdottoCarousel">Sax</h3>
							</div>
						</div>

						<div class="item">
							<a href="prodotto?id=50"> <img class="img img-responsive"
								src="images/productImages/iCiliegi_02.jpg" alt="ICiliegi"
								style="height: 100%; width: 100%;">
							</a>
							<div class="carousel-caption">
								<h3 class="nomeProdottoCarousel">Ciliegi</h3>
							</div>
						</div>

						<div class="item">
							<a href="prodotto?id=12"> <img class="img img-responsive"
								src="images/productImages/Fina_01.jpg" alt="Fina"
								style="height: 100%; width: 100%;">
							</a>
							<div class="carousel-caption">
								<h3 class="nomeProdottoCarousel">Fina</h3>
							</div>
						</div>


					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Precedente</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Successiva</span>
					</a>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>



	<!-- Area prodotti home -->

	<!-- Prodotti in offerta -->

	<h2 class="nomiSezioniProdotti">Prodotti in offerta</h2>
	<hr>
	<div class="container inOfferta">
		<div class="row prodottiInOfferta">

			<c:forEach var="prodotto" items="${prodottiInOfferta}" begin="0"
				end="2" step="1">

				<div class="col-sm-4">
					<div class="coupon">
						<div class="containerLogo">
							<h4 class="nomeProdottoOfferta">${prodotto.marcaProdotto}</h4>
						</div>
						<div class="containerImmagine img img-responsive"
							style="text-align: center;">
							<a href="prodotto?id=${prodotto.idProdotto}"><img
								class="immagineProdottoInOfferta img img-responsive"
								src="${prodotto.immaginePrincipale}" alt="Divano Ardiano"></a>
						</div>
						<div class="containerTitoloETestoOfferta">
							<div class="titoloArticoloInOfferta">
								<h4 class="nomeProdottoOfferta">${prodotto.nomeProdotto}</h4>
								<p>${prodotto.descrizioneProdotto}</p>
							</div>
						</div>
						<div class="containerPrezzoEData">
							<p>
								Prezzo: <span class="prezzo">${prodotto.prezzoProdotto}0
									€</span>
							</p>
							<button type="button"
								class="btn btn-default bottoneProdottoInOfferta">
								<a href="prodotto?id=${prodotto.idProdotto}"></span> Mostra</a>
							</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<br> <br>
		<div class="row prodottiInOfferta">

			<c:forEach var="prodotto" items="${prodottiInOfferta}" begin="3"
				end="5" step="1">

				<div class="col-sm-4">
					<div class="coupon">
						<div class="containerLogo">
							<h4 class="nomeProdottoOfferta">${prodotto.marcaProdotto}</h4>
						</div>
						<a href="prodotto?id=${prodotto.idProdotto}"><img
							class="immagineProdottoInOfferta img img-responsive"
							src="${prodotto.immaginePrincipale}" alt="Divano Ardiano"></a>
						<div class="containerTitoloETestoOfferta">
							<div class="titoloArticoloInOfferta">
								<h4 class="nomeProdottoOfferta">${prodotto.nomeProdotto}</h4>
								<p>${prodotto.descrizioneProdotto}.</p>
							</div>
						</div>
						<div class="containerPrezzoEData">
							<p>
								Prezzo: <span class="prezzo">${prodotto.prezzoProdotto}0
									€</span>
							</p>
							<button type="button"
								class="btn btn-default bottoneProdottoInOfferta">
								<a href="prodotto?id=${prodotto.idProdotto}"></span> Mostra</a>
							</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<br> <br>

	</div>

	<!-- Prodotti piu visti -->
	<h2 class="nomiSezioniProdotti">Piu' visti</h2>
	<hr>
	<div class="container piuVisti">

		<div class="row prodottiPiuVisti">

			<c:forEach var="prodotto" items="${prodottiPiuVisti}" begin="0"
				end="2" step="1">

				<div class="col-sm-4">
					<div class="couponPiuVisto">
						<a href="prodotto?id=${prodotto.idProdotto}"><img
							class="immagineProdottoPiuVisto img img-responsive"
							src="${prodotto.immaginePrincipale}" alt="Divano Ardiano"></a>
						<div class="containerTitoloETesto">
							<div class="titoloArticoloPiuVisto">
								<h4>${prodotto.nomeProdotto }</h4>
							</div>
						</div>
						<button type="button"
							class="btn btn-default bottoneProdottoPiuVisto">
							<a href="prodotto?id=${prodotto.idProdotto}"></span> Mostra</a>
						</button>

					</div>
				</div>

			</c:forEach>
		</div>

		<div class="row prodottiPiuVisti">

			<c:forEach var="prodotto" items="${prodottiPiuVisti}" begin="3"
				end="5" step="1">

				<div class="col-sm-4">
					<div class="couponPiuVisto">
						<a href="prodotto?id=${prodotto.idProdotto}"><img
							class="immagineProdottoPiuVisto img img-responsive"
							src="${prodotto.immaginePrincipale}" alt="Divano Ardiano"></a>
						<div class="containerTitoloETesto">
							<div class="titoloArticoloPiuVisto">
								<h4>${prodotto.nomeProdotto }</h4>
							</div>
						</div>
						<button type="button"
							class="btn btn-default bottoneProdottoPiuVisto">
							<a href="prodotto?id=${prodotto.idProdotto}"></span> Mostra</a>
						</button>

					</div>
				</div>

			</c:forEach>
		</div>

	</div>

	<br>
	<br>

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
						<li><a href="aboutUs.jsp">Help desk</a></li>
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