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

		Prodotto prodotto = new Prodotto();

		// ARMADI LEFABLIER
		// ----------------------------------------------------------

		// Brahman

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Griglio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Brahman");
		prodotto.setPrezzoProdotto(Double.parseDouble("4039.00"));
		prodotto.setMisureProdotto("295cm x 67cm x 255cm");
		prodotto.setDisponibilit�Prodotto(true);
		prodotto.setDescrizioneProdotto("Dettagli eleganti ed essenziali per l�armadio a due ante scorrevoli \r\n"
				+ "Brahman dove un sottile profilo attraversa le ante scandendone la superficie in due parti.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Giove

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Giove");
		prodotto.setPrezzoProdotto(Double.parseDouble("3820.00"));
		prodotto.setMisureProdotto("296cm x 68cm x 253cm");
		prodotto.setDisponibilit�Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Giove � un armadio dalla linea importante, ma allo stesso tempo dal gusto classico \r\n"
						+ "ed elegante frutto della maestria artigianale made in Le Fablier.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Astro

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Nero");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Astro");
		prodotto.setPrezzoProdotto(Double.parseDouble("4490.00"));
		prodotto.setMisureProdotto("300cm x 65cm x 255cm");
		prodotto.setDisponibilit�Prodotto(true);
		prodotto.setDescrizioneProdotto("Armadio con due ante scorrevoli.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);
		
		// ----------------------------------------------------------

	}

	public void createCassettiere() {

		Prodotto prodotto = new Prodotto();

		// CASSETTIERE LEFABLIER
		// ----------------------------------------------------------

		// Ayurveda

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Griglio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Ayurveda");
		prodotto.setPrezzoProdotto(Double.parseDouble("1817.00"));
		prodotto.setMisureProdotto("65cm x 43cm x 160cm");
		prodotto.setDisponibilit�Prodotto(true);
		prodotto.setDescrizioneProdotto("Forma rigorosa e gusto sofisticato del dettaglio, linee che delicatamente \r\n"
				+ "avvolgono la forma, giochi di trasparenze e di dettagli sussurrati.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Atha

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Griglio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Atha");
		prodotto.setPrezzoProdotto(Double.parseDouble("1638.00"));
		prodotto.setMisureProdotto("74cm x 43cm x 130cm");
		prodotto.setDisponibilit�Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Funzionalit� ed estetica sono racchiuse nel settimino Atha, dove i 7 cassetti sono intervallati \r\n"
						+ "solo da una delicata fascia a definire la cura e la maestria della lavorazione del rovere, oltre al top a vassoio.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Zen

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Griglio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Zen");
		prodotto.setPrezzoProdotto(Double.parseDouble("2571.00"));
		prodotto.setMisureProdotto("110cm x 43cm x 160cm");
		prodotto.setDisponibilit�Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Superfici che si incontrano e si abbracciano, accostate per generare nuove forme e nuovi dettagli.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);
		
		// ----------------------------------------------------------

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