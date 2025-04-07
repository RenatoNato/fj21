package com.br.caelum.fj21.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		// Tenta primeiro conexão com MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "1234");
			System.out.println("✅ Conectado ao MySQL");
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("⚠️ Não foi possível conectar ao MySQL. Tentando H2...");
		}

		// Se falhar, tenta H2 em memória
		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:h2:~/fj21;AUTO_SERVER=TRUE", "sa", "1234");
					//"jdbc:h2:~/fj21;INIT=RUNSCRIPT FROM 'classpath:schema.sql';AUTO_SERVER=TRUE", "sa", "1234");
					//"jdbc:h2:mem:fj21;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:schema.sql'", "sa", "1234");
			//"jdbc:h2:~/fj21;INIT=RUNSCRIPT FROM 'classpath:schema.sql';AUTO_SERVER=TRUE"

			System.out.println("✅ Conectado ao banco H2");
			return con;
		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("❌ Não foi possível conectar a nenhum banco de dados", ex);
		}
	}

}
