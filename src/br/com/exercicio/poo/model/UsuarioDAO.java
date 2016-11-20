package br.com.exercicio.poo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.PreparedStatement;

import br.com.caelum.vraptor.ioc.Component;
import br.com.exercicio.poo.conexao.Conexao;

@Component
public class UsuarioDAO {
	
	private Connection conn;
	
	public UsuarioDAO() {		
		this.conn = new Conexao().getConexao();
	}
	
	public List<Usuario> listarUsuarios(){
		List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		String query = "SELECT * FROM teste.usuarios";
		
		try {
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(query);
			ResultSet result = stm.executeQuery();
			
			while (result.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(result.getString("nome"));
				usuario.setEndereco(result.getString("endereco"));
				usuario.setCpf(result.getString("cpf"));
				usuario.setIdade(result.getInt("idade"));
				
				listaDeUsuarios.add(usuario);
				
			}
			
			return listaDeUsuarios;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario listarUsuariosPorCPF(String cpf, String senha){
		Usuario usuario = new Usuario();
		String query = "SELECT * FROM teste.usuarios WHERE cpf = ? AND senha = md5(?)";		
		
		try {
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(query);
			statement.setString(1, cpf);
			statement.setString(2, senha);
			
			ResultSet result = statement.executeQuery();
			if (result.next()) {				
				usuario.setId(result.getInt("id"));
				usuario.setNome(result.getString("nome"));
				usuario.setEndereco(result.getString("endereco"));
				usuario.setCpf(result.getString("cpf"));
				usuario.setIdade(result.getInt("idade"));
				
				return usuario;
			}
			
			statement.close();
			return usuario;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao Buscar Dados");
		}
	}
	
	public void incluirUsuario(Usuario novoUsuario){
		String query = "INSERT INTO teste.usuarios (nome, cpf, endereco, idade, senha) VALUES(?,?,?,?, md5(?))";
		try {
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(query);
			stm.setString(1, novoUsuario.getNome());
			stm.setString(2, novoUsuario.getCpf());
			stm.setString(3, novoUsuario.getEndereco());
			stm.setInt(4, novoUsuario.getIdade());
			stm.setString(5, novoUsuario.getSenha());
			
			stm.execute();
			stm.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizarUsuario(Usuario usuarioAtualizado){
		
	}
	
	public void excluirUsuario(int id){
		
	}
	
}
