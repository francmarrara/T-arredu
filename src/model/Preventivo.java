package model;

import java.util.Date;
import java.util.List;

public class Preventivo {

	private Integer idPreventivo;
	private Date dataOraPreventivo;
	private Venditore idVenditore;
	private Utente idUtente;
	private List<Prodotto> listaProdotti;

	public Integer getIdPreventivo() {
		return idPreventivo;
	}

	public void setIdPreventivo(Integer idPreventivo) {
		this.idPreventivo = idPreventivo;
	}

	public Date getDataOraPreventivo() {
		return dataOraPreventivo;
	}

	public void setDataOraPreventivo(Date dataOraPreventivo) {
		this.dataOraPreventivo = dataOraPreventivo;
	}

	public Venditore getIdVenditore() {
		return idVenditore;
	}

	public void setIdVenditore(Venditore idVenditore) {
		this.idVenditore = idVenditore;
	}

	public Utente getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Utente idUtente) {
		this.idUtente = idUtente;
	}

	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

}
