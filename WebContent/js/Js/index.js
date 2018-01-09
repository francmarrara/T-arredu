/*Allinea il menu all'header quando si scrolla la pagina */
$(document).ready(function() {
    /* affix the navbar after scroll below header */
    $(".navbar").affix({ offset: { top: $("header").outerHeight(true) } });
});