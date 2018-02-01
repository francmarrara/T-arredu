package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoConImmagini;
import model.Venditore;
import persistenceDAO.DAOFactory;

public class VenditoreServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> marcheProdotti = new ArrayList<>();
		List<String> ambientiProdotti = new ArrayList<>();
		Venditore venditore = new Venditore();

		String email = (String) req.getParameter("id");

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		venditore = factory.getVenditoreDAO().findByPrimaryKey(email);
		req.setAttribute("venditore", venditore);
		
		List<ProdottoConImmagini> prodotti = factory.getProdottoDAO().findProductsByVenditoreProdottoConImmagini(email);

		req.setAttribute("prodotti", prodotti);

		marcheProdotti = factory.getProdottoDAO().getTutteLeMarche();
		req.setAttribute("marcheProdotti", marcheProdotti);
		req.setAttribute("ambientiProdotti", ambientiProdotti);

		RequestDispatcher dispacher = req.getRequestDispatcher("venditore.jsp");
		dispacher.forward(req, resp);

	}

}
