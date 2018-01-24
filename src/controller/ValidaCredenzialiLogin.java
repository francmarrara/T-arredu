package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistenceDAO.DataBaseManager;
import persistenceDAO.UtenteDAO;

public class ValidaCredenzialiLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("emailUtente");
		String passw = req.getParameter("psw");

		HttpSession session = req.getSession();

		DataBaseManager dbManager = new DataBaseManager();
		UtenteDAO utenteDao = dbManager.getUtenteDao();

		PrintWriter out = resp.getWriter();

		if (utenteDao.credenzialiUtenteGiaPresenti(email, passw)) {
			
			System.out.println("VERO  mail " + email + "  pass " + passw);

			session.setAttribute("utenteLoggato", true);
			RequestDispatcher dispatcher = req.getRequestDispatcher("");
			dispatcher.forward(req, resp);

		} else {

			System.out.println("FALSO  mail " + email + "  pass " + passw);
			
			session.setAttribute("utenteLoggato", false);
			RequestDispatcher dispatcher = req.getRequestDispatcher("");
			dispatcher.forward(req, resp);

		}
	}

}
