<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<html lang="it">

<head>
<title>T-arredu HomePage</title>
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
<script type="text/javascript" src="js/slick.min.js"></script>

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
				+ '&hashtags=#tarredu,#unical,#ingsw,#ricca';

		go_share.href = 'https://plus.google.com/share?text=vieni a trovarci su Tarredu arredamenti&u='
				+ encodeURIComponent(location.href);
	}
</script>

<link rel="stylesheet" href="css/snackbar.css">
<link rel="stylesheet" href="css/index.css">
<script src="js/Js/index.js"></script>
<script src="js/Js/login.js"></script>

<link rel="shortcut icon" href="images/TarreduLogo.png">


<!-- Start WOWSlider.com HEAD section -->
<link rel="stylesheet" type="text/css" href="engine1/style.css" />
<script type="text/javascript" src="engine1/jquery.js"></script>
<!-- End WOWSlider.com HEAD section -->
</head>

<body>

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

				<li class="navbarOggetto"><a href="aboutUs.jsp">About us</a></li>
				<li class="dropdown navbarOggetto"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Venditori </a>
					<ul class="dropdown-menu">
						<c:forEach var="venditore" items="${listaVenditori}">

							<li><a class="nomeNegozio" href="venditore?id=${venditore.emailVenditore}" style="color: red;">${venditore.nomeNegozio}</a>
							</li>

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

				<c:if test="${utenteLoggato == false  || empty utenteLoggato}">

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

	<!-- Bottone laterale a scomparsa -->
	<div id="mySidenav" class="sidenav">
		<a href="#top" id="backToTopMenu">Torna su</a>
	</div>

	<!-- Slider centrale -->
	<div class="jumbotron">
		<!-- Start SLIDER section -->
		<div id="wowslider-container1">
			<div class="ws_images">
				<ul>
					<li><img class="img img-responsive"
						src="data1/images/arke.jpg" alt="Arke" title="Arke" id="wows1_0" /></li>
					<li><img class="img img-responsive"
						src="data1/images/fina.jpg" alt="Fina" title="Fina" id="wows1_1" /></li>
					<li><img class="img img-responsive"
						src="data1/images/medolla.jpg" alt="Medolla" title="Medolla"
						id="wows1_2" /></li>
					<li><img class="img img-responsive"
						src="data1/images/bastiglia.jpg" alt="Bastiglia" title="Bastiglia"
						id="wows1_3" /></li>
					<li><a href="http://wowslider.net"><img
							src="data1/images/rivo.jpg" alt="javascript image slider"
							title="Rivo" id="wows1_4" /></a></li>
					<li><img class="img img-responsive"
						src="data1/images/terra.jpg" alt="Terra" title="Terra"
						id="wows1_5" /></li>
				</ul>
			</div>
			<div class="ws_bullets">
				<div>
					<a href="prodotto.html" title="Arke"><span><img
							src="data1/tooltips/arke.jpg" alt="Arke" />1</span></a> <a
						href="prodotto.html" title="Fina"><span><img
							src="data1/tooltips/fina.jpg" alt="Fina" />2</span></a> <a
						href="prodotto.html" title="Medolla"><span><img
							src="data1/tooltips/medolla.jpg" alt="Medolla" />3</span></a> <a
						href="prodotto.html" title="Bastiglia"><span><img
							src="data1/tooltips/bastiglia.jpg" alt="Bastiglia" />4</span></a> <a
						href="prodotto.html" title="Rivo"><span><img
							src="data1/tooltips/rivo.jpg" alt="Rivo" />5</span></a> <a
						href="prodotto.html" title="Terra"><span><img
							src="data1/tooltips/terra.jpg" alt="Terra" />6</span></a>
				</div>
			</div>
			<div class="ws_shadow"></div>

			<script type="text/javascript" src="engine1/wowslider.js"></script>
			<script type="text/javascript" src="engine1/script.js"></script>
		</div>

		<!-- End SLIDER section -->
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
							<h4>${prodotto.marcaProdotto}</h4>
						</div>
						<div class="containerImmagine" style="text-align: center;">
							<a href="prodotto?id=${prodotto.idProdotto}"><img
								class="immagineProdottoInOfferta img img-responsive"
								src="${prodotto.immaginePrincipale}" alt="Divano Ardiano"></a>
						</div>
						<div class="containerTitoloETestoOfferta">
							<div class="titoloArticoloInOfferta">
								<h4>${prodotto.nomeProdotto}</h4>
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
							<h4>${prodotto.marcaProdotto}</h4>
						</div>
						<a href="prodotto?id=${prodotto.idProdotto}"><img
							class="immagineProdottoInOfferta img img-responsive"
							src="${prodotto.immaginePrincipale}" alt="Divano Ardiano"></a>
						<div class="containerTitoloETestoOfferta">
							<div class="titoloArticoloInOfferta">
								<h4>${prodotto.nomeProdotto}</h4>
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
							class="immagineProdottoPiuVisto"
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
							class="immagineProdottoPiuVisto"
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