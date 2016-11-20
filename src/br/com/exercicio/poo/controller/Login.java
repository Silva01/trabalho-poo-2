package br.com.exercicio.poo.controller;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class Login {

	private Result result;
	
	public Login(Result result) {
		this.result = result;
	}
	
	public void logar(String cpf, String senha){
		System.out.println(cpf);
		System.out.println(senha);
	}	
}
