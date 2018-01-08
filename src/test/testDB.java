package test;

import java.util.List;

import model.Prodotto;
import persistenceDAO.DataBaseManager;

public class testDB {

	public static void main(String args[]) {

		DataBaseManager dbManager = new DataBaseManager();

		// DROP
		long startDrop = System.currentTimeMillis();

		dbManager.dropDataBase();

		long endDrop = System.currentTimeMillis();

		System.out.println("Il drop ha impiegato " + (endDrop - startDrop) / 1000 + " secondi");

		// CREATE

		long startCreate = System.currentTimeMillis();

		dbManager.createDataBase();

		long endCreate = System.currentTimeMillis();

		System.out.println("Il create ha impiegato " + (endCreate - startCreate) / 1000 + " secondi");

		// POPULATE

		long startPopulate = System.currentTimeMillis();

		dbManager.createVenditori();
		dbManager.createArmadi();
		dbManager.createCassettiere();
		dbManager.createComodini();
		dbManager.createCredenze();
		dbManager.createIlluminazioni();
		dbManager.createLetti();
		dbManager.createTavoli();
		dbManager.createCucine();
		dbManager.createLibrerie();
		dbManager.createScrivanie();
		dbManager.createSedie();
		dbManager.createBagni();
		dbManager.createCameraDaLetto();
		dbManager.createPoltrone();

		long endPopulate = System.currentTimeMillis();

		System.out.println("Il Populate ha impiegato " + (endPopulate - startPopulate) / 1000 + " secondi");

		// RECUPERO PRODOTTI

//		long startFindProducts = System.currentTimeMillis();
//
//		List<Prodotto> prodotti = dbManager.getProdottoDao().findAll();
//
//		long endFindProducts = System.currentTimeMillis();
//
//		System.out.println("Il Find ha impiegato " + (endFindProducts - startFindProducts) / 1000 + " secondi");
//
//		System.out.println("----------------");
//
//		System.out.println("----------------");
//
//		System.out.println("----------------");
//		
//		System.out.println("STAMPA PRODOTTI");
//
//		for (Prodotto p : prodotti) {
//			p.stampaProdotto();
//		}

	}

}
