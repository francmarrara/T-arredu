package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Carrello;
import model.Commento;
import model.Prodotto;
import model.ProdottoConImmagini;
import model.Venditore;
import persistenceDAO.DAOFactory;
import persistenceDAO.DataSource;
import persistenceDAO.PersistenceException;
import persistenceDAO.ProdottoDAO;
import persistenceDAO.UtenteDAO;

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
			String insert = "insert into prodotto(id_prodotto, marcaProdotto, tipoProdotto, ambienteProdotto, nomeProdotto, "
					+ "prezzoProdotto, misureProdotto, offertaProdotto, "
					+ "descrizioneProdotto, numeroVisite, immaginePrincipale ) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, prodotto.getIdProdotto());
			statement.setString(2, prodotto.getMarcaProdotto());
			statement.setString(3, prodotto.getTipoProdotto());
			statement.setString(4, prodotto.getAmbienteProdotto());
			statement.setString(5, prodotto.getNomeProdotto());
			statement.setDouble(6, prodotto.getPrezzoProdotto());
			statement.setString(7, prodotto.getMisureProdotto());
			statement.setBoolean(8, prodotto.getOffertaProdotto());
			statement.setString(9, prodotto.getDescrizioneProdotto());
			statement.setInt(10, prodotto.getNumeroVisite());
			statement.setString(11, prodotto.getUrlImmaginePrincipale());

			statement.executeUpdate();

			for (String s : prodotto.getUrlImmaginiProdotto()) {

				insert = "insert into urlImmaginiProdotto(id_prodotto,urlImmagine) values(?,?)";
				statement = connection.prepareStatement(insert);
				statement.setInt(1, prodotto.getIdProdotto());
				statement.setString(2, s);
				statement.executeUpdate();

			}

			for (String c : prodotto.getColoriProdotto()) {

				insert = "insert into coloriPerProdotto(id_prodotto, coloreProdotto) values(?,?)";
				statement = connection.prepareStatement(insert);
				statement.setInt(1, prodotto.getIdProdotto());
				statement.setString(2, c);
				statement.executeUpdate();

			}

			for (Venditore v : prodotto.getVenditoriProdotto()) {

				insert = "insert into venditorePerProdotto(id_prodotto, emailVenditore) values(?,?)";
				statement = connection.prepareStatement(insert);
				statement.setInt(1, prodotto.getIdProdotto());
				statement.setString(2, v.getEmailVenditore());
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
				prodotto.setTipoProdotto(result.getString("tipoProdotto"));
				prodotto.setAmbienteProdotto(result.getString("ambienteProdotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				prodotto.setMisureProdotto(result.getString("misureProdotto"));
				prodotto.setOffertaProdotto(result.getBoolean("offertaProdotto"));
				prodotto.setDescrizioneProdotto(result.getString("descrizioneProdotto"));
				prodotto.setNumeroVisite(result.getInt("numeroVisite"));

				String queryVenditore = "select * from venditorePerProdotto where id_prodotto = ?";
				PreparedStatement statementVenditori = connection.prepareStatement(queryVenditore);
				statementVenditori.setInt(1, prodotto.getIdProdotto());

				ResultSet resultVenditori = statementVenditori.executeQuery();

				while (resultVenditori.next()) {

					DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

					prodotto.getVenditoriProdotto().add(
							factory.getVenditoreDAO().findByPrimaryKey(resultVenditori.getString("emailVenditore")));

				}

				String queryUrl = "select * from urlImmaginiProdotto where id_prodotto = ?";
				PreparedStatement statementUrl = connection.prepareStatement(queryUrl);
				statementUrl.setInt(1, prodotto.getIdProdotto());

				ResultSet resultImmagini = statementUrl.executeQuery();

				while (resultImmagini.next()) {
					prodotto.getUrlImmaginiProdotto().add(resultImmagini.getString("urlImmagine"));

				}

				String queryColor = "select * from coloriPerProdotto where id_prodotto = ?";
				PreparedStatement statementColor = connection.prepareStatement(queryColor);
				statementColor.setInt(1, prodotto.getIdProdotto());

				ResultSet resultColor = statementColor.executeQuery();

				while (resultColor.next()) {
					prodotto.getColoriProdotto().add(resultColor.getString("coloreProdotto"));

				}

				String queryCommenti = "select * from commentoProdotto where idProdotto = ?";
				PreparedStatement statementCommenti = connection.prepareStatement(queryCommenti);
				statementCommenti.setInt(1, prodotto.getIdProdotto());

				ResultSet resultCommenti = statementCommenti.executeQuery();

				// if (resultCommenti.first() == true) {

				while (resultCommenti.next()) {

					Commento c = new Commento();

					c.setIdCommento(resultCommenti.getInt("id_commentoProdotto"));
					c.setEmailUtente((resultCommenti.getString("utenteEmail")));
					c.setIdProdotto((resultCommenti.getInt("idProdotto")));
					c.setCommento((resultCommenti.getString("commentoProdotto")));
					c.setValutazione((resultCommenti.getInt("valutazioneProdotto")));

					DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
					UtenteDAO utenteDao = factory.getUtenteDAO();

					c.setNomeUtente(utenteDao.getNomeUtente(c.getEmailUtente()));

					prodotto.getCommentiProdotto().add(c);

				}
			}
			// }

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
	public List<Prodotto> findAll() {

		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<>();

		try {

			Prodotto prodotto;
			PreparedStatement statement;

			String query = "select id_prodotto from prodotto";

			statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);
				prodotto = new Prodotto();
				prodotto = prodottoDao.findByPrimaryKey(result.getInt("id_prodotto"));
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
			String update = "update prodotto SET marcaProdotto = ?, tipoProdotto = ? ,ambienteProdotto = ?, nomeProdotto = ?, "
					+ "prezzoProdotto = ?, misureProdotto = ?, offertaProdotto = ?, "
					+ "descrizioneProdotto = ?, numeroVisite = ? WHERE id_prodotto=?";

			PreparedStatement statement = connection.prepareStatement(update);

			statement.setString(1, prodotto.getMarcaProdotto());
			statement.setString(2, prodotto.getTipoProdotto());
			statement.setString(3, prodotto.getAmbienteProdotto());
			statement.setString(4, prodotto.getNomeProdotto());
			statement.setDouble(5, prodotto.getPrezzoProdotto());
			statement.setBoolean(6, prodotto.getOffertaProdotto());
			statement.setString(7, prodotto.getMisureProdotto());
			statement.setString(8, prodotto.getDescrizioneProdotto());
			statement.setInt(9, prodotto.getNumeroVisite());
			statement.setInt(10, prodotto.getIdProdotto());

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

			removeAllColorsInProduct(prodotto);
			removeAllVenditoriInProduct(prodotto);
			removeAllImagesInProduct(prodotto);

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
	public void cambioOfferta(Prodotto prodotto, boolean offerta) {

		Connection connection = this.dataSource.getConnection();

		try {
			String update = "update prodotto SET offertaProdotto = ? where id_prodotto = ?";
			PreparedStatement statement = connection.prepareStatement(update);

			statement.setBoolean(1, offerta);
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
			PreparedStatement statementProdotto;

			String query = "select id_prodotto from prodotto where marcaProdotto = ?";
			statementProdotto = connection.prepareStatement(query);

			statementProdotto.setString(1, marcaProdotto);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			while (resultProdotto.next()) {

				ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);
				prodotto = new Prodotto();
				prodotto = prodottoDao.findByPrimaryKey(resultProdotto.getInt("id_prodotto"));
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
			PreparedStatement statementProdotto;

			String query = "select id_prodotto from coloriPerProdotto where coloreProdotto = ?";
			statementProdotto = connection.prepareStatement(query);

			statementProdotto.setString(1, coloreProdotto);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			while (resultProdotto.next()) {

				ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);
				prodotto = new Prodotto();
				prodotto = prodottoDao.findByPrimaryKey(resultProdotto.getInt("id_prodotto"));
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
	public List<Prodotto> findByTipo(String tipoProdotto) {

		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<>();

		try {

			Prodotto prodotto;
			PreparedStatement statementProdotto;

			String query = "select id_prodotto from prodotto where tipoProdotto = ?";
			statementProdotto = connection.prepareStatement(query);

			statementProdotto.setString(1, tipoProdotto);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			while (resultProdotto.next()) {

				ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);
				prodotto = new Prodotto();
				prodotto = prodottoDao.findByPrimaryKey(resultProdotto.getInt("id_prodotto"));
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
			PreparedStatement statementProdotto;

			String query = "select id_prodotto from prodotto where ambienteProdotto = ?";
			statementProdotto = connection.prepareStatement(query);

			statementProdotto.setString(1, ambienteProdotto);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			while (resultProdotto.next()) {

				ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);
				prodotto = new Prodotto();
				prodotto = prodottoDao.findByPrimaryKey(resultProdotto.getInt("id_prodotto"));
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
			String query = "select prodottoID from prodottoInPreventivo where preventivoID = ?";
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
			String query = "select id_prodottoInCarrello from prodottoInCarrello where email_utenteCarrello = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, carrello.getUtenteCarrello());
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
	public List<String> getImages(Integer idProdotto) {
		Connection connection = this.dataSource.getConnection();
		List<String> immagini = new LinkedList<String>();

		try {

			PreparedStatement statement;

			String query = "select urlImmagine from urlImmaginiProdotto where id_prodotto = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, idProdotto);
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
			statement.setInt(1, prodotto.getIdProdotto());
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
			statement.setInt(1, prodotto.getIdProdotto());
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
			statement.setInt(1, prodotto.getIdProdotto());
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
	public void addColorToProduct(String color, Prodotto prodotto) {

		Connection connection = this.dataSource.getConnection();
		try {
			String insert;
			PreparedStatement statement;

			insert = "insert into coloriPerProdotto(id_prodotto, coloreProdotto) values(?,?)";
			statement = connection.prepareStatement(insert);
			statement.setInt(1, prodotto.getIdProdotto());
			statement.setString(2, color);
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
	public void removeColorInProduct(String color, Prodotto prodotto) {

		Connection connection = this.dataSource.getConnection();

		try {
			String delete;
			PreparedStatement statement;

			delete = "delete FROM coloriPerProdotto where id_prodotto = ? and coloreProdotto =?";
			statement = connection.prepareStatement(delete);
			statement.setInt(1, prodotto.getIdProdotto());
			statement.setString(2, color);
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
	public void removeAllColorsInProduct(Prodotto prodotto) {

		Connection connection = this.dataSource.getConnection();

		try {
			String delete;
			PreparedStatement statement;

			delete = "delete FROM coloriPerProdotto where id_prodotto = ?";
			statement = connection.prepareStatement(delete);
			statement.setInt(1, prodotto.getIdProdotto());
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
	public void addVenditoreToProduct(String emailVenditore, Prodotto prodotto) {

		Connection connection = this.dataSource.getConnection();

		try {

			String insert;
			PreparedStatement statement;

			insert = "insert into venditorePerProdotto(id_prodotto, emailVenditore) values(?,?)";
			statement = connection.prepareStatement(insert);
			statement.setInt(1, prodotto.getIdProdotto());
			statement.setString(2, emailVenditore);
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
	public void removeVenditoreInProduct(String emailVenditore, Prodotto prodotto) {

		Connection connection = this.dataSource.getConnection();

		try {
			String delete;
			PreparedStatement statement;

			delete = "delete FROM venditorePerProdotto where id_prodotto = ? and emailVenditore = ?";
			statement = connection.prepareStatement(delete);
			statement.setInt(1, prodotto.getIdProdotto());
			statement.setString(2, emailVenditore);
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
	public void removeAllVenditoriInProduct(Prodotto prodotto) {

		Connection connection = this.dataSource.getConnection();

		try {
			String delete;
			PreparedStatement statement;

			delete = "delete FROM venditorePerProdotto where id_prodotto = ?";
			statement = connection.prepareStatement(delete);
			statement.setInt(1, prodotto.getIdProdotto());
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

	@Override
	public List<Prodotto> findByVenditore(String emailVenditore) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new LinkedList<>();

		try {

			Prodotto prodotto;
			PreparedStatement statement;

			String query = "select id_prodotto from venditorePerProdotto where emailVenditore = ?";

			statement = connection.prepareStatement(query);
			statement.setString(1, emailVenditore);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);
				prodotto = new Prodotto();
				prodotto = prodottoDao.findByPrimaryKey(result.getInt("id_prodotto"));
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
	public List<ProdottoConImmagini> findAllProductWithImages() {
		Connection connection = this.dataSource.getConnection();
		ArrayList<ProdottoConImmagini> prodotti = new ArrayList<ProdottoConImmagini>();

		try {

			PreparedStatement statement;
			String query = "select id_prodotto from prodotto";
			statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				ProdottoConImmagini prodotto = findByPrimaryKeyProdottoConImmagini(result.getInt("id_prodotto"));

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
	public Integer getNumberOfvisit(Integer idProdotto) {
		Connection connection = this.dataSource.getConnection();
		Integer value = null;
		try {

			PreparedStatement statement;
			String query = "select numeroVisite from prodotto WHERE id_prodotto = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, idProdotto);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				value = result.getInt("numeroVisite");

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
		return value;
	}

	@Override
	public void visitPlusPlus(Integer idProdotto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "UPDATE prodotto \r\n" + "  SET numeroVisite = numeroVisite + 1 \r\n"
					+ "  WHERE id_prodotto = ?";

			PreparedStatement statement = connection.prepareStatement(update);

			statement.setInt(1, idProdotto);

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
	public ProdottoConImmagini findByPrimaryKeyProdottoConImmagini(Integer idProdotto) {

		Connection connection = this.dataSource.getConnection();
		ProdottoConImmagini prodotto = null;

		try {

			PreparedStatement statement;
			String query = "select id_prodotto,marcaProdotto,nomeProdotto,prezzoProdotto,numeroVisite,immaginePrincipale from prodotto where id_prodotto = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, idProdotto);

			ResultSet result = statement.executeQuery();

			if (result.next()) {

				prodotto = new ProdottoConImmagini();

				prodotto.setIdProdotto(result.getInt("id_prodotto"));
				prodotto.setMarcaProdotto(result.getString("marcaProdotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				prodotto.setNumeroVisite(result.getInt("numeroVisite"));

				prodotto.setImmaginePrincipale(result.getString("immaginePrincipale"));
				;

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
	public List<ProdottoConImmagini> findProductsByVenditoreProdottoConImmagini(String emailVenditore) {
		Connection connection = this.dataSource.getConnection();
		List<ProdottoConImmagini> prodotti = new LinkedList<>();

		try {

			ProdottoConImmagini prodotto;
			PreparedStatement statement;

			String query = "select id_prodotto from venditorePerProdotto where emailVenditore = ?";

			statement = connection.prepareStatement(query);
			statement.setString(1, emailVenditore);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				prodotto = findByPrimaryKeyProdottoConImmagini(result.getInt("id_prodotto"));
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
	public List<ProdottoConImmagini> findProductsByCarrelloProdottiConImmagini(Carrello carrello) {
		Connection connection = this.dataSource.getConnection();
		List<ProdottoConImmagini> prodotti = new LinkedList<>();
		try {
			PreparedStatement statement;
			String query = "select id_prodottoInCarrello from prodottoInCarrello where email_utenteCarrello = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, carrello.getUtenteCarrello());
			ResultSet result = statement.executeQuery();
			while (result.next()) {

				prodotti.add(findByPrimaryKeyProdottoConImmagini(result.getInt("id_prodottoInCarrello")));
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
	public List<ProdottoConImmagini> findProductsByMarcaProdottiConImmagini(String marcaProdotto) {

		Connection connection = this.dataSource.getConnection();
		List<ProdottoConImmagini> prodotti = new LinkedList<>();

		try {

			ProdottoConImmagini prodotto;
			PreparedStatement statementProdotto;

			String query = "select id_prodotto from prodotto where marcaProdotto = ?";
			statementProdotto = connection.prepareStatement(query);

			statementProdotto.setString(1, marcaProdotto);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			while (resultProdotto.next()) {
				prodotto = findByPrimaryKeyProdottoConImmagini(resultProdotto.getInt("id_prodotto"));

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
	public List<ProdottoConImmagini> findProductsByPrenventivoProdottiConImmagini(Integer idPreventivo) {

		Connection connection = this.dataSource.getConnection();
		List<ProdottoConImmagini> prodotti = new LinkedList<>();

		try {

			ProdottoConImmagini prodotto;
			PreparedStatement statementProdotto;

			String query = "select id_prodotto from prodottoInPreventivo where id_preventivo = ?";
			statementProdotto = connection.prepareStatement(query);

			statementProdotto.setInt(1, idPreventivo);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			while (resultProdotto.next()) {
				prodotto = findByPrimaryKeyProdottoConImmagini(resultProdotto.getInt("id_prodotto"));

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
	public List<ProdottoConImmagini> findProductsByAmbienteProdottiConImmagini(String ambienteProdotto) {

		Connection connection = this.dataSource.getConnection();
		List<ProdottoConImmagini> prodotti = new LinkedList<>();

		try {

			ProdottoConImmagini prodotto;
			PreparedStatement statementProdotto;

			String query = "select id_prodotto from prodotto where ambienteProdotto = ?";
			statementProdotto = connection.prepareStatement(query);

			statementProdotto.setString(1, ambienteProdotto);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			while (resultProdotto.next()) {
				prodotto = findByPrimaryKeyProdottoConImmagini(resultProdotto.getInt("id_prodotto"));

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
	public List<ProdottoConImmagini> findProductsByTipoProdottiConImmagini(String tipoProdotto) {

		Connection connection = this.dataSource.getConnection();
		List<ProdottoConImmagini> prodotti = new LinkedList<>();

		try {

			ProdottoConImmagini prodotto;
			PreparedStatement statementProdotto;

			String query = "select id_prodotto from prodotto where tipoProdotto = ?";
			statementProdotto = connection.prepareStatement(query);

			statementProdotto.setString(1, tipoProdotto);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			while (resultProdotto.next()) {
				prodotto = findByPrimaryKeyProdottoConImmagini(resultProdotto.getInt("id_prodotto"));

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

	public List<ProdottoConImmagini> prodottiInOfferta() {

		Connection connection = this.dataSource.getConnection();
		List<ProdottoConImmagini> prodotti = new LinkedList<>();

		try {

			ProdottoConImmagini prodotto;
			PreparedStatement statementProdotto;

			String query = "select id_prodotto, descrizioneProdotto, marcaProdotto,numeroVisite,nomeProdotto, prezzoProdotto, numeroVisite, immaginePrincipale from prodotto where offertaProdotto = 1 order by numeroVisite desc, prezzoProdotto desc LIMIT 6";
			statementProdotto = connection.prepareStatement(query);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			while (resultProdotto.next()) {
				prodotto = new ProdottoConImmagini();
				prodotto.setIdProdotto(resultProdotto.getInt("id_prodotto"));
				prodotto.setMarcaProdotto(resultProdotto.getString("marcaProdotto"));
				prodotto.setNomeProdotto(resultProdotto.getString("nomeProdotto"));
				prodotto.setPrezzoProdotto(resultProdotto.getDouble("prezzoProdotto"));
				prodotto.setNumeroVisite(resultProdotto.getInt("numeroVisite"));
				prodotto.setDescrizioneProdotto(resultProdotto.getString("descrizioneProdotto"));
				prodotto.setImmaginePrincipale(resultProdotto.getString("immaginePrincipale"));
				;

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

	public List<ProdottoConImmagini> prodottiPerVisibilitā() {
		Connection connection = this.dataSource.getConnection();
		List<ProdottoConImmagini> prodotti = new LinkedList<>();

		try {

			ProdottoConImmagini prodotto;
			PreparedStatement statementProdotto;

			String query = "select id_prodotto, marcaProdotto,numeroVisite,nomeProdotto, prezzoProdotto, numeroVisite, immaginePrincipale from prodotto order by numeroVisite desc, prezzoProdotto desc LIMIT 6";
			statementProdotto = connection.prepareStatement(query);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			while (resultProdotto.next()) {

				prodotto = new ProdottoConImmagini();
				prodotto.setIdProdotto(resultProdotto.getInt("id_prodotto"));
				prodotto.setMarcaProdotto(resultProdotto.getString("marcaProdotto"));
				prodotto.setNomeProdotto(resultProdotto.getString("nomeProdotto"));
				prodotto.setPrezzoProdotto(resultProdotto.getDouble("prezzoProdotto"));
				prodotto.setNumeroVisite(resultProdotto.getInt("numeroVisite"));

				prodotto.setImmaginePrincipale(resultProdotto.getString("immaginePrincipale"));
				;

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
	public ProdottoConImmagini getProdottoPerPreventivo(Integer idProdotto) {

		Connection connection = this.dataSource.getConnection();

		try {

			ProdottoConImmagini prodotto;
			PreparedStatement statementProdotto;

			String query = "select prod.id_prodotto, prod.nomeProdotto, vend.emailVenditore, vend.nomeNegozio from tarreduDB.prodotto as prod, tarreduDB.venditore as vend, \r\n"
					+ "tarreduDB.venditorePerProdotto as vendPrev\r\n"
					+ "where prod.id_prodotto = vendPrev.id_prodotto and vend.emailVenditore = vendPrev.emailVenditore and prod.id_prodotto=?;";

			statementProdotto = connection.prepareStatement(query);
			statementProdotto.setInt(1, idProdotto);

			ResultSet resultProdotto = statementProdotto.executeQuery();

			if (resultProdotto.next()) {

				prodotto = new ProdottoConImmagini();
				prodotto.setIdProdotto(resultProdotto.getInt("id_prodotto"));
				prodotto.setNomeProdotto(resultProdotto.getString("nomeProdotto"));
				prodotto.setNomeNegozioVenditore((resultProdotto.getString("nomeNegozio")));
				prodotto.setEmailVenditore((resultProdotto.getString("emailVenditore")));

				return prodotto;

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

		return null;
	}

}