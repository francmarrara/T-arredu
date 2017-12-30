package persistenceDAO;

import java.util.List;

import model.Venditore;


public interface VenditoreDAO {

	public void save(Venditore venditore);  // Create
	public Venditore findByPrimaryKey(Integer idVenditore);     // Retrieve
	public List<Venditore> findAll();       
	public void update(Venditore venditore); //Update
	public void delete(Venditore venditore); //Delete	
	
	
}
