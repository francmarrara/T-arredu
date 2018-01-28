// Menu Catalogo Prodotti - Mostra/Nascondi al passaggio del mouse
$(document).ready(function() {
	$("#catalogoProdotti").hover(function() {
		$(this).find("#menuProdotti").show(250);
	}, function() {
		$(this).find("#menuProdotti").hide(250);
	});
});

/* Abilita bottone laterale */
$(document).ready(function() {
	$(window).scroll(function() {
		if ($(this).scrollTop() > 200) {
			$('#backToTopMenu').fadeIn(200);
		} else {
			$('#backToTopMenu').fadeOut(200);
		}
	});
});

/* SNACKBAR */
function showSnackbar() {
	var x = document.getElementById("snackbar")
	x.className = "show";
	setTimeout(function() {
		x.className = x.className.replace("show", "");
	}, 3000);
}

// Errore sullo snackbar che ti invita a registrati

function chiediLogin() {
	$("#snackbar")
			.text(
					"PER EFFETTUARE QUESTA AZIONE DEVI ESSERE REGISTRATO ED EFFETTUARE IL LOGIN");
	$("#snackbar").css({
		'background-color' : 'red'
	});
	showSnackbar();
};

function aggiungiPreferito(idProdotto, emailUtente) {

	$.ajax({
		type : "GET",
		url : "prodottoGiaInPreferiti",

		data : {
			idProdotto : idProdotto,
			emailUtente : emailUtente,

		},
		// controllo che il prodotto non sia già in preferiti
		success : function(data) {
			if (data == "true") {
				$("#snackbar").text("PRODOTTO GIA' IN PREFERITI");
				$("#snackbar").css({
					'background-color' : 'red'
				});
				showSnackbar();
			} else {
				// se non è in preferiti faccio un altra chiamata ajax e lo
				// aggiungo
				$.ajax({
					type : "GET",
					url : "aggiungiPreferito",

					data : {
						emailUtente : emailUtente,
						idProdotto : idProdotto,
					},
					success : function() {

						$("#snackbar").text("AGGIUNTO AI PREFERITI");
						$("#snackbar").css({
							'background-color' : 'green'
						});
						showSnackbar();

					}
				// fine seconda chiamata ajax
				})

				// fine else
			}

			// fine success
		}
	// fine prima chiamata ajax
	})

}

function aggiungiNelCarrello(idProdotto, emailUtente) {

	$.ajax({
		type : "GET",
		url : "prodottoGiaInCarrello",

		data : {
			idProdotto : idProdotto,
			emailUtente : emailUtente,

		},
		success : function(data) {
			if (data == "true") {
				$("#snackbar").text("PRODOTTO GIA' NEL CARRELLO");
				$("#snackbar").css({
					'background-color' : 'red'
				});
				showSnackbar();
			} else {

				$.ajax({
					type : "GET",
					url : "aggiungiNelCarrello",

					data : {
						emailUtente : emailUtente,
						idProdotto : idProdotto,
					},
					success : function() {
						$("#snackbar").text("AGGIUNTO AL CARRELLO");
						$("#snackbar").css({
							'background-color' : 'green'
						});
						showSnackbar();
					}

				})
			}

		}
	})

}

/* Registra commento prodotto */

function registraCommentoProdotto(idProdotto, emailUtenteLoggato) {

	var recensioneVal = $("#subject").val();
	var valutazione = $('.messageCheckbox:checked').val();

	var recensione = {
		idProdotto : idProdotto,
		emailUtente : emailUtenteLoggato,
		recensioneVal : recensioneVal,
		valutazione : valutazione,
	};

	$.ajax({
		type : "POST",
		url : "aggiungiCommento",
		datatype : "json",
		data : JSON.stringify(recensione),
		success : function() {

			$("#snackbar").text("RECENSIONE REGISTRATA CON SUCCESSO");
			$("#snackbar").css({
				'background-color' : 'green'
			});
			showSnackbar();
			window.setTimeout(location.reload(), 1000);

		}
	});

}
