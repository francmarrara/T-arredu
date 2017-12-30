package model;

import java.util.Date;

public class Utente {

	private Integer idUtente;
	private String nomeUtente;
	private String cognomeUtente;
	private Date datadiNascita;
	private String emailUtente;
	private String passwordUtente;
	
	//costruttore senza parametri
	private Utente() {
		
	}
	
	//Get & set
	
	public Integer getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}
	public String getNomeUtente() {
		return nomeUtente;
	}
	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	public String getCognomeUtente() {
		return cognomeUtente;
	}
	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}
	public Date getDatadiNascita() {
		return datadiNascita;
	}
	public void setDatadiNascita(Date datadiNascita) {
		this.datadiNascita = datadiNascita;
	}
	public String getEmailUtente() {
		return emailUtente;
	}
	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getPasswordUtente() {
		return passwordUtente;
	}

	public void setPasswordUtente(String passwordUtente) {
		this.passwordUtente = passwordUtente;
	}
}
