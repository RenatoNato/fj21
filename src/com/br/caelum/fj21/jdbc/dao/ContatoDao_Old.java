package com.br.caelum.fj21.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.br.caelum.fj21.jdbc.ConnectionFactory;
import com.br.caelum.fj21.jdbc.modelo.Contato;

public class ContatoDao_Old {
	private Connection connection;

	public ContatoDao_Old() {
		this.connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			// Seta valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			// executa
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao adicionar contato: " + e);
		}
	}

	public List<Contato> getLista() {
		List<Contato> contatos = new ArrayList<>();

		String sql = "SELECT * FROM contatos";

		try (	PreparedStatement stmt = this.connection.prepareStatement(sql); 
				ResultSet rs = stmt.executeQuery()	) {
			
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return contatos;
	}

}
