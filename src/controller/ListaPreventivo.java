package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoConImmagini;
import model.Venditore;
import persistenceDAO.DAOFactory;
import persistenceDAO.ProdottoDAO;

public class ListaPreventivo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

		System.out.println(venditoriEProdotti.toString());

		for (ProdottoConImmagini prodotto : prodottiDaInserireNelPreventivo) {

			venditoriEProdotti.get(prodotto.getEmailVenditore()).add(prodotto);

		}
		
		System.out.println(venditoriEProdotti.toString());

	}

}
