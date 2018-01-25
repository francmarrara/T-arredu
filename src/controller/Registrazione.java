package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistenceDAO.DataBaseManager;

public class Registrazione extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String email = req.getParameter("email");
		String dataNascita = req.getParameter("dataDiNascita");
		String numeroDiTelefono = req.getParameter("numeroDiTelefono");
		String password = req.getParameter("psw");
		String confirmPassword = req.getParameter("psw-repeat");
		
		if(password.equals(confirmPassword)) {
		
		DateFormat format = new SimpleDateFormat
				("yyyy-mm-dd", Locale.ITALIAN);
        Date date = null;
        try {
			date = format.parse(dataNascita);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
		Utente utente = new Utente();
		utente.setCognomeUtente(cognome);
		utente.setNomeUtente(nome);
		utente.setEmailUtente(email);
		utente.setPasswordUtente(password);
		utente.setDatadiNascita(date);
		utente.setNumeroTelefonoUtente(numeroDiTelefono);
		
		
	
		
		DataBaseManager dbManager = new DataBaseManager();
		
		dbManager.getUtenteDao().save(utente);
		
		req.setAttribute("utente", utente);
				
		
		RequestDispatcher dispacher = 
				req.getRequestDispatcher
						("/WEB-INF/index.jsp");
		dispacher.forward(req, resp);
		}	
	
		else {
	
			
			
		}
	
	
	}
	
	
	
	
	
	

}
