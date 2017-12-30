package persistenceJDBC;

import java.util.List;


import model.Prodotto;
import model.Venditore;
import persistenceDAO.DataSource;
import persistenceDAO.ProdottoDAO;

public class ProdottoDaoJDBC implements ProdottoDAO {
	
	private DataSource dataSource; 
	
	public ProdottoDaoJDBC(DataSource dataSource){
		this.setDataSource(dataSource);
	}

	@Override
	public void save(Prodotto prodotto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Prodotto findByPrimaryKey(Integer idProdotto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> findByVenditore(Venditore venditore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Prodotto prodotto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Prodotto prodotto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cambioDisponibilità(Prodotto prodotto, boolean disponibilità) {
		// TODO Auto-generated method stub

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
