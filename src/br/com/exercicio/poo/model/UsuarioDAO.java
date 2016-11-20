package br.com.exercicio.poo.model;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class UsuarioDAO {

	private Usuario usuario;
	
	public UsuarioDAO(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> listarUsuarios(){
		return null;
	}
	
	public Usuario listarUsuariosPorCPF(String cpf){
		return null;
	}
	
	public void incluirUsuario(Usuario novoUsuario){
		
	}
	
	public void atualizarUsuario(Usuario usuarioAtualizado){
		
	}
	
	public void excluirUsuario(int id){
		
	}
	
}
