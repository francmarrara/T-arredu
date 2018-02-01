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

// $(window).on('load', function() {
// $("#tipoProdotto").change(function() {
//		
// var str1 = "prodottiPerTipo?tipo=";
// var tipo = $("#tipoProdotto option:selected").attr("value");
// var res = str1.concat(tipo);
//
// if (tipo != "Tutti") {
// $("#ambienteProdotto option:selected").text(tipo);
//
// window.setTimeout(window.location.replace(res), 1000);
// }
// else{
// window.setTimeout(window.location.replace("prodotti"), 1000);
// }
// })
// })

$(window).on('load', function() {
	$("#tipoProdotto").change(function() {
		
		
		
		
	}
}
		
	}