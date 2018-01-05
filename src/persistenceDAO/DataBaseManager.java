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
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto("Dettagli eleganti ed essenziali per líarmadio a due ante scorrevoli \r\n"
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
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Giove Ë un armadio dalla linea importante, ma allo stesso tempo dal gusto classico \r\n"
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
		prodotto.setDisponibilit‡Prodotto(true);
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
		prodotto.setDisponibilit‡Prodotto(true);
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
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Funzionalit‡ ed estetica sono racchiuse nel settimino Atha, dove i 7 cassetti sono intervallati \r\n"
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
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Superfici che si incontrano e si abbracciano, accostate per generare nuove forme e nuovi dettagli.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

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
		comodinoZaffiro.setDescrizioneProdotto(
				"Comodino con tre cassetti, circondati da uníelegante " + "cornice arrotondata e dolcemente morbida. ");

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
		credenzaDyhana
				.setDescrizioneProdotto("Un elegante gioco di superfici rivela i cassetti centrali che racchiudono"
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
		credenzaGaya.setDescrizioneProdotto("La bellezza e líeleganza della forma pura,"
				+ " essenziale, che mostra tutta la sua forza espressiva Ë il segreto della credenza Gaya.");

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

		Prodotto cucinaLeGemmeComp1 = new Prodotto();

		cucinaLeGemmeComp1.setAmbienteProdotto("Cucina");
		cucinaLeGemmeComp1.setTipoProdotto("Cucina");
		cucinaLeGemmeComp1.setMarcaProdotto("Le Fablier");
		cucinaLeGemmeComp1.setNomeProdotto("Composizione 1 - Le Gemme");
		cucinaLeGemmeComp1.getColoriProdotto().add("Bianco");
		cucinaLeGemmeComp1.getColoriProdotto().add("Grigio");
		cucinaLeGemmeComp1.getColoriProdotto().add("Marrone");
		cucinaLeGemmeComp1.getVenditoriProdotto().add("info@antonellamazzei.it");
		cucinaLeGemmeComp1.setPrezzoProdotto(7650.00);
		cucinaLeGemmeComp1.setMisureProdotto("Misure in cm (LxPxH) 540x38/59x216");
		cucinaLeGemmeComp1.setDisponibilit‡Prodotto(true);
		cucinaLeGemmeComp1.setDescrizioneProdotto(
				"Forme e altezze diverse vengono " + "modulate per creare una nuova idea di spazio dove la cucina "
						+ "diventa anche zona living. Il top.");

		prodottoDao.save(cucinaLeGemmeComp1);

		Prodotto cucinaICigliegiComp1 = new Prodotto();

		cucinaICigliegiComp1.setAmbienteProdotto("Cucina");
		cucinaICigliegiComp1.setTipoProdotto("Cucina");
		cucinaICigliegiComp1.setMarcaProdotto("Le Fablier");
		cucinaICigliegiComp1.setNomeProdotto("Composizione 1 - I Ciliegi");
		cucinaICigliegiComp1.getColoriProdotto().add("Marrone");
		cucinaICigliegiComp1.getVenditoriProdotto().add("info@antonellamazzei.it");
		cucinaICigliegiComp1.setPrezzoProdotto(5894.00);
		cucinaICigliegiComp1.setMisureProdotto("Misure in cm (LxPxH) 360x38/59x216");
		cucinaICigliegiComp1.setDisponibilit‡Prodotto(true);
		cucinaICigliegiComp1.setDescrizioneProdotto(
				"Una cucina, che nasce dal gusto " + 
				"tradizionale  di un tempo, in cui qualit‡ e materiale " + 
				"fanno da protagonisti.");

		prodottoDao.save(cucinaICigliegiComp1);

	
		Prodotto cucinaMelogranoComp1 = new Prodotto();

		cucinaMelogranoComp1.setAmbienteProdotto("Cucina");
		cucinaMelogranoComp1.setTipoProdotto("Cucina");
		cucinaMelogranoComp1.setMarcaProdotto("Le Fablier");
		cucinaMelogranoComp1.setNomeProdotto("Composizione 1 - Melograno");
		cucinaMelogranoComp1.getColoriProdotto().add("Marrone");
		cucinaMelogranoComp1.getColoriProdotto().add("Bianco");
		cucinaMelogranoComp1.getColoriProdotto().add("Grigio");
		cucinaMelogranoComp1.getVenditoriProdotto().add("info@antonellamazzei.it");
		cucinaMelogranoComp1.setPrezzoProdotto(6419.00);
		cucinaMelogranoComp1.setMisureProdotto("Misure in cm (LxPxH) 360+90x59/38x215+35");
		cucinaMelogranoComp1.setDisponibilit‡Prodotto(true);
		cucinaMelogranoComp1.setDescrizioneProdotto(
				"Cucina Componibile. La struttura dei mobili" + 
				" e dei ripiani Ë realizzata con pannelli in particelle di legno" + 
				" a bassa emissione di formaldeide (classe E 1).");

		prodottoDao.save(cucinaMelogranoComp1);

	
	
	}

	public void createLibrerie() {

		Prodotto libreriaVeda = new Prodotto();

		libreriaVeda.setAmbienteProdotto("Studio");
		libreriaVeda.setTipoProdotto("Libreria");
		libreriaVeda.setMarcaProdotto("Le Fablier");
		libreriaVeda.setNomeProdotto("Veda");
		libreriaVeda.getColoriProdotto().add("Marrone");
		libreriaVeda.getColoriProdotto().add("Bianco");
		libreriaVeda.getColoriProdotto().add("Grigio");
		libreriaVeda.getVenditoriProdotto().add("info@antonellamazzei.it");
		libreriaVeda.setPrezzoProdotto(3721.00);
		libreriaVeda.setMisureProdotto("Misure in cm (LxPxH) 147x40x199");
		libreriaVeda.setDisponibilit‡Prodotto(true);
		libreriaVeda.setDescrizioneProdotto(
				"Libreria a giorno realizzata con struttura in legno massello di Rovere. Le superfici sono trattate" + 
				"con finiture speciali per esaltare la venatura del legno.");

		prodottoDao.save(libreriaVeda);
		

	}

	public void createIlluminazioni() {

		Prodotto prodotto = new Prodotto();

		// ILLUMINAZIONE LEFABLIER
		// ----------------------------------------------------------

		// Hari

		prodotto.getColoriProdotto().add("Nero");
		prodotto.getColoriProdotto().add("Oro");
		prodotto.getColoriProdotto().add("Bianco");
		prodotto.getColoriProdotto().add("Argento");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Hari");
		prodotto.setPrezzoProdotto(Double.parseDouble("774.00"));
		prodotto.setMisureProdotto("50cm x 180cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto("Lampada da terra e da tavolo con stelo in pirex trasparente e \r\n"
				+ "paralume in tessuto con filo e prese in coordinato con il paralume.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Reishi

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Ambra");
		prodotto.getColoriProdotto().add("Blu");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Reishi");
		prodotto.setPrezzoProdotto(Double.parseDouble("363.00"));
		prodotto.setMisureProdotto("15cm x 43cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Lampada da tavolo con struttra in pirex trasparente e bicchiere interno bianco, ambra o blu.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Zeta

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Zeta");
		prodotto.setPrezzoProdotto(Double.parseDouble("565.00"));
		prodotto.setMisureProdotto("21cm x 21cm x 52cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto("Lampada da comodino con struttura cromata e paralume in lino avorio.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Miss

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Giallo");
		prodotto.getColoriProdotto().add("Bianco");
		prodotto.getColoriProdotto().add("Nero");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Miss");
		prodotto.setPrezzoProdotto(Double.parseDouble("857.00"));
		prodotto.setMisureProdotto("48cm x 180cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Lampada con struttura cromata e stelo sagomato in pirex trasparente e paralume liscio bianco, giallo o nero.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

	}

	public void createLetti() {

		Prodotto prodotto = new Prodotto();

		// LETTI LEFABLIER
		// ----------------------------------------------------------

		// Deva

		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Deva");
		prodotto.setPrezzoProdotto(Double.parseDouble("1530.00"));
		prodotto.setMisureProdotto("173cm x 212cm x 115cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Uníelegante bordatura in Rovere massello racchiude la preziosit‡ della ricercata imbottitura della testata del letto Deva.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Sunrise

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Noce");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Sunrise");
		prodotto.setPrezzoProdotto(Double.parseDouble("4775.00"));
		prodotto.setMisureProdotto("175cm x 213cm x 101cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto("Letto con giroletto e testata sagomata imbottiti.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Silicio

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Bianco");
		prodotto.getColoriProdotto().add("Nero");
		prodotto.getColoriProdotto().add("Rosso");
		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Silicio");
		prodotto.setPrezzoProdotto(Double.parseDouble("1814.00"));
		prodotto.setMisureProdotto("172cm x 222cm x 111cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Morbidezza e calore esprime il letto Silicio. Líampia testiera imbottita, che puÚ essere rivestita in tessuto, in pelle o ecopelle, \r\n"
						+ "richiama le linee morbide e delicatamente voluttuose della testata e della pediera.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Ligustro

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Bianco");
		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Marrone");
		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Ligustro");
		prodotto.setPrezzoProdotto(Double.parseDouble("1097.00"));
		prodotto.setMisureProdotto("175cm x 222cm x 100cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Il letto Ligustro si compone di una testiera dalla forma rettilinea e squadrata, rifinita da una sofisticata imbottitura che avvolge anche la struttura del letto.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

	}

	public void createScrivanie() {
		
		Prodotto scrivaniaAtlas = new Prodotto();

		scrivaniaAtlas.setAmbienteProdotto("Studio");
		scrivaniaAtlas.setTipoProdotto("Scrivania");
		scrivaniaAtlas.setMarcaProdotto("Le Fablier");
		scrivaniaAtlas.setNomeProdotto("Atlas");
		scrivaniaAtlas.getColoriProdotto().add("Marrone");
		scrivaniaAtlas.getVenditoriProdotto().add("info@antonellamazzei.it");
		scrivaniaAtlas.setPrezzoProdotto(3572.00);
		scrivaniaAtlas.setMisureProdotto("Misure in cm (LxPxH) 200x90x78");
		scrivaniaAtlas.setDisponibilit‡Prodotto(true);
		scrivaniaAtlas.setDescrizioneProdotto(
				"Scrivania in linea classica.");
		
		prodottoDao.save(scrivaniaAtlas);
		
		
		
		
		Prodotto scrivaniaSummer = new Prodotto();

		scrivaniaSummer.setAmbienteProdotto("Studio");
		scrivaniaSummer.setTipoProdotto("Scrivania");
		scrivaniaSummer.setMarcaProdotto("Le Fablier");
		scrivaniaSummer.setNomeProdotto("Summer");
		scrivaniaSummer.getColoriProdotto().add("Marrone");
		scrivaniaSummer.getColoriProdotto().add("Nero");
		scrivaniaSummer.getVenditoriProdotto().add("info@antonellamazzei.it");
		scrivaniaSummer.setPrezzoProdotto(4591.00);
		scrivaniaSummer.setMisureProdotto("MMisure in cm (LxPxH) 180x87x77");
		scrivaniaSummer.setDisponibilit‡Prodotto(true);
		scrivaniaSummer.setDescrizioneProdotto(
				"Summer Ë una scrivania dallíaspetto scultoreo, perfetta allíinterno " + 
				"dello studio in cui si mostra in tutta la sua maestosit‡.");

		prodottoDao.save(scrivaniaSummer);

		
		Prodotto scrivaniaYoga = new Prodotto();

		scrivaniaYoga.setAmbienteProdotto("Studio");
		scrivaniaYoga.setTipoProdotto("Scrivania");
		scrivaniaYoga.setMarcaProdotto("Le Fablier");
		scrivaniaYoga.setNomeProdotto("Yoga");
		scrivaniaYoga.getColoriProdotto().add("Marrone");
		scrivaniaYoga.getColoriProdotto().add("Bianco");
		scrivaniaYoga.getColoriProdotto().add("Grigio");
		scrivaniaYoga.getVenditoriProdotto().add("info@antonellamazzei.it");
		scrivaniaYoga.setPrezzoProdotto(1436.00);
		scrivaniaYoga.setMisureProdotto("Misure in cm (LxPxH) 150x70x80");
		scrivaniaYoga.setDisponibilit‡Prodotto(true);
		scrivaniaYoga.setDescrizioneProdotto(
				"Forma sinuosa e ricercata per lo scrittoio Yoga," + 
				" che unisce la funzionalit‡ alla ricerca estetica.");

		prodottoDao.save(scrivaniaYoga);
		
		
		
	}

	public void createSedute() {

	}

	public void createTavoli() {

		Prodotto prodotto = new Prodotto();

		// TAVOLI LEFABLIER
		// ----------------------------------------------------------

		// Ekanta

		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Ekanta");
		prodotto.setPrezzoProdotto(Double.parseDouble("1822.00"));
		prodotto.setMisureProdotto("170/210cm x 90cm x 75cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Design fluido ed armonico per il tavolo Ekanta, caratterizzato da slanciate gambe in legno massello di Rovere che, unite alla struttura del piano del tavolo, \r\n"
						+ "conferiscono alla composizione una linea morbida ed elegante.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Tulipano

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrone");
		prodotto.getColoriProdotto().add("Avorio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Tulipano");
		prodotto.setPrezzoProdotto(Double.parseDouble("2042.00"));
		prodotto.setMisureProdotto("180/264cm x 90cm x 79cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto("Tavolo rettangolare allungabile, struttura in legno massello di ciliegio.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Cartesio

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrone");
		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Cartesio");
		prodotto.setPrezzoProdotto(Double.parseDouble("1765.00"));
		prodotto.setMisureProdotto("115/200cm x 115cm x 80cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Forma quadrata e accuratezza dei dettagli rendono il tavolo Cartesio un elemento di charme che diventa protagonista in ogni ambiente.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Muschio

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Bianco");
		prodotto.getColoriProdotto().add("Marrone");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Muschio");
		prodotto.setPrezzoProdotto(Double.parseDouble("1555.00"));
		prodotto.setMisureProdotto("220cm x 100cm x 75cm");
		prodotto.setDisponibilit‡Prodotto(true);
		prodotto.setDescrizioneProdotto(
				"Tavolo fisso in rovere dalle linee calde, con dimensioni che rimandano alla lavorazione artigianale.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

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
