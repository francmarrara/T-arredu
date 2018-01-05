package test;

import java.util.List;

import model.Prodotto;
import persistenceDAO.DataBaseManager;

public class testDB {

	public static void main(String args[]) {

		DataBaseManager dbManager = new DataBaseManager();
//		dbManager.dropDataBase();
//		dbManager.createDataBase();
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

List <Prodotto> prodotti = dbManager.getProdottoDao().findByTipo("Scrivania");

for(Prodotto p : prodotti) {
	p.stampaProdotto();
}

	}

}
