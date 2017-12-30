package persistenceJDBC;

import java.util.List;

import model.Venditore;
import persistenceDAO.DataSource;
import persistenceDAO.VenditoreDAO;

public class VenditoreDaoJDBC implements VenditoreDAO {
private DataSource dataSource;
	
	public VenditoreDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Venditore venditore) {
		// TODO Auto-generated method stub

	}

	@Override
	public Venditore findByPrimaryKey(Integer idVenditore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venditore> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Venditore venditore) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Venditore venditore) {
		// TODO Auto-generated method stub

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
