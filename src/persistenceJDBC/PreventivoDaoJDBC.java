package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Preventivo;
import model.Prodotto;
import model.Utente;
import model.Venditore;
import persistenceDAO.DataSource;
import persistenceDAO.PersistenceException;
import persistenceDAO.PreventivoDAO;
import persistenceDAO.ProdottoDAO;
import persistenceDAO.UtenteDAO;
import persistenceDAO.VenditoreDAO;

public class PreventivoDaoJDBC implements PreventivoDAO {

	private DataSource dataSource;

	public PreventivoDaoJDBC(DataSource dataSource) {

		this.dataSource = dataSource;

	}

	@Override
	public void save(Preventivo preventivo) {

		Connection connection = dataSource.getConnection();
		
		try {
			
			String save = " insert into preventivo (data_ora_preventivo) values (?) ";
			
			PreparedStatement statement = connection.prepareStatement(save);
			
			long secs = preventivo.getDataOraPreventivo().getTime();
			statement.setDate(1, new java.sql.Date(secs));
			
			statement.executeUpdate();
			
			updateProdotto(preventivo, connection);
			
			
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
	public Preventivo findByPrimaryKey(Long codicePreventivo) {

		Connection connection = this.dataSource.getConnection();
		Preventivo preventivo = null;
		
		PreparedStatement statement;
		String query = "select * from preventivo where id_preventivo = ?";
		
		try {
			
			statement = connection.prepareStatement(query);
			statement.setLong(0, codicePreventivo);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				preventivo = new Preventivo();
				
				preventivo.setIdPreventivo((int) result.getLong("id_preventivo"));
				
				long secs = result.getDate("data_ora_preventivo").getTime();
				preventivo.setDataOraPreventivo(new java.util.Date(secs));
				
				VenditoreDAO venditoreDAO = new VenditoreDaoJDBC(dataSource);
				Venditore venditore = venditoreDAO.findByPrimaryKey(result.getString("id_venditore"));
				preventivo.setIdVenditore(venditore);
				
				//cambiare la chiave primaria di utente dentro preventivo, ossia email utente
				UtenteDAO utenteDAO = new UtenteDaoJDBC(dataSource);
				Utente utente = utenteDAO.findByPrimaryKey(result.getString("email"));
				preventivo.setIdUtente(utente);
				
				ProdottoDAO prodottoDAO = new ProdottoDaoJDBC(dataSource);
				List<Prodotto> listaProdotto = prodottoDAO.findProductsByPreventivo(codicePreventivo);
				preventivo.setListaProdotti(listaProdotto);
				
				
				
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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Preventivo preventivo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Preventivo> findAll() {

		Connection connection = this.dataSource.getConnection();
		List<Preventivo> preventivi = new LinkedList<>();
		List<Prodotto> prodotti = new LinkedList<>();

		try {

			Preventivo preventivo;

			String query = "select * from preventivo";
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				preventivo = new Preventivo();

				preventivo.setIdPreventivo(result.getInt("id_preventivo"));
				long secs = result.getDate("data_ora_preventivo").getTime();
				preventivo.setDataOraPreventivo(new java.util.Date(secs));

				UtenteDAO utenteDao = new UtenteDaoJDBC(dataSource);
				Utente utente = new Utente();
				utente = utenteDao.findByPrimaryKey(result.getString("id_utente"));
				preventivo.setIdUtente(utente);
				
				VenditoreDAO venditoreDao = new VenditoreDaoJDBC(dataSource);
				Venditore venditore = new Venditore();
				venditore = venditoreDao.findByPrimaryKey(result.getString("id_venditore"));
				preventivo.setIdVenditore(venditore);
				
				prodotti = findAllProductByPreventivo(preventivo.getIdPreventivo());// DA FARE
				preventivo.setListaProdotti(prodotti);
				
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
	public void updateProdotto(Preventivo preventivo, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUtente(Preventivo preventivo, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVenditore(Preventivo preventivo, Connection connection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prodotto> findAllProductByPreventivo(Integer id_preventivo) {
		return null;
		
		
		
	}



}
