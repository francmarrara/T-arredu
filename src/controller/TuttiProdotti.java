package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoConImmagini;
import persistenceDAO.DAOFactory;

public class TuttiProdotti extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		
		List<ProdottoConImmagini> prodotti = factory.getProdottoDAO().findAllProductWithImages();
		
		
		req.setAttribute("prodotti", prodotti);

		for(ProdottoConImmagini p : prodotti) {
			p.stampaProdotto();
		}
		
		
		RequestDispatcher dispacher = req.getRequestDispatcher("prodotti.jsp");
		dispacher.forward(req, resp);

		
		
	}
	
	
}
