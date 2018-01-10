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

// Pannello dei prodotti in offerta
$(document).ready(function() {
    window.onload = function() {
        $('.slider').slick({
            autoplay: true,
            autoplaySpeed: 1500,
            centerMode: true,
            slidesToShow: 3,
            slidesToScroll: 1
        });
    };
});