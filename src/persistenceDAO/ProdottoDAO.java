package persistenceDAO;

import java.util.List;

import model.Prodotto;
import model.Venditore;


public interface ProdottoDAO {
	public void save(Prodotto prodotto);  // Create
	public Prodotto findByPrimaryKey(Integer idProdotto);     // Retrieve
	public List<Prodotto> findByVenditore(Venditore venditore);     // Retrieve
	public List<Prodotto> findAll();       
	public void update(Prodotto prodotto); //Update
	public void delete(Prodotto prodotto); //Delete	

	public void cambioDisponibilit�(Prodotto prodotto, boolean disponibilit�);//cambia la disponibilit� del prodotto
	public List<Prodotto> findProductsByPreventivo(Long codicePreventivo);
   	

}
