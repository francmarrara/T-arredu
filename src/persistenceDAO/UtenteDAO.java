package persistenceDAO;

import java.util.List;

import model.Utente;



public interface UtenteDAO {

	public void save(Utente utente);  // Create
	public Utente findByPrimaryKey(Integer idUtente);     // Retrieve
	public List<Utente> findAll();       
	public void update(Utente utente); //Update
	public void delete(Utente utente); //Delete	
	
	public void changePassword(Utente utente, String password);
	
}
