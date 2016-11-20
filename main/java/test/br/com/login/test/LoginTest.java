package br.com.login.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.exercicio.poo.controller.Login;

public class LoginTest {
	
	@Test
	public void deveraCriarUmaSessaoDeUsuario(){
		Login login = new Login();
		//Assert.assertEquals(true, login.login());
	}	
}
