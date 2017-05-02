package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {

	public static String user = "root";
	public static String password = "123456";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver Mysql não encontrado!");
		}
	}

	public static Connection getConnection() {
		Connection conexao = null;

		try {
			conexao = DriverManager
					.getConnection("jdbc:mysql://localhost/bancocliente?user=" + user + "&password=" + password);
		} catch (SQLException e) {
			throw new RuntimeException("Erro no usuario ou senha!");
		}
		return conexao;
	}

}
