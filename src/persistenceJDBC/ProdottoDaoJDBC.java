package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Carrello;
import model.Prodotto;
import model.Venditore;
import persistenceDAO.DataSource;
import persistenceDAO.IdBuilder;
import persistenceDAO.PersistenceException;
import persistenceDAO.ProdottoDAO;
import persistenceDAO.VenditoreDAO;
import static java.lang.Math.toIntExact;

public class ProdottoDaoJDBC implements ProdottoDAO {

	private DataSource dataSource;

	public ProdottoDaoJDBC(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public void save(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into prodotto(id_prodotto, marcaProdotto, ambienteProdotto, nomeProdotto, coloreProdotto, prezzoProdotto, disponibilitaProdotto, descrizioneProdotto, email_venditoreProdotto) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, prodotto.getIdProdotto());
			statement.setString(2, prodotto.getMarcaProdotto());
			statement.setString(3, prodotto.getAmbienteProdotto());
			statement.setString(4, prodotto.getNomeProdotto());
			statement.setString(5, prodotto.getColoreProdotto());
			statement.setDouble(6, prodotto.getPrezzoProdotto());
			statement.setBoolean(7, prodotto.getDisponibilit‡Prodotto());
			statement.setString(8, prodotto.getDescrizioneProdotto());
			statement.setString(9, prodotto.getVenditoreProdotto().getEmailVenditore());

			statement.executeUpdate();

			for (String s : prodotto.getUrlImmaginiProdotto()) {

				insert = "insert into urlImmaginiProdotto(id_prodotto,urlImmagine) values(?,?)";
				statement = connection.prepareStatement(insert);
				statement.setInt(1, findByPrimaryKey(prodotto.getIdProdotto()).getIdProdotto());
				statement.setString(2, s);
				statement.executeUpdate();

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
				prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				prodotto.setDisponibilit‡Prodotto(result.getBoolean("disponibilitaProdotto"));

				VenditoreDAO venditoreDAO = new VenditoreDaoJDBC(dataSource);

				prodotto.setVenditoreProdotto(
						venditoreDAO.findByPrimaryKey(result.getString("email_venditoreProdotto")));

				query = "select * from urlImmaginiProdotto where id_prodotto = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, idProdotto);
				result = statement.executeQuery();
				if (result.next()) {
					prodotto.getUrlImmaginiProdotto().add(result.getString("urlImmagine"));

				}

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

	@SuppressWarnings("resource")
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
				prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				prodotto.setDisponibilit‡Prodotto(result.getBoolean("disponibilitaProdotto"));

				VenditoreDAO venditoreDAO = new VenditoreDaoJDBC(dataSource);

				prodotto.setVenditoreProdotto(
						venditoreDAO.findByPrimaryKey(result.getString("email_venditoreProdotto")));

				query = "select * from urlImmaginiProdotto where id_prodotto = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, prodotto.getIdProdotto());
				result = statement.executeQuery();
				if (result.next()) {
					prodotto.getUrlImmaginiProdotto().add(result.getString("urlImmagine"));

				}

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

	@SuppressWarnings("resource")
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
				prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				prodotto.setDisponibilit‡Prodotto(result.getBoolean("disponibilitaProdotto"));

				VenditoreDAO venditoreDAO = new VenditoreDaoJDBC(dataSource);

				prodotto.setVenditoreProdotto(
						venditoreDAO.findByPrimaryKey(result.getString("email_venditoreProdotto")));

				query = "select * from urlImmaginiProdotto where id_prodotto = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, prodotto.getIdProdotto());
				result = statement.executeQuery();
				if (result.next()) {
					prodotto.getUrlImmaginiProdotto().add(result.getString("urlImmagine"));

				}

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
			statement.setDouble(5, prodotto.getPrezzoProdotto());
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

	@SuppressWarnings("resource")
	@Override
	public List<Prodotto> findByMarca(String marcaProdotto) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<>();
		try {
			Prodotto prodotto;
			PreparedStatement statement;
			String query = "select * from prodotto where marcaProdotto = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, marcaProdotto);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				prodotto = new Prodotto();
				prodotto.setIdProdotto(result.getInt("id_prodotto"));
				prodotto.setMarcaProdotto(result.getString("marcaProdotto"));
				prodotto.setAmbienteProdotto(result.getString("ambienteProdotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setColoreProdotto(result.getString("coloreProdotto"));
				prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				prodotto.setDisponibilit‡Prodotto(result.getBoolean("disponibilitaProdotto"));

				VenditoreDAO venditoreDAO = new VenditoreDaoJDBC(dataSource);

				prodotto.setVenditoreProdotto(
						venditoreDAO.findByPrimaryKey(result.getString("email_venditoreProdotto")));
				query = "select * from urlImmaginiProdotto where id_prodotto = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, prodotto.getIdProdotto());
				result = statement.executeQuery();
				if (result.next()) {
					prodotto.getUrlImmaginiProdotto().add(result.getString("urlImmagine"));

				}

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

	@SuppressWarnings("resource")
	@Override
	public List<Prodotto> findByColour(String coloreProdotto) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<>();
		try {
			
			Prodotto prodotto;
			PreparedStatement statement;
			String query = "select * from prodotto where coloreProdotto = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, coloreProdotto);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				prodotto = new Prodotto();
				prodotto.setIdProdotto(result.getInt("id_prodotto"));
				prodotto.setMarcaProdotto(result.getString("marcaProdotto"));
				prodotto.setAmbienteProdotto(result.getString("ambienteProdotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setColoreProdotto(result.getString("coloreProdotto"));
				prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				prodotto.setDisponibilit‡Prodotto(result.getBoolean("disponibilitaProdotto"));

				VenditoreDAO venditoreDAO = new VenditoreDaoJDBC(dataSource);

				prodotto.setVenditoreProdotto(
						venditoreDAO.findByPrimaryKey(result.getString("email_venditoreProdotto")));

				query = "select * from urlImmaginiProdotto where id_prodotto = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, prodotto.getIdProdotto());
				result = statement.executeQuery();
				if (result.next()) {
					prodotto.getUrlImmaginiProdotto().add(result.getString("urlImmagine"));

				}

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

	@SuppressWarnings("resource")
	@Override
	public List<Prodotto> findByAmbiente(String ambienteProdotto) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<>();
		try {
			Prodotto prodotto;
			PreparedStatement statement;
			String query = "select * from prodotto where ambienteProdotto = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, ambienteProdotto);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				prodotto = new Prodotto();
				prodotto.setIdProdotto(result.getInt("id_prodotto"));
				prodotto.setMarcaProdotto(result.getString("marcaProdotto"));
				prodotto.setAmbienteProdotto(result.getString("ambienteProdotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setColoreProdotto(result.getString("coloreProdotto"));
				prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				prodotto.setDisponibilit‡Prodotto(result.getBoolean("disponibilitaProdotto"));

				VenditoreDAO venditoreDAO = new VenditoreDaoJDBC(dataSource);

				prodotto.setVenditoreProdotto(
						venditoreDAO.findByPrimaryKey(result.getString("email_venditoreProdotto")));

				query = "select * from urlImmaginiProdotto where id_prodotto = ?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, prodotto.getIdProdotto());
				result = statement.executeQuery();
				if (result.next()) {
					prodotto.getUrlImmaginiProdotto().add(result.getString("urlImmagine"));

				}

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
	public List<Prodotto> findProductsByPreventivo(Integer codicePreventivo) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<>();
		try {
			PreparedStatement statement;
			String query = "select * from prodottoInPreventivo where preventivoID = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, toIntExact(codicePreventivo));
			ResultSet result = statement.executeQuery();
			while (result.next()) {

				prodotti.add(findByPrimaryKey(result.getInt("prodottoID")));
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
	public List<Prodotto> findProductsByCarrello(Carrello carrello) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<>();
		try {
			PreparedStatement statement;
			String query = "select * from prodottoInCarrello where email_utenteCarrello = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, carrello.getUtenteCarrello().getEmailUtente());
			ResultSet result = statement.executeQuery();
			while (result.next()) {

				prodotti.add(findByPrimaryKey(result.getInt("id_prodottoInCarrello")));
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
	public List<String> getImages(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		List<String> immagini = new LinkedList<String>();

		try {

			PreparedStatement statement;

			String query = "select * from urlImmaginiProdotto where id_prodotto = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, prodotto.getIdProdotto());
			ResultSet result = statement.executeQuery();

			result = statement.executeQuery();
			if (result.next()) {
				immagini.add(result.getString("urlImmagine"));

			}

		} catch (

		SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return immagini;
	}

	@Override
	public void addImageToProduct(String url, Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert;
			PreparedStatement statement;

			insert = "insert into urlImmaginiProdotto(id_prodotto,urlImmagine) values(?,?)";
			statement = connection.prepareStatement(insert);
			statement.setInt(1, findByPrimaryKey(prodotto.getIdProdotto()).getIdProdotto());
			statement.setString(2, url);
			statement.executeUpdate();

		}

		catch (SQLException e) {
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
	public void removeImageInProduct(String url, Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete;
			PreparedStatement statement;

			delete = "delete FROM urlImmaginiProdotto where id_prodotto = ? and urlImmagine=?";
			statement = connection.prepareStatement(delete);
			statement.setInt(1, findByPrimaryKey(prodotto.getIdProdotto()).getIdProdotto());
			statement.setString(2, url);
			statement.executeUpdate();

		}

		catch (SQLException e) {
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
	public void removeAllImagesInProduct(Prodotto prodotto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete;
			PreparedStatement statement;

			delete = "delete FROM urlImmaginiProdotto where id_prodotto = ?";
			statement = connection.prepareStatement(delete);
			statement.setInt(1, findByPrimaryKey(prodotto.getIdProdotto()).getIdProdotto());
			statement.executeUpdate();

		}

		catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	
	
	
	

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
