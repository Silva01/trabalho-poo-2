<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Exercici-POO-2/login/cadastrar" method="post">
		<fieldset>
			<label>Nome:</label>
			<input type="text" name="usuario.nome"/>
			<br>
			<label>CPF:</label>
			<input type="text" name="usuario.cpf"/>
			<br>
			<label>Endereço:</label>
			<input type="text" name="usuario.endereco"/>
			<br>
			<label>Idade:</label>
			<input type="number" name="usuario.idade"/>
			<br>
			<label>Senha:</label>
			<input type="password" name="usuario.senha"/>
			<br>
			<input type="submit" value="Cadastrar"/>
			<input type="reset" value="Resetar"/>
		</fieldset>
	</form>
</body>
</html>