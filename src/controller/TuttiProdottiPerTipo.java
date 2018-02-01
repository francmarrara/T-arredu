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
import persistenceDAO.DAOFactory;

public class TuttiProdottiPerTipo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<ProdottoConImmagini> prodottiPerTipo = new ArrayList<>();
		List<String> marcheProdottiPerTipo = new ArrayList<>();
		
		String tipo = req.getParameter("tipo");
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		
		prodottiPerTipo = factory.getProdottoDAO().findProductsByAmbienteProdottiConImmagini(tipo);
		marcheProdottiPerTipo = factory.getProdottoDAO().getMarchePerAmbiente(tipo);
		
		
		req.setAttribute("prodotti", prodottiPerTipo);
		req.setAttribute("marcheProdotti", marcheProdottiPerTipo);
		
		
		RequestDispatcher dispacher = req.getRequestDispatcher("prodotti.jsp");
		dispacher.forward(req, resp);
		
	}
	
	
	
}
