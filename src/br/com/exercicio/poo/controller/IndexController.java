package br.com.exercicio.poo.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.exercicio.poo.anotacoes.Liberado;
import br.com.exercicio.poo.model.UsuarioDAO;

@Resource
public class IndexController {

	private Result result;
	private UsuarioDAO usuarioDAO;
	
	public IndexController(Result result) {
		this.result = result;
		this.usuarioDAO = new UsuarioDAO();
	}
	
	@Liberado
	public void listar(){
		result.include("listaUsuarios", usuarioDAO.listarUsuarios());	
	}
	
	@Liberado
	@Path("/deslogar")
	public void logout(){
		result.redirectTo(LoginController.class).logout();
	}

}
