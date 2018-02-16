package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Venditore;
import persistenceDAO.DataSource;
import persistenceDAO.IdBuilder;
import persistenceDAO.PersistenceException;
import persistenceDAO.VenditoreDAO;

public class VenditoreDaoJDBC implements VenditoreDAO {
	private DataSource dataSource;

	public VenditoreDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Venditore venditore) {

		Connection connection = dataSource.getConnection();

		try {

			String save = " insert into venditore(id_venditore, nomeTitolare, cognomeTitolare, "
					+ "nomeNegozio, indirizzoVenditore, emailVenditore, numeroTelefonicoVenditore, descrizioneVenditore, latitudineVenditore, longitudineVenditore) values"
					+ "(?,?,?,?,?,?,?,?,?,?) ";

			PreparedStatement statement = connection.prepareStatement(save);

			Integer id = IdBuilder.getId(connection);
			venditore.setIdVenditore(id);

			statement.setInt(1, id);
			statement.setString(2, venditore.getNomeTitolare());
			statement.setString(3, venditore.getCognomeTitolare());
			statement.setString(4, venditore.getNomeNegozio());
			statement.setString(5, venditore.getIndirizzoVenditore());
			statement.setString(6, venditore.getEmailVenditore());
			statement.setString(7, venditore.getNumeroTelefonicoVenditore());
			statement.setString(8, venditore.getDescrizioneVenditore());
			statement.setString(9, venditore.getLatitudineVenditore());
			statement.setString(10, venditore.getLongitudineVenditore());

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
	public Venditore findByPrimaryKey(String emailVenditore) {

		Connection connection = dataSource.getConnection();
		Venditore venditore = new Venditore();

		try {

			String find = " select * from venditore where emailVenditore = ? ";

			PreparedStatement statement = connection.prepareStatement(find);

			statement.setString(1, emailVenditore);

			ResultSet result = statement.executeQuery();

			if (result.next()) {

				venditore.setIdVenditore(result.getInt("id_venditore"));
				venditore.setNomeTitolare(result.getString("nomeTitolare"));
				venditore.setCognomeTitolare(result.getString("cognomeTitolare"));
				venditore.setNomeNegozio(result.getString("nomeNegozio"));
				venditore.setIndirizzoVenditore(result.getString("indirizzoVenditore"));
				venditore.setEmailVenditore(result.getString("emailVenditore"));
				venditore.setNumeroTelefonicoVenditore(result.getString("numeroTelefonicoVenditore"));
				venditore.setDescrizioneVenditore(result.getString("descrizioneVenditore"));
				venditore.setLatitudineVenditore(result.getString("latitudineVenditore"));
				venditore.setLongitudineVenditore(result.getString("longitudineVenditore"));


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

		return venditore;
	}

	@Override
	public List<Venditore> findAll() {

		Connection connection = this.dataSource.getConnection();
		List<Venditore> venditori = new LinkedList<>();

		try {

			Venditore venditore;

			String query = "select * from venditore";
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				venditore = new Venditore();

				venditore.setIdVenditore(result.getInt("id_venditore"));
				venditore.setNomeTitolare(result.getString("nomeTitolare"));
				venditore.setCognomeTitolare(result.getString("cognomeTitolare"));
				venditore.setNomeNegozio(result.getString("nomeNegozio"));
				venditore.setIndirizzoVenditore(result.getString("indirizzoVenditore"));
				venditore.setEmailVenditore(result.getString("emailVenditore"));
				venditore.setNumeroTelefonicoVenditore(result.getString("numeroTelefonicoVenditore"));
				venditore.setDescrizioneVenditore(result.getString("descrizioneVenditore"));
				venditore.setLatitudineVenditore(result.getString("latitudineVenditore"));
				venditore.setLongitudineVenditore(result.getString("longitudineVenditore"));


				venditori.add(venditore);

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

		return venditori;
	}

	@Override
	public List<Venditore> findVenditoriByPreventivo(Integer codicePreventivo) {

		Connection connection = this.dataSource.getConnection();
		List<Venditore> venditori = new LinkedList<>();

		try {

			PreparedStatement statement;
			String query = "select * from venditoreInPreventivo where preventivoID = ?";

			statement = connection.prepareStatement(query);
			statement.setInt(1, codicePreventivo);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				venditori.add(findByPrimaryKey(result.getString("venditoreEmail")));

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
		return venditori;
	}

	@Override
	public void update(Venditore venditore) {

		Connection connection = this.dataSource.getConnection();

		try {

			String update = "update venditore SET nomeTitolare = ?, cognomeTitolare = ?, nomeNegozio = ?, "
					+ "indirizzoVenditore = ?, emailVenditore = ?, numeroTelefonicoVenditore = ?, descrizioneVenditore = ?, latitudineVenditore = ?,"
					+ "longitudineVenditore=? "
					+ "WHERE emailVenditore = ?";
			PreparedStatement statement = connection.prepareStatement(update);

			statement.setString(1, venditore.getNomeTitolare());
			statement.setString(2, venditore.getCognomeTitolare());
			statement.setString(3, venditore.getNomeNegozio());
			statement.setString(4, venditore.getIndirizzoVenditore());
			statement.setString(5, venditore.getEmailVenditore());
			statement.setString(6, venditore.getNumeroTelefonicoVenditore());
			statement.setString(7, venditore.getDescrizioneVenditore());
			statement.setString(8, venditore.getLatitudineVenditore());
			statement.setString(9, venditore.getLongitudineVenditore());
			statement.setString(10, venditore.getEmailVenditore());
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
	public void delete(Venditore venditore) {

		Connection connection = this.dataSource.getConnection();

		try {

			String delete = "delete FROM venditore WHERE email = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, venditore.getEmailVenditore());

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

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<String> venditoriCheNonRicevonoPreventiviDa30Giorni() {
		Connection connection = this.dataSource.getConnection();
		List<String> emails = new ArrayList<String>();
		try {
			String query = "SELECT venditoreEmail from venditoreInPreventivo as V, preventivo as P where V.preventivoID = P.id_preventivo AND P.data_ora_preventivo <(curdate()- INTERVAL 30 DAY);";
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				emails.add(result.getString("venditoreEmail"));
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
		return emails;
	
	}

}
