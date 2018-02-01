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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/Footer-with-social-icons.css">

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/slick.min.js"></script>

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

    <link rel="stylesheet" href="css/prodotti.css">
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
            <img src="images/headerImage.png" alt="headerImage" width="1318px" height="50px">
        </div>
    </header>

    <!-- Menu di navigazione principale -->
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li class="navbarOggetto"><img id="logoButton" src="images/TarreduLogo.png" width="50" height="50"></li>
                <li class="navbarOggetto"><a href="index.html">Home</a></li>
                <!-- DropMenu per catalogo prodotti -->
                <li class="dropdown navbarOggetto" id="catalogoProdotti">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Catalogo Prodotti
                    <span class="caret"></span></a>
                    <ul class="dropdown-menu row" id="menuProdotti">
                        <li class="col-sm-3" id="listaMenu">
                            <ul class="list-unstyled">
                                <li>
                                    <h4 class="NomiCategorie">Ambienti</h4>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Cucina</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Bagno</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Soggiorno</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Studio</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Camera da letto</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Salotto</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Stanza da pranzo</a>
                                </li>
                            </ul>
                        </li>
                        <li class="col-sm-3" id="listaMenu">
                            <ul class="list-unstyled">
                                <li>
                                    <h4 class="NomiCategorie">Categorie</h4>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Armadi</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Cassettiere</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Comodini</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Illuminazioni</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Credenze</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Letti</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Tavoli</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Librerie</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Scrivanie</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Sedie</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Poltrone</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Divani</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Vetrine</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Bagni</a>
                                </li>
                            </ul>
                        </li>
                        <li class="col-sm-3" id="listaMenu">
                            <ul class="list-unstyled">
                                <li>
                                    <h4 class="NomiCategorie">Marche</h4>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Prodotti 2</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Prodotti 3</a>
                                </li>
                            </ul>
                        </li>
                        <li class="col-sm-3" id="listaMenu">
                            <ul class="list-unstyled">
                                <li>
                                    <h4 class="NomiCategorie">Marche</h4>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Prodotti 2</a>
                                </li>
                                <li>
                                    <a class="oggettiCategorie" href="prodotti.html">Prodotti 3</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li class="navbarOggetto"><a href="prodotti.html">Tutti i Prodotti</a></li>
                <li class="navbarOggetto"><a href="aboutUs.html">About us</a></li>
                <li class="navbarOggetto"><a href="profiloUtente.html">Utente</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right menuDestra">

                <li class="navbarOggetto">
                    <!-- Form per il login -->
                    <a href="#" onclick="document.getElementById('login').style.display='block'">
                        <span class="glyphicon glyphicon-log-in"></span> Login</a>

                    <div id="login" class="modal">

                        <form class="modal-content animate" action="------">
                            <div class="imgcontainer">
                                <span onclick="document.getElementById('login').style.display='none'" class="close" title="Chiudi Login">&times;</span>
                                <img src="images/userLogin.jpg" alt="Avatar" class="avatar" width=150 height=150>
                            </div>

                            <div class="containerModal">
                                <label><b>Username</b></label>
                                <input class="inputLogIn" type="text" placeholder="Inserire Username" name="uname" required>

                                <label><b>Password</b></label>
                                <input class="inputLogIn" type="password" placeholder="Inserire Password" name="psw" required>

                                <button class="buttonLog" type="submit">Login</button>
                                <div class="containerCheckbox">
                                    <label>Ricordami <input type="checkbox" id="checkRicordami" onclick="controlla()"></label>
                                </div>
                            </div>

                            <div class="containerModalBottom" style="background-color:#ffffff">
                                <button type="button" onclick="document.getElementById('login').style.display='none'" class="cancelbtn">Cancel</button>
                                <span class="psw"><a href="#">Password dimenticata?</a></span>
                            </div>
                        </form>
                    </div>
                </li>
                <li class="navbarOggetto">
                    <!-- Form per la registrazione -->
                    <a href="#" onclick="document.getElementById('registrazione').style.display='block'">
                        <span class="glyphicon glyphicon-user user"></span> Registrati</a>

                    <div id="registrazione" class="modal">

                        <form class="modal-content animateReg" action="------">
                            <div class="imgcontainerReg">
                                <span onclick="document.getElementById('registrazione').style.display='none'" class="closeReg" title="Chiudi Registrazione">&times;</span>
                            </div>
                            <h1>Registrazione</h1>
                            <p>Compila questo modulo per creare un account.</p>
                            <hr>
                            <div class="containerReg">

                                <label><b>Nome</b></label>
                                <input type="text" placeholder="Inserire Nome" name="nome" required>

                                <label><b>Cognome</b></label>
                                <input type="text" placeholder="Inserire Cognome" name="cognome" required>

                                <label><b>Email</b></label>
                                <input type="text" placeholder="Inserire Indirizzo Email" name="email" required>

                                <label><b>Password</b></label>
                                <input type="password" placeholder="Inserire Password" name="psw" required>

                                <label><b>Ripetere Password</b></label>
                                <input type="password" placeholder="Reinserire Password" name="psw-repeat" required>


                            </div>
                            <div class="containerRegistrazione">
                                <label>Ricordami
                                            <input type="checkbox" checked="checked" style="margin-bottom:15px"> 
                                          </label>
                            </div>


                            <div class="containerRegButton" style="background-color:#ffffff">
                                <button type="button" onclick="document.getElementById('registrazione').style.display='none'" class="cancelbtnReg">Cancel</button>
                                <button class="buttonReg" type="submit">Registrati</button>
                            </div>
                        </form>
                    </div>

                </li>
                <li class="carrello navbarOggetto"><a href="carrello.html"><span class="glyphicon glyphicon-shopping-cart"></span> Carrello</a></li>
            </ul>
        </div>
    </nav>

    <!-- Bottone laterale a scomparsa -->
    <div id="mySidenav" class="sidenav">
        <a href="#top" id="backToTopMenu">Torna su</a>
    </div>

    <p class="titolo_sopra_prodotti" style="padding-top:10%;">
        PRODOTTI </p>

    <hr>

    <!--Inizio Menu di selezione Tipo prodotti e Prezzo-->

    <div class="container" style="text-align: center">

        <div class="container menu_selezione">
            <div class="row ">
                <div class="col-md-3 single-top-left ">
                    <h4 class="titolo_menu_selezione">Seleziona Tipologia di Prodotti</h4>
                    <select name="tipoProdotto " class="form-control ">
                      <option value="1 ">Armadi</option> 
                      <option value="2 ">Cassettiere</option> 
                      <option value="3 ">Comodi</option> 
                     <option value="4 ">Credenze</option> 
                      <option value="5 ">Cucine</option>
                      <option value="6 ">Librerie</option>                      
                      <option value="7 ">Illuminazione</option> 
                      <option value="8 ">Letti</option> 
                      <option value="9 ">Scrivanie</option>
                      <option value="10 ">Sedie</option>
                      <option value="11 ">Divani</option>
                      <option value="12 ">Poltrone</option>
                      <option value="13 ">Tavolo</option>
                      <option value="14 ">Vetrine</option>

             </select>
                </div>
                <div class="col-md-9 single-top-right ">
                    <div style="padding-left:75%; ">
                        <h4 class="titolo_menu_selezione">Prezzo</h4>
                        <select name="indirizzo " class="form-control ">
                 <option value="1 ">Crescente</option>
                 <option value="2 ">Decrescente</option>
           </select>
                    </div>
                </div>


            </div>
        </div>
        <!--Fine Menu di selezione Tipo prodotti e Prezzo-->


        <!--Inizio Box Prodotti -->

        <div class="container prodotti" style="padding-top : 2%;">
            <div class="row"> 
                <div class="col-md-4 grid-item">
                    <img class="img img-responsive img_grid" src="images/productImages/Ardiano_01.jpg" alt="Divano Ardiano">
                    <div>
                        <div>
                            <h4 class="titolo_prodotto">Ardiano</h4>
                            <div class="testo_prodotto">
                                <p>Braccioli e schienali hanno la stessa altezza in questo sofÃ  essenziale, con un'immagine giovane ed informale, che appare rigoroso ma equilibrato nelle sue linee a pozzetto.</p>
                            </div>
                            <button type=" button " class="btn btn-default"><a href="prodotto.html">Vai</a></button>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 grid-item"> <img class="img img-responsive img_grid " src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">
                    <div>
                        <div>
                            <h4 class="titolo_prodotto ">TITOLO 1</h4>
                            <div class="testo_prodotto ">
                                <p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur. Sea te minim soleat senserit, ex quo luptatum tacimates voluptatum.</p>
                            </div>
                            <button type=" button " class="btn btn-default"><a href="prodotto.html">Vai</a></button> </div>
                    </div>
                </div>
                <div class="col-md-4 grid-item"> <img class="img img-responsive img_grid " src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">
                    <div>
                        <div>
                            <h4 class="titolo_prodotto ">TITOLO 1</h4>
                            <div class="testo_prodotto ">
                                <p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur. Sea te minim soleat senserit, ex quo luptatum tacimates voluptatum.</p>
                            </div>
                            <button type=" button " class="btn btn-default"><a href="prodotto.html">Vai</a></button> </div>
                    </div>
                </div>
                
                </div>
                 <div class="row"> 
                <div class="col-md-4 grid-item">
                    <img class="img img_grid img-responsive" src="images/productImages/Ardiano_01.jpg" alt="Divano Ardiano">
                    <div>
                        <div>
                            <h4 class="titolo_prodotto">Ardiano</h4>
                            <div class="testo_prodotto">
                                <p>Braccioli e schienali hanno la stessa altezza in questo sofÃ  essenziale, con un'immagine giovane ed informale, che appare rigoroso ma equilibrato nelle sue linee a pozzetto.</p>
                            </div>
                            <button type=" button " class="btn btn-default"><a href="prodotto.html">Vai</a></button>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 grid-item"> <img class="img img_grid img-responsive" src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">
                    <div>
                        <div>
                            <h4 class="titolo_prodotto ">TITOLO 1</h4>
                            <div class="testo_prodotto ">
                                <p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur. Sea te minim soleat senserit, ex quo luptatum tacimates voluptatum.</p>
                            </div>
                            <button type=" button " class="btn btn-default"><a href="prodotto.html">Vai</a></button> </div>
                    </div>
                </div>
                <div class="col-md-4 grid-item"> <img class="img img_grid img-responsive" src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">
                    <div>
                        <div>
                            <h4 class="titolo_prodotto ">TITOLO 1</h4>
                            <div class="testo_prodotto ">
                                <p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur. Sea te minim soleat senserit, ex quo luptatum tacimates voluptatum.</p>
                            </div>
                            <button type=" button " class="btn btn-default"><a href="prodotto.html">Vai</a></button> </div>
                    </div>
                </div>
                
                </div>
                 <div class="row"> 
                <div class="col-md-4 grid-item">
                    <img class="img img_grid img-responsive" src="images/productImages/Ardiano_01.jpg" alt="Divano Ardiano">
                    <div>
                        <div>
                            <h4 class="titolo_prodotto">Ardiano</h4>
                            <div class="testo_prodotto">
                                <p>Braccioli e schienali hanno la stessa altezza in questo sofÃ  essenziale, con un'immagine giovane ed informale, che appare rigoroso ma equilibrato nelle sue linee a pozzetto.</p>
                            </div>
                            <button type=" button " class="btn btn-default"><a href="prodotto.html">Vai</a></button>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 grid-item"> <img class="img img_grid img-responsive" src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">
                    <div>
                        <div>
                            <h4 class="titolo_prodotto ">TITOLO 1</h4>
                            <div class="testo_prodotto ">
                                <p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur. Sea te minim soleat senserit, ex quo luptatum tacimates voluptatum.</p>
                            </div>
                            <button type=" button " class="btn btn-default"><a href="prodotto.html">Vai</a></button> </div>
                    </div>
                </div>
                <div class="col-md-4 grid-item"> <img class="img img_grid img-responsive" src="images/productImages/Sunrise_01.jpg " alt="Letto Sunrise ">
                    <div>
                        <div>
                            <h4 class="titolo_prodotto ">TITOLO 1</h4>
                            <div class="testo_prodotto ">
                                <p>Lorem ipsum dolor sit amet, et nam pertinax gloriatur. Sea te minim soleat senserit, ex quo luptatum tacimates voluptatum.</p>
                            </div>
                            <button type=" button " class="btn btn-default"><a href="prodotto.html">Vai</a></button> </div>
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
    <button type="button" class="btn btn-primary bottoneTornaSu"><a href="#top" style="color:#ffffff">Torna su...</a></button>

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
            <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
            <a href="#" class="facebook"><i class="fa fa-facebook-official"></i></a>
            <a href="#" class="google"><i class="fa fa-google-plus"></i></a>
        </div>
    </footer>

</body>

</html>