package test;

import persistenceDAO.DataBaseManager;

public class testDB {

	public static void main(String args[]) {
		
		DataBaseManager dbManager = new DataBaseManager();
		dbManager.dropDataBase();
		dbManager.createDataBase();
		dbManager.createVenditori();
		dbManager.createArmadi();
		dbManager.createCassettiere();

	}

}
