<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="commentoProdotto" class="model.Commento"
	scope="session" />

<html lang="it">

<head>
<title>${prodottoCercato.nomeProdotto}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/Footer-with-social-icons.css">
<link rel="stylesheet" href="css/prodotto.css">
<link rel="stylesheet" href="css/snackbar.css">

<script src="js/Js/prodotto.js"></script>
<script src="js/Js/login.js"></script>


<link rel="shortcut icon" href="images/TarreduLogo.png">

<!-- Start WOWSlider.com HEAD section -->
<link rel="stylesheet" type="text/css" href="engine1/style.css" />
<script type="text/javascript" src="engine1/jquery.js"></script>
<!-- End WOWSlider.com HEAD section -->

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
				<li class="navbarOggetto"><a href="aboutUs.jsp">About us</a></li>
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

	<!-- Bottone laterale a scomparsa -->
	<div id="mySidenav" class="sidenav">
		<a href="#top" id="backToTopMenu">Torna su</a>
	</div>

	<div class="container mioSlider" style="background-color: aliceblue">
		<div class="row" id="">
			<div class="col-md-7 single-top-left">
				<h2 class="product_name">${prodottoCercato.nomeProdotto}</h2>
				<p class="separatore"></p>
				<div id="myCarousel" class="carousel slide" data-ride="carousel">

					<!-- Indicicatori inferiori -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>

						<c:if test="${dimensioneListaImmagini} > 1">
							<c:forEach var="immagineProdotto"
								items="${listaImmaginiProdotto}" varStatus="loop" begin="1"
								end="${dimensioneListaImmagini}" step="1">

								<li data-target="#myCarousel" data-slide-to="${loop.index}"></li>
							</c:forEach>
						</c:if>


					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">

						<div class="item active">
							<img src="${listaImmaginiProdotto[0]}"
								alt="${prodotto.nomeProdotto}">
							<div class="carousel-caption"></div>
						</div>

						<c:forEach var="immagineProdotto" items="${listaImmaginiProdotto}"
							begin="1" end="${dimensioneListaImmagini}" step="1">

							<div class="item">
								<img src="${immagineProdotto}" alt="${prodotto.nomeProdotto}'">
								<div class="carousel-caption"></div>
							</div>

						</c:forEach>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>


			<!-- Div a destra con marca e pulsanti-->

			<div class="col-md-5 single-top-right descrizione">
				<div class="marca_prodotto">${prodottoCercato.marcaProdotto}</div>
				<div class="tipo_prodotto">${prodottoCercato.tipoProdotto}</div>
				<div class="ambiente_prodotto">${prodottoCercato.ambienteProdotto}</div>


				<hr>
				<hr>
				<div class="prezzo_prodotto">Prezzo Consigliato :
					${prodottoCercato.prezzoProdotto}</div>

				<c:if test="${utenteLoggato == true}">
					<div class="btn-group button_carrello">
						<button type="button" class="btn btn-success"
							title="Aggiungi questo prodotto al tuo carrello"
							onclick="aggiungiNelCarrello('${prodottoCercato.idProdotto}','${emailUtenteLoggato}')">
							Aggiungi al carrello</button>
					</div>
					<div class="btn-group button_favoriti">
						<button type="button" class="btn btn-danger"
							title="Aggiungi ai favoriti"
							onclick="aggiungiPreferito('${prodottoCercato.idProdotto}','${emailUtenteLoggato}')">Aggiungi
							ai favoriti</button>
					</div>
				</c:if>

				<!-- AGGIUNGERE SNACKBAR PER BOTTONI QUANDO NON SEI LOGGATO -->
				<c:if test="${utenteLoggato == false}">
					<div class="btn-group button_carrello">
						<button type="button" class="btn btn-success"
							title="Aggiungi questo prodotto al tuo carrello"
							onclick="chiediLogin()">Aggiungi al carrello</button>
					</div>
					<div class="btn-group button_favoriti">
						<button type="button" class="btn btn-danger"
							title="Aggiungi ai favoriti" onclick="chiediLogin()">Aggiungi
							ai favoriti</button>
					</div>
				</c:if>

			</div>
			<!--Fine  Div a destra con marca e pulsanti-->


		</div>
	</div>

	<div class="container menu_basso" style="background-color: aliceblue">
		<div class="col-md-9 single-top-left ">
			<ul class="nav nav-tabs menu_down">
				<li class="active"><a data-toggle="tab" href="#descrizione">Descrizione</a></li>
				<li><a data-toggle="tab" href="#misure">Misure</a></li>
				<li><a data-toggle="tab" href="#colori">Colori Disponibili</a></li>
				<li><a data-toggle="tab" href="#venditori">Venditori</a></li>
				<li><a data-toggle="tab" href="#recensioni">Recensioni</a></li>
				<li><a data-toggle="tab" href="#aggiungiRecensione">Aggiungi
						una recensione!</a></li>



			</ul>

			<div class="tab-content">
				<div id="descrizione" class="tab-pane fade in active">
					<h3>Descrizione</h3>
					<p class="descrizione_bassa">${prodottoCercato.descrizioneProdotto}.</p>
				</div>
				<div id="misure" class="tab-pane fade">
					<h3>Misure</h3>
					<p class="descrizione_bassa">Misure:
						${prodottoCercato.misureProdotto}</p>
				</div>
				<div id="colori" class="tab-pane fade">
					<h3>Colori</h3>
					<p class="descrizione_bassa">${prodottoCercato.coloriProdotto}</p>
				</div>
				<div id="venditori" class="tab-pane fade">
					<h3>Puoi Trovarlo Qui</h3>
					<ul class="lista_venditori">
						<c:forEach var="venditore" items="${listaVenditoriProdotto}">

							<li><a href="venditore?id=${venditore.emailVenditore}">${venditore.nomeNegozio}</a></li>

						</c:forEach>
					</ul>
				</div>

				<div id="recensioni" class="tab-pane fade">
					<h3>Recensioni</h3>
					<ul class="recensioni">


						<c:forEach var="commentoProdotto" items="${listaCommentiProdotto}">

							<li>
								<p>${commentoProdotto.commento}->Utente:
									${commentoProdotto.nomeUtente}</p>
							</li>

						</c:forEach>

					</ul>
				</div>
				<div id="aggiungiRecensione" class="tab-pane fade">
					<h3>Inserire Recensione</h3>

					<c:if test="${utenteLoggato == true}">

						<c:choose>
							<c:when test="${empty commentoPresente}">

								<div class="containerFormRecensione">
									<form>
										<label for="fname">Nome</label> <input type="text" id="fname"
											name="firstname" value="${nomeUtente}" readonly> <label
											for="lname">Cognome</label> <input type="text" id="lname"
											name="lastname" value="${cognomeUtente}" readonly> <br>
										<div class="containerCheckbox">
											<p>
												<strong>Inserire una valutazione del prodotto (da 1
													a 5)</strong>
											</p>
											<label class="containerLabel">1/5<input
												type="checkbox" checked="checked" name="radio"
												class="messageCheckbox" value="1">
												
											</label> <label class="containerLabel">2/5 <input
												type="checkbox" name="radio" class="messageCheckbox"
												value="2">

											</label> <label class="containerLabel">3/5 <input
												type="checkbox" name="radio" class="messageCheckbox"
												value="3">

											</label> <label class="containerLabel">4/5 <input
												type="checkbox" name="radio" class="messageCheckbox"
												value="4">

											</label> <label class="containerLabel">5/5 <input
												type="checkbox" name="radio" class="messageCheckbox"
												value="5">

											</label>
										</div>

										<hr>
										<label>Recensione</label> <br>
										<textarea id="subject" name="subject"
											placeholder="Scrivi la recensione.."
											style="height: 50%; width: 100%;"></textarea>
										<br> <br>

										<button type="button" class="btn btn-danger inviaRecensione"
											title="nvia recensione"
											onclick="registraCommentoProdotto('${prodottoCercato.idProdotto}','${emailUtenteLoggato}')">Salva
											commento</button>


									</form>
								</div>

							</c:when>
							<c:otherwise>
								<li>${commentoPresente.commento}->Utente:
									${commentoPresente.nomeUtente} -> Prodotto:
									${commentoPresente.idProdotto}</li>
							</c:otherwise>
						</c:choose>
					</c:if>

					<c:if test="${utenteLoggato == false}">

						<p>
							<strong>Registrarsi per poter rilasciare una recensione.</strong>
						</p>

					</c:if>

				</div>
			</div>

		</div>

	</div>


	<br>


	<button type="button" class="btn btn-primary bottoneTornaSu">
		<a href="#top" style="color: #ffffff">Torna su...</a>
	</button>

	<div class="content"></div>
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
			<a href="#" class="twitter"><i class="fa fa-twitter"></i></a> <a
				href="#" class="facebook"><i class="fa fa-facebook-official"></i></a>
			<a href="#" class="google"><i class="fa fa-google-plus"></i></a>
		</div>
	</footer>
	<div id="snackbar"></div>
</body>

</html>