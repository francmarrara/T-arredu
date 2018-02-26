package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenceDAO.DAOFactory;

public class ImpostaImmagineComePrincipale extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		System.out.println("sono entrato");
		

		String urlImmagine = req.getParameter("urlImmagine");
		System.out.println(urlImmagine);

		Integer idProdotto = Integer.parseInt(req.getParameter("idProdotto"));

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		if (factory.getProdottoDAO().isImmaginePrincipale(idProdotto, urlImmagine)) {
			System.out.println("primo if");
			out.write("false");
		} else {
			factory.getProdottoDAO().setImmaginePrincipale(idProdotto, urlImmagine);
			System.out.println("secondo if");
			out.write("true");
		}

	}

}
