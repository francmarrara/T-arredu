$(window).on('load', function() {

	
	
});

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

/* Validatore formatoEMAIL */
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
		alert("email errata");
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

/* Gestisci snackbar */
function mostraSnackbar() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 5000);
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

/*
var validaCredenziali = function() {

	var email = $(".EmailUtenteLogin").val();
	var password = $(".passwordLogin").val();

	var credenziali = {
		emailUtente : email,
		passwordUtente : password
	};

	$.ajax({

		type : "POST",
		url : "validaCredenzialiLogin",
		datatype : "json",
		data : JSON.stringify(credenziali),
		success : function(data) {

			$("#snackbar").text(data);
			mostraSnackbar();

		}

	});

} */
