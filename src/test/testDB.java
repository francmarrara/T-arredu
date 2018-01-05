package test;

import persistenceDAO.DataBaseManager;

public class testDB {

	public static void main(String args[]) {
DataBaseManager dbManager = new DataBaseManager();
dbManager.dropDataBase();
dbManager.createDataBase();
dbManager.createVenditori();

<<<<<<< HEAD
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
//
		Prodotto prodotto = new Prodotto();
		ProdottoDAO prodottoDao = factory.getProdottoDAO();

		prodotto.getUrlImmaginiProdotto().add("img001.jpeg");
		prodotto.getUrlImmaginiProdotto().add("img002.jpeg");
		
		prodotto.setMarcaProdotto("Scavolini");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("StoTavolo");
		prodotto.getColoriProdotto().add("Bianco");
		prodotto.setPrezzoProdotto(Double.parseDouble("450.00"));
		prodotto.setMisureProdotto("200cm x 100cm x 50cm");
		prodotto.setDisponibilitàProdotto(true);
		prodotto.setDescrizioneProdotto("Tavolo bianco per ambiente cucina");
		prodotto.getVenditoriProdotto().add(venditore.getEmailVenditore());

		prodottoDao.save(prodotto);
//
		Prodotto prodotto2 = new Prodotto();
		prodottoDao = factory.getProdottoDAO();
		
		prodotto2.getColoriProdotto().add("Rosso");
		prodotto2.getColoriProdotto().add("Viola");
		prodotto2.getVenditoriProdotto().add(venditore.getEmailVenditore());

		prodotto2.setMarcaProdotto("Scavolini");
		prodotto2.setTipoProdotto("Tavolo");
		prodotto2.setAmbienteProdotto("Bagno");
		prodotto2.setNomeProdotto("BagnoTavolo");
		prodotto2.setPrezzoProdotto(Double.parseDouble("250.00"));
		prodotto2.setMisureProdotto("400cm x 400cm x 150cm");
		prodotto2.setDisponibilitàProdotto(true);
		prodotto2.setDescrizioneProdotto("Tavolo rosa per ambiente bagno");

		prodottoDao.save(prodotto2);

		Carrello c = new Carrello();
		c.setUtenteCarello(utente);
		c.getProdottiNelCarrello().add(prodotto);
		c.getProdottiNelCarrello().add(prodotto2);

		CarrelloDAO carrelloDao = factory.getCarrelloDAO();
		carrelloDao.save(c);

		Preventivo preventivo = new Preventivo();
		PreventivoDAO preventivoDao = factory.getPreventivoDAO();

		preventivo.setUtente(utente);
		cal.set(2018, Calendar.JANUARY, 3);
		preventivo.setDataOraPreventivo(cal.getTime());

		preventivo.getListaProdotti().add(prodotto);
		preventivo.getListaProdotti().add(prodotto2);
		preventivo.getListaVenditori().add(venditore);
=======
>>>>>>> master



	}

}
