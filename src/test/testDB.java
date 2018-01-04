package test;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import model.Carrello;
import model.Preventivo;
import model.Prodotto;
import model.Utente;
import model.Venditore;
import persistenceDAO.CarrelloDAO;
import persistenceDAO.DAOFactory;
import persistenceDAO.PreventivoDAO;
import persistenceDAO.ProdottoDAO;
import persistenceDAO.UtenteDAO;
import persistenceDAO.UtilDAO;
import persistenceDAO.VenditoreDAO;

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
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("StoTavolo");
		prodotto.setColoreProdotto("Bianco");
		prodotto.setPrezzoProdotto(Double.parseDouble("450.00"));
		prodotto.setMisureProdotto("200cm x 100cm x 50cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto("Tavolo bianco per ambiente cucina");
		prodotto.setVenditoreProdotto(venditore);

		prodottoDao.save(prodotto);

		Prodotto prodotto2 = new Prodotto();
		prodottoDao = factory.getProdottoDAO();

		prodotto2.setMarcaProdotto("Scavolini");
		prodotto2.setTipoProdotto("Tavolo");
		prodotto2.setAmbienteProdotto("Bagno");
		prodotto2.setNomeProdotto("BagnoTavolo");
		prodotto2.setColoreProdotto("Rosa");
		prodotto2.setPrezzoProdotto(Double.parseDouble("250.00"));
		prodotto2.setMisureProdotto("400cm x 400cm x 150cm");
		prodotto2.setDisponibilit‡Prodotto(true);
		prodotto2.setDescrizioneProdotto("Tavolo rosa per ambiente bagno");
		prodotto2.setVenditoreProdotto(venditore);

		prodottoDao.save(prodotto2);

		Carrello c = new Carrello();
		c.setUtenteCarello(utente);
		c.getProdottiNelCarrello().add(prodotto);
		c.getProdottiNelCarrello().add(prodotto2);

		CarrelloDAO carrelloDao = factory.getCArrelloDAO();
		carrelloDao.save(c);

		Preventivo preventivo = new Preventivo();
		PreventivoDAO preventivoDao = factory.getPreventivoDAO();

		preventivo.setUtente(utente);
		cal.set(2018, Calendar.JANUARY, 3);
		preventivo.setDataOraPreventivo(cal.getTime());

		preventivo.getListaProdotti().add(prodotto);
		preventivo.getListaProdotti().add(prodotto2);

		preventivoDao.save(preventivo);

		preventivoDao.addVenditoreToPreventivo(prodotto.getVenditoreProdotto(), preventivo);

		List<Prodotto> prodotti = prodottoDao.findByMarca("Scavolini");

		for (Prodotto p : prodotti) {
			p.stampaProdotto();
		}
	}

}
