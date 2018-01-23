package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoConImmagini;
import persistenceDAO.DataBaseManager;
import persistenceDAO.ProdottoDAO;

public class IndexServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<ProdottoConImmagini> prodottiInOfferta = null;
		List<ProdottoConImmagini> prodottiPiuVisti = null;
		
		DataBaseManager dbManager = new DataBaseManager();
		
		ProdottoDAO prodotto = dbManager.getProdottoDao();
		
		prodottiInOfferta = prodotto.prodottiInOfferta();
		prodottiPiuVisti = prodotto.prodottiPerVisibilità();
		
		req.setAttribute("prodottiInOfferta", prodottiInOfferta);
		req.setAttribute("prodottiPiuVisti", prodottiPiuVisti);
		
		RequestDispatcher dispacher = 
				req.getRequestDispatcher
						("index.jsp");
		dispacher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
