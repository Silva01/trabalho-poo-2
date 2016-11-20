package br.com.exercicio.poo.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.exercicio.poo.anotacoes.Liberado;

@Resource
public class IndexController {

	private Result result;
	
	public IndexController(Result result) {
		this.result = result;
	}
	
	@Liberado
	public void listar(){
		System.out.println("Listando");
	}
	
	@Liberado
	@Path("/deslogar")
	public void logout(){
		result.redirectTo(LoginController.class).logout();
	}

}
