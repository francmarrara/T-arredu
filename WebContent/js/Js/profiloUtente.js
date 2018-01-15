// Menu Catalogo Prodotti - Mostra/Nascondi al passaggio del mouse
$(document).ready(function() {
    $("#catalogoProdotti").hover(function() {
        $(this).find("#menuProdotti").show(250);
    }, function() {
        $(this).find("#menuProdotti").hide(250);
    });
});

//