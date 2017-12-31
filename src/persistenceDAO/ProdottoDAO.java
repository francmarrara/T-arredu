package persistenceDAO;

import java.util.List;

import model.Carrello;
import model.Prodotto;
import model.Venditore;


public interface ProdottoDAO {
	public void save(Prodotto prodotto);  // Create
	public Prodotto findByPrimaryKey(Integer idProdotto);     // Retrieve
	public List<Prodotto> findByVenditore(Venditore venditore);     // Retrieve
	public List<Prodotto> findByMarca(String marcaProdotto); // Retrieve
	public List<Prodotto> findByColour(String coloreProdotto); // Retrieve
	public List<Prodotto> findByAmbiente(String ambienteProdotto); // Retrieve
	public List<Prodotto> findAll();       
	public void update(Prodotto prodotto); //Update
	public void delete(Prodotto prodotto); //Delete	

	public void cambioDisponibilità(Prodotto prodotto, boolean disponibilità);//cambia la disponibilità del prodotto
	public List<Prodotto> findProductsByPreventivo(Long codicePreventivo);
   	public List<Prodotto> findProductsByCarrello(Carrello carrello);

}
