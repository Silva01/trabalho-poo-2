package br.com.exercicio.poo.model;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class Login {
	
	private UsuarioDAO usuarioDAO;
	
	public Login() {
		this.usuarioDAO = new UsuarioDAO(new Usuario());
	}

	public Usuario validarLogin(String cpf, String senha){		
		Usuario usuario = usuarioDAO.listarUsuariosPorCPF(cpf, senha);		
		if (usuario.getCpf().equals(cpf)) {
			return usuario;
		}
		return null;
	}
}
