package persistenceDAO;

import java.sql.Connection;
import java.util.List;

import model.Preventivo;
import model.Prodotto;
import model.Venditore;

public interface PreventivoDAO {

	public void save(Preventivo corso);// Create
	public Preventivo findByPrimaryKey(Long codice);// Retrieve     
	public void update(Preventivo corso); //Update
	public void delete(Preventivo corso); //Delete
	public List<Preventivo> findAll(); // Trova tutti i preventivi
	public List<Prodotto> findAllProductByPreventivo(Integer id_preventivo);
	
	public void updateProdotto(Preventivo preventivo, Connection connection);
	public void updateUtente(Preventivo preventivo, Connection connection);
	public void updateVenditore(Preventivo preventivo, Connection connection);


	
}
