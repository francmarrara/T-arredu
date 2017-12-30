package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Utente;
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
				utente.setIdUtente(result.getInt("utente_id"));			
				utente.setNomeUtente(result.getString("nome"));
				utente.setCognomeUtente(result.getString("cognome"));
				long secs = result.getDate("dataNascita").getTime();
				utente.setDatadiNascita(new java.util.Date(secs));
		        utente.setEmailUtente(result.getString("email"));
                utente.setNumeroTelefonoUtente(result.getString("numeroTelefonico"));
                utente.setPasswordUtente(result.getString("passwordUtente"));
				
		                                     
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
	public List<Utente> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Utente> utenti = new LinkedList<>();
		try {
			Utente utente;
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new Utente();
				utente.setIdUtente(result.getInt("utente_id"));			
				utente.setNomeUtente(result.getString("nome"));
				utente.setCognomeUtente(result.getString("cognome"));
				long secs = result.getDate("dataNascita").getTime();
				utente.setDatadiNascita(new java.util.Date(secs));
		        utente.setEmailUtente(result.getString("email"));
                utente.setNumeroTelefonoUtente(result.getString("numeroTelefonico"));
                utente.setPasswordUtente(result.getString("passwordUtente"));
				
				utenti.add(utente);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return utenti;
	}

	@Override
	public void update(Utente utente) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET nome = ?, cognome = ?, dataNascita = ?, email = ?, numeroTelefonico = ?, passwordUtente = ?  WHERE email=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getNomeUtente());
			statement.setString(2, utente.getCognomeUtente());
			long secs = utente.getDatadiNascita().getTime();
			statement.setDate(3, new java.sql.Date(secs));
			statement.setString(4, utente.getEmailUtente());
			statement.setString(5, utente.getNumeroTelefonoUtente());
			statement.setString(6, utente.getPasswordUtente());
			statement.setString(7, utente.getEmailUtente());
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
	public void delete(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM utente WHERE email = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, utente.getEmailUtente());
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
	public void changePassword(Utente utente, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET passwordUtente = ? WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, utente.getEmailUtente());
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

}
