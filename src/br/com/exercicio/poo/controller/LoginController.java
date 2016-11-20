package br.com.exercicio.poo.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.exercicio.poo.model.SessaoUsuario;
import br.com.exercicio.poo.model.Usuario;

@Resource
public class LoginController {

	private Result result;
	private br.com.exercicio.poo.model.Login login;
	private SessaoUsuario sessaoUsuario;
	
	public LoginController(Result result, br.com.exercicio.poo.model.Login login, SessaoUsuario sessaoUsuario) {
		this.result = result;
		this.login = login;
		this.sessaoUsuario = sessaoUsuario;
	}
	
	public void logar(String cpf, String senha){
		if (cpf != null) {
			Usuario usuario = login.validarLogin(cpf, senha);
			if (usuario == null) {
				
			} else {
				sessaoUsuario.login(usuario);
				result.redirectTo(IndexController.class).listar();
			}
		}
	}	
}
