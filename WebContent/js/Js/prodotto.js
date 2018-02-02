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

/*VALIDATORE EMAIL*/

var validate_email = function(email) {
	var pattern = /^([a-zA-A0-9_.-])+@([a-zA-Z0-9_.-])+([a-zA-Z])+/;
	var is_email_valid = false;
	if (email.match(pattern) != null) {
		is_email_valid = true;
	}
	return is_email_valid;
}

/* Valida Email registrazione */
$(document).on("focusout", "#emailUtente", function() {
	var input_val = $(this).val();
	var is_success = validate_email(input_val);

    if (!is_success) {

        
        $("#emailUtente").css({ 'background-color': 'red' });
        $("#snackbar").text("FORMATO EMAIL NON CORRETTO");
        $("#snackbar").css({ 'background-color': 'red' });
        showSnackbar();
    }
 else {

        $.ajax({
            type: "GET",
            url: "verificaMail",

            data: {
                email: input_val
            },
            success: function(data) {
                if (data == "false") {
                    $("#emailUtente").css({ 'background-color': '#7FFF00' });
                    $("#snackbar").css({ 'background-color': '#7FFF00' });
                    $("#snackbar").text("EMAIL CORRETTA");
                    showSnackbar();
                } else {
                    $("#emailUtente").css({ 'background-color': 'red' });
                    $("#snackbar").css({ 'background-color': 'red' });
                    $("#snackbar").text("EMAIL GIA' REGISTRATA");
                    showSnackbar();
                }
            }
        })
    }

});


/* Validatore PASSWORD */

$(document).on("focusout", "#psw-repeat", function() {
    var password = $("#psw").val();
    var confirmPassword = $("#psw-repeat").val();

    if (password == confirmPassword) {
        $("#psw").css({ 'background-color': '#7FFF00' });
        $("#psw-repeat").css({ 'background-color': '#7FFF00' });
        $("#snackbar").css({ 'background-color': '#7FFF00' });
        $("#snackbar").text("PASSWORD MATCH");
        showSnackbar();

    } else {
        $("#psw").css({ 'background-color': 'red' });
        $("#psw-repeat").css({ 'background-color': 'red' });
        $("#snackbar").css({ 'background-color': 'red' });
        $("#snackbar").text("PASSWORD DOESN'T MATCH");
        showSnackbar();
    }


})

/* REGISTRAZIONE */
function registrazione(){
	
	var utente = {
			nome : $("#nome").val(),
			cognome : $("#cognome").val(),
			dataDiNascita : $("#dataDiNascita").val(),
			numeroDiTelefono : $("#numeroDiTelefono").val(),
			emailUtente : $("#emailUtente").val(),
			password : $("#psw").val()
	}
	
	
	$.ajax({
		type: "GET",		
		url: "registrazione",		
		datatype : "json",
		data: JSON.stringify(utente),
		success: function(){
			  $("#snackbar").css({ 'background-color': '#7FFF00' });
		        $("#snackbar").text("REGISTRAZIONE COMPLETATA");
		        showSnackbar();
		}	
	});
	console.log(utente);
	
}

/* Controllo LOGIN */

/* Valida email login */
$(document).on("focusout", ".EmailUtenteLogin", function() {
	var input_val = $(this).val();
	var is_success = validate_email(input_val);

	if (!is_success) {
		alert("Email format wrong");
	}

	$.ajax({
		type : "GET",
		url : "verificaMail",

		data : {
			email : input_val
		},
		success : function(data) {
			/*alert(data);*/
		}
	})

});

/* CheckBox votazione */




