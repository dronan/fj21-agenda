package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.mvc.helper.CalendarFormatter;

import java.sql.Connection;

public class AlteraContatoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		String tipo = req.getParameter("paramAltera");
		if (tipo.equals("altera")) {
			this.altera(req, resp);

		} else {

			this.popula(req, resp);
		}

	}

	public void popula(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));
		// contato.setId(id);

		System.out.println("buscando o contato:" + id);
		
		Connection connection = (Connection) req.getAttribute("conexao");

		ContatoDAO dao = new ContatoDAO(connection);
		contato = dao.pesquisar(id);

		req.setAttribute("nome", contato.getNome());
		req.setAttribute("endereco", contato.getEndereco());
		req.setAttribute("email", contato.getEmail());
		
		String dataBr = new CalendarFormatter().formatCalendar(contato.getDataNascimento());
		req.setAttribute("dataNascimento", dataBr);

		RequestDispatcher rd = req.getRequestDispatcher("/altera-contato.jsp");
		rd.forward(req, resp);

		System.out.println("buscando o contato:" + contato.getNome());
	}

	public void altera(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));
		contato.setId(id);
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
		dao.altera(contato);

		RequestDispatcher rd = req
				.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(req, resp);

		System.out.println("Alterando contato... " + contato.getNome());

	}

}
