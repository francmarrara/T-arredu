package test;

import java.util.Date;

import model.Commento;
import model.Utente;
import persistenceDAO.DataBaseManager;

public class testDB {

	public static void main(String args[]) {

		DataBaseManager dbManager = new DataBaseManager();

//		// DROP
//		long startDrop = System.currentTimeMillis();
//
//		dbManager.dropDataBase();
//
//		long endDrop = System.currentTimeMillis();
//
//		System.out.println("Il drop ha impiegato " + (endDrop - startDrop) / 1000 + " secondi");
//
//		// CREATE
//
//		long startCreate = System.currentTimeMillis();
//
//		dbManager.createDataBase();
//
//		long endCreate = System.currentTimeMillis();
//
//		System.out.println("Il create ha impiegato " + (endCreate - startCreate) / 1000 + " secondi");
//
//		// POPULATE
//
//		System.out.println("Populating....");
//		
//		long startPopulate = System.currentTimeMillis();
//
//		dbManager.createVenditori();
//		dbManager.createArmadi();
//		dbManager.createCassettiere();
//		dbManager.createComodini();
//		dbManager.createCredenze();
//		dbManager.createIlluminazioni();
//		dbManager.createLetti();
//		dbManager.createTavoli();
//		dbManager.createCucine();
//		dbManager.createLibrerie();
//		dbManager.createScrivanie();
//		dbManager.createSedie();
//     	dbManager.createPoltrone();
//		dbManager.createDivani();
//        dbManager.createVetrine();
//		dbManager.createBagni();
//		dbManager.createCameraDaLetto();
//
//		long endPopulate = System.currentTimeMillis();
//
//		System.out.println("Il Populate ha impiegato " + (endPopulate - startPopulate) / 1000 + " secondi");
//
//		// RECUPERO PRODOTTI
//
//		System.out.println("----------------");
//
//		System.out.println("----------------");
//
//		System.out.println("----------------");
//		
//		Utente utente = new Utente();
//		utente.setNomeUtente("Francesco");
//		utente.setCognomeUtente("Marrara");
//		utente.setEmailUtente("francmarrara@gmail.com");
//		utente.setPasswordUtente("Cacazza");
//		utente.setNumeroTelefonoUtente("09666666");
//		utente.setDatadiNascita(new Date(1, 1, 1998));
//		dbManager.getUtenteDao().save(utente);

//		dbManager.getUtenteDao().aggiungiProdottoInPreferiti(6, "francmarrara@gmail.com");
//		dbManager.getUtenteDao().aggiungiProdottoInPreferiti(7, "francmarrara@gmail.com");
//		dbManager.getUtenteDao().aggiungiProdottoInPreferiti(8, "francmarrara@gmail.com");

//		dbManager.getProdottoDao().visitPlusPlus(6);
//		dbManager.getProdottoDao().visitPlusPlus(6);
//		dbManager.getProdottoDao().visitPlusPlus(6);
//		dbManager.getProdottoDao().visitPlusPlus(7);
//		dbManager.getProdottoDao().visitPlusPlus(7);
//		dbManager.getProdottoDao().visitPlusPlus(8);
		
//		long startFind = System.currentTimeMillis();
//
//		
//	   List<ProdottoConImmagini> prodotti = dbManager.getProdottoDao().prodottiInOfferta();
//
//	long endFind = System.currentTimeMillis();
//	System.out.println((endFind-startFind)/1000);
//
//	   for(ProdottoConImmagini p : prodotti) {
//		   p.stampaProdotto();
//	   }
		
		//System.out.println(dbManager.getUtenteDao().giaRegistrato("francmarrara@gmail.com"));

		
		
		Commento c = new Commento();
		c.setIdProdotto(6);
		c.setEmailUtente("francmarrara@gmail.com");
		c.setValutazione(5);
		c.setCommento("Proprio un gran bell'acquisto!!!");

		dbManager.getCommentoDao().save(c);
		
		for(Commento comm : dbManager.getCommentoDao().findByProduct(6)) {
			c.stampaCommento();
		}
		
		
		
		
		
		
		
		
		
}
}