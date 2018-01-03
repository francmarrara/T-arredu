package persistenceDAO;

import java.sql.Connection;
import java.util.List;

import model.Preventivo;
import model.Prodotto;
import model.Utente;
import model.Venditore;

public interface PreventivoDAO {

	public void save(Preventivo preventivo);// Create
	public Preventivo findByPrimaryKey(Long codice);// Retrieve     
	public void update(Preventivo preventivo); //Update
	public void delete(Preventivo preventivo); //Delete
	
	public List<Preventivo> findAll(); // Trova tutti i preventivi
	
	// Trova prodotti, venditori e utenti per un preventivo
	public List<Prodotto> findAllProdottoByPreventivo(Integer id_preventivo);
	public List<Venditore> findAllVenditoreByPreventivo(Integer id_preventivo);
	public Utente findUtenteByPreventivo(String emailUtente);
	
	// Aggiorna prodotto, venditore e utente di un preventivo
	public void updateProdotto(Preventivo preventivo);
	public void updateUtente(Preventivo preventivo);
	public void updateVenditore(Preventivo preventivo);
	
	// Aggiunge un prodotto o un venditore al preventivo
	public void addProductToPreventivo(Prodotto prodotto);
	public void addVenditoreToPreventivo(Venditore venditore);
	
}
