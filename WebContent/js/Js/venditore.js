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

function chiediLogin() {
	$("#snackbar")
			.text(
					"PER EFFETTUARE QUESTA AZIONE DEVI ESSERE REGISTRATO ED EFFETTUARE IL LOGIN");
	$("#snackbar").css({
		'background-color' : 'red'
	});
	showSnackbar();
};

/* SNACKBAR */
function showSnackbar() {
	var x = document.getElementById("snackbar")
	x.className = "show";
	setTimeout(function() {
		x.className = x.className.replace("show", "");
	}, 3000);
}

/* VALIDATORE EMAIL */

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

		$("#emailUtente").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("FORMATO EMAIL NON CORRETTO");
		$("#snackbar").css({
			'background-color' : 'red'
		});
		showSnackbar();
	} else {

		$.ajax({
			type : "GET",
			url : "verificaMail",

			data : {
				email : input_val
			},
			success : function(data) {
				if (data == "false") {
					$("#emailUtente").css({
						'background-color' : '#7FFF00'
					});
					$("#snackbar").css({
						'background-color' : '#7FFF00'
					});
					$("#snackbar").text("EMAIL CORRETTA");
					showSnackbar();
				} else {
					$("#emailUtente").css({
						'background-color' : 'red'
					});
					$("#snackbar").css({
						'background-color' : 'red'
					});
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
		$("#psw").css({
			'background-color' : '#7FFF00'
		});
		$("#psw-repeat").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").text("PASSWORD MATCH");
		showSnackbar();

	} else {
		$("#psw").css({
			'background-color' : 'red'
		});
		$("#psw-repeat").css({
			'background-color' : 'red'
		});
		$("#snackbar").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("PASSWORD DOESN'T MATCH");
		showSnackbar();
	}

})

/* REGISTRAZIONE */
function registrazione() {

	var utente = {
		nome : $("#nome").val(),
		cognome : $("#cognome").val(),
		dataDiNascita : $("#dataDiNascita").val(),
		numeroDiTelefono : $("#numeroDiTelefono").val(),
		emailUtente : $("#emailUtente").val(),
		password : $("#psw").val()
	}

	$.ajax({
		type : "GET",
		url : "registrazione",
		datatype : "json",
		data : JSON.stringify(utente),
		success : function() {
			$("#snackbar").css({
				'background-color' : '#7FFF00'
			});
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
			/* alert(data); */
		}
	})

});

$(window).on('load', function() {
	$("#tipoProdotto").change(function() {
		var tipo = $("#tipoProdotto option:selected").attr("value");
		$('#ambienteProdotto').val("---");
		$('#marcaProdotto').val("---");

		$('.grid-item').each(function(i, obj) {
			console.log($(this).attr("class"));

			if (!$(this).hasClass(tipo)) {
				$(this).hide();
			} else {
				$(this).show();

			}
		});

	})

})

$(window).on('load', function() {
	$("#ambienteProdotto").change(function() {
		var tipo = $("#ambienteProdotto option:selected").attr("value");
		$('#marcaProdotto').val("---");
		$('#tipoProdotto').val("---");

		if (tipo == 'Tutti') {
			$('.grid-item').each(function(i, obj) {
				$(this).show();
			})
		} else {
			$('.grid-item').each(function(i, obj) {

				if (!$(this).hasClass(tipo)) {
					$(this).hide();
				} else {
					$(this).show();

				}
			});
		}
	})

})

$(window).on('load', function() {
	$("#marcaProdotto").change(function() {
		var tipo = $("#marcaProdotto option:selected").attr("value");
		$('#ambienteProdotto').val("---");
		$('#tipoProdotto').val("---");

		if (tipo == 'Tutti') {
			$('.grid-item').each(function(i, obj) {
				$(this).show();
			})
		} else {
			$('.grid-item').each(function(i, obj) {

				if (!$(this).hasClass(tipo)) {
					console.log($(this).attr("class"));
					$(this).hide();
				} else {
					$(this).show();

				}
			});
		}
	})

})





/* ordinamento per prezzo */
$(window).on('load',function() {

	$("#ordinaPrezzo").change(function() {

		var tipo = $("#ordinaPrezzo option:selected").attr("value");

		
		var mylist = $('.rigaProdotto');
	    var listitems = mylist.children('.grid-item').get();

	    
		
	if(tipo == '1'){
		//crescente
		listitems.sort(function(a, b) {
		   var compA = parseFloat($(a).attr("value"));
		   var compB = parseFloat($(b).attr("value"));
		   return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
		})
		}
	else if(tipo =='2'){
		//decrescente
		
		listitems.sort(function(a, b) {
			   var compA = parseFloat($(a).attr("value"));
			   var compB = parseFloat($(b).attr("value"));
			   return (compA > compB) ? -1 : (compA < compB) ? 1 : 0;
			})
	}   


		
   mylist.append(listitems);

						
	})
	})








