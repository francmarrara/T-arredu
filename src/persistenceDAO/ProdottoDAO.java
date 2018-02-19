package persistenceDAO;

import java.util.List;

import model.Carrello;
import model.Prodotto;
import model.ProdottoConImmagini;

public interface ProdottoDAO {
	public void save(Prodotto prodotto); // Create

	public Prodotto findByPrimaryKey(Integer idProdotto); // Retrieve

	public List<Prodotto> findAll();

	public List<ProdottoConImmagini> findAllProductWithImages();

	public void update(Prodotto prodotto); // Update

	public void delete(Prodotto prodotto); // Delete

	public void cambioOfferta(Prodotto prodotto, boolean disponibilit�);// cambia la disponibilit� del prodotto

	public List<String> getImages(Integer idProdotto);

	public Integer getNumberOfvisit(Integer idProdotto);

	public void visitPlusPlus(Integer idProdotto);

	public ProdottoConImmagini findByPrimaryKeyProdottoConImmagini(Integer idProdotto); // Retrieve

	public List<ProdottoConImmagini> findProductsByVenditoreProdottoConImmagini(String emailVenditore);

	public List<ProdottoConImmagini> findProductsByCarrelloProdottiConImmagini(Carrello carrello);

	public List<ProdottoConImmagini> findProductsByPrenventivoProdottiConImmagini(Integer idPreventivo);

	public List<ProdottoConImmagini> prodottiInOfferta();

	public List<ProdottoConImmagini> prodottiPerVisibilit�();

	public ProdottoConImmagini getProdottoPerPreventivo(Integer idProdotto);

	public List<String> getTutteLeMarche();

	public List<String> getMarchePerAmbiente(String ambiente);

}
