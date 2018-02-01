<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>

<head>
<title>Prodotti</title>
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

<link rel="stylesheet" href="css/prodotti.css">
<link rel="stylesheet" href="css/snackbar.css">
<script src="js/Js/prodotti.js"></script>

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
				<li class="navbarOggetto"><a href="index.jsp">Home</a></li>
				
				<li class="navbarOggetto"><a href="prodotti">Catalogo Prodotti</a></li>
				<li class="navbarOggetto"><a href="aboutUs.html">About us</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right menuDestra">

				<c:if test="${utenteLoggato == true}">

					<li class="navbarOggetto"><a onclick="effettuaLogout()" class="nomeUtente" style="cursor: pointer;"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>

					<li class="navbarOggetto"><a href="utente" class="nomeUtente"><span
							class="glyphicon glyphicon-user user"></span> Benvenuto,
							${nomeUtente}</a></li>
							
				<li class="carrello navbarOggetto"><a href="carrello"><span
				class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>

				</c:if>

				<c:if test="${utenteLoggato == false}">

					<li class="navbarOggetto">
						<!-- Form per il login --> <a href="login"
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
					<li class="carrello navbarOggetto"><a onclick="chiediLogin()" style="cursor:pointer"><span
						class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>
				</c:if>

				
			</ul>
		</div>
	</nav>

	<!-- Bottone laterale a scomparsa -->
	<div id="mySidenav" class="sidenav">
		<a href="#top" id="backToTopMenu">Torna su</a>
	</div>

	<p class="titolo_sopra_prodotti" style="padding-top: 10%;">
		PRODOTTI</p>

	<hr>

	<!--Inizio Menu di selezione Tipo prodotti e Prezzo-->

	<div class="container" style="text-align: center">

		<div class="container menu_selezione">
			<div class="row ">
				<div class="col-md-3 single-top-left ">
					<h4 class="titolo_menu_selezione">Seleziona Tipologia di
						Prodotti</h4>
					<select name="tipoProdotto " class="form-control " id="tipoProdotto">
						<option value="">---</option>
						<option value="Armadio">Armadio</option>
						<option value="Cassettiera">Cassettiera</option>
						<option value="Comodino">Comodino</option>
						<option value="Credenza">Credenza</option>
						<option value="Cucina">Cucina</option>
						<option value="Libreria">Libreria</option>
						<option value="Illuminazione">Illuminazione</option>
						<option value="Letto">Letto</option>
						<option value="Scrivania">Scrivania</option>
						<option value="Sedia">Sedia</option>
						<option value="Divano">Divano</option>
						<option value="Poltrona">Poltrona</option>
						<option value="Tavolo">Tavolo</option>
						<option value="Bagno">Bagno</option>
						<option value="Vetrina">Vetrina</option>
						<option value="Camera da Letto">Camera da Letto</option>


					</select>
				</div>
				<div class="col-md-3 single-top-left ">
					<h4 class="titolo_menu_selezione">Seleziona Ambiente di
						Prodotti</h4>
					<select name="ambienteProdotto" class="form-control"
						id="ambienteProdotto">
						<option value="---">---</option>
						<option value="Cucina">Cucina</option>
						<option value="Bagno">Bagno</option>
						<option value="Soggiorno">Soggiorno</option>
						<option value="Studio">Studio</option>
						<option value="Camera da Letto">Camera da letto</option>
						<option value="Sala da Pranzo">Sala da pranzo</option>
						<option value="Salotto">Salotto</option>
						<option value="Tutti">Tutti gli ambienti</option>
					</select>
				</div>
				<div class="col-md-3 single-top-left ">
					<h4 class="titolo_menu_selezione">Seleziona Marca</h4>
					<select name="marcaProdotto" class="form-control" id="marcaProdotto">

						<option value="---">---</option>
						<c:forEach var="marca" items="${marcheProdotti}">
							<option value="${marca}">${marca}</option>
						</c:forEach>
						<option value="Tutti">Tutte le marche</option>

					</select>
				</div>
				<div class="col-md-3 single-top-right ">
					<div>
						<h4 class="titolo_menu_selezione">Prezzo</h4>
						<select name="indirizzo " class="form-control" id="ordinaPrezzo">
						    <option value="---">---</option>
							<option value="1 ">Crescente</option>
							<option value="2 ">Decrescente</option>
						</select>
					</div>
				</div>


			</div>
		</div>
		<!--Fine Menu di selezione Tipo prodotti e Prezzo-->


		<!--Inizio Box Prodotti -->

		<div class="container prodotti" style="padding-top: 2%;">

			<div class="row">
				<c:forEach var="prodotto" items="${prodotti}">
					<div class="col-md-4 grid-item ${prodotto.marcaProdotto} ${prodotto.tipoProdotto} ${prodotto.ambienteProdotto}" data-percentage="${prodotto.prezzoProdotto}" id="prodottoDaNascondere">
						<img class="img img-responsive img_grid"
							src="${prodotto.immaginePrincipale}"
							alt="${prodotto.nomeProdotto}">
						<div>
							<div>
								<h4 class="titolo_prodotto">${prodotto.nomeProdotto}</h4>
								<div class="testo_prodotto">
									<p>${prodotto.descrizioneProdotto}.</p>
								</div>
								<button type=" button " class="btn btn-default">
									<a href="prodotto?id=${prodotto.idProdotto}">Vai</a>
								</button>
							</div>
						</div>
					</div>
				</c:forEach>

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
	<button type="button" class="btn btn-primary bottoneTornaSu">
		<a href="#top" style="color: #ffffff">Torna su...</a>
	</button>

	<!-- Footer -->
	<footer id="myFooter">
		<div class="container" style="text-align: center">
			<div class="row">
				<div class="col-sm-3 myCols">
				</div>
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
				<div class="col-sm-3 myCols">
				</div>
				
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