package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	private static final String DRIVER_CLASS = "org.hsqldb.jdbcDriver";

	private static final String URL = "jdbc:hsqldb:hsql://localhost/writeitdb";

	private static final String USER = "sa";

	private static final String PASS = "";

	public static synchronized Connection getConnection() {
		//Tenta conectar com o banco
		try {
			Class.forName(DRIVER_CLASS);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
