package test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.Prodotto;
import model.ProdottoConImmagini;
import model.Utente;
import persistenceDAO.DataBaseManager;
import persistenceDAO.UtenteDAO;

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


	   List<ProdottoConImmagini> prodotti = dbManager.getUtenteDao().getProdottiPreferitiConImmagini("francmarrara@gmail.com");

	   
	   for(ProdottoConImmagini p : prodotti) {
		   p.stampaProdotto();
	   }

}
}