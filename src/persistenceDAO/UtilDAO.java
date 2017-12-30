package persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDAO {

	private DataSource dataSource;

	public UtilDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void dropDatabase() {

		Connection connection = dataSource.getConnection();
		try {

			String delete = "drop table if exists utente;";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();

			delete = "drop table if exists prodotto;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();

			delete = "drop table if exists venditore;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();

			// + "drop table if exists feedback;"
			
			delete = "drop table if exists preventivo;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			// + "drop table if exists carrello;";

			System.out.println("Executed drop database");

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

	public void createDatabase() {

		Connection connection = dataSource.getConnection();
		try {

			String add = "CREATE TABLE `utente` (\r\n" + "  `utente_id` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `nome` VARCHAR(255) NOT NULL,\r\n" + "  `cognome` VARCHAR(255) NOT NULL,\r\n"
					+ "  `dataNascita` DATE NOT NULL,\r\n" + "  `email` VARCHAR(255) NOT NULL,\r\n"
					+ "  `numeroTelefonico` VARCHAR(255) NOT NULL,\r\n"
					+ "  `passwordUtente` VARCHAR(255) NOT NULL,\r\n"
					+ "  UNIQUE INDEX `utente_id_UNIQUE` (`utente_id` ASC),\r\n" + "  PRIMARY KEY (`email`));";

			PreparedStatement statement = connection.prepareStatement(add);
			statement.executeUpdate();

			add = "CREATE TABLE `venditore` (\r\n" + "  `id_venditore` INT NOT NULL AUTO_INCREMENT, \r\n"  
					+ "  `nomeTitolare` VARCHAR(255) NOT NULL,\r\n" + "  `cognomeTitolare` VARCHAR(255) NOT NULL,\r\n"
					+ "  `nomeNegozio` VARCHAR(255) NOT NULL,\r\n" + "  `indirizzoVenditore` VARCHAR(255) NOT NULL,\r\n"
					+ "  `emailVenditore` VARCHAR(255) NOT NULL,\r\n"
					+ "  `numeroTelefonicoVenditore` VARCHAR(255) NOT NULL,\r\n" + "  PRIMARY KEY (`id_venditore`),\r\n"
					+ "  UNIQUE INDEX `id_venditore_UNIQUE` (`id_venditore` ASC));";

			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			

			add = "CREATE TABLE `tarreduDB`.`prodotto` (\r\n" + "  `id_prodotto` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `marcaProdotto` VARCHAR(255) NOT NULL,\r\n" + "  `ambienteProdotto` VARCHAR(255) NOT NULL,\r\n"
					+ "  `nomeProdotto` VARCHAR(255) NOT NULL,\r\n" + "  `coloreProdotto` VARCHAR(255) NOT NULL,\r\n"
					+ "  `prezzoProdotto` VARCHAR(255) NOT NULL,\r\n"
					+ "  `disponibilitaProdotto` TINYINT NOT NULL,\r\n"
					+ "  `descrizioneProdotto` VARCHAR(255) NOT NULL,\r\n"
					+ "  `id_venditoreProdotto` INT NOT NULL,\r\n" + "  PRIMARY KEY (`id_prodotto`),\r\n"
					+ "  UNIQUE INDEX `id_prodotto_UNIQUE` (`id_prodotto` ASC),\r\n"
					+ "  INDEX `id_venditoreProdotto_idx` (`id_venditoreProdotto` ASC),\r\n"
					+ "  CONSTRAINT `id_venditoreProdotto`\r\n" + "    FOREIGN KEY (`id_venditoreProdotto`)\r\n"
					+ "    REFERENCES `tarreduDB`.`venditore` (`id_venditore`)\r\n" + "    ON DELETE CASCADE\r\n"
					+ "    ON UPDATE CASCADE);";

			statement = connection.prepareStatement(add);

			statement.executeUpdate();

			
			
			add = "CREATE TABLE `tarreduDB`.`preventivo` (\r\n" + 
					"  `id_preventivo` INT(11) NOT NULL AUTO_INCREMENT,\r\n" + 
					"  `data_ora_preventivo` DATE NOT NULL,\r\n" + 
					"  `id_utente` INT(11) NOT NULL,\r\n" + 
					"  `id_venditore` INT(11) NOT NULL,\r\n" + 
					"  `id_prodotto` INT(11) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`id_preventivo`),\r\n" + 
					"  UNIQUE INDEX `id_prventivo_UNIQUE` (`id_preventivo` ASC),\r\n" + 
					"  INDEX `id_utente_idx` (`id_utente` ASC),\r\n" + 
					"  INDEX `id_venditore_idx` (`id_venditore` ASC),\r\n" + 
					"  INDEX `id_prodotto_idx` (`id_prodotto` ASC),\r\n" + 
					"  CONSTRAINT `id_utente`\r\n" + 
					"    FOREIGN KEY (`id_utente`)\r\n" + 
					"    REFERENCES `tarreduDB`.`utente` (`utente_id`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE,\r\n" + 
					"  CONSTRAINT `id_venditore`\r\n" + 
					"    FOREIGN KEY (`id_venditore`)\r\n" + 
					"    REFERENCES `tarreduDB`.`venditore` (`id_venditore`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE,\r\n" + 
					"  CONSTRAINT `id_prodotto`\r\n" + 
					"    FOREIGN KEY (`id_prodotto`)\r\n" + 
					"    REFERENCES `tarreduDB`.`prodotto` (`id_prodotto`)\r\n" + 
					"    ON DELETE NO ACTION\r\n" + 
					"    ON UPDATE NO ACTION);";

			statement = connection.prepareStatement(add);
			statement.executeUpdate();

			
			
			
			
			
			System.out.println("Executed create database");

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

	public void resetDatabase() {

		Connection connection = dataSource.getConnection();
		try {
			String delete = "delete FROM utente";
			PreparedStatement statement = connection.prepareStatement(delete);

			statement.executeUpdate();

			delete = "delete FROM prodotto";
			statement = connection.prepareStatement(delete);

			delete = "delete FROM venditore";
			statement = connection.prepareStatement(delete);

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