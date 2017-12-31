package model;

public class Venditore {

	private Integer idVenditore;
	private String nomeTitolare;
	private String cognomeTitolare;
	private String nomeNegozio;
	private String indirizzoVenditore;
	private String emailVenditore;
	private String numeroTelefonicoVenditore;

	// costruttore senza parametri
	public Venditore() {

	}

	// getter & setter

	public Integer getIdVenditore() {
		return idVenditore;
	}

	public void setIdVenditore(Integer idVenditore) {
		this.idVenditore = idVenditore;
	}

	public String getNomeTitolare() {
		return nomeTitolare;
	}

	public void setNomeTitolare(String nomeTitolare) {
		this.nomeTitolare = nomeTitolare;
	}

	public String getCognomeTitolare() {
		return cognomeTitolare;
	}

	public void setCognomeTitolare(String cognomeTitolare) {
		this.cognomeTitolare = cognomeTitolare;
	}

	public String getNomeNegozio() {
		return nomeNegozio;
	}

	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio = nomeNegozio;
	}

	public String getIndirizzoVenditore() {
		return indirizzoVenditore;
	}

	public void setIndirizzoVenditore(String indirizzoVenditore) {
		this.indirizzoVenditore = indirizzoVenditore;
	}

	public String getEmailVenditore() {
		return emailVenditore;
	}

	public void setEmailVenditore(String emailVenditore) {
		this.emailVenditore = emailVenditore;
	}

	public String getNumeroTelefonicoVenditore() {
		return numeroTelefonicoVenditore;
	}

	public void setNumeroTelefonicoVenditore(String numeroTelefonicoVenditore) {
		this.numeroTelefonicoVenditore = numeroTelefonicoVenditore;
	}

}
