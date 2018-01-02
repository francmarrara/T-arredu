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
			updateUtente(preventivo, connection);
			updateVenditore(preventivo, connection);
			
			
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
		
		
		
		return preventivo;
	}

	@Override
	public void update(Preventivo preventivo) {

		Connection connection = this.dataSource.getConnection();

		try {

			String update = "update preventivo SET data_ora_preventivo = ?";
			PreparedStatement statement = connection.prepareStatement(update);

			long secs = preventivo.getDataOraPreventivo().getTime();
			statement.setDate(1, new java.sql.Date(secs));
			
			// MANCANO TABELLE PREVENTIVO-VENDITORE PRODOTTO-PREVENTIVO UTENTE-PREVENTIVO
			

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

			String delete = "delete FROM preventivo WHERE id_preventivo = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, preventivo.getIdPreventivo());

			statement.executeUpdate();
			
			// MANCANO TABELLE PREVENTIVO-VENDITORE PRODOTTO-PREVENTIVO UTENTE-PREVENTIVO

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
		List<Prodotto> prodotti = new LinkedList<>();

		

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
	public void addProductToPreventivo(Prodotto prodotto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prodotto> findAllProdottoByPreventivo(Integer id_preventivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venditore> findAllVenditoreByPreventivo(Integer id_preventivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente findUtenteByPreventivo(String emailUtente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addVenditoreToPreventivo(Venditore venditore) {
		// TODO Auto-generated method stub
		
	}



}
