package model;

import java.sql.Connection;
import java.util.ArrayList;

import persistenceDAO.IdBuilder;
import persistenceDAO.MySqlDAOFactory;

public class Prodotto {

	private Integer idProdotto;
	private String nomeProdotto;
	private String tipoProdotto;
	private String marcaProdotto;
	private String ambienteProdotto;
	private Double prezzoProdotto;
	private String misureProdotto;
	private Boolean disponibilitāProdotto;
	private String descrizioneProdotto;
	private ArrayList<String> urlImmaginiProdotto;
	private ArrayList<String> coloriProdotto;
	private ArrayList<String> venditoriProdotto;
	private Integer numeroVisite;

	// costruttore senza Parametri
	public Prodotto() {

		Connection connection = MySqlDAOFactory.getDataSource().getConnection();

		Integer id = IdBuilder.getId(connection);
		setIdProdotto(id);

		urlImmaginiProdotto = new ArrayList<String>();
		coloriProdotto = new ArrayList<String>();
		venditoriProdotto = new ArrayList<String>();
		numeroVisite=0;

	}

	// Getter & Setter
	public Integer getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getMarcaProdotto() {
		return marcaProdotto;
	}

	public void setMarcaProdotto(String marcaProdotto) {
		this.marcaProdotto = marcaProdotto;
	}

	public String getAmbienteProdotto() {
		return ambienteProdotto;
	}

	public void setAmbienteProdotto(String ambienteProdotto) {
		this.ambienteProdotto = ambienteProdotto;
	}

	public Double getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(Double prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}

	public Boolean getDisponibilitāProdotto() {
		return disponibilitāProdotto;
	}

	public void setDisponibilitāProdotto(Boolean disponibilitāProdotto) {
		this.disponibilitāProdotto = disponibilitāProdotto;
	}

	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public ArrayList<String> getUrlImmaginiProdotto() {
		return urlImmaginiProdotto;
	}

	public void setUrlImmaginiProdotto(ArrayList<String> urlImmaginiProdotto) {
		this.urlImmaginiProdotto = urlImmaginiProdotto;
	}

	public String getMisureProdotto() {
		return misureProdotto;
	}

	public void setMisureProdotto(String misureProdotto) {
		this.misureProdotto = misureProdotto;
	}

	public String getTipoProdotto() {
		return tipoProdotto;
	}

	public void setTipoProdotto(String tipoProdotto) {
		this.tipoProdotto = tipoProdotto;
	}

	public void stampaProdotto() {

		System.out.println("Id : " + idProdotto);
		System.out.println("Nome : " + nomeProdotto);
		System.out.println("Tipo : " + tipoProdotto);
		System.out.println("Marca : " + marcaProdotto);
		System.out.println("Ambiente : " + ambienteProdotto);
		System.out.println("Prezzo : " + prezzoProdotto);
		System.out.println("Misure : " + misureProdotto);
		System.out.println("Disponibilitā : " + disponibilitāProdotto);
		System.out.println("Descrizione : " + descrizioneProdotto);
		System.out.println("IMMAGINI : ");
		System.out.println("----------------");
		for (String s : urlImmaginiProdotto) {
			System.out.println(s);
		}
		System.out.println("----------------");
		System.out.println();

		System.out.println("COLORI : ");
		System.out.println("----------------");
		for (String s : coloriProdotto) {
			System.out.println(s);
		}
		System.out.println("----------------");
		System.out.println();
	}

	public ArrayList<String> getColoriProdotto() {
		return coloriProdotto;
	}

	public void setColoriProdotto(ArrayList<String> coloriProdotto) {
		this.coloriProdotto = coloriProdotto;
	}

	public ArrayList<String> getVenditoriProdotto() {
		return venditoriProdotto;
	}

	public void setVenditoriProdotto(ArrayList<String> venditoriProdotto) {
		this.venditoriProdotto = venditoriProdotto;
	}

	public Integer getNumeroVisite() {
		return numeroVisite;
	}

	public void setNumeroVisite(Integer numeroVisite) {
		this.numeroVisite = numeroVisite;
	}

}
