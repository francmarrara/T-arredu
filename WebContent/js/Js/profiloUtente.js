/*Allinea il menu all'header quando si scrolla la pagina con scomparsa */
$(document).ready(function() {
    /* affix the navbar after scroll below header */
    $(".navbar").affix({ offset: { top: $("header").outerHeight(true) } });

    $(window).scroll(function() {
        if ($(this).scrollTop() < 100) {
            $('.navbar').fadeIn(400);
        } else if ($(this).scrollTop() > 150) {
            $('.navbar').fadeIn(550);
        } else {
            $('.navbar').fadeOut(400);
        }

    })
});

// Menu Catalogo Prodotti - Mostra/Nascondi al passaggio del mouse
$(document).ready(function() {
    $("#catalogoProdotti").hover(function() {
        $(this).find("#menuProdotti").show(250);
    }, function() {
        $(this).find("#menuProdotti").hide(250);
    });
});