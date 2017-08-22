package br.com.urbanape.util;

import br.com.urbanape.DAO.DAO;
import br.com.urbanape.modelo.TipoDeUsuarioDoSistemaSilu;
import br.com.urbanape.modelo.UsuarioDoSistemaSilu;

public class TesteJPA {

	public static void main(String[] args) {

		TipoDeUsuarioDoSistemaSilu tipo = new TipoDeUsuarioDoSistemaSilu();
		
		tipo.setDescricao("Administrador");
		tipo.setTipo("A");
		
		new DAO<>(TipoDeUsuarioDoSistemaSilu.class).adiciona(tipo);
		
		UsuarioDoSistemaSilu userSilu = new UsuarioDoSistemaSilu();
		userSilu.setLogin("matheus");
		userSilu.setNome("Matheus Santana");
		userSilu.setSenha("123456");
		userSilu.setEmail("teste@urbana-pe.com.br");
		
		userSilu.setTipo(tipo);

		new DAO<>(UsuarioDoSistemaSilu.class).adiciona(userSilu);
	}

}