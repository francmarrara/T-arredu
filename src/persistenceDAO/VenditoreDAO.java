package persistenceDAO;

import java.util.List;

import model.Prodotto;
import model.Venditore;


public interface VenditoreDAO {

	public void save(Venditore venditore);  // Create
	public Venditore findByPrimaryKey(String emailVenditore);     // Retrieve
	public List<Venditore> findAll();       
	public void update(Venditore venditore); //Update
	public void delete(Venditore venditore); //Delete	
	
	public List<Venditore> findVenditoriByPreventivo(Integer codicePreventivo);// Trova tutti i venditori di un preventivo
	
	
}
