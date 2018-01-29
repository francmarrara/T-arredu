function effettuaLogout(){

	$.ajax({
		type : "GET",
		url : "effettuaLogout",

		success : function() {
			$("#snackbar").text("LOGOUT EFFETTUATO");
			$("#snackbar").css({
				'background-color' : 'green'
			});
			showSnackbar();
		
			window.setTimeout(location.reload(), 1000);
			//window.location.replace('index.jsp');
		
		}

	})
	
}