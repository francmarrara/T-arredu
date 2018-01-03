package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.print.attribute.SetOfIntegerSyntax;

import model.Preventivo;
import model.Prodotto;
import model.Utente;
import model.Venditore;
import persistenceDAO.DataSource;
import persistenceDAO.IdBuilder;
import persistenceDAO.PersistenceException;
import persistenceDAO.PreventivoDAO;
import persistenceDAO.UtenteDAO;

public class PreventivoDaoJDBC implements PreventivoDAO {

	private DataSource dataSource;

	public PreventivoDaoJDBC(DataSource dataSource) {

		this.dataSource = dataSource;

	}

	@Override
	public void save(Preventivo preventivo) {

		Connection connection = dataSource.getConnection();

		try {

			String save = " insert into preventivo (id_preventivo, data_ora_preventivo, id_utente) values (?,?,?) ";

			PreparedStatement statement = connection.prepareStatement(save);

			System.out.println("prev " + preventivo.getIdPreventivo());
			statement.setInt(1, preventivo.getIdPreventivo());

			long secs = preventivo.getDataOraPreventivo().getTime();
			statement.setDate(2, new java.sql.Date(secs));

			Utente utente = new Utente();
			UtenteDAO utenteDao = new UtenteDaoJDBC(dataSource);

			utente = utenteDao.findByPrimaryKey(preventivo.getUtente().getEmailUtente());
			statement.setString(3, utente.getEmailUtente());

			statement.executeUpdate();

			updateProdottoInPreventivo(preventivo);
			updateVenditoreInPreventivo(preventivo);

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
	public Preventivo findByPrimaryKey(Integer codicePreventivo) {

		Connection connection = dataSource.getConnection();
		Preventivo preventivo = null;

		try {

			String find = "select * from preventivo where id_preventivo = ?";
			PreparedStatement statement = connection.prepareStatement(find);

			statement.setInt(1, codicePreventivo);

			ResultSet result = statement.executeQuery();

			if (result.next()) {

				preventivo = new Preventivo();
				preventivo.setIdPreventivo(result.getInt("id_preventivo"));

				long secs = result.getDate("data_ora_preventivo").getTime();
				preventivo.setDataOraPreventivo(new java.util.Date(secs));

				Utente utente = new Utente();
				UtenteDAO utenteDao = new UtenteDaoJDBC(dataSource);
				utente = utenteDao.findByPrimaryKey(result.getString("id_utente"));

				preventivo.setUtente(utente);

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

		return preventivo;
	}

	@Override
	public void update(Preventivo preventivo) {

		Connection connection = this.dataSource.getConnection();

		try {

			String update = "update preventivo SET data_ora_preventivo = ?, id_utente = ? WHERE id_preventivo = ?";
			PreparedStatement statement = connection.prepareStatement(update);

			long secs = preventivo.getDataOraPreventivo().getTime();
			statement.setDate(1, new java.sql.Date(secs));

			statement.setString(2, preventivo.getUtente().getEmailUtente());
			statement.setInt(3, preventivo.getIdPreventivo());

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
	public void delete(Preventivo preventivo) {

		Connection connection = this.dataSource.getConnection();

		try {

			// Prima di eliminare un preventivo, elimino i riferimenti nelle tabelle
			// prodottoInPreventivo
			// e venditoreInPreventivo
			String delete = "delete FROM prodottoInPreventivo WHERE preventivoID = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setInt(1, preventivo.getIdPreventivo());

			statement.executeUpdate();

			delete = "delete FROM venditoreInPreventivo WHERE preventivoID = ? ";
			statement = connection.prepareStatement(delete);

			statement.setInt(1, preventivo.getIdPreventivo());

			statement.executeUpdate();

			delete = "delete FROM preventivo WHERE id_preventivo = ? ";
			statement = connection.prepareStatement(delete);

			statement.setInt(1, preventivo.getIdPreventivo());

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
	public List<Preventivo> findAll() {

		Connection connection = this.dataSource.getConnection();
		List<Preventivo> preventivi = new LinkedList<>();

		try {

			String findAll = "select * from preventivo";
			PreparedStatement statement = connection.prepareStatement(findAll);

			ResultSet results = statement.executeQuery();

			while (results.next()) {

				Preventivo preventivo = new Preventivo();
				preventivo.setIdPreventivo(results.getInt("id_preventivo"));

				long secs = results.getDate("data_ora_preventivo").getTime();
				preventivo.setDataOraPreventivo(new java.util.Date(secs));

				Utente utente = new Utente();
				UtenteDAO utenteDao = new UtenteDaoJDBC(dataSource);
				utente = utenteDao.findByPrimaryKey(results.getString("id_utente"));

				preventivo.setUtente(utente);

				preventivi.add(preventivo);

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

		return preventivi;

	}

	@Override
	public void updateProdottoInPreventivo(Preventivo preventivo) {

		Connection connection = dataSource.getConnection();

		try {

			if (!(preventivo.getListaProdotti().isEmpty())) {

				for (Prodotto p : preventivo.getListaProdotti()) {

					addProductToPreventivo(p, preventivo);

				}
			}

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public void updateVenditoreInPreventivo(Preventivo preventivo) {

		Connection connection = dataSource.getConnection();

		try {

			if (!(preventivo.getListaVenditori().isEmpty())) {

				for (Venditore v : preventivo.getListaVenditori()) {

					addVenditoreToPreventivo(v, preventivo);

				}

			}

		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public Utente findUtenteByPreventivo(Preventivo preventivo) {

		Connection connection = dataSource.getConnection();
		Utente utente = null;

		try {

			String find = "select id_utente from preventivo where id_preventivo = ?";
			PreparedStatement statement = connection.prepareStatement(find);

			statement.setInt(1, preventivo.getIdPreventivo());

			ResultSet result = statement.executeQuery();

			if (result.next()) {

				UtenteDAO utenteDao = new UtenteDaoJDBC(dataSource);
				utente = utenteDao.findByPrimaryKey(result.getString("id_utente"));

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

		return utente;

	}

	@Override
	public void addProductToPreventivo(Prodotto prodotto, Preventivo preventivo) {

		Connection connection = dataSource.getConnection();

		try {

			String addProduct = "insert into prodottoInPreventivo (id_prodottoInPreventivo, preventivoID, "
					+ "prodottoID) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(addProduct);

			Integer id = IdBuilder.getId(connection);
			statement.setInt(1, id);

			statement.setInt(2, preventivo.getIdPreventivo());
			statement.setInt(3, prodotto.getIdProdotto());

			statement.executeUpdate();

			preventivo.addProdotto(prodotto);

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
	public void addVenditoreToPreventivo(Venditore venditore, Preventivo preventivo) {

		Connection connection = dataSource.getConnection();

		try {

			String addVenditore = "insert into venditoreInPreventivo (id_venditoreInPreventivo, venditoreEmail, "
					+ "preventivoID) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(addVenditore);

			Integer id = IdBuilder.getId(connection);
			statement.setInt(1, id);

			statement.setString(2, venditore.getEmailVenditore());
			statement.setInt(3, preventivo.getIdPreventivo());

			statement.executeUpdate();

			preventivo.addVenditore(venditore);

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

}
