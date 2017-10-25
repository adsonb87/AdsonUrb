package br.com.urbanape.modelo;

public class Pedido {
	private Integer id;
	private String cabecalho;
	private String cpf;
	private int usoDiario;
	private double valorUsoDiario;	
	private String nome;	
	private int tipoCartao;	
	private int aplicacao;
	
	
	
	public Pedido() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getUsoDiario() {
		return usoDiario;
	}

	public void setUsoDiario(int uso) {
		this.usoDiario = uso;
	}

	public double getValorUsoDiario() {
		return valorUsoDiario;
	}

	public void setValorUsoDiario(double valor) {
		this.valorUsoDiario = (valor/100);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(int tipo) {
		this.tipoCartao = tipo;
	}

	public int getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(int codigo) {
		this.aplicacao = codigo;
	}

	@Override
	public String toString() {
		return "Pedido [cabecalho=" + cabecalho + ", cpf=" + cpf + ", uso=" + usoDiario + ", valor=" + valorUsoDiario + ", nome="
				+ nome + ", tipo=" + tipoCartao + ", codigo=" + aplicacao + "]\n";
	}
}
