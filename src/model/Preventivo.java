package model;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.activation.DataSource;

import persistenceDAO.IdBuilder;
import persistenceDAO.MySqlDAOFactory;

public class Preventivo {

	private Integer idPreventivo;
	private Date dataOraPreventivo;
	private List<Venditore> listaVenditori;
	private Utente utente;
	private List<Prodotto> listaProdotti;
	private String richiesteAggiuntiveUtente;
	
	public Preventivo() {

		Connection connection = MySqlDAOFactory.getDataSource().getConnection();
		
		Integer id = IdBuilder.getId(connection);
		setIdPreventivo(id);
		
	}

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

	public List<Venditore> getListaVenditori() {
		return listaVenditori;
	}

	public void setListaVenditori(List<Venditore> idVenditore) {
		this.listaVenditori = idVenditore;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente idUtente) {
		this.utente = idUtente;
	}

	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public String getRichiesteAggiuntiveUtente() {
		return richiesteAggiuntiveUtente;
	}

	public void setRichiesteAggiuntiveUtente(String richiesteAggiuntiveUtente) {
		this.richiesteAggiuntiveUtente = richiesteAggiuntiveUtente;
	}

	public void addProdotto(Prodotto prodotto) {

		listaProdotti.add(prodotto);

	}

	public void addVenditore(Venditore venditore) {

		listaVenditori.add(venditore);

	}

}
