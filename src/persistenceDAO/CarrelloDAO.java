package persistenceDAO;

import java.util.List;

import model.Carrello;

import model.Utente;

public interface CarrelloDAO {

	public void save(Carrello carrello);  // Create
	public Carrello findByPrimaryKey(Integer idCarrello);     // Retrieve
	public Carrello findByUtente(Utente utente);     // Retrieve
	
	public List<Carrello> findAll();       
	public void update(Carrello carrello); //Update
	public void delete(Carrello carrello); //Delete	

   	
	
	
}
