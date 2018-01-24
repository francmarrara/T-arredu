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

var validate_email = function(email) {
	var pattern = /^([a-zA-A0-9_.-])+@([a-zA-Z0-9_.-])+([a-zA-Z])+/;
	var is_email_valid = false;
	if (email.match(pattern) != null) {
		is_email_valid = true;
	}
	return is_email_valid;
}

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
			alert(data);
		}
	})

});

/* Validatore formatoEMAIL */