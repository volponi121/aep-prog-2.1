package connectjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	private Connect() {
		
	}
	
	public static Connection criarConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle://localhost:1521/aep2", "oracle", "fabio");
	}
}
