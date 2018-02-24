/* Inserimento immagini */
$(document).ready(
		function() {

			var contatore = $("#contatoreImmagini").val();

			$("#aggiungiImmagine").click(
					function() {
						contatore++;
						$(".listaImmagini ol").append(
								"<li><input type=" + "file" + " name=" + "pic"
										+ contatore + " accept=" + "image/*"
										+ "" + ">" + "</li>");

						$("#contatoreImmagini").val(contatore);
						return false;

					});

		});