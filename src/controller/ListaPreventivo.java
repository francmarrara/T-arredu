package controller;

import java.io.IOException;
import java.io.PrintWriter;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> master

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaPreventivo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] prodotti = req.getParameterValues("prodotti[]");
<<<<<<< HEAD
//		String[] richieste = req.getParameterValues("richieste[]");

		
		
=======

>>>>>>> master
//		ArrayList<ProdottoConImmagini> prodottiDaInserireNelPreventivo = new ArrayList<ProdottoConImmagini>();
//
//		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
//		ProdottoDAO prodottoDao = factory.getProdottoDAO();
<<<<<<< HEAD
		
		for (int i = 0; i < prodotti.length; i++) {
			System.out.println(prodotti[i]);
//			ProdottoConImmagini p = prodottoDao.findByPrimaryKeyProdottoConImmagini(Integer.parseInt(prodotti[i]));
//			p.setRichiestaAggiuntivaInPreventivo(richieste[i]);

//			prodottiDaInserireNelPreventivo.add(p);

=======
//
		for (int i = 0; i < prodotti.length; i++) {

		//	ProdottoConImmagini p = prodottoDao.findByPrimaryKeyProdottoConImmagini(Integer.parseInt(prodotti[i]));

System.out.println(prodotti[i]);
>>>>>>> master
		}
//
//		for (ProdottoConImmagini p : prodottiDaInserireNelPreventivo) {
//
//		}
<<<<<<< HEAD
		
		PrintWriter out = resp.getWriter();
		out.println(prodotti[0]);
		
		
=======

>>>>>>> master

		
		
	}

}
