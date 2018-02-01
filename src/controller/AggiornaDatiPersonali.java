package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistenceDAO.DAOFactory;

public class AggiornaDatiPersonali extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utente utente = new Utente();
		String emailVecchia = (String) req.getSession().getAttribute("emailUtenteLoggato");

		utente.setNomeUtente(req.getParameter("nome"));
		utente.setCognomeUtente(req.getParameter("cognome"));
		String data = ((req.getParameter("bday")));
		utente.setEmailUtente(req.getParameter("email"));
		utente.setNumeroTelefonoUtente((req.getParameter("recapitoTelefonicoUtente")));

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(data);
			utente.setDatadiNascita(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		utente.stampaUtente();
		System.out.println("vec " + emailVecchia);

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		factory.getUtenteDAO().update(utente, emailVecchia);

		req.getSession().setAttribute("emailUtenteLoggato", utente.getEmailUtente());
		req.getSession().setAttribute("nomeUtente", utente.getNomeUtente());

		resp.sendRedirect("utente");

	}

}