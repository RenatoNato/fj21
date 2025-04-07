package com.br.caelum.fj21.jdbc.teste;

import java.util.List;

import com.br.caelum.fj21.jdbc.dao.ContatoDao;
import com.br.caelum.fj21.jdbc.modelo.Contato;

public class TestaLista {
	public static void main(String[] args) {

		ContatoDao dao = new ContatoDao();

		List<Contato> contatos = dao.getLista();

		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + contato.getDataNascimento().getTime() + "\n");

		}

	}

}
