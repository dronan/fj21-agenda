<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp" />

 
Formulario para alteração de contatos:<br>

<form action="mvc" method="post">
id: <input type="text" name="id" value="${param.id}" readonly style="border:none" /><br>
nome: <input type="text" name="nome" value="${requestScope.nome}"/><br>
endereco: <input type="text" name="endereco" value="${requestScope.endereco}" /><br>
email: <input type="text" name="email" value="${requestScope.email}" /><br>
Data de Nascimento: <caelum:campoData id="dataNascimento" value="${requestScope.dataNascimento}" />
	<input type="hidden" name="logica" value="AlteraContatoLogic"/>
	<input type="hidden" name="paramAltera" value="altera"/><br><br>
	<input type="submit" value="Alterar"/>
</form>

<c:import url="rodape.jsp" />
</body>
</html>