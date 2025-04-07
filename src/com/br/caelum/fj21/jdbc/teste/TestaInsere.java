package com.br.caelum.fj21.jdbc.teste;

import java.util.Calendar;

import com.br.caelum.fj21.jdbc.dao.ContatoDao;
import com.br.caelum.fj21.jdbc.modelo.Contato;

public class TestaInsere {
	public static void main(String[] args) {

		//Cria um cointato pronto para gravar
		Contato contato = new Contato();
		contato.setNome("Cezar Softwares");
		contato.setEmail("renatocezarsilva@hotmail.com");
		contato.setEndereco("Av. Henriqueta Mendes Guerra 1330");
		contato.setDataNascimento(Calendar.getInstance());
		
		//Grava nesta conexão
		ContatoDao dao = new ContatoDao();
		
		//Metodo elegante que grava
		dao.adiciona(contato);
		
		System.out.println("Gravado!");
		
		

	}

}
