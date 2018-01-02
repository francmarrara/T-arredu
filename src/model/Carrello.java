package model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	
	private Integer idCarello;
	private Utente utenteCarello;
	private List<Prodotto> prodottiNelCarrello;
	
	//costruttore senza parametri
	public Carrello() {
		prodottiNelCarrello = new ArrayList<Prodotto>();
	}
	
	

	public Integer getIdCarello() {
		return idCarello;
	}

	public void setIdCarello(Integer idCarello) {
		this.idCarello = idCarello;
	}

	public Utente getUtenteCarrello() {
		return utenteCarello;
	}

	public void setUtenteCarello(Utente utenteCarello) {
		this.utenteCarello = utenteCarello;
	}

	public List<Prodotto> getProdottiNelCarrello() {
		return prodottiNelCarrello;
	}

	public void setProdottiNelCarrello(List<Prodotto> prodottiNelCarrello) {
		this.prodottiNelCarrello = prodottiNelCarrello;
	}
	
	
	
	
	

}