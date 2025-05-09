package com.br.caelum.fj21.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.br.caelum.fj21.jdbc.ConnectionFactory;

public class JDBCInsere {
	// Formatação de data no padrão brasileiro
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


	public static void main(String[] args) throws SQLException {
		// Conectando

		try (Connection con = new ConnectionFactory().getConnection();) {

			String sql = "insert into contatos" + " (nome,email,endereco,dataNascimento)" + "values (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			// Preenche valores
			stmt.setString(1, "teste");
			stmt.setString(2, "renato@hotmail.com.br");
			stmt.setString(3, "R. Vergueiro 3185 cj57");
			stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

			// Executa
			stmt.execute();
			stmt.close();
			System.out.println("Gravado!");

		} catch (SQLException e) {
			System.err.println(e);
		}

	}

}
