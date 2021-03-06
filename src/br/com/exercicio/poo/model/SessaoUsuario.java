package br.com.exercicio.poo.model;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class SessaoUsuario {

	private Usuario usuario;
	private int id;
	
	public void login(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String nomeUsuarioLogado(){
		return usuario.getNome();
	}
	
	public boolean isLogado(){
		return usuario != null;
	}
	
	public void logout(){
		this.usuario = null;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
}
