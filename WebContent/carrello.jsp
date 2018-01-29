<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="it">


<head>
    <title>Il tuo Carrello</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/Footer-with-social-icons.css">
    <link rel="stylesheet" href="css/carrello.css">
    <link rel="stylesheet" href="css/snackbar.css">
    

    <script src="js/Js/carrello.js"></script>
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
window.smartsupp||(function(d) {
  var s,c,o=smartsupp=function(){ o._.push(arguments)};o._=[];
  s=d.getElementsByTagName('script')[0];c=d.createElement('script');
  c.type='text/javascript';c.charset='utf-8';c.async=true;
  c.src='https://www.smartsuppchat.com/loader.js?';s.parentNode.insertBefore(c,s);
})(document);
</script>
    
    
    
</head>


<body>
    <!-- Sfondo -->
    <div id="bg">
        <img src="images/sfondoLegno.png" alt="">
    </div>

    <!-- Header -->
    <header class="container-fluid headerImage">
        <img src="images/headerImage.png" alt="headerImage" width="1318px" height="50px">
    </header>



    <!-- Menu di navigazione principale -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="navbarOggetto"><img id="logoButton"
					src="images/TarreduLogo.png" width="50" height="50"></li>
				<li class="navbarOggetto"><a href="index.jsp">Home</a></li>
				<!-- DropMenu per catalogo prodotti -->
				<li class="dropdown navbarOggetto" id="catalogoProdotti"><a
					class="dropdown-toggle" data-toggle="dropdown" href="">Catalogo
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

					<li class="navbarOggetto"><a onclick="effettuaLogout()" class="nomeUtente" style="cursor: pointer;"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>

					<li class="navbarOggetto"><a href="#" class="nomeUtente"><span
							class="glyphicon glyphicon-user user"></span> ${nomeUtente}</a></li>
							
							<li class="carrello navbarOggetto"><a href="carrello?email=${emailUtenteLoggato}"><span
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
					<li class="carrello navbarOggetto"><a onclick="chiediLogin()" style="cursor:pointer;"><span
						class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>
				</c:if>

				
			</ul>
		</div>
	</nav>

    <!-- Bottone laterale a scomparsa -->
    <div id="mySidenav" class="sidenav">
        <a href="#top" id="backToTopMenu">Torna su</a>
    </div>

    <div class="container boxCarrello" style="background: aliceblue; border: 2px solid black; padding-bottom:50px;">
        <div class="row">
            <div class="col-sm-12 col-md-10 col-md-offset-1">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Prodotto</th>
                            <th>Seleziona Per Preventivo</th>
                            <th class="text-center">Prezzo Consigliato</th>
                            <th class="text-center">Rimuovi</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="prodotto" items="${prodottiNelCarrello}">
                        <tr>
                            <td class="col-sm-8 col-md-6">
                                <div class="media">
                                    <a class="thumbnail pull-left" href="prodotto?id=${prodotto.idProdotto}"> <img class="media-object" src="${prodotto.immaginePrincipale}" style="width: 72px; height: 72px;"> </a>
                                    <div class="media-body">
                                        <h4 class="media-heading"><a href="prodotto?id=${prodotto.idProdotto}">${prodotto.nomeProdotto}</a></h4>
                                        <h4 class="media-heading">MARCA : ${prodotto.marcaProdotto}</h4>
                                    </div>
                                </div>
                            </td>
                            <td class="col-sm-1 col-md-1" style="text-align: center">
                                <input type="checkbox" id="exampleInputEmail1" value="true">
                            </td>
                            <td class="col-sm-1 col-md-1 text-center"><strong>${prodotto.prezzoProdotto} Euro</strong></td>
                            
                            <td class="col-sm-1 col-md-1">
                                <button type="button" class="btn btn-danger" onclick="rimuoviDalCarrello('${prodotto.idProdotto}','${emailUtenteLoggato}')">
                                <span class="glyphicon glyphicon-remove"></span> Rimuovi dal Carrello
                            </button></td>
                        </tr>
                        </c:forEach>
                            <td>
                                <button type="button" class="btn btn-default">
                                <span class="glyphicon glyphicon-shopping-cart"></span> <a href="index.jsp">Home</a>
                            </button></td>
                            <td>
                                <button type="button" class="btn btn-success" onclick="richiediPreventivo()")>
                                RichiediPreventivo<span class="glyphicon glyphicon-play"></span>
                            </button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <button type="button" class="btn btn-primary bottoneTornaSu"><a href="#top" style="color:#ffffff">Torna su...</a></button>

    <div class="content">
    </div>
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
            <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
            <a href="#" class="facebook"><i class="fa fa-facebook-official"></i></a>
            <a href="#" class="google"><i class="fa fa-google-plus"></i></a>
        </div>
    </footer>
    	<div id="snackbar"></div>
    
</body>

</html>