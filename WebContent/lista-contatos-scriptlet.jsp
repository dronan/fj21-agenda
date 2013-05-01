<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, br.com.caelum.jdbc.dao.*, br.com.caelum.jdbc.modelo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="100%">
<tr>
<td>Nome</td>
<td>Email</td>
<td>Endereco</td>
<td>Data de Nascimento</td>
</tr>
<%
ContatoDAO dao = new ContatoDAO();
List<Contato> contatos = dao.getLista();
for (Contato contato : contatos){
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
%>
<tr>
<td><%=contato.getNome() %></td>
<td><%=contato.getEmail() %></td>
<td><%=contato.getEndereco() %></td>
<td><%=formatador.format(contato.getDataNascimento().getTime()) %></td>
</tr>
<%
}
%>
</table>
</body>
</html>