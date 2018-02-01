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


$(window).on('load', function() {
	$("#tipoProdotto").change(function() {
	var tipo = $("#tipoProdotto option:selected").attr("value");
		
		$('.grid-item').each(function(i, obj) {
			
			if(!$(this).hasClass(tipo)){
			$(this).hide();
		}
			else{
				$(this).show();
				
				}				   
			   });
			
})

})

$(window).on('load', function() {
	$("#ambienteProdotto").change(function() {
	var tipo = $("#ambienteProdotto option:selected").attr("value");
	
	if(tipo == 'Tutti'){
		$('.grid-item').each(function(i, obj) {
			$(this).show();})
		}
	else{
		$('.grid-item').each(function(i, obj) {
			
			if(!$(this).hasClass(tipo)){
			$(this).hide();
		}
			else{
				$(this).show();
				
				}				   
			   });
	}	
})

})

$(window).on('load', function() {
	$("#marcaProdotto").change(function() {
	var tipo = $("#marcaProdotto option:selected").attr("value");
	
	if(tipo == 'Tutti'){
		$('.grid-item').each(function(i, obj) {
			$(this).show();})
		}
	else{
		$('.grid-item').each(function(i, obj) {
			
			if(!$(this).hasClass(tipo)){
			console.log($(this).attr("class"));
			$(this).hide();
		}
			else{
				$(this).show();
				
				}				   
			   });
	}	
})

})







