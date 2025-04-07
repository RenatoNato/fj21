package com.br.caelum.fj21.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import com.br.caelum.fj21.jdbc.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		connection.close();

	}

}
