package persistenceDAO;

import java.util.List;

import model.Preventivo;
import model.Prodotto;
import model.Venditore;


public interface ProdottoDAO {
	public void save(Prodotto prodotto);  // Create
	public Prodotto findByPrimaryKey(Integer idProdotto);     // Retrieve
	public List<Prodotto> findByVenditore(Venditore venditore);     // Retrieve
	public List<Prodotto> findByMarca(String marcaProdotto);
	public List<Prodotto> findByColour(String coloreProdotto);
	public List<Prodotto> findAll();       
	public void update(Prodotto prodotto); //Update
	public void delete(Prodotto prodotto); //Delete	
	public void deleteProductsFromPreventivo(Long codicePreventivo);//Cancella tutti i prodotti da preventivo

	public void cambioDisponibilitÓ(Prodotto prodotto, boolean disponibilitÓ);//cambia la disponibilitÓ del prodotto
	public List<Prodotto> findProductsByPreventivo(Long codicePreventivo);
   	

}
