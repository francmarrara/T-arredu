package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Prodotto;
import model.Venditore;
import persistenceDAO.DataSource;
import persistenceDAO.PersistenceException;
import persistenceDAO.ProdottoDAO;
import persistenceDAO.VenditoreDAO;

public class ProdottoDaoJDBC implements ProdottoDAO {

	private DataSource dataSource;

	public ProdottoDaoJDBC(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public void save(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into prodotto(marcaProdotto, ambienteProdotto, nomeProdotto, coloreProdotto, prezzoProdotto, disponibilitaProdotto, descrizioneProdotto, id_venditoreProdotto) values (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, prodotto.getMarcaProdotto());
			statement.setString(2, prodotto.getAmbienteProdotto());
			statement.setString(3, prodotto.getNomeProdotto());
			statement.setString(4, prodotto.getColoreProdotto());
			statement.setString(5, prodotto.getPrezzoProdotto());
			statement.setBoolean(6, prodotto.getDisponibilit‡Prodotto());
			statement.setString(7, prodotto.getDescrizioneProdotto());
			statement.setInt(8, prodotto.getVenditoreProdotto().getIdVenditore());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public Prodotto findByPrimaryKey(Integer idProdotto) {
		Connection connection = this.dataSource.getConnection();
		Prodotto prodotto = null;
		try {
			PreparedStatement statement;
			String query = "select * from prodotto where id_prodotto = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, idProdotto);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				prodotto = new Prodotto();
				prodotto.setIdProdotto(result.getInt("id_prodotto"));
				prodotto.setMarcaProdotto(result.getString("marcaProdotto"));
				prodotto.setAmbienteProdotto(result.getString("ambienteProdotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setColoreProdotto(result.getString("coloreProdotto"));
				prodotto.setPrezzoProdotto(result.getString("prezzoProdotto"));
				prodotto.setDisponibilit‡Prodotto(result.getBoolean("disponibilitaProdotto"));

				VenditoreDAO venditoreDAO = new VenditoreDaoJDBC(dataSource);

				prodotto.setVenditoreProdotto(venditoreDAO.findByPrimaryKey(result.getInt("id_venditoreProdotto")));

			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return prodotto;
	}

	@Override
	public List<Prodotto> findByVenditore(Venditore venditore) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<>();
		try {
			Prodotto prodotto;
			PreparedStatement statement;
			String query = "select * from prodotto where id_venditoreProdotto = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, venditore.getIdVenditore());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				prodotto = new Prodotto();
				prodotto.setIdProdotto(result.getInt("id_prodotto"));
				prodotto.setMarcaProdotto(result.getString("marcaProdotto"));
				prodotto.setAmbienteProdotto(result.getString("ambienteProdotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setColoreProdotto(result.getString("coloreProdotto"));
				prodotto.setPrezzoProdotto(result.getString("prezzoProdotto"));
				prodotto.setDisponibilit‡Prodotto(result.getBoolean("disponibilitaProdotto"));

				VenditoreDAO venditoreDAO = new VenditoreDaoJDBC(dataSource);

				prodotto.setVenditoreProdotto(venditoreDAO.findByPrimaryKey(result.getInt("id_venditoreProdotto")));

				prodotti.add(prodotto);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return prodotti;
	}

	@Override
	public List<Prodotto> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<>();
		try {
			Prodotto prodotto;
			PreparedStatement statement;
			String query = "select * from prodotto";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				prodotto = new Prodotto();
				prodotto.setIdProdotto(result.getInt("id_prodotto"));
				prodotto.setMarcaProdotto(result.getString("marcaProdotto"));
				prodotto.setAmbienteProdotto(result.getString("ambienteProdotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setColoreProdotto(result.getString("coloreProdotto"));
				prodotto.setPrezzoProdotto(result.getString("prezzoProdotto"));
				prodotto.setDisponibilit‡Prodotto(result.getBoolean("disponibilitaProdotto"));

				VenditoreDAO venditoreDAO = new VenditoreDaoJDBC(dataSource);

				prodotto.setVenditoreProdotto(venditoreDAO.findByPrimaryKey(result.getInt("id_venditoreProdotto")));

				prodotti.add(prodotto);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return prodotti;
	}

	@Override
	public void update(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update prodotto SET marcaProdotto = ?, ambienteProdotto = ?, nomeProdotto = ?, coloreProdotto = ?, prezzoProdotto = ?, disponibilitaProdotto = ?, descrizioneProdotto = ?, id_venditoreProdotto = ?  WHERE id_prodotto=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, prodotto.getMarcaProdotto());
			statement.setString(2, prodotto.getAmbienteProdotto());
			statement.setString(3, prodotto.getNomeProdotto());
			statement.setString(4, prodotto.getColoreProdotto());
			statement.setString(5, prodotto.getPrezzoProdotto());
			statement.setBoolean(6, prodotto.getDisponibilit‡Prodotto());
			statement.setString(7, prodotto.getDescrizioneProdotto());
			statement.setInt(8, prodotto.getVenditoreProdotto().getIdVenditore());
			statement.setInt(9, prodotto.getIdProdotto());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public void delete(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM prodotto WHERE id_prodotto = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, prodotto.getIdProdotto());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public void cambioDisponibilit‡(Prodotto prodotto, boolean disponibilit‡) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update prodotto SET disponibilitaProdotto = ? where id_prodotto = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setBoolean(1, disponibilit‡);
			statement.setInt(2, prodotto.getIdProdotto());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public List<Prodotto> findProductsByPreventivo(Long codicePreventivo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void deleteProductsFromPreventivo(Long codicePreventivo) {
		// TODO Auto-generated method stub
		
	}


}
