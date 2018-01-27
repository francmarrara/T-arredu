package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Statement;

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
			String query = "SELECT * FROM prodottiPreferiti JOIN prodotto where prodottiPreferiti.id_prodotto = prodotto.id_prodotto and prodottiPreferiti.emailUtente=?";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				ProdottoConImmagini prodotto = new ProdottoConImmagini();
				prodotto.setIdProdotto(result.getInt("id_prodotto"));
				prodotto.setNomeProdotto(result.getString("nomeProdotto"));
				prodotto.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				prodotto.setMarcaProdotto(result.getString("marcaProdotto"));
				prodotto.setNumeroVisite(result.getInt("numeroVisite"));

				prodotto.setImmaginePrincipale(result.getString("immaginePrincipale"));
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
	
	
    @Override
	public boolean giaPreferito(Integer idProdotto, String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		try {

			PreparedStatement statement;
			String query = "select id_prodotto from prodottiPreferiti where emailUtente = ? and id_prodotto = ? ";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtente);
			statement.setInt(2, idProdotto);

			ResultSet result = statement.executeQuery();

			if (!result.first() == false) {
				System.out.println("no data");
				return true;
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

		return false;
	}
    
    @Override
   	public boolean giaInCarrello(Integer idProdotto, String emailUtente) {

   		Connection connection = this.dataSource.getConnection();

   		try {

   			PreparedStatement statement;
   			String query = "select id_prodottoInCarrello from prodottoInCarrello where email_utenteCarrello = ? and id_prodottoInCarrello = ? ";
   			statement = connection.prepareStatement(query);
   			statement.setString(1, emailUtente);
   			statement.setInt(2, idProdotto);

   			ResultSet result = statement.executeQuery();

   			if (!result.first() == false) {
   				
   				return true;
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

   		return false;
   	}
    
    
    

	@Override
	public boolean giaRegistrato(String email) {

		Connection connection = this.dataSource.getConnection();

		try {

			PreparedStatement statement;
			String query = "select email from utente where email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);

			ResultSet result = statement.executeQuery();

			if (!result.first() == false) {
				return true;
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

		return false;

	}

	@Override
	public boolean credenzialiUtenteGiaPresenti(String email, String password) {

		Connection connection = this.dataSource.getConnection();

		PreparedStatement statement;

		try {

			String query = "select * FROM utente WHERE email = ? and passwordUtente = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, email);
			statement.setString(2, password);

			ResultSet result = statement.executeQuery();

			if (!result.first() == false)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public String getNomeUtente(String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		PreparedStatement statement;

		String nomeUtente = null;

		try {

			String query = "select nome FROM utente WHERE email = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, emailUtente);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				nomeUtente = result.getString("nome");
System.out.println("SUCA");
				return nomeUtente;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public void aggiungiProdottoInCarrello(Integer idProdotto, String emailUtente) {

		Connection connection = this.dataSource.getConnection();

		try {

			String insert = "insert into prodottoInCarrello(id_prodottoInCarrello, email_utenteCarrello) values (?,?)";
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
	public void rimuoviProdottoInCarrello(Integer idProdotto, String emailUtente) {
		Connection connection = this.dataSource.getConnection();
		try {

			String delete = "delete FROM prodottoInCarrello WHERE id_prodottoInCarrello = ? and email_utenteCarrello = ?";
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

}
