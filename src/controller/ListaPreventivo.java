package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoConImmagini;
import persistenceDAO.DAOFactory;
import persistenceDAO.ProdottoDAO;

public class ListaPreventivo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] prodotti = req.getParameterValues("prodotti[]");
		String[] richieste = req.getParameterValues("richieste[]");

		ArrayList<ProdottoConImmagini> prodottiDaInserireNelPreventivo = new ArrayList<ProdottoConImmagini>();

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProdottoDAO prodottoDao = factory.getProdottoDAO();

		for (int i = 0; i < prodotti.length; i++) {
			
			ProdottoConImmagini p = prodottoDao.findByPrimaryKeyProdottoConImmagini(Integer.parseInt(prodotti[i]));
			p.setRichiestaAggiuntivaInPreventivo(richieste[i]);

			prodottiDaInserireNelPreventivo.add(p);

		}

		for (ProdottoConImmagini p : prodottiDaInserireNelPreventivo) {
		
		
		}

	}

}
