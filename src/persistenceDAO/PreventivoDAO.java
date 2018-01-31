package persistenceDAO;

import java.util.List;

import model.Preventivo;
import model.Prodotto;
import model.ProdottoConImmagini;
import model.Utente;
import model.Venditore;

public interface PreventivoDAO {

	public void save(Preventivo preventivo);// Create
	public Preventivo findByPrimaryKey(Integer codice);// Retrieve     
	public void update(Preventivo preventivo); //Update
	public void delete(Preventivo preventivo); //Delete
	
	public List<Preventivo> findAll(); // Trova tutti i preventivi
	
	//Trova l'utente di un preventivo
	public Utente findUtenteByPreventivo(Preventivo preventivo);
	
	// Aggiorna prodotto e venditore di un preventivo
	public void updateProdottoInPreventivo(Preventivo preventivo);
	public void updateVenditoreInPreventivo(Preventivo preventivo);
	
	// Aggiunge un prodotto o un venditore al preventivo
	public void addProductToPreventivo(ProdottoConImmagini prodotto, Integer idPreventivo);
	public void addVenditoreToPreventivo(String venditore, Preventivo preventivo);
	
}
