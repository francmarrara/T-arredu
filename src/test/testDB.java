package test;

import java.util.Calendar;
import model.Utente;
import persistenceDAO.DAOFactory;
import persistenceDAO.UtenteDAO;
import persistenceDAO.UtilDAO;

public class testDB {

	public static void main(String args[]) {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UtilDAO util = factory.getUtilDAO();
		UtenteDAO utenteDAO = factory.getUtenteDAO();

		util.dropDatabase();

		util.createDatabase();
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(1989, Calendar.NOVEMBER, 5); // // 5 Novembre 1989
		
		Utente utente = new Utente();
		
		utente.setNomeUtente("Francesco");
		utente.setCognomeUtente("Marrara");
		utente.setDatadiNascita(cal.getTime());
		utente.setEmailUtente("francmarrara@gmail.com");
		utente.setNumeroTelefonoUtente("3473139840");
		utente.setPasswordUtente("puppamilafava01!");
		
		utenteDAO.save(utente);

	}

}
