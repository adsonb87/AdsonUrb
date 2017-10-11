package br.com.urbanape.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.urbanape.DAO.DAO;
import br.com.urbanape.modelo.TipoDeUsuarioDoSistemaSilu;
import br.com.urbanape.modelo.UsuarioDoSistemaSilu;

@Named
@ViewScoped //javax.faces.view.ViewScoped
public class UsuarioDoSistemaSiluBean implements Serializable{

	private UsuarioDoSistemaSilu user = null;
	private TipoDeUsuarioDoSistemaSilu tipo = new TipoDeUsuarioDoSistemaSilu();
	@SuppressWarnings("unused")
	private List<TipoDeUsuarioDoSistemaSilu> tipos;
	private String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userId");
	private boolean idNulo = (id == null);
	private Integer userId = idNulo ? 0 : Integer.parseInt(id);
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
		Messages.addGlobalInfo("Usuário cadastrado com sucesso");

		return "home?faces-redirect=true";
	}

	public void limpar() {
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

	public String carregarUserDeOutraView(String us) {
//		if (us != null) {
//			this.user = new DAO<UsuarioDoSistemaSilu>(UsuarioDoSistemaSilu.class).buscaPorId(Integer.parseInt(us));
//		}
		return "userSilu?faces-redirect=true&userId="+us;
	}
}
