package br.com.urbanape.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.urbanape.modelo.UsuarioDoSistemaSilu;

public class UsuarioDoSistemaSiluDAO {

	public boolean existe(UsuarioDoSistemaSilu UsuarioDoSistemaSilu, String senha) {

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		
		EntityManager em = new JPAUtil().getEntityManager();

		TypedQuery<UsuarioDoSistemaSilu> query = em.createQuery(
				"select u from UsuarioDoSistemaSilu u where u.login = :pLogin", UsuarioDoSistemaSilu.class);

		query.setParameter("pLogin", UsuarioDoSistemaSilu.getLogin());

		UsuarioDoSistemaSilu result = null;

		try {
			result = query.getSingleResult();
			System.out.println(result.getSenha());
			if (bcrypt.matches(senha, result.getSenha())) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		em.close();

		return false;
	}
}
