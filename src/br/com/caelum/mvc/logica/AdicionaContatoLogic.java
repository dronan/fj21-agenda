package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		Contato contato = new Contato();
		contato.setNome(req.getParameter("nome"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setEmail(req.getParameter("email"));
		

		String dataEmTexto = req.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		contato.setDataNascimento(dataNascimento);
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		ContatoDAO dao = new ContatoDAO(connection);
		
		dao.adiciona(contato);
		
		System.out.println("contato foi adicionado!");
		
		RequestDispatcher rd = req.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(req, resp);


	}

}
