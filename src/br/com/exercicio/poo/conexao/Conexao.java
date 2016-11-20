package br.com.exercicio.poo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class Conexao {

	public Connection getConexao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://192.168.33.14:3306", "root", "123");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {			
			throw new RuntimeException(e);
		}
	}
}
