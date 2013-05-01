<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="caelum" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<!--  Cria o DAO -->
	<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDAO"/>
<form action="mvc" method="post">
	<table border="1" width="100%">
		<tr bgcolor="aaeeee">
			<td>Nome</td>
			<td>Email</td>
			<td>Endereco</td>
			<td>Data de Nascimento</td>
			<td>Ação</td>
		</tr>
		<!-- Percorre os contatos montando as linhas na tabela -->
		<c:forEach var="contato" items="${dao.lista}" varStatus="contador">
			<tr bgcolor="#${contador.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td><a href="mvc?logica=AlteraContatoLogic&paramAltera=popula&id=${contato.id}">${contato.nome}</a></td>
				<td>
				<c:if test="${not empty contato.email }">
						<a href="mailto:${contato.email}">${contato.email}</a>
				</c:if>
				
				<c:if test="${empty contato.email }">
					E-mail não informado
				</c:if>
				
				</td>
				<td>${contato.endereco }</td>
				<td><fmt:formatDate type="date" value="${contato.dataNascimento.time}"/></td>
				<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Excluir</a></td>
			</tr>
		</c:forEach>
		
		<tr bgcolor="aaeeee">
			<td><input type="text" name="nome"></td>
			<td><input type="text" name="email"></td>
			<td><input type="text" name="endereco"></td>
			<td><caelum:campoData id="dataNascimento" value=""/></td>
			<td><input type="hidden" name="logica" value="AdicionaContatoLogic"><input type="submit" value="adicionar"></td>
		</tr>
		
	</table>
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>