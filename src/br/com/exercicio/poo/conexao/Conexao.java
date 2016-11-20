package br.com.exercicio.poo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection getConexao(){
		try {
			return DriverManager.getConnection("jdbc:mysql://192.168.33.17/teste", "root", "123");
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao Conectar");
		}
	}
}
