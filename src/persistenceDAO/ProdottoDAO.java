package persistenceDAO;

import java.util.List;

import model.Carrello;
import model.Prodotto;
import model.ProdottoConImmagini;
import model.Venditore;

public interface ProdottoDAO {
	public void save(Prodotto prodotto); // Create

	public Prodotto findByPrimaryKey(Integer idProdotto); // Retrieve


	public List<Prodotto> findByMarca(String marcaProdotto); // Retrieve

	public List<Prodotto> findByTipo(String tipoProdotto); // Retrieve

	public List<Prodotto> findByColour(String coloreProdotto); // Retrieve

	public List<Prodotto> findByAmbiente(String ambienteProdotto); // Retrieve

	public List<Prodotto> findAll();

	public List<ProdottoConImmagini> findAllProductWithImages();
	
	public void update(Prodotto prodotto); // Update

	public void delete(Prodotto prodotto); // Delete

	public void cambioOfferta(Prodotto prodotto, boolean disponibilità);// cambia la disponibilità del prodotto

	public List<Prodotto> findProductsByPreventivo(Integer codicePreventivo);

	public List<Prodotto> findProductsByCarrello(Carrello carrello);

	public List<Prodotto> findByVenditore(String emailVenditore);

	public List<String> getImages(Integer idProdotto);

	public void addImageToProduct(String url, Prodotto prodotto);

	public void removeImageInProduct(String url, Prodotto prodotto);

	public void removeAllImagesInProduct(Prodotto prodotto);

	public void addColorToProduct(String color, Prodotto prodotto);

	public void removeColorInProduct(String color, Prodotto prodotto);

	public void removeAllColorsInProduct(Prodotto prodotto);

	public void addVenditoreToProduct(String emailVenditore, Prodotto prodotto);

	public void removeVenditoreInProduct(String emailVenditore, Prodotto prodotto);

	public void removeAllVenditoriInProduct(Prodotto prodotto);
	
	public Integer getNumberOfvisit(Integer idProdotto);
	
	public void visitPlusPlus(Integer idProdotto);
	
	public ProdottoConImmagini findByPrimaryKeyProdottoConImmagini(Integer idProdotto); // Retrieve

	public List<ProdottoConImmagini> findProductsByVenditoreProdottoConImmagini(String emailVenditore);

	public List<ProdottoConImmagini> findProductsByCarrelloProdottiConImmagini(Carrello carrello);

	public List<ProdottoConImmagini> findProductsByMarcaProdottiConImmagini(String marcaProdotto);

	public List<ProdottoConImmagini> findProductsByPrenventivoProdottiConImmagini(Integer idPreventivo);

	public List<ProdottoConImmagini> findProductsByAmbienteProdottiConImmagini(String ambienteProdotto);

	public List<ProdottoConImmagini> findProductsByTipoProdottiConImmagini(String tippProdotto);

	public List<ProdottoConImmagini> prodottiInOfferta();
	public List<ProdottoConImmagini> prodottiPerVisibilità();
	
	
	
	
	
	
	

}
