package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Commento;
import model.Prodotto;
import model.Venditore;
import persistenceDAO.DataBaseManager;

public class GetProdottoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6269492782108630350L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer idProdotto = Integer.parseInt(req.getParameter("id"));
		String emailUtente = null;

		if (req.getSession().getAttribute("emailUtenteLoggato") != null) {
			emailUtente = (String) (req.getSession().getAttribute("emailUtenteLoggato"));
		}

		DataBaseManager dbManager = new DataBaseManager();

		Prodotto p = dbManager.getProdottoDao().findByPrimaryKey(idProdotto);
		dbManager.getProdottoDao().visitPlusPlus(idProdotto);

		req.setAttribute("prodottoCercato", p);

		// LISTA FOTO

		List<String> immaginiProdotto = p.getUrlImmaginiProdotto();
		req.setAttribute("listaImmaginiProdotto", immaginiProdotto);
		req.setAttribute("dimensioneListaImmagini", immaginiProdotto.size());

		// LISTA COMMENTI

		List<Commento> commentiProdotto = p.getCommentiProdotto();
		req.setAttribute("listaCommentiProdotto", commentiProdotto);
		req.setAttribute("dimensioneListaCommenti", commentiProdotto.size());

		// LISTA VENDITORI
		List<Venditore> venditoriProdotto = p.getVenditoriProdotto();
		req.setAttribute("listaVenditoriProdotto", venditoriProdotto);

		// TROVA COMMENTO UTENTE PER PRODOTTO
		Commento commento = dbManager.getCommentoDao().getCommentoUtentePerProdotto(idProdotto, emailUtente);

		if (commento != null) {

			req.setAttribute("commentoPresente", commento);
		}

		RequestDispatcher dispacher = req.getRequestDispatcher("prodotto.jsp");
		dispacher.forward(req, resp);

	}

}
