package persistenceDAO;

import persistenceJDBC.UtenteDaoJDBC;

@SuppressWarnings("deprecation")
class MySqlDAOFactory extends DAOFactory {

	
	
	private static  DataSource dataSource;
	

	// --------------------------------------------

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			setDataSource(new DataSource("jdbc:mysql://tarredudb.c8me4gj6vybs.eu-west-1.rds.amazonaws.com:3306/tarreduDB?autoReconnect=true&useSSL=false","tarredu","tarredu01"));
		} 
		catch (Exception e) {
			System.err.println("MySqlDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}


	public static DataSource getDataSource() {
		return dataSource;
	}


	public static void setDataSource(DataSource dataSource) {
		MySqlDAOFactory.dataSource = dataSource;
	}

	
	// --------------------------------------------
	
	@Override
	public UtilDAO getUtilDAO() {

		return new UtilDAO(dataSource);
		
	}


	@Override
	public UtenteDAO getUtenteDAO() {
		
		return new UtenteDaoJDBC(dataSource);
	}
	
	
	
}