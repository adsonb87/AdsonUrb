package br.com.urbanape.modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "SILU_USUARIO_SISTEMA")
@SequenceGenerator(name = "id_sequence_usuario_sistema_silu", sequenceName = "ID_SEQ", initialValue = 5, allocationSize = 1)
public class UsuarioDoSistemaSilu {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_usuario_sistema_silu")
	private Integer id;

	private String nome;
	private String login;
	private String email;
	private String senha;

	@OneToOne(fetch = FetchType.EAGER)
	private TipoDeUsuarioDoSistemaSilu tipo = new TipoDeUsuarioDoSistemaSilu();

	@Temporal(TemporalType.DATE)
	private Calendar ultimaAlteracao = Calendar.getInstance();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		BCryptPasswordEncoder encriptador = new BCryptPasswordEncoder();
		this.senha = encriptador.encode(senha);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public TipoDeUsuarioDoSistemaSilu getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeUsuarioDoSistemaSilu tipo) {
		this.tipo = tipo;
	}

	public Calendar getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Calendar ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

}