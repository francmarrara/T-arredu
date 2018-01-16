package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProdottoConImmagini {

	private Integer idProdotto;
	private String nomeProdotto;
	private Double prezzoProdotto;
	
	private List<String> urlImmagini;
	

	public ProdottoConImmagini() {
		urlImmagini = new LinkedList<String>();
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

	public List<String> getUrlImmagini() {
		return urlImmagini;
	}

	public void setUrlImmagini(List<String> urlImmagini) {
		this.urlImmagini = urlImmagini;
	}

	public void stampaProdotto() {
		System.out.println("----------");
		System.out.println("Id Prodotto : " + idProdotto);
		System.out.println("Nome Prodotto : " + nomeProdotto);
		System.out.println("Prezzo Prodotto : " +prezzoProdotto);
		System.out.println("===IMMAGINI===");

		for (String s : urlImmagini) {
			System.out.println(s);
		}

		System.out.println("---------");
	}

	public Double getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(Double prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}

}
