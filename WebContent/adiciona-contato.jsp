<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="calendario" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<form action="adicionaContato" method="post">
		Nome: <input type="text" name="nome"><br> E-mail: <input
			type="text" name="email"><br> Endereço: <input
			type="text" name="endereco"><br> Data Nascimento: 
			<calendario:campoData id="dataNascimento" value="" />
			<br> <input
			type="submit" value="Gravar">
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>