package br.com.urbanape.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.urbanape.DAO.DAO;
import br.com.urbanape.modelo.TipoDeUsuarioDoSistemaSilu;
import br.com.urbanape.modelo.UsuarioDoSistemaSilu;

@ManagedBean
@ViewScoped
public class TipoDeUsuarioBean implements Serializable{

	private TipoDeUsuarioDoSistemaSilu tipo = new TipoDeUsuarioDoSistemaSilu();
	private Integer tipoId;
	private List<TipoDeUsuarioDoSistemaSilu> tipos = null;
	@SuppressWarnings("unused")
	private UsuarioDoSistemaSilu user;

	public TipoDeUsuarioDoSistemaSilu getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeUsuarioDoSistemaSilu tipo) {
		this.tipo = tipo;
	}

	public Integer getTipoId() {
		return tipoId;
	}

	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}

	public void setTipos(List<TipoDeUsuarioDoSistemaSilu> tipos) {
		this.tipos = tipos;
	}

	public void carregarTipoDeUsuarioDoSistemaSiluPorId() {
		this.tipo = new DAO<TipoDeUsuarioDoSistemaSilu>(TipoDeUsuarioDoSistemaSilu.class).buscaPorId(tipoId);
	}

	public String gravar() {
		String msg;

		if (this.tipo.getId() == null) {
			new DAO<TipoDeUsuarioDoSistemaSilu>(TipoDeUsuarioDoSistemaSilu.class).adiciona(this.tipo);
			msg = "cadastrado";
		} else {
			new DAO<TipoDeUsuarioDoSistemaSilu>(TipoDeUsuarioDoSistemaSilu.class).atualiza(this.tipo);
			msg = "atualizado";
		}

		this.tipo = new TipoDeUsuarioDoSistemaSilu();

		Messages.addGlobalInfo("Tipo de usuário " + msg + " com sucesso!");

		return "home?faces-redirect=true";
	}

	public void limpar() {
		this.tipo = new TipoDeUsuarioDoSistemaSilu();
	}

	public List<TipoDeUsuarioDoSistemaSilu> getTipos() {
		DAO<TipoDeUsuarioDoSistemaSilu> dao = new DAO<TipoDeUsuarioDoSistemaSilu>(TipoDeUsuarioDoSistemaSilu.class);
		if (this.tipos == null) {
			this.tipos = dao.listaTodos();
		}
		return tipos;
	}

	public void carregarTipoDeUsuario(TipoDeUsuarioDoSistemaSilu tipo) {
		this.tipo = tipo;
	}

	public void removerTipoDeUsuario(TipoDeUsuarioDoSistemaSilu tipo) {
		new DAO<TipoDeUsuarioDoSistemaSilu>(TipoDeUsuarioDoSistemaSilu.class).remove(tipo);
	}

	public String carregarUsuarioDoSistemaSilu(UsuarioDoSistemaSilu user) {
		this.user = user;
		return "userSilu?";
	}

	public void removerUsuarioDoSistemaSilu(UsuarioDoSistemaSilu user) {
		new DAO<UsuarioDoSistemaSilu>(UsuarioDoSistemaSilu.class).remove(user);
	}

}