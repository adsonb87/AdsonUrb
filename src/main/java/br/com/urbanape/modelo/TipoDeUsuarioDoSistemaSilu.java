package br.com.urbanape.modelo;


//@Entity
//@Table(name = "SILU_TIPO_USUARIO_SISTEMA")
//@SequenceGenerator(name = "id_sequence_tipo_usuario_silu", sequenceName = "ID_SEQ", initialValue = 5, allocationSize = 1)

public class TipoDeUsuarioDoSistemaSilu {

//	@Id
//	@Column(name = "ID")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_tipo_usuario_silu")

	private Integer id;

	private String tipo;
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}