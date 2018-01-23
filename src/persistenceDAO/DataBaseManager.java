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

		// Antonella Mazzei Arredamenti, Cosenza

		Venditore mazzei = new Venditore();
		mazzei.setNomeNegozio("Antonella Mazzei Arredamenti");
		mazzei.setNomeTitolare("Antonella");
		mazzei.setCognomeTitolare("Mazzei");
		mazzei.setNumeroTelefonicoVenditore("+39 338 5378178");
		mazzei.setEmailVenditore("info@antonellamazzei.it");
		mazzei.setIndirizzoVenditore("Viale Cosmai 32, 87100 Cosenza (di fronte Guardia di Finanza)");

		venditoreDao.save(mazzei);

		// ----------------------------------------------------------

		// Scavolini Store, Cosenza

		Venditore scavoliniCosenza = new Venditore();
		scavoliniCosenza.setNomeNegozio("Scavolini Store Cosenza");
		scavoliniCosenza.setNomeTitolare("Gianluca");
		scavoliniCosenza.setCognomeTitolare("Mauro");
		scavoliniCosenza.setNumeroTelefonicoVenditore("0984 839164");
		scavoliniCosenza.setEmailVenditore("marazitamobilisas@libero.it");
		scavoliniCosenza.setIndirizzoVenditore("Via Verdi, 87036 Cosenza  (di fronte Guardia di Finanza)");

		venditoreDao.save(scavoliniCosenza);

		// ----------------------------------------------------------

		// Conforti Arredamenti, Rende

		Venditore confortiArredamenti = new Venditore();
		confortiArredamenti.setNomeNegozio("Conforti Arredamenti");
		confortiArredamenti.setNomeTitolare("Andrea");
		confortiArredamenti.setCognomeTitolare("Conforti");
		confortiArredamenti.setNumeroTelefonicoVenditore("0984 839164");
		confortiArredamenti.setEmailVenditore("info@confortiarredamenti.it");
		confortiArredamenti.setIndirizzoVenditore("S.S 107 Santo Stefano di Rende");

		venditoreDao.save(confortiArredamenti);

		// ----------------------------------------------------------
		// Poltrone e sof�, Rende

		Venditore poltroneSofa = new Venditore();
		poltroneSofa.setNomeNegozio("Poltrone & Sofa");
		poltroneSofa.setNomeTitolare("Mario");
		poltroneSofa.setCognomeTitolare("Rossi");
		poltroneSofa.setNumeroTelefonicoVenditore("0984 838196");
		poltroneSofa.setEmailVenditore("info@poltronesofarende.it");
		poltroneSofa.setIndirizzoVenditore("Via Giuseppe Verdi, 9, 87036 Quattromiglia CS");

		venditoreDao.save(poltroneSofa);

		// Arredamenti due pi, Rende

		Venditore arredamentiDuePi = new Venditore();
		arredamentiDuePi.setNomeNegozio("ArredamentiDuePi");
		arredamentiDuePi.setNomeTitolare("Bruno");
		arredamentiDuePi.setCognomeTitolare("Polillo");
		arredamentiDuePi.setNumeroTelefonicoVenditore("0984 1900082");
		arredamentiDuePi.setEmailVenditore("info@arredamentiduepi.it");
		arredamentiDuePi.setIndirizzoVenditore("S.S.19 G.Verdi Rende");

		venditoreDao.save(arredamentiDuePi);

		// ----------------------------------------------------------

	}

	public void createArmadi() {

		Prodotto prodotto = new Prodotto();

		// ARMADI LEFABLIER
		// ----------------------------------------------------------

		// Brahman

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Brahman");
		prodotto.setPrezzoProdotto(Double.parseDouble("4039.00"));
		prodotto.setMisureProdotto("295cm x 67cm x 255cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Dettagli eleganti ed essenziali per l�armadio a due ante scorrevoli \r\n"
				+ "Brahman dove un sottile profilo attraversa le ante scandendone la superficie in due parti.");
		prodotto.getUrlImmaginiProdotto().add("Brahman_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Brahman_02.jpg");

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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Giove � un armadio dalla linea importante, ma allo stesso tempo dal gusto classico \r\n"
						+ "ed elegante frutto della maestria artigianale made in Le Fablier.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Giove_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Giove_02.jpg");
		prodotto.getUrlImmaginiProdotto().add("Giove_03.jpg");

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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Armadio con due ante scorrevoli.");
		prodotto.getUrlImmaginiProdotto().add("Astro_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Astro_02.jpg");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// ARMADI MODULNOVA
		// ----------------------------------------------------------

		// MH6

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");

		prodotto.setMarcaProdotto("Modulnova");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("MH6");
		prodotto.setPrezzoProdotto(Double.parseDouble("3794.00"));
		prodotto.setMisureProdotto("500cm x 175cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Cucina ad isola MH6, con basi e fianchi in melaminico lava, top in laminato lava e piano snack in legno invecchiato abete nero.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("Mh6_01.jpg");
		prodottoDao.save(prodotto);

		// Twenty

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Beige");

		prodotto.setMarcaProdotto("Modulnova");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Twenty");
		prodotto.setPrezzoProdotto(Double.parseDouble("4500.00"));
		prodotto.setMisureProdotto("600cm x 200cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"In resina cemento grigio con lavabo in granito nero assoluto e penisola in legno massello sabbiato.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("Twenty_01.jpg");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// ARMADI FLOU
		// ----------------------------------------------------------

		// Epoque

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Flou");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Epoque");
		prodotto.setPrezzoProdotto(Double.parseDouble("1730.00"));
		prodotto.setMisureProdotto("288cm x 259cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"E' una gamma di armadi caratterizzata da materiali di pregio, accuratezza delle lavorazioni e ampia modularita e varieta di ante e maniglie.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("Epoque_01.jpg");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// ARMADI LEMA
		// ----------------------------------------------------------

		// Fina

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Lema");
		prodotto.setTipoProdotto("Armadio");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Fina");
		prodotto.setPrezzoProdotto(Double.parseDouble("3400.00"));
		prodotto.setMisureProdotto("600cm x 450cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Armadio quattro ante scorrevoli in vetro laccato con maniglia integrata nel profilo dell�anta. I pannelli presentano una cornice in alluminio anodizzato naturale.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("Fina_01.jpg");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

	}

	public void createCassettiere() {

		Prodotto prodotto = new Prodotto();

		// CASSETTIERE LEFABLIER
		// ----------------------------------------------------------

		// Ayurveda

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Ayurveda");
		prodotto.setPrezzoProdotto(Double.parseDouble("1817.00"));
		prodotto.setMisureProdotto("65cm x 43cm x 160cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Forma rigorosa e gusto sofisticato del dettaglio, linee che delicatamente \r\n"
				+ "avvolgono la forma, giochi di trasparenze e di dettagli sussurrati.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Ayurveda_01.jpg");

		prodottoDao.save(prodotto);

		// Atha

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Atha");
		prodotto.setPrezzoProdotto(Double.parseDouble("1638.00"));
		prodotto.setMisureProdotto("74cm x 43cm x 130cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Funzionalit� ed estetica sono racchiuse nel settimino Atha, dove i 7 cassetti sono intervallati \r\n"
						+ "solo da una delicata fascia a definire la cura e la maestria della lavorazione del rovere, oltre al top a vassoio.");
		prodotto.getUrlImmaginiProdotto().add("Atha_01.jpg");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// Zen

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Grigio");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Le Fablier");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Zen");
		prodotto.setPrezzoProdotto(Double.parseDouble("2571.00"));
		prodotto.setMisureProdotto("110cm x 43cm x 160cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Superfici che si incontrano e si abbracciano, accostate per generare nuove forme e nuovi dettagli.");
		prodotto.getUrlImmaginiProdotto().add("Zen_01.jpg");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// CASSETTIERE DALE ITALIA
		// ----------------------------------------------------------

		// SideBoard A-141

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Porada");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("SideBoard A-141");
		prodotto.setPrezzoProdotto(Double.parseDouble("2570.00"));
		prodotto.setMisureProdotto("200x80cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Cassettiera molto comoda, stile vintage.");

		prodotto.getVenditoriProdotto().add("info@confortiarredamenti.it");
		prodotto.getUrlImmaginiProdotto().add("SideBoard_01.jpg");

		prodottoDao.save(prodotto);

		// CASSETTIERE DUE PI
		// ----------------------------------------------------------

		// Piroette

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrore");
		prodotto.setMarcaProdotto("Porada");
		prodotto.setTipoProdotto("Cassettiera");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Piroette");
		prodotto.setPrezzoProdotto(2670.00);
		prodotto.setMisureProdotto("62x107");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Piroette � una cassettiera alta dotata di sette cassetti,"
				+ " caratterizzata dalla torsione dei frontali e realizzata in massello di noce.");
		prodotto.getUrlImmaginiProdotto().add("Piroette_01.jpg");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");

		prodottoDao.save(prodotto);

		// EILEEN

		Prodotto cassettieraEileen = new Prodotto();

		cassettieraEileen.setAmbienteProdotto("Soggiorno");
		cassettieraEileen.setTipoProdotto("Cassettiera");
		cassettieraEileen.setMarcaProdotto("Rimadesio");
		cassettieraEileen.setNomeProdotto("Eileen");
		cassettieraEileen.getColoriProdotto().add("Grigio");
		cassettieraEileen.getVenditoriProdotto().add("info@arredamentiduepi.it");
		cassettieraEileen.setPrezzoProdotto(3300.00);
		cassettieraEileen.setMisureProdotto("200x45x80");
		cassettieraEileen.setOffertaProdotto(true);
		cassettieraEileen.setDescrizioneProdotto(
				"Dotata di struttura di sostegno in acciaio inox, due ante scorrevoli complanari in vetro laccato opaco e ripiani interni in vetro laccato.");
		cassettieraEileen.getUrlImmaginiProdotto().add("Eileen_01.jpg");

		prodottoDao.save(cassettieraEileen);

		// PITAGORA

		Prodotto cassettieraPitagora = new Prodotto();

		cassettieraPitagora.setAmbienteProdotto("Camera da Letto");
		cassettieraPitagora.setTipoProdotto("Cassettiera");
		cassettieraPitagora.setMarcaProdotto("Novamobili");
		cassettieraPitagora.setNomeProdotto("Pitagora");
		cassettieraPitagora.getColoriProdotto().add("Marrone");
		cassettieraPitagora.getVenditoriProdotto().add("info@arredamentiduepi.it");
		cassettieraPitagora.setPrezzoProdotto(226.00);
		cassettieraPitagora.setMisureProdotto("110x53x76");
		cassettieraPitagora.setOffertaProdotto(true);
		cassettieraPitagora.setDescrizioneProdotto(
				"Cassettiera a quattro cassetti prevista in due misure nelle finiture ecolegno, materico e laccato opaco.");
		cassettieraPitagora.getUrlImmaginiProdotto().add("Pitagora_01.jpg");

		prodottoDao.save(cassettieraPitagora);

		// DOTTY

		Prodotto cassettieraDotty = new Prodotto();
		cassettieraDotty.setAmbienteProdotto("Camera da Letto");
		cassettieraDotty.setTipoProdotto("Cassettiera");
		cassettieraDotty.setMarcaProdotto("Novamobili");
		cassettieraDotty.setNomeProdotto("Dotty");
		cassettieraDotty.getColoriProdotto().add("Grigio");
		cassettieraDotty.getVenditoriProdotto().add("info@arredamentiduepi.it");
		cassettieraDotty.setPrezzoProdotto(497.00);
		cassettieraDotty.setMisureProdotto("130x53x72");
		cassettieraDotty.setOffertaProdotto(true);
		cassettieraDotty.setDescrizioneProdotto(
				"Cassettiera a quatto cassetti laccata opaco. I cassetti inferiori sono dotati di sistema di apertura push-pull.");
		cassettieraDotty.getUrlImmaginiProdotto().add("Dotty_01");
		prodottoDao.save(cassettieraDotty);

	}

	public void createComodini() {
		// COMODINI LEFABLIER
		// ----------------------------------------------------------

		// Samsara

		Prodotto comodinoSamsara = new Prodotto();

		comodinoSamsara.setAmbienteProdotto("Camera Da Letto");
		comodinoSamsara.setTipoProdotto("Comodino");
		comodinoSamsara.setMarcaProdotto("Le Fablier");
		comodinoSamsara.setNomeProdotto("Samsara");
		comodinoSamsara.getColoriProdotto().add("Bianco");
		comodinoSamsara.getVenditoriProdotto().add("info@antonellamazzei.it");
		comodinoSamsara.setPrezzoProdotto(516.00);
		comodinoSamsara.setMisureProdotto("Misure in cm (LxPxH) 55x38x51");
		comodinoSamsara.setOffertaProdotto(true);
		comodinoSamsara.setDescrizioneProdotto("Piccolo scrigno di dettagli. Non solo comodino, "
				+ "ma emblema della ricerca della cura del dettaglio.");
		comodinoSamsara.getUrlImmaginiProdotto().add("Samsara_01.jpg");

		prodottoDao.save(comodinoSamsara);

		// Zaffiro

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
		comodinoZaffiro.setOffertaProdotto(true);
		comodinoZaffiro.setDescrizioneProdotto(
				"Comodino con tre cassetti, circondati da un�elegante " + "cornice arrotondata e dolcemente morbida. ");
		comodinoZaffiro.getUrlImmaginiProdotto().add("Zaffiro_01.jpg");
		prodottoDao.save(comodinoZaffiro);

		// Giglio

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
		comodinoGiglio.setMisureProdotto("Misure in cm �42x60h");
		comodinoGiglio.setOffertaProdotto(true);
		comodinoGiglio.setDescrizioneProdotto("Giglio � un comodo tavolino rotondo con piano d�appoggio,"
				+ "la cui funzione � adattabile a diversi ambienti.");
		comodinoGiglio.getUrlImmaginiProdotto().add("Giglio_01.jpg");
		prodottoDao.save(comodinoGiglio);

		// ----------------------------------------------------------

	}

	public void createCredenze() {

		// CREDENZE LEFABLIER
		// ----------------------------------------------------------

		// Dyhana

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
		credenzaDyhana.setOffertaProdotto(true);
		credenzaDyhana
				.setDescrizioneProdotto("Un elegante gioco di superfici rivela i cassetti centrali che racchiudono"
						+ " la sartorialit� artigianale della lavorazione del rovere, cos� come il ricercato top"
						+ " a vassoio, il delicato profilo che abbraccia tutto il mobile e lo zoccolo con piedi");
		credenzaDyhana.getUrlImmaginiProdotto().add("Dyhana_01.jpg");
		prodottoDao.save(credenzaDyhana);

		// Gaya

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
		credenzaGaya.setOffertaProdotto(true);
		credenzaGaya.setDescrizioneProdotto("La bellezza e l�eleganza della forma pura,"
				+ " essenziale, che mostra tutta la sua forza espressiva � il segreto della credenza Gaya.");

		credenzaGaya.getUrlImmaginiProdotto().add("Gaya_01.jpg");
		credenzaGaya.getUrlImmaginiProdotto().add("Gaya_02.jpg");

		prodottoDao.save(credenzaGaya);

		// Clematide

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
		credenzaClematide.setOffertaProdotto(true);
		credenzaClematide.setDescrizioneProdotto("La credenza Clematide, � una credenza "
				+ "dall�aspetto rigoroso caratterizzata da una particolare anta scorrevole a pannelli in noce canaletto");
		credenzaClematide.getUrlImmaginiProdotto().add("Clematide_01.jpg");
		prodottoDao.save(credenzaClematide);

	}

	public void createCucine() {

		// CUCINE LEFABLIER
		// ----------------------------------------------------------

		// Le Gemme Comp 1

		Prodotto cucina = new Prodotto();

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Le Fablier");
		cucina.setNomeProdotto("Composizione 1 - Le Gemme");
		cucina.getColoriProdotto().add("Bianco");
		cucina.getColoriProdotto().add("Grigio");
		cucina.getColoriProdotto().add("Marrone");
		cucina.getVenditoriProdotto().add("info@antonellamazzei.it");
		cucina.setPrezzoProdotto(7650.00);
		cucina.setMisureProdotto("Misure in cm (LxPxH) 540x38/59x216");
		cucina.setOffertaProdotto(true);
		cucina.setDescrizioneProdotto(
				"Forme e altezze diverse vengono " + "modulate per creare una nuova idea di spazio dove la cucina "
						+ "diventa anche zona living. Il top.");
		cucina.getUrlImmaginiProdotto().add("LeGemme_01.jpg");
		cucina.getUrlImmaginiProdotto().add("LeGemme_02.jpg");

		prodottoDao.save(cucina);

		// I Ciliegi Comp 1

		Prodotto cucinaICigliegiComp1 = new Prodotto();

		cucinaICigliegiComp1.setAmbienteProdotto("Cucina");
		cucinaICigliegiComp1.setTipoProdotto("Cucina");
		cucinaICigliegiComp1.setMarcaProdotto("Le Fablier");
		cucinaICigliegiComp1.setNomeProdotto("Composizione 1 - I Ciliegi");
		cucinaICigliegiComp1.getColoriProdotto().add("Marrone");
		cucinaICigliegiComp1.getVenditoriProdotto().add("info@antonellamazzei.it");
		cucinaICigliegiComp1.setPrezzoProdotto(5894.00);
		cucinaICigliegiComp1.setMisureProdotto("Misure in cm (LxPxH) 360x38/59x216");
		cucinaICigliegiComp1.setOffertaProdotto(true);
		cucinaICigliegiComp1.setDescrizioneProdotto("Una cucina, che nasce dal gusto "
				+ "tradizionale  di un tempo, in cui qualit� e materiale " + "fanno da protagonisti.");
		cucinaICigliegiComp1.getUrlImmaginiProdotto().add("iCiliegi_01.jpg");
		cucinaICigliegiComp1.getUrlImmaginiProdotto().add("iCiliegi_02.jpg");
		cucinaICigliegiComp1.getUrlImmaginiProdotto().add("iCiliegi_03.jpg");

		prodottoDao.save(cucinaICigliegiComp1);

		// Melograno Comp 1

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
		cucinaMelogranoComp1.setOffertaProdotto(true);
		cucinaMelogranoComp1.setDescrizioneProdotto("Cucina Componibile. La struttura dei mobili"
				+ " e dei ripiani � realizzata con pannelli in particelle di legno"
				+ " a bassa emissione di formaldeide (classe E 1).");
		cucinaMelogranoComp1.getUrlImmaginiProdotto().add("Melograno_01.jpg");
		cucinaMelogranoComp1.getUrlImmaginiProdotto().add("Melograno_02.jpg");

		prodottoDao.save(cucinaMelogranoComp1);

		// ----------------------------------------------------------

		// CUCINE SCAVOLINI
		// ----------------------------------------------------------

		// Madeleine

		cucina = new Prodotto();

		cucina.getColoriProdotto().add("Bianco");

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Scavolini");
		cucina.setNomeProdotto("Madeleiene");
		cucina.getVenditoriProdotto().add("marazitamobilisas@libero.it");
		cucina.setPrezzoProdotto(8043.00);
		cucina.setMisureProdotto("270x240x254");
		cucina.setOffertaProdotto(true);
		cucina.setDescrizioneProdotto(
				"Cucina Scavolini modello Madeleine angolare in legno castagno con tavolo e n.4 sedie.\n"
						+ "N.2 pensili a vetrina, colonna frigo comprensiva di frigorifero Ariston. Lavello Franke 2 vasche in Fragranite.");
		cucina.getUrlImmaginiProdotto().add("Madeleiene_01.jpg");
		prodottoDao.save(cucina);

		// Sax

		cucina = new Prodotto();

		cucina.getColoriProdotto().add("Bianco");

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Scavolini");
		cucina.setNomeProdotto("Sax");
		cucina.getVenditoriProdotto().add("marazitamobilisas@libero.it");
		cucina.setPrezzoProdotto(9500.00);
		cucina.setMisureProdotto("245x275x215");
		cucina.setOffertaProdotto(true);
		cucina.setDescrizioneProdotto(
				"La cucina ideale per chi ama l�essenzialita� delle forme,il design semplice ed attuale. Il modello Sax appartenendo alla linea �Basic� , ha dei costi molto contenuti,pur avendo a disposizione svariate finiture e numerose varianti di colore.");
		cucina.getUrlImmaginiProdotto().add("Sax_01.jpg");
		prodottoDao.save(cucina);

		// Grand Relais

		cucina = new Prodotto();

		cucina.getColoriProdotto().add("Beige");

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Scavolini");
		cucina.setNomeProdotto("Grand Relais");
		cucina.getVenditoriProdotto().add("marazitamobilisas@libero.it");
		cucina.setPrezzoProdotto(9750.00);
		cucina.setMisureProdotto("435x225");
		cucina.setOffertaProdotto(true);
		cucina.setDescrizioneProdotto(
				"Cucina Scavolini, modello Grand Relais con ante in finitutra nera, fornita di 2 colonne estraibili da 15cm.");
		cucina.getUrlImmaginiProdotto().add("Grand_Relais_01.jpg");
		prodottoDao.save(cucina);

		// ----------------------------------------------------------

		// CUCINE PEDINI
		// ----------------------------------------------------------

		// Arke

		cucina = new Prodotto();

		cucina.getColoriProdotto().add("Bianco");
		cucina.getColoriProdotto().add("Grigio");

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Pedini");
		cucina.setNomeProdotto("Arke");
		cucina.getVenditoriProdotto().add("info@confortiarredamenti.it");
		cucina.setPrezzoProdotto(9850.00);
		cucina.setMisureProdotto("800x300cm");
		cucina.setOffertaProdotto(true);
		cucina.setDescrizioneProdotto(
				"Arke accosta alla vasta gamma di materiali, finiture e colori una varieta' di legni pregiati, per dar vita a progetti destinati all�eccellenza.");
		cucina.getUrlImmaginiProdotto().add("Arke_01.jpg");
		prodottoDao.save(cucina);

		// Artika

		cucina = new Prodotto();

		cucina.getColoriProdotto().add("Bianco");

		cucina.setAmbienteProdotto("Cucina");
		cucina.setTipoProdotto("Cucina");
		cucina.setMarcaProdotto("Pedini");
		cucina.setNomeProdotto("Artika");
		cucina.getVenditoriProdotto().add("info@confortiarredamenti.it");
		cucina.setPrezzoProdotto(11550.00);
		cucina.setMisureProdotto("750x250cm");
		cucina.setOffertaProdotto(true);
		cucina.setDescrizioneProdotto("Artika rappresenta una cucina completa suddivisa in due blocchi.");
		cucina.getUrlImmaginiProdotto().add("Artika_01.jpg");

		prodottoDao.save(cucina);

	}

	public void createCameraDaLetto() {

		// CAMERE DA LETTO GIESSEGI
		// ----------------------------------------------------------

		// New Moon

		Prodotto cameraDaLetto = new Prodotto();

		cameraDaLetto.setAmbienteProdotto("Camera da Letto");
		cameraDaLetto.setTipoProdotto("Camera da Letto");
		cameraDaLetto.setMarcaProdotto("Giessegi");
		cameraDaLetto.setNomeProdotto("New Moon");
		cameraDaLetto.getColoriProdotto().add("Bianco");
		cameraDaLetto.getVenditoriProdotto().add("info@antonellamazzei.it");
		cameraDaLetto.setPrezzoProdotto(4930.00);
		cameraDaLetto.setMisureProdotto("Misure in cm (LxPxH) 277x66x262");
		cameraDaLetto.setOffertaProdotto(true);
		cameraDaLetto.setDescrizioneProdotto("Camera matrimoniale completa.");
		cameraDaLetto.getUrlImmaginiProdotto().add("NewMoon_01.jpg");
		prodottoDao.save(cameraDaLetto);

		// ----------------------------------------------------------

		// CAMERE DA LETTO DUEPI
		// ----------------------------------------------------------

		// Terra R02

		Prodotto cameraLettoTerraR02 = new Prodotto();

		cameraLettoTerraR02.setAmbienteProdotto("Camera da Letto");
		cameraLettoTerraR02.setTipoProdotto("Camera da Letto");
		cameraLettoTerraR02.setMarcaProdotto("Nardi Interni");
		cameraLettoTerraR02.setNomeProdotto("Terra R02");
		cameraLettoTerraR02.getColoriProdotto().add("Grigio");
		cameraLettoTerraR02.getColoriProdotto().add("Lilla");
		cameraLettoTerraR02.getVenditoriProdotto().add("info@arredamentiduepi.it");
		cameraLettoTerraR02.setPrezzoProdotto(2025.00);
		cameraLettoTerraR02.setMisureProdotto("Misure in cm (LxPxH) 168x220x92");
		cameraLettoTerraR02.setOffertaProdotto(true);
		cameraLettoTerraR02.setDescrizioneProdotto(
				"Letto matrimoniale Notturno 2 con rivestimento in tessuto e base H 25 cm con piano a doghe regolabili.");
		cameraLettoTerraR02.getUrlImmaginiProdotto().add("TerraR02_01.jpg");
		prodottoDao.save(cameraLettoTerraR02);

		// CAMERE DA LETTO NARDI INTERNI
		// ----------------------------------------------------------

		// Terra R04

		cameraDaLetto = new Prodotto();

		cameraDaLetto.setAmbienteProdotto("Camera da Letto");
		cameraDaLetto.setTipoProdotto("Camera da Letto");
		cameraDaLetto.setMarcaProdotto("Nardi Interni");
		cameraDaLetto.setNomeProdotto("Terra R04");
		cameraDaLetto.getColoriProdotto().add("Lilla");
		cameraDaLetto.getColoriProdotto().add("Grigio");
		cameraDaLetto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		cameraDaLetto.setPrezzoProdotto(3100.00);
		cameraDaLetto.setMisureProdotto("-");
		cameraDaLetto.setOffertaProdotto(true);
		cameraDaLetto.setDescrizioneProdotto(
				"Spazio Ragazzi � un programma completo per la cameretta, che si articola attraverso composizioni con letti a terra, soluzioni con letti inseriti fra o sotto armadi a ponte e composizioni salvaspazio.");
		cameraDaLetto.getUrlImmaginiProdotto().add("TerraR04_01.jpg");
		prodottoDao.save(cameraDaLetto);

		// ----------------------------------------------------------

	}

	public void createLibrerie() {

		// LIBRERIE LEFABLIER
		// ----------------------------------------------------------

		// Veda

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
		libreriaVeda.setOffertaProdotto(true);
		libreriaVeda.setDescrizioneProdotto(
				"Libreria a giorno realizzata con struttura in legno massello di Rovere. Le superfici sono trattate"
						+ "con finiture speciali per esaltare la venatura del legno.");
		libreriaVeda.getUrlImmaginiProdotto().add("Veda_01.jpg");
		prodottoDao.save(libreriaVeda);

		// ----------------------------------------------------------

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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Lampada da terra e da tavolo con stelo in pirex trasparente e \r\n"
				+ "paralume in tessuto con filo e prese in coordinato con il paralume.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Hari_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Hari_02.jpg");
		prodotto.getUrlImmaginiProdotto().add("Hari_03.jpg");
		prodotto.getUrlImmaginiProdotto().add("Hari_04.jpg");

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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Lampada da tavolo con struttra in pirex trasparente e bicchiere interno bianco, ambra o blu.");
		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Reishi_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Reishi_02.jpg");
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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Lampada da comodino con struttura cromata e paralume in lino avorio.");
		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Zeta_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Zeta_02.jpg");
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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Lampada con struttura cromata e stelo sagomato in pirex trasparente e paralume liscio bianco, giallo o nero.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");

		prodotto.getUrlImmaginiProdotto().add("Miss_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Miss_02.jpg");
		prodotto.getUrlImmaginiProdotto().add("Miss_03.jpg");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// ILLUMINAZIONE ARTEMIDE
		// ----------------------------------------------------------

		// Harry H

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Argento");

		prodotto.setMarcaProdotto("Artemide");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Harry H");
		prodotto.setPrezzoProdotto(Double.parseDouble("184.00"));
		prodotto.setMisureProdotto("47cm D");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"La lampada Harry H. e' un sistema ibrido che affianca LED e OLED valorizzando i pregi delle due tecnologie e combinandoli per offrire il massimo delle performance.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("HarryH_01.jpg");
		prodottoDao.save(prodotto);

		// Lana

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Artemide");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Lana");
		prodotto.setPrezzoProdotto(Double.parseDouble("127.00"));
		prodotto.setMisureProdotto("12cm x 150cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Un�innovativa ottica stampata in policarbonato trasparente permette di guidare il flusso emesso dalla sorgente LED fino alla sezione di uscita.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("Lana_01.jpg");

		prodottoDao.save(prodotto);

		// Mendori

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Artemide");
		prodotto.setTipoProdotto("Illuminazione");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Mendori");
		prodotto.setPrezzoProdotto(Double.parseDouble("651.00"));
		prodotto.setMisureProdotto("48cm x 50cm x 44cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Lampada da tavolo Mendori con sorgente a LED 8W, 3000K dimmer. IN-EI � un serie di lampade che si declina in tre varianti: a sospensione, da tavolo, da terra.");
		prodotto.getUrlImmaginiProdotto().add("Mendori_01.jpg");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

	}

	public void createBagni() {

		// BAGNI SCAVOLINI
		// ----------------------------------------------------------

		// Idro

		Prodotto bagno = new Prodotto();

		bagno.getColoriProdotto().add("Blu");

		bagno.setAmbienteProdotto("Bagno");
		bagno.setTipoProdotto("Bagno");
		bagno.setMarcaProdotto("Scavolini");
		bagno.setNomeProdotto("Idro");
		bagno.getVenditoriProdotto().add("marazitamobilisas@libero.it");
		bagno.setPrezzoProdotto(7670.00);
		bagno.setMisureProdotto("200x250");
		bagno.setOffertaProdotto(true);
		bagno.setDescrizioneProdotto(
				"Questa composizione del modello idro di Scavolini Bathrooms offre la possibilit� di creare eleganti soluzioni d'arredo anche per gli spazi ridotti.");
		bagno.getUrlImmaginiProdotto().add("Idro_01.jpg");
		prodottoDao.save(bagno);

		// Lagu

		bagno = new Prodotto();

		bagno.getColoriProdotto().add("Bianco");

		bagno.setAmbienteProdotto("Bagno");
		bagno.setTipoProdotto("Bagno");
		bagno.setMarcaProdotto("Scavolini");
		bagno.setNomeProdotto("Lagu");
		bagno.getVenditoriProdotto().add("marazitamobilisas@libero.it");
		bagno.setPrezzoProdotto(4150.00);
		bagno.setMisureProdotto("275x300");
		bagno.setOffertaProdotto(true);
		bagno.setDescrizioneProdotto(
				"Composizione molto attuale e completa particolarmente adatta a bagni abbastanza stretti.");
		bagno.getUrlImmaginiProdotto().add("Lagu_01.jpg");

		prodottoDao.save(bagno);

		// Rivo

		bagno = new Prodotto();

		bagno.getColoriProdotto().add("Bianco");

		bagno.setAmbienteProdotto("Bagno");
		bagno.setTipoProdotto("Bagno");
		bagno.setMarcaProdotto("Scavolini");
		bagno.setNomeProdotto("Rivo");
		bagno.getVenditoriProdotto().add("marazitamobilisas@libero.it");
		bagno.setPrezzoProdotto(5845.00);
		bagno.setMisureProdotto("320x275");
		bagno.setOffertaProdotto(true);
		bagno.setDescrizioneProdotto(
				"Altissima qualit� per l�arredo bagno Scavolini modello Rivo impiallacciato legno. Base lavabo impiallacciata legno laccato opaco Frassino Visone composta da due basi con cassettoni.");
		bagno.getUrlImmaginiProdotto().add("Rivo_01.jpg");

		prodottoDao.save(bagno);

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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Un�elegante bordatura in Rovere massello racchiude la preziosit� della ricercata imbottitura della testata del letto Deva.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Deva_01.jpg");
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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Letto con giroletto e testata sagomata imbottiti.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Sunrise_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Sunrise_02.jpg");

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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Morbidezza e calore esprime il letto Silicio. L�ampia testiera imbottita, che pu� essere rivestita in tessuto, in pelle o ecopelle, \r\n"
						+ "richiama le linee morbide e delicatamente voluttuose della testata e della pediera.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Silicio_01.jpg");

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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Il letto Ligustro si compone di una testiera dalla forma rettilinea e squadrata, rifinita da una sofisticata imbottitura che avvolge anche la struttura del letto.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Ligustro_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Ligustro_02.jpg");
		prodotto.getUrlImmaginiProdotto().add("Ligustro_03.jpg");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// LETTI FLOU
		// ----------------------------------------------------------

		// Angle

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Beige");
		prodotto.getColoriProdotto().add("Bianco");

		prodotto.setMarcaProdotto("Flou");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Angle");
		prodotto.setPrezzoProdotto(Double.parseDouble("2670.00"));
		prodotto.setMisureProdotto("184cm x 235cm x 130cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Letto matrimoniale Angle, previsto in versione semplice o con paravento. La testata imbottita � disponibile in versione liscia o trapuntata capitonn� con rivestimento totalmente sfoderabile in tessuto o pelle.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("Angle_01.jpg");
		prodottoDao.save(prodotto);

		// Notturno

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Amaranto");

		prodotto.setMarcaProdotto("Flou");
		prodotto.setTipoProdotto("Letto");
		prodotto.setAmbienteProdotto("Camera da Letto");
		prodotto.setNomeProdotto("Notturno");
		prodotto.setPrezzoProdotto(Double.parseDouble("2025.00"));
		prodotto.setMisureProdotto("168cm x 220cm x 92cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Letto matrimoniale Notturno 2 con rivestimento in tessuto e base H 25 cm con piano a doghe regolabili.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("Notturno_01.jpg");
		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

	}

	public void createScrivanie() {

		// SCRIVANIE LEFABLIER
		// ----------------------------------------------------------

		// Atlas

		Prodotto scrivaniaAtlas = new Prodotto();

		scrivaniaAtlas.setAmbienteProdotto("Studio");
		scrivaniaAtlas.setTipoProdotto("Scrivania");
		scrivaniaAtlas.setMarcaProdotto("Le Fablier");
		scrivaniaAtlas.setNomeProdotto("Atlas");
		scrivaniaAtlas.getColoriProdotto().add("Marrone");
		scrivaniaAtlas.getVenditoriProdotto().add("info@antonellamazzei.it");
		scrivaniaAtlas.setPrezzoProdotto(3572.00);
		scrivaniaAtlas.setMisureProdotto("Misure in cm (LxPxH) 200x90x78");
		scrivaniaAtlas.setOffertaProdotto(true);
		scrivaniaAtlas.setDescrizioneProdotto("Scrivania in linea classica.");

		scrivaniaAtlas.getUrlImmaginiProdotto().add("Atlas_01.jpg");
		scrivaniaAtlas.getUrlImmaginiProdotto().add("Atlas_02.jpg");
		scrivaniaAtlas.getUrlImmaginiProdotto().add("Atlas_03.jpg");

		prodottoDao.save(scrivaniaAtlas);

		// Summer

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
		scrivaniaSummer.setOffertaProdotto(true);
		scrivaniaSummer.setDescrizioneProdotto("Summer � una scrivania dall�aspetto scultoreo, perfetta all�interno "
				+ "dello studio in cui si mostra in tutta la sua maestosit�.");
		scrivaniaSummer.getUrlImmaginiProdotto().add("Summer_01.jpg");
		scrivaniaSummer.getUrlImmaginiProdotto().add("Summer_02.jpg");

		prodottoDao.save(scrivaniaSummer);

		// Yoga
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
		scrivaniaYoga.setOffertaProdotto(true);
		scrivaniaYoga.setDescrizioneProdotto("Forma sinuosa e ricercata per lo scrittoio Yoga,"
				+ " che unisce la funzionalit� alla ricerca estetica.");
		scrivaniaYoga.getUrlImmaginiProdotto().add("Yoga_01.jpg");
		prodottoDao.save(scrivaniaYoga);

		// ----------------------------------------------------------

	}

	public void createSedie() {

		// SEDIE LEFABLIER
		// ----------------------------------------------------------

		// Meissa

		Prodotto sediaMeissa = new Prodotto();

		sediaMeissa.setAmbienteProdotto("Sala da Pranzo");
		sediaMeissa.setTipoProdotto("Sedia");
		sediaMeissa.setMarcaProdotto("Le Fablier");
		sediaMeissa.setNomeProdotto("Meissa");
		sediaMeissa.getColoriProdotto().add("Marrone");
		sediaMeissa.getColoriProdotto().add("Bianco");
		sediaMeissa.getVenditoriProdotto().add("info@antonellamazzei.it");
		sediaMeissa.setPrezzoProdotto(345.00);
		sediaMeissa.setMisureProdotto("Misure in cm (LxPxH) 46x49x92");
		sediaMeissa.setOffertaProdotto(true);
		sediaMeissa.setDescrizioneProdotto("Sedia con seduta imbottita in tessuto o pelle.");
		sediaMeissa.getUrlImmaginiProdotto().add("Meissa_01.jpg");
		prodottoDao.save(sediaMeissa);

		// Margherita

		Prodotto sediaMargherita = new Prodotto();

		sediaMargherita.setAmbienteProdotto("Sala da Pranzo");
		sediaMargherita.setTipoProdotto("Sedia");
		sediaMargherita.setMarcaProdotto("Le Fablier");
		sediaMargherita.setNomeProdotto("Margherita");
		sediaMargherita.getColoriProdotto().add("Marrone");
		sediaMargherita.getVenditoriProdotto().add("info@antonellamazzei.it");
		sediaMargherita.setPrezzoProdotto(407.00);
		sediaMargherita.setMisureProdotto("Misure in cm (LxPxH) 60x53x96");
		sediaMargherita.setOffertaProdotto(true);
		sediaMargherita.setDescrizioneProdotto("Sedia capotavola con seduta imbottita rivestita in tessuto.");
		sediaMargherita.getUrlImmaginiProdotto().add("Margherita_01.jpg");
		prodottoDao.save(sediaMargherita);

		// Kunti

		Prodotto sediaKunti = new Prodotto();

		sediaKunti.getColoriProdotto().add("Marrone");
		sediaKunti.getColoriProdotto().add("Bianco");
		sediaKunti.getColoriProdotto().add("Grigio");

		sediaKunti.setAmbienteProdotto("Sala da Pranzo");
		sediaKunti.setTipoProdotto("Sedia");
		sediaKunti.setMarcaProdotto("Le Fablier");
		sediaKunti.setNomeProdotto("Kunti");
		sediaKunti.getVenditoriProdotto().add("info@antonellamazzei.it");
		sediaKunti.setPrezzoProdotto(1436.00);
		sediaKunti.setMisureProdotto("Misure in cm (LxPxH) 55x56x89");
		sediaKunti.setOffertaProdotto(true);
		sediaKunti.setDescrizioneProdotto("Profilo essenziale ma solido per una seduta importante.");
		sediaKunti.getUrlImmaginiProdotto().add("Kunti_01.jpg");
		prodottoDao.save(sediaKunti);

		// ----------------------------------------------------------

		// SEDIE LEMA
		// ----------------------------------------------------------

		// Toa

		Prodotto sedia = new Prodotto();

		sedia.setAmbienteProdotto("Soggiorno");
		sedia.setTipoProdotto("Sedia");
		sedia.setMarcaProdotto("Lema");
		sedia.setNomeProdotto("Toa");
		sedia.getColoriProdotto().add("Nero");
		sedia.getVenditoriProdotto().add("info@arredamentiduepi.it");
		sedia.setPrezzoProdotto(270.00);
		sedia.setMisureProdotto("Misure in cm (LxPxH) 45x51x76");
		sedia.setOffertaProdotto(true);
		sedia.setDescrizioneProdotto(
				"Sedia con struttura leggera in metallo con quattro gambe coniche a sezione quadrata a cui si abbinano seduta e schienale in materiale plastico.");
		sedia.getUrlImmaginiProdotto().add("Toa_01.jpg");
		prodottoDao.save(sedia);

		// FillNoir

		sedia = new Prodotto();

		sedia.setAmbienteProdotto("Soggiorno");
		sedia.setTipoProdotto("Sedia");
		sedia.setMarcaProdotto("Lema");
		sedia.setNomeProdotto("FillNoir");
		sedia.getColoriProdotto().add("Beige");
		sedia.getVenditoriProdotto().add("info@arredamentiduepi.it");
		sedia.setPrezzoProdotto(199.00);
		sedia.setMisureProdotto("Misure in cm (LxPxH) 58x83x50");
		sedia.setOffertaProdotto(true);
		sedia.setDescrizioneProdotto(
				"Sedia con struttura in tubolare metallico verniciato nero opaco con dettagli in metallo finitura black-nikel (anche in oro lucido e bronzo chiaro), seduta e schienali imbottiti e rivestiti in tessuto.");
		sedia.getUrlImmaginiProdotto().add("FilNoir_1.jpg");
		prodottoDao.save(sedia);

		// ----------------------------------------------------------

	}

	public void createPoltrone() {

		// POLTRONE MATERASSI
		// ----------------------------------------------------------
		// Poltrona Spazio Relax

		Prodotto poltrona = new Prodotto();

		poltrona.getColoriProdotto().add("Rossa");

		poltrona.setAmbienteProdotto("Soggiorno");
		poltrona.setTipoProdotto("Poltrona");
		poltrona.setMarcaProdotto("Materassi");
		poltrona.setNomeProdotto("Poltrona Spazio Relax");
		poltrona.setPrezzoProdotto(990.00);
		poltrona.setMisureProdotto("Misure in cm (LxPxH) 78x74x105");
		poltrona.setOffertaProdotto(true);
		poltrona.setDescrizioneProdotto(
				"Poltrona con sollevamento, dispone di due motori per muovere indipendentemente schienale e pediera.");

		poltrona.getVenditoriProdotto().add("info@confortiarredamenti.it");
		poltrona.getUrlImmaginiProdotto().add("SpazioRelax_01.jpg");
		prodottoDao.save(poltrona);

		// ----------------------------------------------------------

		// POLTRONE LE FABLIER
		// ----------------------------------------------------------

		// PERSICA

		Prodotto poltronaPersica = new Prodotto();

		poltronaPersica.setAmbienteProdotto("Studio");
		poltronaPersica.setTipoProdotto("Poltrona");
		poltronaPersica.setMarcaProdotto("Le Fablier");
		poltronaPersica.setNomeProdotto("Persica");
		poltronaPersica.getColoriProdotto().add("Marrone");
		poltronaPersica.getColoriProdotto().add("Bianco");
		poltronaPersica.getVenditoriProdotto().add("info@antonellamazzei.it");
		poltronaPersica.setPrezzoProdotto(1004.00);
		poltronaPersica.setMisureProdotto("Misure in cm (LxPxH) 57x66x98/108");
		poltronaPersica.setOffertaProdotto(true);
		poltronaPersica.setDescrizioneProdotto("La poltrona girevole Persica, dallo spirito versatile, � un"
				+ " elemento d�arredo perfetto per l�ufficio ma anche per la casa. ");
		poltronaPersica.getUrlImmaginiProdotto().add("Persica_01.jpg");
		poltronaPersica.getUrlImmaginiProdotto().add("Persica_02.jpg");
		prodottoDao.save(poltronaPersica);

		// APOLLO

		Prodotto poltronaApollo = new Prodotto();

		poltronaApollo.setAmbienteProdotto("Salotto");
		poltronaApollo.setTipoProdotto("Poltrona");
		poltronaApollo.setMarcaProdotto("Le Fablier");
		poltronaApollo.setNomeProdotto("Apollo");
		poltronaApollo.getColoriProdotto().add("Marrone");
		poltronaApollo.getVenditoriProdotto().add("info@antonellamazzei.it");
		poltronaApollo.setPrezzoProdotto(1251.00);
		poltronaApollo.setMisureProdotto("Misure in cm (LxPxH) 71x69x88");
		poltronaApollo.setOffertaProdotto(true);
		poltronaApollo.setDescrizioneProdotto(
				"Linee nette per la poltroncina Apollo, " + "un elemento d�arredo dalla forma pulita e scultorea.");
		poltronaApollo.getUrlImmaginiProdotto().add("Apollo_01.jpg");
		prodottoDao.save(poltronaApollo);

		// LUNETTA

		Prodotto poltronaLunetta = new Prodotto();

		poltronaLunetta.setAmbienteProdotto("Salotto");
		poltronaLunetta.setTipoProdotto("Poltrona");
		poltronaLunetta.setMarcaProdotto("Le Fablier");
		poltronaLunetta.setNomeProdotto("Lunetta");
		poltronaLunetta.getColoriProdotto().add("Grigio");
		poltronaLunetta.getVenditoriProdotto().add("info@antonellamazzei.it");
		poltronaLunetta.setPrezzoProdotto(1338.00);
		poltronaLunetta.setMisureProdotto("Misure in cm (LxPxH) 68x77x81");
		poltronaLunetta.setOffertaProdotto(true);
		poltronaLunetta.setDescrizioneProdotto("Lunetta � una comoda poltroncina" + " dallo stile contemporaneo.");
		poltronaLunetta.getUrlImmaginiProdotto().add("Lunetta_01.jpg");
		prodottoDao.save(poltronaLunetta);

		//
		// ----------------------------------------------------------

		// POLTRONE POLTRONE E SOFA'
		// ----------------------------------------------------------
		// MEDOLLA

		Prodotto poltronaMedolla = new Prodotto();

		poltronaMedolla.setAmbienteProdotto("Soggiorno");
		poltronaMedolla.setTipoProdotto("Poltrona");
		poltronaMedolla.setMarcaProdotto("Poltrone e Sof�");
		poltronaMedolla.setNomeProdotto("Medolla");
		poltronaMedolla.getColoriProdotto().add("Marrone");
		poltronaMedolla.getColoriProdotto().add("Grigio");
		poltronaMedolla.getVenditoriProdotto().add("info@poltronesofarende.it");
		poltronaMedolla.setPrezzoProdotto(1020.00);
		poltronaMedolla.setMisureProdotto("Larghezza: 84cm, Profondit�:89cm, Altezza: 100cm");
		poltronaMedolla.setOffertaProdotto(true);
		poltronaMedolla
				.setDescrizioneProdotto("L'alto schienale, la seduta e il poggiareni assicurano il massimo comfort.");
		poltronaMedolla.getUrlImmaginiProdotto().add("Medolla_01.jpg");
		poltronaMedolla.getUrlImmaginiProdotto().add("Medolla_02.jpg");
		poltronaMedolla.getUrlImmaginiProdotto().add("Medolla_03.jpg");
		prodottoDao.save(poltronaMedolla);

		// POLTRONE DUEPI
		// ----------------------------------------------------------
		// CLARISSA

		Prodotto poltronaClarissa = new Prodotto();

		poltronaClarissa.setAmbienteProdotto("Soggiorno");
		poltronaClarissa.setTipoProdotto("Poltrona");
		poltronaClarissa.setMarcaProdotto("Bontempi casa");
		poltronaClarissa.setNomeProdotto("Clarissa");
		poltronaClarissa.getColoriProdotto().add("Bianco");
		poltronaClarissa.getColoriProdotto().add("Nero");
		poltronaClarissa.getVenditoriProdotto().add("info@arredamentiduepi.it");
		poltronaClarissa.setPrezzoProdotto(747.00);
		poltronaClarissa.setMisureProdotto("67x92x89");
		poltronaClarissa.setOffertaProdotto(true);
		poltronaClarissa.setDescrizioneProdotto(
				"Poltrona sfoderabile con struttura in acciaio laccato bianco o nero. Seduta e schienale sono imbottiti e rivestiti in pelle, ecopelle o tessuto.");
		poltronaClarissa.getUrlImmaginiProdotto().add("Clarissa_01.jpg");
		prodottoDao.save(poltronaClarissa);

		// DAYA

		Prodotto poltronaDaya = new Prodotto();

		poltronaDaya.setAmbienteProdotto("Soggiorno");
		poltronaDaya.setTipoProdotto("Poltrona");
		poltronaDaya.setMarcaProdotto("Bontempi casa");
		poltronaDaya.setNomeProdotto("Daya");
		poltronaDaya.getColoriProdotto().add("Nero");
		poltronaDaya.getVenditoriProdotto().add("info@arredamentiduepi.it");
		poltronaDaya.setPrezzoProdotto(115.00);
		poltronaDaya.setMisureProdotto("80x80x90");
		poltronaDaya.setOffertaProdotto(true);
		poltronaDaya.setDescrizioneProdotto(
				"Poltrona con base centrale girevole in acciaio cromato, scocca con inserto metallico, imbottita in poliuretano flessibile.");
		poltronaDaya.getUrlImmaginiProdotto().add("Daya_01.jpg");
		prodottoDao.save(poltronaDaya);

	}

	public void createDivani() {
		// DIVANI LEFABLIER
		// ----------------------------------------------------------

		// ALBA

		Prodotto divanoAlba = new Prodotto();

		divanoAlba.setAmbienteProdotto("Soggiorno");
		divanoAlba.setTipoProdotto("Divano");
		divanoAlba.setMarcaProdotto("Le Fablier");
		divanoAlba.setNomeProdotto("Alba");
		divanoAlba.getColoriProdotto().add("Grigio");
		divanoAlba.getVenditoriProdotto().add("info@antonellamazzei.it");
		divanoAlba.setPrezzoProdotto(6008.00);
		divanoAlba.setMisureProdotto("Misure (LxPxH) in cm 244x105x98");
		divanoAlba.setOffertaProdotto(true);
		divanoAlba.setDescrizioneProdotto("Divano in stile moderno.");

		divanoAlba.getUrlImmaginiProdotto().add("Alba_01.jpg");
		divanoAlba.getUrlImmaginiProdotto().add("Alba_02.jpg");

		prodottoDao.save(divanoAlba);

		// ----------------------------------------------------------

		// DIVANI POLTRONE & SOFA'
		// ----------------------------------------------------------

		// ALBA

		Prodotto divanoAlpe = new Prodotto();

		divanoAlpe.setAmbienteProdotto("Soggiorno");
		divanoAlpe.setTipoProdotto("Divano");
		divanoAlpe.setMarcaProdotto("Poltrone & Sof�");
		divanoAlpe.setNomeProdotto("Alpe");
		divanoAlpe.getColoriProdotto().add("Grigio");
		divanoAlpe.getColoriProdotto().add("Marrone");
		divanoAlpe.getVenditoriProdotto().add("info@poltronesofarende.it");
		divanoAlpe.setPrezzoProdotto(544.00);
		divanoAlpe.setMisureProdotto("Misure: Larghezza:210cm , Profondit�:	96cm, Altezza:	94cm");
		divanoAlpe.setOffertaProdotto(true);
		divanoAlpe.setDescrizioneProdotto("Un divano dalle linee morbide e avvolgenti, "
				+ "ispirato nel nome alla piccola frazione in provincia di Parma.");

		divanoAlpe.getUrlImmaginiProdotto().add("Alpe_01.jpg");
		divanoAlpe.getUrlImmaginiProdotto().add("Alpe_02.jpg");
		divanoAlpe.getUrlImmaginiProdotto().add("Alpe_03.jpg");

		prodottoDao.save(divanoAlpe);

		// ARDIANO

		Prodotto divanoArdiano = new Prodotto();

		divanoArdiano.setAmbienteProdotto("Soggiorno");
		divanoArdiano.setTipoProdotto("Divano");
		divanoArdiano.setMarcaProdotto("Poltrone & Sof�");
		divanoArdiano.setNomeProdotto("Ardiano");
		divanoArdiano.getColoriProdotto().add("Rosso");
		divanoArdiano.getVenditoriProdotto().add("info@poltronesofarende.it");
		divanoArdiano.setPrezzoProdotto(99.00);
		divanoArdiano.setMisureProdotto("Misure: Larghezza:	196cm, Profondit�:	89cm, Altezza:	65cm");
		divanoArdiano.setOffertaProdotto(true);
		divanoArdiano.setDescrizioneProdotto(
				"Braccioli e schienali hanno la stessa altezza in questo sof� essenziale, con un'immagine giovane ed informale, "
						+ "che appare rigoroso ma equilibrato nelle sue linee a pozzetto.");
		divanoArdiano.getUrlImmaginiProdotto().add("Ardiano_01.jpg");
		divanoArdiano.getUrlImmaginiProdotto().add("Ardiano_02.jpg");
		divanoArdiano.getUrlImmaginiProdotto().add("Ardiano_03.jpg");
		divanoArdiano.getUrlImmaginiProdotto().add("Ardiano_04.jpg");
		prodottoDao.save(divanoArdiano);

		// BASTIGLIA

		Prodotto divanoBastiglia = new Prodotto();

		divanoBastiglia.setAmbienteProdotto("Soggiorno");
		divanoBastiglia.setTipoProdotto("Divano");
		divanoBastiglia.setMarcaProdotto("Poltrone & Sof�");
		divanoBastiglia.setNomeProdotto("Bastiglia");
		divanoBastiglia.getColoriProdotto().add("Grigio");
		divanoBastiglia.getColoriProdotto().add("Bianco");
		divanoBastiglia.getVenditoriProdotto().add("info@poltronesofarende.it");
		divanoBastiglia.setPrezzoProdotto(1056.00);
		divanoBastiglia.setMisureProdotto(" Misure: Larghezza:	248cm, Profondit�:	154cm, Altezza:	100cm");
		divanoBastiglia.setOffertaProdotto(true);
		divanoBastiglia
				.setDescrizioneProdotto("Un divano dalle linee rigorose ed essenziali che prende il nome dal paesino"
						+ " in provincia di Modena, famoso per il suo santuario.");
		divanoBastiglia.getUrlImmaginiProdotto().add("Bastiglia_01.jpg");
		divanoBastiglia.getUrlImmaginiProdotto().add("Bastiglia_02.jpg");
		divanoBastiglia.getUrlImmaginiProdotto().add("Bastiglia_03.jpg");

		prodottoDao.save(divanoBastiglia);

		// ----------------------------------------------------------

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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Design fluido ed armonico per il tavolo Ekanta, caratterizzato da slanciate gambe in legno massello di Rovere che, unite alla struttura del piano del tavolo, \r\n"
						+ "conferiscono alla composizione una linea morbida ed elegante.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Ekanta_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Ekanta_02.jpg");
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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Tavolo rettangolare allungabile, struttura in legno massello di ciliegio.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Tulipano_01.jpg");
		prodotto.getUrlImmaginiProdotto().add("Tulipano_02.jpg");

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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Forma quadrata e accuratezza dei dettagli rendono il tavolo Cartesio un elemento di charme che diventa protagonista in ogni ambiente.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Cartesio_01.jpg");
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
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Tavolo fisso in rovere dalle linee calde, con dimensioni che rimandano alla lavorazione artigianale.");

		prodotto.getVenditoriProdotto().add("info@antonellamazzei.it");
		prodotto.getUrlImmaginiProdotto().add("Muschio_01.jpg");
		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// TAVOLI DI LAZZARO
		// ----------------------------------------------------------

		// Open90

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Di Lazzaro");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Open90");
		prodotto.setPrezzoProdotto(Double.parseDouble("211.00"));
		prodotto.setMisureProdotto("110/150cm x 70cm x 76cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto("Tavolo allungabile.");
		prodotto.getUrlImmaginiProdotto().add("Open90_01.jpg");

		prodotto.getVenditoriProdotto().add("info@confortiarredamenti.it");

		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// TAVOLI FIAM
		// ----------------------------------------------------------

		// Atlas

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Celeste");

		prodotto.setMarcaProdotto("Fiam");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Atlas");
		prodotto.setPrezzoProdotto(Double.parseDouble("12600.00"));
		prodotto.setMisureProdotto("220cm x 100cm x 74cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Tavolo con piano rettangolare in vetro temperato (spessore 20 mm) poggiante su quattro gambe realizzate con sezioni di vetro scolpite a mano e incollate una sull�altra.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");

		prodotto.getUrlImmaginiProdotto().add("AtlasTavolo_01.jpg");
		prodottoDao.save(prodotto);

		// 3Pod

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Grigio");

		prodotto.setMarcaProdotto("Fiam");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Studio");
		prodotto.setNomeProdotto("3Pod");
		prodotto.setPrezzoProdotto(Double.parseDouble("450.00"));
		prodotto.setMisureProdotto("143cm x 140cm x 73cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"La base del tavolo 3-Pod, si ispira al classico tripode: un segno continuo in acciaio cromato che sorregge un piano (rettangolare, tondo o a goccia) in vetro, legno o laccato.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("3Ppod_01.jpg");
		prodottoDao.save(prodotto);

		// Plie

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrone");

		prodotto.setMarcaProdotto("Fiam");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Soggiorno");
		prodotto.setNomeProdotto("Plie");
		prodotto.setPrezzoProdotto(Double.parseDouble("4080.00"));
		prodotto.setMisureProdotto("200cm x 100cm x 74cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Tavolo rettangolare con base in vetro fum� e piano in rovere termotrattato. Pli� � composto da due basi in vetro sagomato e curvato.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("Plie_01.jpg");
		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

		// TAVOLI LEMA
		// ----------------------------------------------------------

		// Thera

		prodotto = new Prodotto();

		prodotto.getColoriProdotto().add("Marrone");

		prodotto.setMarcaProdotto("Lema");
		prodotto.setTipoProdotto("Tavolo");
		prodotto.setAmbienteProdotto("Cucina");
		prodotto.setNomeProdotto("Thera");
		prodotto.setPrezzoProdotto(Double.parseDouble("2570.00"));
		prodotto.setMisureProdotto("180cm x 90cm x 73cm");
		prodotto.setOffertaProdotto(true);
		prodotto.setDescrizioneProdotto(
				"Tavolo allungabile Thera di Marelli e Molteni. Il piano, che parte da 180cm e raggiunge una lunghezza massima di 240cm, � sorretto da gambe posizionate obliquamente rispetto al top in modo da creare un incastro geometrico armonico.");

		prodotto.getVenditoriProdotto().add("info@arredamentiduepi.it");
		prodotto.getUrlImmaginiProdotto().add("Thera_01.jpg");
		prodottoDao.save(prodotto);

		// ----------------------------------------------------------

	}

	public void createVetrine() {

		// VETRINE LEFABLIER
		// ----------------------------------------------------------

		// AMBROSIA

		Prodotto vetrinaAmbrosia = new Prodotto();

		vetrinaAmbrosia.setAmbienteProdotto("Soggiorno");
		vetrinaAmbrosia.setTipoProdotto("Vetrina");
		vetrinaAmbrosia.setMarcaProdotto("Le Fablier");
		vetrinaAmbrosia.setNomeProdotto("Ambrosia");
		vetrinaAmbrosia.getColoriProdotto().add("Marrone");
		vetrinaAmbrosia.getVenditoriProdotto().add("info@antonellamazzei.it");
		vetrinaAmbrosia.setPrezzoProdotto(1632.00);
		vetrinaAmbrosia.setMisureProdotto("Misure in cm (LxPxH) 68x45x207");
		vetrinaAmbrosia.setOffertaProdotto(true);
		vetrinaAmbrosia.setDescrizioneProdotto("Argentiera 1 anta dx/sx.");
		vetrinaAmbrosia.getUrlImmaginiProdotto().add("Ambrosia_01.jpg");
		vetrinaAmbrosia.getUrlImmaginiProdotto().add("Ambrosia_02.jpg");

		prodottoDao.save(vetrinaAmbrosia);

		// BALI

		Prodotto vetrinaBali = new Prodotto();

		vetrinaBali.setAmbienteProdotto("Soggiorno");
		vetrinaBali.setTipoProdotto("Vetrina");
		vetrinaBali.setMarcaProdotto("Le Fablier");
		vetrinaBali.setNomeProdotto("Bali");
		vetrinaBali.getColoriProdotto().add("Grigio");
		vetrinaBali.getVenditoriProdotto().add("info@antonellamazzei.it");
		vetrinaBali.setPrezzoProdotto(1563.00);
		vetrinaBali.setMisureProdotto("Misure in cm (LxPxH) 120x43x184");
		vetrinaBali.setOffertaProdotto(true);
		vetrinaBali.setDescrizioneProdotto(
				"Eleganza e design moderno sono" + " racchiuse nell�argentiera a due ante Bali.");
		vetrinaBali.getUrlImmaginiProdotto().add("Bali_01.jpg");
		prodottoDao.save(vetrinaBali);

		// ABELIA

		Prodotto vetrinaAbelia = new Prodotto();

		vetrinaAbelia.setAmbienteProdotto("Studio");
		vetrinaAbelia.setTipoProdotto("Vetrina");
		vetrinaAbelia.setMarcaProdotto("Le Fablier");
		vetrinaAbelia.setNomeProdotto("Abelia");
		vetrinaAbelia.getColoriProdotto().add("Grigio");
		vetrinaAbelia.getVenditoriProdotto().add("info@antonellamazzei.it");
		vetrinaAbelia.setPrezzoProdotto(1930.00);
		vetrinaAbelia.setMisureProdotto("Misure in cm (LxPxH) 69x45x206");
		vetrinaAbelia.setOffertaProdotto(true);
		vetrinaAbelia.setDescrizioneProdotto(
				"La vetrina Abelia, � una vetrina a colonna caratterizzata da una slanciata anta, inserite"
						+ " in una elegante struttura in legno di frassino spazzolato.");
		vetrinaAbelia.getUrlImmaginiProdotto().add("Abelia_01.jpg");
		prodottoDao.save(vetrinaAbelia);

		// ----------------------------------------------------------

		// VETRINE DUE PI
		// ----------------------------------------------------------

		// ALAMBRA

		Prodotto vetrinaAlambra = new Prodotto();

		vetrinaAlambra.setAmbienteProdotto("Soggiorno");
		vetrinaAlambra.setTipoProdotto("Vetrina");
		vetrinaAlambra.setMarcaProdotto("Lema");
		vetrinaAlambra.setNomeProdotto("Alambra");
		vetrinaAlambra.getColoriProdotto().add("Grigio");
		vetrinaAlambra.getVenditoriProdotto().add("info@arredamentiduepi.it");
		vetrinaAlambra.setPrezzoProdotto(3600.00);
		vetrinaAlambra.setMisureProdotto("600x500");
		vetrinaAlambra.setOffertaProdotto(true);
		vetrinaAlambra.setDescrizioneProdotto(
				" La proposta a cassetti che si caratterizza per il particolare costruttivo a coda di rondine\" e l�escluviso sistema di scorrimento invisibile.");
		vetrinaAlambra.getUrlImmaginiProdotto().add("Alambra_01.jpg");
		prodottoDao.save(vetrinaAlambra);

		// GLANCE

		Prodotto vetrinaGlance = new Prodotto();

		vetrinaGlance.setAmbienteProdotto("Camera da Letto");
		vetrinaGlance.setTipoProdotto("Vetrina");
		vetrinaGlance.setMarcaProdotto("Lema");
		vetrinaGlance.setNomeProdotto("Glance");
		vetrinaGlance.getColoriProdotto().add("Marrone");
		vetrinaGlance.getVenditoriProdotto().add("info@arredamentiduepi.it");
		vetrinaGlance.setPrezzoProdotto(2500.00);
		vetrinaGlance.setMisureProdotto("120x45x170 ");
		vetrinaGlance.setOffertaProdotto(true);
		vetrinaGlance.setDescrizioneProdotto(
				" Vetrina Glance dalle linee scultoree e massicce. Il modello ha struttura in rovere termotrattato, ante in cristallo e perimetro bordato in alluminio bronzato.");
		vetrinaGlance.getUrlImmaginiProdotto().add("Glance_01.jpg");
		prodottoDao.save(vetrinaGlance);

		// GALERIST

		Prodotto vetrinaGalerist = new Prodotto();

		vetrinaGalerist.setAmbienteProdotto("Soggiorno");
		vetrinaGalerist.setTipoProdotto("Vetrina");
		vetrinaGalerist.setMarcaProdotto("Lema");
		vetrinaGalerist.setNomeProdotto("Galerist");
		vetrinaGalerist.getColoriProdotto().add("Argento");
		vetrinaGalerist.getVenditoriProdotto().add("info@arredamentiduepi.it");
		vetrinaGalerist.setPrezzoProdotto(6866.00);
		vetrinaGalerist.setMisureProdotto("110x250");
		vetrinaGalerist.setOffertaProdotto(true);
		vetrinaGalerist.setDescrizioneProdotto(
				" Galerist deve il suo nome al modo in cui espone gli oggetti nello spazio: una vetrina che nasce da uno stilema classico e si reinventa per diventare arredo contemporaneo e di design.");
		vetrinaGalerist.getUrlImmaginiProdotto().add("Galerist_01.jpg");
		prodottoDao.save(vetrinaGalerist);

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
