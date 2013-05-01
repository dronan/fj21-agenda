package br.com.caelum.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class RemoveContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));
		contato.setId(id);
		Connection connection = (Connection) req.getAttribute("conexao");
		
		ContatoDAO dao = new ContatoDAO(connection);
		dao.remove(contato);
		
		RequestDispatcher rs = req.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rs.forward(req, resp);
		
		System.out.println("Excluindo contato id: "+contato.getId());

	}

}
