<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<nav>
		<ul>
			<li><a href="http://localhost:8080/Exercici-POO-2/deslogar">Logout</a></li>
		</ul>
	</nav>
	
	<div>
		<table>
			<thead>
				<tr>
					<th>Cod</th>
					<th>Usuário</th>
					<th>CPF</th>
					<th>Endereco</th>
					<th>Idade</th>
					<th>Excluir</th>
					<th>Atualizar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ listaUsuarios }" var="lista">
					<tr>
						<td>${ lista.id }</td>
						<td>${ lista.nome }</td>
						<td>${ lista.cpf }</td>
						<td>${ lista.endereco }</td>
						<td>${ lista.idade }</td>
						<td><a href="http://localhost:8080/Exercici-POO-2/index/excluir?id=${ lista.id }"">Excluir</a></td>
						<td><a href="http://localhost:8080/Exercici-POO-2/index/atualizar?ids=${ lista.id }">Atualizar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>