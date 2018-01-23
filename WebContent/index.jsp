<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="prodotto" class="model.ProdottoConImmagini"
	scope="session" />
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

<link rel="stylesheet" href="css/index.css">
<script src="js/Js/index.js"></script>

<link rel="shortcut icon" href="images/TarreduLogo.png">


<!-- Start WOWSlider.com HEAD section -->
<link rel="stylesheet" type="text/css" href="engine1/style.css" />
<script type="text/javascript" src="engine1/jquery.js"></script>
<!-- End WOWSlider.com HEAD section -->
</head>

<body>
	<!-- Sfondo -->
	<div id="bg">
		<img src="images/sfondoLegno.png" alt="">
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
				<li class="navbarOggetto"><a href="#">Home</a></li>
				<!-- DropMenu per catalogo prodotti -->
				<li class="dropdown navbarOggetto" id="catalogoProdotti"><a
					class="dropdown-toggle" data-toggle="dropdown" href="#">Catalogo
						Prodotti <span class="caret"></span>
				</a>
					<ul class="dropdown-menu row" id="menuProdotti">
						<li class="col-sm-3" id="listaMenu">
							<ul class="list-unstyled">
								<li>
									<h4 class="NomiCategorie">Ambienti</h4>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Cucina</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Bagno</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Soggiorno</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Studio</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Camera
										da letto</a></li>
								<li><a class="oggettiCategorie" href="prodotti.html">Salotto</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Stanza
										da pranzo</a></li>
							</ul>
						</li>
						<li class="col-sm-3" id="listaMenu">
							<ul class="list-unstyled">
								<li>
									<h4 class="NomiCategorie">Categorie</h4>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Armadi</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Cassettiere</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Comodini</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Illuminazioni</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Credenze</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Letti</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Tavoli</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Librerie</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Scrivanie</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Sedie</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Poltrone</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Divani</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Vetrine</a>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Bagni</a>
								</li>
							</ul>
						</li>
						<li class="col-sm-3" id="listaMenu">
							<ul class="list-unstyled">
								<li>
									<h4 class="NomiCategorie">Marche</h4>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Prodotti
										2</a></li>
								<li><a class="oggettiCategorie" href="prodotti.html">Prodotti
										3</a></li>
							</ul>
						</li>
						<li class="col-sm-3" id="listaMenu">
							<ul class="list-unstyled">
								<li>
									<h4 class="NomiCategorie">Marche</h4>
								</li>
								<li><a class="oggettiCategorie" href="prodotti.html">Prodotti
										2</a></li>
								<li><a class="oggettiCategorie" href="prodotti.html">Prodotti
										3</a></li>
							</ul>
						</li>
					</ul></li>
				<li class="navbarOggetto"><a href="prodotti.html">Tutti i
						Prodotti</a></li>
				<li class="navbarOggetto"><a href="aboutUs.html">About us</a></li>
				<li class="navbarOggetto"><a href="profiloUtente.html">Utente</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right menuDestra">

				<li class="navbarOggetto">
					<!-- Form per il login --> <a href="#"
					onclick="document.getElementById('login').style.display='block'">
						<span class="glyphicon glyphicon-log-in"></span> Login
				</a>

					<div id="login" class="modal  ">

						<form class="modal-content animate" action="------">
							<div class="imgcontainer">
								<span
									onclick="document.getElementById('login').style.display='none'"
									class="close" title="Chiudi Login">&times;</span> <img
									src="images/userLogin.jpg" alt="Avatar" class="avatar"
									width=150 height=150>
							</div>

							<div class="containerModal">
								<label><b>Username</b></label> <input class="inputLogIn"
									type="text" placeholder="Inserire Username" name="uname"
									required> <label><b>Password</b></label> <input
									class="inputLogIn" type="password"
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
								<span class="psw"><a href="#">Password dimenticata?</a></span>
							</div>
						</form>
					</div>
				</li>
				<li class="navbarOggetto">
					<!-- Form per la registrazione --> <a href="#"
					onclick="document.getElementById('registrazione').style.display='block'">
						<span class="glyphicon glyphicon-user user"></span> Registrati
				</a>

					<div id="registrazione" class="modal">

						<form class="modal-content animateReg" action="------">
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
								<input type="text" placeholder="Inserire Cognome" name="cognome"
									required> <label><b>Email</b></label> <input
									type="text" placeholder="Inserire Indirizzo Email" name="email"
									required> <label><b>Password</b></label> <input
									type="password" placeholder="Inserire Password" name="psw"
									required> <label><b>Ripetere Password</b></label> <input
									type="password" placeholder="Reinserire Password"
									name="psw-repeat" required>


							</div>
							<div class="containerRegistrazione">
								<label>Ricordami <input type="checkbox"
									checked="checked" style="margin-bottom: 15px">
								</label>
							</div>


							<div class="containerRegButton" style="background-color: #ffffff">
								<button type="button"
									onclick="document.getElementById('registrazione').style.display='none'"
									class="cancelbtnReg">Cancel</button>
								<button class="buttonReg" type="submit">Registrati</button>
							</div>
						</form>
					</div>

				</li>
				<li class="carrello navbarOggetto"><a href="carrello.html"><span
						class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>
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
					<li><img src="data1/images/arke.jpg" alt="Arke" title="Arke"
						id="wows1_0" /></li>
					<li><img src="data1/images/fina.jpg" alt="Fina" title="Fina"
						id="wows1_1" /></li>
					<li><img src="data1/images/medolla.jpg" alt="Medolla"
						title="Medolla" id="wows1_2" /></li>
					<li><img src="data1/images/bastiglia.jpg" alt="Bastiglia"
						title="Bastiglia" id="wows1_3" /></li>
					<li><a href="http://wowslider.net"><img
							src="data1/images/rivo.jpg" alt="javascript image slider"
							title="Rivo" id="wows1_4" /></a></li>
					<li><img src="data1/images/terra.jpg" alt="Terra"
						title="Terra" id="wows1_5" /></li>
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
						<img class="immagineProdottoInOfferta"
							src="images/productImages/Ardiano_01.jpg" alt="Divano Ardiano">
						<div class="containerTitoloETesto">
							<div class="titoloArticoloInOfferta">
								<h4>${prodotto.nomeProdotto}</h4>
								<p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur.
									Sea te minim soleat senserit, ex quo luptatum tacimates
									voluptatum.</p>
							</div>
						</div>
						<div class="containerPrezzoEData">
							<p>
								Prezzo: <span class="prezzo">${prodotto.prezzoProdotto}</span>
							</p>
							<button type="button"
								class="btn btn-default bottoneProdottoInOfferta">
								<a href="prodotto.html"></span> Mostra</a>
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
						<img class="immagineProdottoInOfferta"
							src="images/productImages/Ardiano_01.jpg" alt="Divano Ardiano">
						<div class="containerTitoloETesto">
							<div class="titoloArticoloInOfferta">
								<h4>${prodotto.nomeProdotto}</h4>
								<p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur.
									Sea te minim soleat senserit, ex quo luptatum tacimates
									voluptatum.</p>
							</div>
						</div>
						<div class="containerPrezzoEData">
							<p>
								Prezzo: <span class="prezzo">${prodotto.prezzoProdotto}</span>
							</p>
							<button type="button"
								class="btn btn-default bottoneProdottoInOfferta">
								<a href="prodotto.html"></span> Mostra</a>
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
						<img class="immagineProdottoPiuVisto"
							src="images/productImages/Ardiano_01.jpg" alt="Divano Ardiano">
						<div class="containerTitoloETesto">
							<div class="titoloArticoloPiuVisto">
								<h4>${prodotto.nomeProdotto }</h4>
							</div>
						</div>
						<button type="button"
							class="btn btn-default bottoneProdottoPiuVisto">
							<a href="prodotto.html"></span> Mostra</a>
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
						<img class="immagineProdottoPiuVisto"
							src="images/productImages/Ardiano_01.jpg" alt="Divano Ardiano">
						<div class="containerTitoloETesto">
							<div class="titoloArticoloPiuVisto">
								<h4>${prodotto.nomeProdotto }</h4>
							</div>
						</div>
						<button type="button"
							class="btn btn-default bottoneProdottoPiuVisto">
							<a href="prodotto.html" onclick="alert(${prodotto.idProdotto})"></span> Mostra</a>
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
		<div class="container">
			<div class="row">
				<div class="col-sm-3 myCols">
					<h5>Ambienti</h5>
					<ul>
						<li><a href="prodotti.html">Cucina</a></li>
						<li><a href="prodotti.html">Bagno</a></li>
						<li><a href="prodotti.html">Soggiorno</a></li>
						<li><a href="prodotti.html">Studio</a></li>
						<li><a href="prodotti.html">Camera da Letto</a></li>
						<li><a href="prodotti.html">Salotto</a></li>
						<li><a href="prodotti.html">Sala da Pranzo</a></li>
					</ul>
				</div>
				<div class="col-sm-3 myCols">
					<h5>Marche</h5>
					<ul>
						<li><a href="prodotti.html">Marca 1</a></li>
						<li><a href="prodotti.html">Marca 2</a></li>
						<li><a href="prodotti.html">Marca 3</a></li>
						<li><a href="prodotti.html">Marca 4</a></li>
					</ul>
				</div>
				<div class="col-sm-3 myCols">
					<h5>Supporto</h5>
					<ul>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Help desk</a></li>
					</ul>
				</div>
				<div class="col-sm-3 myCols">
					<h5>Contatti</h5>
					<ul id="contattiFooter">
						<li><a href="#">Francesco Marrara</a></li>
						<li><a href="#">francmarrara@gmail.com</a></li>
						<li><a href="#">Tel. 347 31 39 840</a></li>
						<li><a href="#">Simone Crisafi</a></li>
						<li><a href="#">xblack90@hotmail.it</a></li>
						<li><a href="#">Tel: 347 73 53 491</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="social-networks">
			<a href="www.twitter.com" class="twitter"><i
				class="fa fa-twitter"></i></a> <a
				href="http://www.facebook.com/sharer.php?u=index.jsp"
				class="facebook"><i class="fa fa-facebook-official"></i></a> <a
				href="www.googleplus.com" class="google"><i
				class="fa fa-google-plus"></i></a>
		</div>
	</footer>
</body>

</html>