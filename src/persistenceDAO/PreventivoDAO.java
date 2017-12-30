package persistenceDAO;

import java.util.List;

import model.Preventivo;
import model.Prodotto;
import model.Venditore;

public interface PreventivoDAO {

	public void save(Preventivo corso);// Create
	public Preventivo findByPrimaryKey(Long codice);// Retrieve     
	public void update(Preventivo corso); //Update
	public void delete(Preventivo corso); //Delete
	public List<Preventivo> findAllPreventivi(); // Trova tutti i preventivi

	
}
