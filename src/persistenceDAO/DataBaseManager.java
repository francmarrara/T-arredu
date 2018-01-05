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
		
		comodinoSamsara.setAmbienteProdotto("Camera Da Letto");
		comodinoSamsara.setTipoProdotto("Comodino");
		comodinoSamsara.setMarcaProdotto("Le Fablier");
		comodinoSamsara.setNomeProdotto("Samsara");
		comodinoSamsara.getColoriProdotto().add("Bianco");
		comodinoSamsara.getVenditoriProdotto().add("info@antonellamazzei.it");
		comodinoSamsara.setPrezzoProdotto(516.00);
		comodinoSamsara.setMisureProdotto("Misure in cm (LxPxH) 55x38x51");
		comodinoSamsara.setDisponibilit‡Prodotto(true);
		comodinoSamsara.setDescrizioneProdotto("Piccolo scrigno di dettagli. Non solo comodino, "
				+ "ma emblema della ricerca della cura del dettaglio.");
		
		prodottoDao.save(comodinoSamsara);
	
		
		Prodotto comodinoZaffiro = new Prodotto();
		
		comodinoZaffiro.setAmbienteProdotto("Camera Da Letto");
		comodinoZaffiro.setTipoProdotto("Comodino");
		comodinoZaffiro.setMarcaProdotto("Le Fablier");
		comodinoZaffiro.setNomeProdotto("Zaffiro");
		comodinoZaffiro.getColoriProdotto().add("Bianco");
		comodinoZaffiro.getColoriProdotto().add("Nero");
		comodinoZaffiro.getColoriProdotto().add("Rosso");
		comodinoZaffiro.getColoriProdotto().add("Marrone");
		comodinoZaffiro.getVenditoriProdotto().add("info@antonellamazzei.it");
		comodinoZaffiro.setPrezzoProdotto(542.00);
		comodinoZaffiro.setMisureProdotto("Misure in cm (LxPxH) 54x35x66");
		comodinoZaffiro.setDisponibilit‡Prodotto(true);
		comodinoZaffiro.setDescrizioneProdotto("Comodino con tre cassetti, circondati da uníelegante "
				+ "cornice arrotondata e dolcemente morbida. ");
		
		prodottoDao.save(comodinoZaffiro);

		
		
		Prodotto comodinoGiglio = new Prodotto();
		comodinoGiglio.setAmbienteProdotto("Camera Da Letto");
		comodinoGiglio.setTipoProdotto("Comodino");
		comodinoGiglio.setMarcaProdotto("Le Fablier");
		comodinoGiglio.setNomeProdotto("Giglio");
		comodinoGiglio.getColoriProdotto().add("Bianco");
		comodinoGiglio.getColoriProdotto().add("Nero");
		comodinoGiglio.getColoriProdotto().add("Grigio");
		comodinoGiglio.getColoriProdotto().add("Marrone");
		comodinoGiglio.getVenditoriProdotto().add("info@antonellamazzei.it");
		comodinoGiglio.setPrezzoProdotto(436.00);
		comodinoGiglio.setMisureProdotto("Misure in cm ÿ42x60h");
		comodinoGiglio.setDisponibilit‡Prodotto(true);
		comodinoGiglio.setDescrizioneProdotto("Giglio Ë un comodo tavolino rotondo con piano díappoggio,"
				+ "la cui funzione Ë adattabile a diversi ambienti.");
		
		prodottoDao.save(comodinoGiglio);
		
		
	}
	
	public void createCredenze() {
		
		Prodotto credenzaDyhana = new Prodotto();
		credenzaDyhana.setAmbienteProdotto("Soggiorno");
		credenzaDyhana.setTipoProdotto("Credenza");
		credenzaDyhana.setMarcaProdotto("Le Fablier");
		credenzaDyhana.setNomeProdotto("Dyhana");
		credenzaDyhana.getColoriProdotto().add("Bianco");
		credenzaDyhana.getColoriProdotto().add("Grigio");
		credenzaDyhana.getVenditoriProdotto().add("info@antonellamazzei.it");
		credenzaDyhana.setPrezzoProdotto(2156.00);
		credenzaDyhana.setMisureProdotto("Misure in cm (LxPxH) 194x50x85");
		credenzaDyhana.setDisponibilit‡Prodotto(true);
		credenzaDyhana.setDescrizioneProdotto("Un elegante gioco di superfici rivela i cassetti centrali che racchiudono"
				+ " la sartorialit‡ artigianale della lavorazione del rovere, cosÏ come il ricercato top"
				+ " a vassoio, il delicato profilo che abbraccia tutto il mobile e lo zoccolo con piedi");
		
		prodottoDao.save(credenzaDyhana);
		
		Prodotto credenzaGaya = new Prodotto();
		credenzaGaya.setAmbienteProdotto("Soggiorno");
		credenzaGaya.setTipoProdotto("Credenza");
		credenzaGaya.setMarcaProdotto("Le Fablier");
		credenzaGaya.setNomeProdotto("Gaya");
		credenzaGaya.getColoriProdotto().add("Bianco");
		credenzaGaya.getColoriProdotto().add("Grigio");
		credenzaGaya.getColoriProdotto().add("Marrone");
		credenzaGaya.getVenditoriProdotto().add("info@antonellamazzei.it");
		credenzaGaya.setPrezzoProdotto(1701.00);
		credenzaGaya.setMisureProdotto("Misure in cm (LxPxH) 182x50x85");
		credenzaGaya.setDisponibilit‡Prodotto(true);
		credenzaGaya.setDescrizioneProdotto("La bellezza e líeleganza della forma pura,"+ 
				" essenziale, che mostra tutta la sua forza espressiva Ë il segreto della credenza Gaya.");
		
		prodottoDao.save(credenzaGaya);
		
		Prodotto credenzaClematide = new Prodotto();
		credenzaClematide.setAmbienteProdotto("Soggiorno");
		credenzaClematide.setTipoProdotto("Credenza");
		credenzaClematide.setMarcaProdotto("Le Fablier");
		credenzaClematide.setNomeProdotto("Clematide");
		credenzaClematide.getColoriProdotto().add("Bianco");
		credenzaClematide.getColoriProdotto().add("Grigio");
		credenzaClematide.getColoriProdotto().add("Marrone");
		credenzaClematide.getVenditoriProdotto().add("info@antonellamazzei.it");
		credenzaClematide.setPrezzoProdotto(2767.00);
		credenzaClematide.setMisureProdotto("Misure in cm (LxPxH) 197x53x88");
		credenzaClematide.setDisponibilit‡Prodotto(true);
		credenzaClematide.setDescrizioneProdotto("La credenza Clematide, Ë una credenza "
				+ "dallíaspetto rigoroso caratterizzata da una particolare anta scorrevole a pannelli in noce canaletto");
		
		prodottoDao.save(credenzaClematide);
		
		
		
		
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
