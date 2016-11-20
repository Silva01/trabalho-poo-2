package br.com.exercicio.poo.model;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.exercicio.poo.anotacoes.Liberado;
import br.com.exercicio.poo.controller.LoginController;

@Intercepts
public class Interceptador implements Interceptor {

	private final SessaoUsuario sessaoUsuario;
	private Result result;
	
	public Interceptador(SessaoUsuario sessaoUsuario, Result result) {
		this.sessaoUsuario = sessaoUsuario;
		this.result = result;
	}
	
	@Override
	public boolean accepts(ResourceMethod method) {		
		return !this.sessaoUsuario.isLogado() && method.containsAnnotation(Liberado.class);
	}

	@Override
	public void intercept(InterceptorStack arg0, ResourceMethod arg1, Object arg2) throws InterceptionException {
		result.redirectTo(LoginController.class).logar("", "");		
	}	
}
