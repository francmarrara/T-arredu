package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Carrello;
import model.Prodotto;
import model.ProdottoConImmagini;
import persistenceDAO.CarrelloDAO;
import persistenceDAO.DAOFactory;
import persistenceDAO.DataSource;
import persistenceDAO.IdBuilder;
import persistenceDAO.PersistenceException;
import persistenceDAO.ProdottoDAO;
import persistenceDAO.UtenteDAO;

public class CarrelloDaoJDBC implements CarrelloDAO {

	private DataSource dataSource;

	public CarrelloDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

//	@Override
//	public void save(Carrello carrello) {
//		Connection connection = dataSource.getConnection();
//		try {
//			String insert = "insert into carrello(id_carrello, email_utente) values (?,?)";
//			
//			Integer id = IdBuilder.getId(connection);
//			carrello.setUtenteCarello(id);
//			
//			PreparedStatement statement = connection.prepareStatement(insert);
//			
//			statement.setInt(1, id);
//			statement.setString(2, carrello.getUtenteCarrello().getEmailUtente());
//
//			statement.executeUpdate();
//
//			for (ProdottoConImmagini p : carrello.getProdottiNelCarrello()) {
//
//				insert = "insert into prodottoInCarrello(id_prodottoInCarrello, email_utenteCarrello) values (?,?)";
//			    statement = connection.prepareStatement(insert);
//
//			    statement.setInt(1, p.getIdProdotto());
//				statement.setString(2, carrello.getUtenteCarrello().getEmailUtente());
//				statement.executeUpdate();
//
//			}
//
//		} catch (
//
//		SQLException e) {
//			throw new PersistenceException(e.getMessage());
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				throw new PersistenceException(e.getMessage());
//			}
//		}
//
//	}

	@Override
	public Carrello findByPrimaryKey(String emailUtenteCarrello) {
		Connection connection = this.dataSource.getConnection();
		Carrello carrello = null;
		try {
			PreparedStatement statement;
			String query = "select id_prodotto,nomeProdotto,marcaProdotto,prezzoProdotto,immaginePrincipale from prodottoInCarrello as ProdCarrello , prodotto as prod where email_utenteCarrello "
					+ "= ? and prod.id_prodotto = id_prodottoInCarrello";
			statement = connection.prepareStatement(query);
			statement.setString(1, emailUtenteCarrello);
			ResultSet result = statement.executeQuery();

			DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			
			carrello = new Carrello();
			carrello.setUtenteCarello(emailUtenteCarrello);

		
			while (result.next()) {
				ProdottoConImmagini p = new ProdottoConImmagini();
				p.setIdProdotto(result.getInt("id_prodotto"));
				p.setNomeProdotto(result.getString("nomeProdotto"));
				p.setMarcaProdotto(result.getString("marcaProdotto"));
				p.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
				p.setImmaginePrincipale(result.getString("immaginePrincipale"));
				
                carrello.getProdottiNelCarrello().add(p);
				

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
		return carrello;
	}

//	@Override
//	public List<Carrello> findAll() {
//		Connection connection = this.dataSource.getConnection();
//		List<Carrello> listaCarrelli = new LinkedList<Carrello>();
//		try {
//			Carrello carrello = null;
//
//			PreparedStatement statement;
//			String query = "select * from carrello";
//			statement = connection.prepareStatement(query);
//			ResultSet result = statement.executeQuery();
//			UtenteDAO utenteDao = new UtenteDaoJDBC(dataSource);
//
//			if (result.next()) {
//				carrello = new Carrello();
//				carrello.setUtenteCarello(result.getInt(("id_carrello")));
//				carrello.setUtenteCarello(utenteDao.findByPrimaryKey(result.getString("email_utente")));
//
//				query = "select * from prodottoInCarrello where email_utenteCarrello = ?";
//				statement = connection.prepareStatement(query);
//				statement.setString(1, result.getString("email_utente"));
//				result = statement.executeQuery();
//				ProdottoDAO prodottoDao = new ProdottoDaoJDBC(dataSource);
//
//				if (result.next()) {
//
//					carrello.getProdottiNelCarrello()
//							.add(prodottoDao.findByPrimaryKeyProdottoConImmagini(result.getInt("id_prodottoInCarrello")));
//
//				}
//				listaCarrelli.add(carrello);
//
//			}
//
//		} catch (SQLException e) {
//			throw new PersistenceException(e.getMessage());
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				throw new PersistenceException(e.getMessage());
//			}
//		}
//		return listaCarrelli;
//
//	}

	@Override
	public void addProduct(Prodotto p, Carrello c) {
		
		Connection connection = dataSource.getConnection();
		try {
			String insert = "insert into prodottoInCarrello(email_utenteCarrello, id_prodottoInCarrello) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, c.getUtenteCarrello());
			statement.setInt(2, p.getIdProdotto());

			statement.executeUpdate();
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
		
		
	}

	@Override
	public void removeProduct(Prodotto p, Carrello c) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM prodottoInCarrello WHERE email_utenteCarrello  = ? and id_prodottoInCarrello = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, c.getUtenteCarrello());
			statement.setInt(2,p.getIdProdotto());
			
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
	public void delete(Carrello carrello) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM prodottoInCarrello WHERE email_utenteCarrello  = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, carrello.getUtenteCarrello());
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
