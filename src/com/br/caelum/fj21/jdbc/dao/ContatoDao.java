package com.br.caelum.fj21.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.br.caelum.fj21.jdbc.ConnectionFactory;
import com.br.caelum.fj21.jdbc.modelo.Contato;

public class ContatoDao {

	public void adiciona(Contato contato) {
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) VALUES (?, ?, ?, ?)";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {
		List<Contato> contatos = new ArrayList<>();
		String sql = "SELECT * FROM contatos";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

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

	public void altera(Contato contato) {
		String sql = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		String sql = "DELETE FROM contatos WHERE id=?";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, contato.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
