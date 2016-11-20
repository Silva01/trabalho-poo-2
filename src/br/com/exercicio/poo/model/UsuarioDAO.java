package br.com.exercicio.poo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.mysql.cj.jdbc.PreparedStatement;

import br.com.caelum.vraptor.ioc.Component;
import br.com.exercicio.poo.conexao.Conexao;

@Component
public class UsuarioDAO {

	private Usuario usuario;
	private Connection conn;
	
	public UsuarioDAO(Usuario usuario) {
		this.usuario = usuario;
		this.conn = new Conexao().getConexao();
	}
	
	public List<Usuario> listarUsuarios(){
		return null;
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
		
	}
	
	public void atualizarUsuario(Usuario usuarioAtualizado){
		
	}
	
	public void excluirUsuario(int id){
		
	}
	
}