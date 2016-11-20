package br.com.exercicio.poo.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.exercicio.poo.model.Login;

public class UsuarioDAOTest {

	@Test
	public void deveraValidarLogin(){
		Login login = new Login();
		Assert.assertEquals(true, login.validarLogin("123456", "123456789"));
	}
}
