<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/Exercici-POO-2/login/logar" method="post">
		<fieldset>
			<label>CPF:</label>
			<input type="text" name="cpf" />
			<br>
			<label>Senha:</label>
			<input type="password" name="senha"/>
			<br>
			<input type="submit" value="Logar"/>
			<input type="reset" value="Resetar"/>
		</fieldset>
	</form>	
</body>
</html>