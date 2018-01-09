package model;

import java.util.ArrayList;

public class ProdottoConImmagini {

	private Integer idProdotto;
	private String nomeProdotto;
	private ArrayList<String> urlImmagini;

	public ProdottoConImmagini() {
		urlImmagini = new ArrayList<String>();
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

	public ArrayList<String> getUrlImmagini() {
		return urlImmagini;
	}

	public void setUrlImmagini(ArrayList<String> urlImmagini) {
		this.urlImmagini = urlImmagini;
	}

	public void stampaProdotto() {
		System.out.println("----------");
		System.out.println("Id Prodotto : " + idProdotto);
		System.out.println("Nome Prodotto : " + nomeProdotto);
		System.out.println("===IMMAGINI===");

		for (String s : urlImmagini) {
			System.out.println(s);
		}

		System.out.println("---------");
	}

}
