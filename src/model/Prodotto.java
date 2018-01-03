package model;

import java.sql.Connection;
import java.util.ArrayList;

import persistenceDAO.IdBuilder;
import persistenceDAO.MySqlDAOFactory;

public class Prodotto {

	private Integer idProdotto;
	private String nomeProdotto;
	private String marcaProdotto;
	private String ambienteProdotto;
	private String coloreProdotto;
	private Double prezzoProdotto;
	private Boolean disponibilit‡Prodotto;
	private String descrizioneProdotto;
	private Venditore venditoreProdotto;
    private ArrayList<String> urlImmaginiProdotto;
	
	
	//costruttore senza Parametri
	public Prodotto() {

		Connection connection = MySqlDAOFactory.getDataSource().getConnection();
		
		Integer id = IdBuilder.getId(connection);
		setIdProdotto(id);
		
		urlImmaginiProdotto = new ArrayList<String>();
	}

	//Getter & Setter
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

	public String getColoreProdotto() {
		return coloreProdotto;
	}

	public void setColoreProdotto(String coloreProdotto) {
		this.coloreProdotto = coloreProdotto;
	}

	public Double getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(Double prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}

	public Boolean getDisponibilit‡Prodotto() {
		return disponibilit‡Prodotto;
	}

	public void setDisponibilit‡Prodotto(Boolean disponibilit‡Prodotto) {
		this.disponibilit‡Prodotto = disponibilit‡Prodotto;
	}

	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public Venditore getVenditoreProdotto() {
		return venditoreProdotto;
	}

	public void setVenditoreProdotto(Venditore venditoreProdotto) {
		this.venditoreProdotto = venditoreProdotto;
	}

	public ArrayList<String> getUrlImmaginiProdotto() {
		return urlImmaginiProdotto;
	}

	public void setUrlImmaginiProdotto(ArrayList<String> urlImmaginiProdotto) {
		this.urlImmaginiProdotto = urlImmaginiProdotto;
	}

}
