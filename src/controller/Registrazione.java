package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registrazione extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		StringBuffer jsonReceived = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));		
		String line = reader.readLine();
		while (line != null){
			jsonReceived.append(line);
			line = reader.readLine();
		}		
		System.out.println(jsonReceived.toString());
		
//		String nome = req.getParameter("nome");
//		String cognome = req.getParameter("cognome");
//		String email = req.getParameter("email");
//		String dataNascita = req.getParameter("dataDiNascita");
//		String numeroDiTelefono = req.getParameter("numeroDiTelefono");
//		String password = req.getParameter("psw");
//		
//		if(password.equals(confirmPassword)) {
//		
//		DateFormat format = new SimpleDateFormat
//				("yyyy-mm-dd", Locale.ITALIAN);
//        Date date = null;
//        try {
//			date = format.parse(dataNascita);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        
//        
//		Utente utente = new Utente();
//		utente.setCognomeUtente(cognome);
//		utente.setNomeUtente(nome);
//		utente.setEmailUtente(email);
//		utente.setPasswordUtente(password);
//		utente.setDatadiNascita(date);
//		utente.setNumeroTelefonoUtente(numeroDiTelefono);
//		
//		
//	
//		
//		DataBaseManager dbManager = new DataBaseManager();
//		
//		dbManager.getUtenteDao().save(utente);
//		
//		req.setAttribute("utente", utente);
//				
//		
		RequestDispatcher dispacher = 
				req.getRequestDispatcher
						("index.jsp");
		dispacher.forward(req, resp);
		}	
	
		
	
	
	}
	
