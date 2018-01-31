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

function prova() {
	console.log("PREMUTO");
}

/* SNACKBAR */
function showSnackbar() {
	var x = document.getElementById("snackbar")
	x.className = "show";
	setTimeout(function() {
		x.className = x.className.replace("show", "");
	}, 3000);
}

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
$(document).on("focusout", "#oldPassword", function() {
	var password = $("#oldPassword").val();

	console.log(password);

	var confirmPassword = $("#passwordPerVerifica").val();

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
