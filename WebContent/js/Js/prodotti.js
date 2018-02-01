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