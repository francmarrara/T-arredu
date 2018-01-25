package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prodotto;
import persistenceDAO.DataBaseManager;

public class GetProdottoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	Integer idProdotto = Integer.parseInt(req.getParameter("id"));
	
	DataBaseManager dbManager = new DataBaseManager();
	
	
	Prodotto p = dbManager.getProdottoDao().findByPrimaryKey(idProdotto);
	
	HttpSession session = req.getSession();
	
	System.out.println(session.getAttribute("utenteLoggato"));
	session.setAttribute("prodottoCercato", p);
	session.setAttribute("utenteLoggato", true);
	RequestDispatcher dispacher = req.getRequestDispatcher("prodotto.jsp");
	dispacher.forward(req, resp);

	
		
	}

	
	
}
