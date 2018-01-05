package persistenceDAO;

import model.Prodotto;
import model.Venditore;

public class DataBaseManager {
	
	private DAOFactory factory;
	private UtilDAO utilDao;
	
	private ProdottoDAO prodottoDao;
	private UtenteDAO utenteDao;
	private PreventivoDAO preventivoDao;
	private CarrelloDAO carrelloDao;
	private VenditoreDAO venditoreDao;
	
	public DataBaseManager() {

		factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		setUtilDao(factory.getUtilDAO());
		
		prodottoDao = factory.getProdottoDAO();
		utenteDao = factory.getUtenteDAO();
		preventivoDao = factory.getPreventivoDAO();
		carrelloDao = factory.getCarrelloDAO();
		venditoreDao = factory.getVenditoreDAO();
		
	}
	
	
	public void createVenditori() {
		
		Venditore mazzei = new Venditore();
		mazzei.setNomeNegozio("Antonella Mazzei Arredamenti");
		mazzei.setNomeTitolare("Antonella");
		mazzei.setCognomeTitolare("Mazzei");
		mazzei.setNumeroTelefonicoVenditore("+39 338 5378178");
		mazzei.setEmailVenditore("info@antonellamazzei.it");
		mazzei.setIndirizzoVenditore("Viale Cosmai 32,  87100 Cosenza  (di fronte Guardia di Finanza)");
		
		venditoreDao.save(mazzei);
	}
	
	
	
	public void createArmadi() {
		
		
		
	}
	
	public void createCassettiere() {
		
		
		
	}
	
	public void createComodini() {
		
		Prodotto comodinoSamsara = new Prodotto();
		
		
		
	}
	
	public void createCredenze() {
		
		
		
	}
	
	public void createCucine() {
		
		
		
	}
	
	public void createLibrerie() {
		
		
		
	}
	
	public void createIlluminazioni() {
		
		
		
	}
	
	public void createLetti() {
		
		
		
	}
	
	public void createScrivanie() {
		
		
		
	}
	
	public void createSedute() {
		
		
		
	}
	
	public void createTavoli() {
		
		
		
	}
	
	public void createVetrine() {
		
		
		
	}
	
	public void dropDataBase() {
		
		utilDao.dropDatabase();
		
	}
	
	public void createDataBase() {
		
		utilDao.createDatabase();
		
	}
	
	public DAOFactory getFactory() {
		return factory;
	}
	public void setFactory(DAOFactory factory) {
		this.factory = factory;
	}
	public ProdottoDAO getProdottoDao() {
		return prodottoDao;
	}
	public void setProdottoDao(ProdottoDAO prodottoDao) {
		this.prodottoDao = prodottoDao;
	}
	public UtenteDAO getUtenteDao() {
		return utenteDao;
	}
	public void setUtenteDao(UtenteDAO utenteDao) {
		this.utenteDao = utenteDao;
	}
	public PreventivoDAO getPreventivoDao() {
		return preventivoDao;
	}
	public void setPreventivoDao(PreventivoDAO preventivoDao) {
		this.preventivoDao = preventivoDao;
	}
	public CarrelloDAO getCarrelloDao() {
		return carrelloDao;
	}
	public void setCarrelloDao(CarrelloDAO carrelloDao) {
		this.carrelloDao = carrelloDao;
	}
	public VenditoreDAO getVenditoreDao() {
		return venditoreDao;
	}
	public void setVenditoreDao(VenditoreDAO venditoreDao) {
		this.venditoreDao = venditoreDao;
	}





	public UtilDAO getUtilDao() {
		return utilDao;
	}





	public void setUtilDao(UtilDAO utilDao) {
		this.utilDao = utilDao;
	}
	
	
}
