<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Account Page</title>
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
<link rel="stylesheet" type="text/css" href="css/profiloUtente.css" />
<link rel="stylesheet" type="text/css" href="css/snackbar.css" />
<script src="js/Js/profiloUtente.js"></script>

<link rel="shortcut icon" href="images/TarreduLogo.png">
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
						<!-- Form per il login --> <a href="#"
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
									<span class="psw"><a href="#">Password dimenticata?</a></span>
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

	<!-- Container con Dati personali, preventivi, preferiti e modififa dati personali -->
	<div class="container"
		style="padding-top: 10%; background-color: white; height: auto; width: 95.3%;">
		<h2>Il mio account</h2>

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Dati
					personali</a></li>
			<li><a data-toggle="tab" href="#menu1">Prodotti Preferiti</a></li>
			<li><a data-toggle="tab" href="#menu2">Storico Preventivi</a></li>
			<li><a data-toggle="tab" href="#menu3">Modifica dati
					personali</a></li>
			<li><a data-toggle="tab" href="#menu4">Modifica Password</a></li>
		</ul>

		<div class="tab-content">
			<!-- Dati personali utente -->
			<div id="home" class="tab-pane fade in active">
				<h3>
					Dati personali <span class="glyphicon glyphicon-user"></span>
				</h3>
				<hr>
				<div class="containerCredenziali">
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Nome</div>
								<div class="panel-body">${utente.nomeUtente}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Cognome</div>
								<div class="panel-body">${utente.cognomeUtente}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Email</div>
								<div class="panel-body">${utente.emailUtente}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Password</div>
								<div class="panel-body" id="passwordPerVerifica">${utente.passwordUtente}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Data di nascita</div>
								<div class="panel-body">${utente.datadiNascita}</div>
							</div>
						</div>
					</div>
					<div class="row credenziali">
						<div class="col-sm-8 rigaCredenziali">
							<div class="panel panel-info">
								<div class="panel-heading">Recapito telefonico</div>
								<div class="panel-body">${utente.numeroTelefonoUtente}</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- Prodotti preferiti utente -->
			<div id="menu1" class="tab-pane fade">
				<div class="containerPreferiti">
					<h3>
						Preferiti <span class="glyphicon glyphicon-star-empty"></span>
					</h3>
					<hr>
					<!--Inizio Box Prodotti -->

					<div class="container ">
						<div class="grid ">
							<div class="grid-item ">
								<img class="img img_grid"
									src="images/productImages/Ardiano_01.jpg" alt="Divano Ardiano">
								<div>
									<div>
										<h4 class="titolo_prodotto">Ardiano</h4>
										<div class="testo_prodotto">
											<p>Braccioli e schienali hanno la stessa altezza in
												questo sofÃ  essenziale, con un'immagine giovane ed
												informale, che appare rigoroso ma equilibrato nelle sue
												linee a pozzetto.</p>
										</div>
										<button type=" button " class="btn btn-default">
											<a href="prodotto.html">Vai</a>
										</button>
									</div>
								</div>
							</div>
							<div class="grid-item ">
								<img class="img img_grid "
									src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">
								<div>
									<div>
										<h4 class="titolo_prodotto ">TITOLO 1</h4>
										<div class="testo_prodotto ">
											<p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur.
												Sea te minim soleat senserit, ex quo luptatum tacimates
												voluptatum.</p>
										</div>
										<button type=" button " class="btn btn-default">
											<a href="prodotto.html">Vai</a>
										</button>
									</div>
								</div>
							</div>
							<div class="grid-item ">
								<img class="img img_grid "
									src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">
								<div>
									<div>
										<h4 class="titolo_prodotto ">TITOLO 1</h4>
										<div class="testo_prodotto ">
											<p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur.
												Sea te minim soleat senserit, ex quo luptatum tacimates
												voluptatum.</p>
										</div>
										<button type=" button " class="btn btn-default">
											<a href="prodotto.html">Vai</a>
										</button>
									</div>
								</div>
							</div>
							<div class="grid-item ">
								<img class="img img_grid "
									src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">
								<div>
									<div>
										<h4 class="titolo_prodotto ">TITOLO 1</h4>
										<div class="testo_prodotto ">
											<p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur.
												Sea te minim soleat senserit, ex quo luptatum tacimates
												voluptatum.</p>
										</div>
										<button type=" button " class="btn btn-default">
											<a href="prodotto.html">Vai</a>
										</button>
									</div>
								</div>
							</div>
							<div class="grid-item ">
								<img class="img img_grid"
									src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">

								<div>
									<div>
										<h4 class="titolo_prodotto ">TITOLO 1</h4>
										<div class="testo_prodotto ">
											<p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur.
												Sea te minim soleat senserit, ex quo luptatum tacimates
												voluptatum.</p>
										</div>
										<button type=" button " class="btn btn-default">
											<a href="prodotto.html">Vai</a>
										</button>
									</div>
								</div>
							</div>
							<div class="grid-item ">
								<img class="img  img_grid "
									src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">
								<div>
									<div>
										<h4 class="titolo_prodotto ">TITOLO 1</h4>
										<div class="testo_prodotto ">
											<p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur.
												Sea te minim soleat senserit, ex quo luptatum tacimates
												voluptatum.</p>
										</div>
										<button type=" button " class="btn btn-default">
											<a href="prodotto.html">Vai</a>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>



					<div class="text-center">
						<ul class="pagination ">
							<li class="page-item "><a class="page-link " href="# ">Previous</a></li>
							<li class="page-item "><a class="page-link " href="# ">1</a></li>
							<li class="page-item "><a class="page-link " href="# ">2</a></li>
							<li class="page-item "><a class="page-link " href="# ">3</a></li>
							<li class="page-item "><a class="page-link " href="# ">Next</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- Lista di preventivi richiesti dall' utente -->
			<div id="menu2" class="tab-pane fade">
				<div class="containerListaPreventivi">
					<h3>
						Preventivi <span class="glyphicon glyphicon-list-alt"></span>
					</h3>
				</div>
				<hr>
				<div class="container boxCarrello"
					style="background: aliceblue; border: 2px solid black; padding-bottom: 50px;">
					<div class="row">
						<div class="col-sm-12 col-md-10 col-md-offset-1">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Codice Preventivo</th>
										<th>Data Preventivo</th>
										<th class="text-center">Lista Prodotti in preventivo</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listaPreventivi}" var="preventivo">
										<tr>
											<td class="col-sm-8 col-md-8">
												<div class="media">
													<div class="immaginePreventivo">
														<a class="thumbnail pull-left" href="#"> <img
															class="media-object" src="images/preventivo.jpg"
															style="width: 72px; height: 72px;">
														</a>
													</div>
													<div class="media-body">
														<br>
														<h4 class="media-heading">
															<a href="#"> Cod: ${preventivo.idPreventivo}</a>
														</h4>
													</div>
												</div>
											</td>
											<td class="col-sm-1 col-md-1 text-left"><strong>${preventivo.dataOraPreventivo}</strong></td>

											<td
												class="col-sm-1 col-md-1 text-center containerListaProdotti">
												<button type="button" class="btn btn-primary"
													data-toggle="modal" data-target="#myModal">
													Prodotti <span class="glyphicon glyphicon-modal-window"></span>
												</button> <!-- Modal -->
												<div class="modal fade" id="myModal" role="dialog">
													<div class="modal-dialog">

														<!-- Modal content-->
														<div class="modal-content">
															<div class="modal-header">
																<h3 class="modal-title">Lista dei prodotti in
																	preventivo</h3>
															</div>
															<div class="modal-body">
																<c:forEach items="${preventivo.listaProdotti}"
																	var="prodotto">
																	<div class="row">
																		<h4>${prodotto.nomeProdotto}</h4>
																		<div class="col-md-6">
																			<img href="prodotto?id=${prodotto.idProdotto}"
																				class="img img-responsive immagineProdotto"
																				style="width: 300px; height: 200px;"
																				src="${prodotto.immaginePrincipale}"
																				alt="Stanza TerraR04">
																		</div>
																		<div class="col-md-6">
																			<div class="containerCaratteristiche">
																				<div class="labelProdotto">
																					<label>Id: </label>
																				</div>
																				<div class="valoreLabelProdotto">
																					<p>${prodotto.idProdotto}</p>
																				</div>
																				<div class="labelProdotto">
																					<label>Marca: </label>
																				</div>
																				<div class="valoreLabelProdotto">
																					<p>${prodotto.marcaProdotto}</p>
																				</div>
																				<div class="labelProdotto">
																					<label>Venditore: </label>
																				</div>
																				<div class="valoreLabelProdotto">
																					<div class="row venditoriProdotto">
																						<p>${prodotto.nomeNegozioVenditore}</p>
																					</div>
																				</div>
																				<div class="labelProdotto">
																					<label>Prezzo: </label>
																				</div>
																				<div class="valoreLabelProdotto">
																					<p>
																					<p>${prodotto.prezzoProdotto}0€</p>
																					</p>
																				</div>
																				<button type="button" class="btn btn-primary"
																					data-toggle="modal" data-target="#myModal"
																					onclick="prodotto?id=${prodotto.idProdotto}">Apri</button>
																			</div>
																		</div>
																		<hr>
																	</div>
																</c:forEach>
															</div>

														</div>

													</div>

												</div>
											</td>

										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- Modifica dati personali utente -->
			<div id="menu3" class="tab-pane fade">
				<div class="containerTitoloForm">
					<h3>
						Modifica Dati Personali <span class="glyphicon glyphicon-pencil"></span>
					</h3>
				</div>
				<hr>
				<div class="containerFormDatipersonali">
					<form action="">
						<div class="containerDatiForm">
							<div class="row">
								<div class="col-md-1">
									<label for="nomeUtente">Nome utente</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="nomeUtente" name="nome"
										placeholder="Inserire nuovo nome utente"
										value="${utente.nomeUtente}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="cognomeUtente">Cognome Utente</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="cognomeUtente" name="cognome"
										placeholder="Inserire nuovo cognome utente"
										value="${utente.cognomeUtente}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="emailUtente">Email Utente</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="emailUtente" name="email"
										placeholder="Inserire nuova email utente"
										value="${utente.emailUtente}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="dataNascita">Data di nascita Utente</label>
								</div>
								<div class="col-md-8">
									<input type="date" name="bday" value="${utente.datadiNascita}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="recapitoTelefonico">Recapito Telefonico</label>
								</div>
								<div class="col-md-8">
									<input type="text" id="recapitoTelefonico"
										name="recapitoTelefonicoUtente"
										placeholder="Inserire nuovo recapito telefonico"
										value="${utente.numeroTelefonoUtente}">
								</div>
							</div>
						</div>

						<div class="row containerSubmitButton">
							<div class="col-md-6">
								<button class="cancelButton" type="reset">Cancella
									tutto</button>
							</div>
							<div class="col-md-6">
								<button class="submitButton" onclick="cambiaDati()">Salva</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- Modifica password utente -->
			<div id="menu4" class="tab-pane fade">
				<div class="containerTitoloForm">
					<h3>
						Modifica Password <span class="glyphicon glyphicon-pencil"></span>
					</h3>
				</div>
				<hr>
				<div class="containerFormDatipersonali cambiaPassword">
					<form onsubmit="cambiaDati(); return false;">
						<div class="containerDatiForm">

							<div class="row">
								<div class="col-md-1">
									<label for="passwordUtente">Vecchia Password</label>
								</div>
								<div class="col-md-8">
									<input type="password" id="oldPassword"
										placeholder="Inserire vecchia Password" name="oldPassword"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="passwordUtente">Nuova Password</label>
								</div>
								<div class="col-md-8">
									<input type="password" id="newPassword"
										placeholder="Inserire nuova Password" name="newPassword"
										required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-1">
									<label for="passwordUtente">Conferma Nuova Password</label>
								</div>
								<div class="col-md-8">
									<input type="password" id="confirmNewPassword"
										placeholder="Confermare nuova Password"
										name="confirm-newPassword" required>
								</div>
							</div>


						</div>

						<div class="row containerSubmitButton">
							<div class="col-md-6">
								<button class="cancelButton" type="reset">Cancella
									tutto</button>
							</div>
							<div class="col-md-6">
								<button class="submitButton">Salva</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<br>
	<br>

	<button type="button" class="btn btn-primary bottoneTornaSu">
		<a href="#top" style="color: #ffffff">Torna su...</a>
	</button>

	<div id="snackbar"></div>
	<div class="content"></div>

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
						<li><a href="venditore">FAQ</a></li>
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
	<div id="snackbar"></div>

</body>

</html>