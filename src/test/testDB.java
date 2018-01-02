package test;

import java.util.Calendar;

import model.Preventivo;
import model.Prodotto;
import model.Utente;
import model.Venditore;
import persistenceDAO.DAOFactory;
import persistenceDAO.PreventivoDAO;
import persistenceDAO.ProdottoDAO;
import persistenceDAO.UtenteDAO;
import persistenceDAO.UtilDAO;
import persistenceDAO.VenditoreDAO;
import persistenceJDBC.VenditoreDaoJDBC;

public class testDB {

	public static void main(String args[]) {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UtilDAO util = factory.getUtilDAO();
		UtenteDAO utenteDAO = factory.getUtenteDAO();
		
		// Resetta e ricrea il DB
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
		
		utente.setCognomeUtente("Rossi");
		utenteDAO.update(utente);
		
		Venditore venditore = new Venditore();
		VenditoreDAO venditoreDao = factory.getVenditoreDAO();
		
		venditore.setNomeTitolare("Simone");
		venditore.setCognomeTitolare("Crisafi");
		venditore.setNomeNegozio("MannaiaDao Enterprise");
		venditore.setIndirizzoVenditore("Via paperino, 3");
		venditore.setNumeroTelefonicoVenditore("3477353491");
		venditore.setEmailVenditore("paperino@suca.it");
		
		venditoreDao.save(venditore);
		
		Prodotto prodotto = new Prodotto();
		ProdottoDAO prodottoDao = factory.getProdottoDAO();
		
		prodotto.setMarcaProdotto("Scavolini");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Tavolo da cucina");
		prodotto.setColoreProdotto("Bianco");
		prodotto.setPrezzoProdotto(Double.parseDouble("450,00"));
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto("Tavolo bianco per ambiente cucina");
		
		prodottoDao.save(prodotto);
		
		Preventivo preventivo = new Preventivo();
		PreventivoDAO preventivoDao = factory.getPreventivoDAO();
		
		cal.set(2018, Calendar.JANUARY, 2);
		preventivo.setDataOraPreventivo(cal.getTime());
		preventivo.setIdUtente(utente);
		preventivo.setIdVenditore(venditore);
		
		
		
	}

}
