package persistenceJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Commento;
import persistenceDAO.CommentoDAO;
import persistenceDAO.DataSource;
import persistenceDAO.PersistenceException;

public class CommentoDaoJDBC implements CommentoDAO {
	
	private DataSource dataSource;

      public CommentoDaoJDBC(DataSource ds) {
		this.dataSource = ds;
	}
	

	@Override
	public void save(Commento commento) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into commentoProdotto(id_commentoProdotto, "
					+ "utenteEmail, idProdotto, commentoProdotto, valutazioneProdotto) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setInt(1, commento.getIdCommento());
			statement.setString(2, commento.getEmailUtente());
			statement.setInt(3, commento.getIdProdotto());
			statement.setString(4, commento.getCommento());
			statement.setInt(5, commento.getValutazione());
			

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
	public Commento findByPrimaryKey(Integer idCommento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commento> findByProduct(Integer idProdotto) {
		Connection connection = this.dataSource.getConnection();
		List<Commento> commenti = new LinkedList<>();

		try {
            Commento c;


			PreparedStatement statement;

			String query = "select * from commentoProdotto where idProdotto = ?";
			statement = connection.prepareStatement(query);

			statement.setInt(1, idProdotto);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
              c = new Commento();
              c.setIdCommento(result.getInt("id_commentoProdotto"));
              c.setCommento(result.getString("commentoProdotto"));
              c.setValutazione(result.getInt("valutazioneProdotto"));
              c.setEmailUtente(result.getString("utenteEmail"));
              c.setIdProdotto(idProdotto);
              
              commenti.add(c);
				
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
		return commenti;
		
		
		
	}

	@Override
	public void update(Commento commento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer idCommento) {
		// TODO Auto-generated method stub

	}

}
