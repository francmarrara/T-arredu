package model;

import java.util.LinkedList;
import java.util.List;

public class ProdottoConImmagini {

	private Integer idProdotto;
	private String nomeProdotto;
	private Double prezzoProdotto;
	private String marcaProdotto;
	private Integer visiteProdotto;
	
    private String immaginePrincipale;	

	public ProdottoConImmagini() {
	visiteProdotto=0;
	}

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



	public void stampaProdotto() {
		System.out.println("----------");
		System.out.println("Id Prodotto : " + idProdotto);
		System.out.println("Nome Prodotto : " + nomeProdotto);
		System.out.println("Prezzo Prodotto : " +prezzoProdotto);
		System.out.println("Numero Visite : " +visiteProdotto);
		System.out.println("Marca Prodotto : " +marcaProdotto);
		System.out.println("===IMMAGINI===");

		
			System.out.println(immaginePrincipale);
		

		System.out.println("---------");
	}

	public Double getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(Double prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}

	public String getMarcaProdotto() {
		return marcaProdotto;
	}

	public void setMarcaProdotto(String marcaProdotto) {
		this.marcaProdotto = marcaProdotto;
	}

	public Integer getNumeroVisite() {
		return visiteProdotto;
	}

	public void setNumeroVisite(Integer visiteProdotto) {
		this.visiteProdotto = visiteProdotto;
	}

	public String getImmaginePrincipale() {
		return immaginePrincipale;
	}

	public void setImmaginePrincipale(String immaginePrincipale) {
		this.immaginePrincipale = immaginePrincipale;
	}

}
