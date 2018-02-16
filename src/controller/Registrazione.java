
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistenceDAO.DataBaseManager;

public class Registrazione extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String email = req.getParameter("email");
		String dataNascita = req.getParameter("dataDiNascita");
		String numeroDiTelefono = req.getParameter("numeroDiTelefono");
		String password = req.getParameter("psw");
		String confirmPassword = req.getParameter("psw-repeat");

		if (password.equals(confirmPassword)) {

			DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ITALIAN);
			Date date = null;
			try {
				date = format.parse(dataNascita);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Utente utente = new Utente();
			utente.setCognomeUtente(cognome);
			utente.setNomeUtente(nome);
			utente.setEmailUtente(email);
			utente.setPasswordUtente(password);
			utente.setDatadiNascita(date);
			utente.setNumeroTelefonoUtente(numeroDiTelefono);

			DataBaseManager dbManager = new DataBaseManager();

			dbManager.getUtenteDao().save(utente);

			req.setAttribute("utente", utente);

			StringBuilder messaggio = new StringBuilder();
			messaggio.append("Gentile, " + utente.getNomeUtente() + " " + utente.getCognomeUtente() + ",\n");
			messaggio.append("la informiamo che la registrazione � stata effettuata con successo. \n\n");
			messaggio.append("Di seguito le credenziali di registrazione: \n");
			messaggio.append("Indirizzo email : " + utente.getEmailUtente() + "\n");
			messaggio.append("Password : " + utente.getPasswordUtente() + "\n");

			sendEmail(utente.getEmailUtente(), "Conferma registrazione", messaggio.toString());

			RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/index.jsp");
			dispacher.forward(req, resp);
		}

		else {

		}

	}

	public void sendEmail(String destinatario, String oggetto, String messaggio) {
		final String username = "tarredu.arredamenti@gmail.com";
		final String password = "Cacazza01!";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tarredu.arredamenti@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject(oggetto);
			message.setText(messaggio);

			Transport.send(message);


		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
