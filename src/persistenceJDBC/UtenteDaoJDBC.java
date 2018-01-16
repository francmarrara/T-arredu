package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Prodotto;
import model.ProdottoConImmagini;
import model.Utente;
import persistenceDAO.DataSource;
import persistenceDAO.IdBuilder;
import persistenceDAO.PersistenceException;
import persistenceDAO.ProdottoDAO;
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

			String insert = "insert into utente(utente_id, nome, cognome, dataNascita, email, numeroTelefonico, passwordUtente) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			Integer id = IdBuilder.getId(connection);
			utente.setIdUtente(id);

			statement.setInt(1, id);
			statement.setString(2, utente.getNomeUtente());
			statement.setString(3, utente.getCognomeUtente());

			long secs = utente.getDatadiNascita().getTime();
			statement.setDate(4, new java.sql.Date(secs));

			statement.setString(5, utente.getEmailUtente());
			statement.setString(6, utente.getNumeroTelefonoUtente());
			statement.setString(7, utente.getPasswordUtente());

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
		} finally {
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

	@Override
	public void aggiungiProdottoInPreferiti(Integer idProdotto, String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		try {

			String insert = "insert into prodottiPreferiti(id_prodotto, emailUtente) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, idProdotto);
			statement.setString(2, emailUtente);

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
	public void rimuoviProdottoInPreferiti(Integer idProdotto, String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		try {

			String delete = "delete FROM prodottiPreferiti WHERE id_prodotto = ? and emailUtente = ?";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setInt(1, idProdotto);
			statement.setString(2, emailUtente);

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
	public List<Prodotto> getProdottiPreferiti(String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);
		
		try {

			PreparedStatement statement;
			String query = "select id_prodotto from prodottiPreferiti where emailUtente = ? ";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				System.out.println(result.getInt("id_prodotto"));
				prodotti.add(prodottoDao.findByPrimaryKey(result.getInt("id_prodotto")));
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
	public List<ProdottoConImmagini> getProdottiPreferitiConImmagini(String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		List<ProdottoConImmagini> prodotti = new ArrayList<ProdottoConImmagini>();
		ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);
		
		try {

			PreparedStatement statement;
			String query = "SELECT \r\n" + 
					"        `p`.`id_prodotto` AS `id`,\r\n" + 
					"        `p`.`nomeProdotto` AS `nome`,\r\n" + 
					"        `p`.`prezzoProdotto` AS `prezzo`,\r\n" + 
					"		`a`.`mailUtente` AS `mail`\r\n" + 
					"\r\n" + 
					"    FROM\r\n" + 
					"        (`prodottiPreferiti` `a`\r\n" + 
					"        FULL OUTER JOIN `prodotto` `p`)\r\n" + 
					"    WHERE\r\n" + 
					"        `a`.`id_prodotto` = `p`.`id_prodotto` AND `a`.`emailUtente` = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				ProdottoConImmagini prodotto = new ProdottoConImmagini();
				prodotto.setIdProdotto(result.getInt("id"));
				prodotto.setNomeProdotto(result.getString("nome"));
				prodotto.setPrezzoProdotto(result.getDouble("prezzo"));
				
				prodotto.setUrlImmagini(prodottoDao.getImages(prodotto.getIdProdotto()));
				
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
	public void rimuoviPreferiti(String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		try {

			String delete = "delete FROM prodottiPreferiti WHERE emailUtente = ?";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.setString(1, emailUtente);

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

}
