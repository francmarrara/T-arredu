package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Indirizzo;
import model.Studente;
import model.Utente;
import persistence.IndirizzoDaoJDBC;
import persistence.dao.IndirizzoDao;
import persistenceDAO.DataSource;
import persistenceDAO.PersistenceException;
import persistenceDAO.UtenteDAO;

public class UtenteDaoJDBC implements UtenteDAO {

	private DataSource dataSource;
	
	public UtenteDaoJDBC(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	@Override
	public void save(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into utente(nome, cognome, dataNascita, email, numeroTelefonico, passwordUtente) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getNomeUtente());
			statement.setString(2, utente.getCognomeUtente());
			long secs = utente.getDatadiNascita().getTime();
			statement.setDate(3, new java.sql.Date(secs));
			statement.setString(4, utente.getEmailUtente());
			statement.setString(5, utente.getNumeroTelefonoUtente());
			statement.setString(6, utente.getPasswordUtente());
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
	public Utente findByPrimaryKey(String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setMatricola(result.getString("matricola"));				
				studente.setNome(result.getString("nome"));
				studente.setCognome(result.getString("cognome"));
				long secs = result.getDate("data_nascita").getTime();
				studente.setDataNascita(new java.util.Date(secs));
				
				IndirizzoDao indirizzoDao = new IndirizzoDaoJDBC(dataSource);
				Indirizzo indirizzo = indirizzoDao.findByPrimaryKey(result.getLong("indirizzo_codice"));
				studente.setIndirizzo(indirizzo);
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
		return studente;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utente utente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utente utente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(Utente utente, String password) {
		// TODO Auto-generated method stub
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
