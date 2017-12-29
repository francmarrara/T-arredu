package test;

import persistenceDAO.DAOFactory;
import persistenceDAO.UtilDAO;

public class testDB {

	public static void main(String args[]) {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UtilDAO util = factory.getUtilDAO();

		util.dropDatabase();

		util.createDatabase();

	}

}
