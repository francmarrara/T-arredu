package persistenceDAO;

import model.Carrello;
import model.Prodotto;

public interface CarrelloDAO {

	//public void save(Carrello carrello);  // Create
	public Carrello findByPrimaryKey(String utenteCarrello);     // Retrieve
	
	//public List<Carrello> findAll();       
	
	public void addProduct(Prodotto p, Carrello c);
	public void removeProduct(Prodotto p, Carrello c);
	
	public void delete(Carrello carrello); //Delete	

   	
	
	
}
