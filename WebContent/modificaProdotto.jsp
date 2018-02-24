<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="it">

<head>
<title>Modifica Prodotto</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">

<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="css/snackbar.css">
<script src="js/Js/snackbar.js"></script>
<link rel="shortcut icon" href="images/TarreduLogo.png">

<link rel="stylesheet" href="css/modificaProdotto.css">
<script src="js/Js/modificaProdotto.js"></script>

</head>
<body>

	<!-- Sfondo -->

	<img class="img img-responsive" src="images/sfondoLegno.png" id="bg">

	<div class="containerGenerale">
		<div class="container containerFormDatipersonali">
			<h2>Modifica Prodotto</h2>
			<form action="aggiungiProdottoVenditore" method="post"
				enctype="multipart/form-data">
				<div class="containerDatiForm">
					<div class="row">
						<div class="col-md-2">
							<label for="nomeProdotto">Nome Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="nomeProdotto" name="nome"
								placeholder="Inserire nuovo nome prodotto" value="">
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<label for="marcaProdotto">Marca Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="marcaProdotto" name="marca"
								placeholder="Inserire nuova marca prodotto" value="">
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<label for="tipoProdotto">Tipo Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="tipoProdotto" name="tipo"
								placeholder="Inserire nuovo tipo del prodotto" value="">
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<label for="ambienteProdotto">Ambiente Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="ambienteProdotto" name="ambiente"
								placeholder="Inserire nuovo ambiente del prodotto" value="">
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<label for="prezzoProdotto">Prezzo Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="prezzoProdotto" name="prezzo"
								placeholder="Inserire nuovo prezzo del prodotto" value="">
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<label for="misureProdotto">Misure Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="misureProdotto" name="misure"
								placeholder="Inserire nuove misure del prodotto" value="">
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<label for="coloriProdotto">Colori Prodotto</label>
						</div>
						<div class="col-md-10">
							<input type="text" id="coloriProdotto" name="colori"
								placeholder="Inserire i colori, separati da ',' " value="">
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<label for="descrizioneProdotto">Descrizione prodotto</label>
						</div>
						<div class="col-md-10">
							<textarea id="descrizioneProdotto" name="descrizioneProdotto"
								placeholder="Inserire una descrizione..."
								style="height: 50%; width: 100%;"></textarea>
						</div>
					</div>

					<div class="row inserireImmagine">
						<div class="col-md-2">
							<label for="inserimentoImmagine">Inserire immagine
								prodotto</label>
						</div>
						<div class="col-md-10 listaImmagini">
							<input id="contatoreImmagini" value="1" name="contatoreImmagini"
								style="display: none;">
							<ol>
								<li><input type="file" name="pic1" accept="image/*"
									class=""></li>
							</ol>
							<button id="aggiungiImmagine">Aggiungi Immagine</button>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<label for="inOfferta">Prodotto in offerta?</label><input
								type="checkbox" name="prodottoInOfferta" class="messageCheckbox"
								value="1">
						</div>

					</div>

				</div>

				<div class="bottoni">
					<div class="row containerSubmitButton">
						<div class="col-md-6">
							<button class="cancelButton" type="reset" onclick="alert('suca')">Cancella tutto</button>
						</div>
						<div class="col-md-6">
							<button class="submitButton" onclick="alert('sucaduevolte')">Salva</button>
						</div>
					</div>
				</div>
			</form>
		</div>


	</div>
















</body>
</html>