package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.ProdottoConImmagini;
import persistenceDAO.DAOFactory;

public class CarrelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String emailUtente = (String) session.getAttribute("emailUtenteLoggato");
		System.out.println(emailUtente);
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		Carrello carrello = factory.getCarrelloDAO().findByPrimaryKey(emailUtente);
		
		req.setAttribute("prodottiNelCarrello", carrello.getProdottiNelCarrello());

		RequestDispatcher dispacher = req.getRequestDispatcher("carrello.jsp");
		dispacher.forward(req, resp);

	}

}
