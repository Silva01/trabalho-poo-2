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
				usuario.setId(result.getInt("id"));
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
	
	public Usuario buscarUsuarioPorId(int id){
		Usuario usuario = new Usuario();
		String query = "SELECT * FROM teste.usuarios WHERE id = ?";
		
		try {
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(query);
			stm.setInt(1, id);
			
			ResultSet result = stm.executeQuery();
			if (result.next()) {				
				usuario.setId(result.getInt("id"));
				usuario.setNome(result.getString("nome"));
				usuario.setCpf(result.getString("cpf"));
				usuario.setEndereco(result.getString("endereco"));
				usuario.setIdade(result.getInt("idade"));				
			}
			
			stm.close();
			return usuario;			
		} catch (Exception e) {
			throw new RuntimeException(e);
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
		String query;		
		if (usuarioAtualizado.getSenha() == "" || usuarioAtualizado.getSenha() == null) {
			query = "UPDATE teste.usuarios SET nome = ?, cpf = ?, endereco = ?, idade = ? WHERE id = ?";
		} else {
			query = "UPDATE teste.usuarios SET nome = ?, cpf = ?, endereco = ?, idade = ?, senha = md5(?) WHERE id = ?";
		}
		
		try {
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(query);
			stm.setString(1, usuarioAtualizado.getNome());
			stm.setString(2, usuarioAtualizado.getCpf());
			stm.setString(3, usuarioAtualizado.getEndereco());
			stm.setInt(4, usuarioAtualizado.getIdade());
			stm.setInt(5, usuarioAtualizado.getId());
			
			stm.execute();
			stm.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void excluirUsuario(int id){
		String query = "DELETE FROM teste.usuarios WHERE id = ?";
		
		try {
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(query);
			stm.setInt(1, id);
			
			stm.execute();
			stm.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
