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

		$("#emailUtente").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").text("FORMATO EMAIL CORRETTO");
		$("#snackbar").css({
			'background-color' : '#7FFF00'
		});
		showSnackbar();

	}

});

// /* Validatore PASSWORD */
$(document).on("focusout", "#confirmNewPassword", function() {

	var oldPassword = $("#oldPassword").val();
	var password = $("#newPassword").val();
	var confirmPassword = $("#confirmNewPassword").val();

	if (password == confirmPassword && password != oldPassword) {
		$("#newPassword").css({
			'background-color' : '#7FFF00'
		});
		$("#confirmNewPassword").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").css({
			'background-color' : '#7FFF00'
		});
		$("#snackbar").text("PASSWORD CORRETTE");
		showSnackbar();

	} else if (password == oldPassword) {
		$("#newPassword").css({
			'background-color' : 'red'
		});
		$("#confirmNewPassword").css({
			'background-color' : 'red'
		});
		$("#oldPassword").css({
			'background-color' : 'red'
		});
		$("#snackbar").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("LA VECCHIA E LA NUOVA PASSWORD SONO UGUALI");
		showSnackbar();

	}

	else {
		$("#newPassword").css({
			'background-color' : 'red'
		});
		$("#confirmNewPassword").css({
			'background-color' : 'red'
		});
		$("#snackbar").css({
			'background-color' : 'red'
		});
		$("#snackbar").text("LE PASSWORD NON SONO UGUALI");
		showSnackbar();
	}

});

// Valida email vecchia confrontata alla nuova
$(document).on(
		"focusout",
		"#oldPassword",
		function() {
			var password = $("#oldPassword").val();

			console.log(password);

			var confirmPassword = document.getElementById(
					"#passwordPerVerifica").val();

			console.log(confirmPassword);

			if (password == confirmPassword) {
				$("#oldPassword").css({
					'background-color' : '#7FFF00'
				});

				$("#snackbar").css({
					'background-color' : '#7FFF00'
				});
				$("#snackbar").text("LA VECCHIA PASSWORD E' CONFERMATA");
				showSnackbar();

			} else {
				$("#oldPassword").css({
					'background-color' : 'red'
				});

				$("#snackbar").css({
					'background-color' : 'red'
				});
				$("#snackbar").text("VECCHIA PASSWORD ERRATA");
				showSnackbar();
			}

		});

function cambiaDati() {

	var userPassword = $("#passwordPerVerifica").val();
	var oldPassword = $("#oldPassword").val();

	var newPassword = $("#newPassword").val();
	var confirmPassword = $("#confirmNewPassword").val();

	if (newPassword == confirmPassword) {

		$.ajax({
			type : "GET",
			url : "cambiaPassword",

			data : {
				nuovaPassword : newPassword,
			},
			success : function() {
				$("#emailUtente").css({
					'background-color' : '#7FFF00'
				});
				$("#snackbar").css({
					'background-color' : '#7FFF00'
				});
				$("#snackbar").text("PASSWORD MODIFICATA CON SUCCESSO");
				showSnackbar();

				window.setTimeout(window.location.replace('utente'), 1000);

			}
		})

	}

}

function effettuaLogout() {

	$.ajax({
		type : "GET",
		url : "effettuaLogout",

		success : function() {
			$("#snackbar").text("LOGOUT EFFETTUATO");
			$("#snackbar").css({
				'background-color' : 'green'
			});
			showSnackbar();

			// window.setTimeout(location.reload(), 1000);
			window.location.replace('index.jsp');

		}

	})
}
