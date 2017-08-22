package br.com.urbanape.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.urbanape.DAO.DAO;
import br.com.urbanape.modelo.TipoDeUsuarioDoSistemaSilu;
import br.com.urbanape.modelo.UsuarioDoSistemaSilu;

@ManagedBean
@ViewScoped
public class UsuarioDoSistemaSiluBean {

	private UsuarioDoSistemaSilu user = new UsuarioDoSistemaSilu();
	private TipoDeUsuarioDoSistemaSilu tipo = new TipoDeUsuarioDoSistemaSilu();
	private List<TipoDeUsuarioDoSistemaSilu> tipos;
	private Integer userId = null;
	private Integer tipoId = null;

	public UsuarioDoSistemaSilu getUser() {
		return user;
	}

	public void setUser(UsuarioDoSistemaSilu user) {
		this.user = user;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getTipoId() {
		return tipoId;
	}

	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}

	public TipoDeUsuarioDoSistemaSilu getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeUsuarioDoSistemaSilu tipo) {
		this.tipo = tipo;
	}
	
	public List<TipoDeUsuarioDoSistemaSilu> getTipos() {
		DAO<TipoDeUsuarioDoSistemaSilu> dao = new DAO<TipoDeUsuarioDoSistemaSilu>(TipoDeUsuarioDoSistemaSilu.class);
		if (this.tipos == null) {
			this.tipos = dao.listaTodos();
		}
		return tipos;
	}

	public void carregarUsuarioDoSistemaSiluPorId() {
		this.user = new DAO<UsuarioDoSistemaSilu>(UsuarioDoSistemaSilu.class).buscaPorId(userId);
	}

	public String gravar() {
		System.out.println("Gravando usuário " + this.user.getNome());
		
		tipo = new DAO<TipoDeUsuarioDoSistemaSilu>(TipoDeUsuarioDoSistemaSilu.class).buscaPorId(tipoId);
		
		this.user.setTipo(tipo);
		
		if (this.user.getId() == null) {
			new DAO<UsuarioDoSistemaSilu>(UsuarioDoSistemaSilu.class).adiciona(this.user);
		} else {
			new DAO<UsuarioDoSistemaSilu>(UsuarioDoSistemaSilu.class).atualiza(this.user);
		}

		this.user = new UsuarioDoSistemaSilu();
		Messages.addGlobalError("Cadastrado com sucesso");

		return "home?faces-redirect=true";
	}

	public void limpar(){
		this.user = new UsuarioDoSistemaSilu();
	}
	public List<UsuarioDoSistemaSilu> getUsuariosDoSistemaSilu() {
		return new DAO<UsuarioDoSistemaSilu>(UsuarioDoSistemaSilu.class).listaTodos();
	}

	public void carregarUsuarioDoSistemaSilu(UsuarioDoSistemaSilu user) {
		this.user = user;
	}

	public void removerUsuarioDoSistemaSilu(UsuarioDoSistemaSilu user) {
		new DAO<UsuarioDoSistemaSilu>(UsuarioDoSistemaSilu.class).remove(user);
	}
}
