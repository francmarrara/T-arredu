package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistenceDAO.DAOFactory;


public class UtenteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7606660061220323902L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String emailUtente = (String) req.getSession().getAttribute("emailUtenteLoggato");
		
		Utente utente = new Utente();
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		
		utente = factory.getUtenteDAO().findByPrimaryKey(emailUtente);
		
		req.setAttribute("utente", utente);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("profiloUtente.jsp");
		dispacher.forward(req, resp);
		
		
	}
	
	

}