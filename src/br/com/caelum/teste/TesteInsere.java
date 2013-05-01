package br.com.caelum.teste;

import java.sql.Connection;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteInsere {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Diego");
		contato.setEndereco("Rua do Deigo");
		contato.setEmail("dronan@bla.com.br");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		System.out.println("Gravado!");
	}

}
