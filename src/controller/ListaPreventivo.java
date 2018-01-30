package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProdottoConImmagini;
import persistenceDAO.DAOFactory;
import persistenceDAO.ProdottoDAO;

public class ListaPreventivo extends HttpServlet {
	private String emailUtente;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		setEmailUtente((String) req.getSession().getAttribute("emailUtenteLoggato"));
		
		
		String[] prodotti = req.getParameterValues("prodotti[]");
		String[] richieste = req.getParameterValues("richieste[]");

		ArrayList<ProdottoConImmagini> prodottiDaInserireNelPreventivo = new ArrayList<ProdottoConImmagini>();

		HashSet<String> listaVenditori = new HashSet<String>();

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProdottoDAO prodottoDao = factory.getProdottoDAO();

		for (int i = 0; i < prodotti.length; i++) {

			ProdottoConImmagini prodotto = prodottoDao.getProdottoPerPreventivo(Integer.parseInt(prodotti[i]));

			prodotto.setRichiestaAggiuntivaInPreventivo(richieste[i]);

			prodottiDaInserireNelPreventivo.add(prodotto);

			listaVenditori.add(prodotto.getEmailVenditore());

		}

		HashMap<String, List<ProdottoConImmagini>> venditoriEProdotti = new HashMap<String, List<ProdottoConImmagini>>();

		for (String venditori : listaVenditori) {

			List<ProdottoConImmagini> lista = new ArrayList<>();
			venditoriEProdotti.put(venditori, lista);

		}

		// System.out.println(venditoriEProdotti.toString());

		for (ProdottoConImmagini prodotto : prodottiDaInserireNelPreventivo) {

			venditoriEProdotti.get(prodotto.getEmailVenditore()).add(prodotto);

		}

		// System.out.println(venditoriEProdotti.toString());
		HttpSession session = req.getSession();
		//sendEmail();
		
	}

	public void sendEmail(String destinatario, String oggetto, String messaggio) {
		final String username = "tarredu.arredamenti@gmail.com";
		final String password = "Cacazza01!";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tarredu.arredamenti@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destinatario));
			message.setSubject(oggetto);
			message.setText(messaggio);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public String getEmailUtente() {
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

}
