package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistenceDAO.DataBaseManager;
import persistenceDAO.UtenteDAO;

public class VerificaEmail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emailDaVerificare = req.getParameter("email");
		
		DataBaseManager dbManager  = new DataBaseManager();
		
		UtenteDAO utenteDao = dbManager.getUtenteDao();
PrintWriter out = resp.getWriter();


	
		if(utenteDao.giaRegistrato(emailDaVerificare)) {
             out.write("true");		
		}
		else
		{
            out.write("false");		
	
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
}
