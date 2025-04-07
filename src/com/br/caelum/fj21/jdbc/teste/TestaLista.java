package com.br.caelum.fj21.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import com.br.caelum.fj21.jdbc.dao.ContatoDao;
import com.br.caelum.fj21.jdbc.modelo.Contato;

public class TestaLista {

	// Formatação de data no padrão brasileiro
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {

		ContatoDao dao = new ContatoDao();

		List<Contato> contatos = dao.getLista();

		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());			
			System.out.println("Data de Nascimento: " + DATE_FORMAT.format(contato.getDataNascimento().getTime()) + "\n");

		}

	}

}
