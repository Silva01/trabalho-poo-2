package br.com.exercicio.poo.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.exercicio.poo.anotacoes.Liberado;
import br.com.exercicio.poo.model.SessaoUsuario;
import br.com.exercicio.poo.model.Usuario;
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
	
	@Liberado	
	public void atualizar(int ids){		
		result.include("usuario", usuarioDAO.buscarUsuarioPorId(ids));		
	}
	
	@Liberado
	@Post("/enviar")
	public void salvarUsuarioAtualizado(Usuario usuario){		
		if (usuario != null && usuario.getCpf() != null) {
			usuarioDAO.atualizarUsuario(usuario);
			result.redirectTo(IndexController.class).listar();
		}
	}
	
	@Liberado
	public void excluir(int id){
		usuarioDAO.excluirUsuario(id);
	}

}
