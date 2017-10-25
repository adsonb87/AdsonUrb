package br.com.pe.urbana.teste;

import java.io.IOException;

import br.com.pe.urbana.modelo.ValidaPedido;

public class Teste3 {
	public static void main(String[] args) throws IOException {

		ValidaPedido pedido = new ValidaPedido("C:\\Users\\adsons\\Desktop\\RECARGA NOVEMBRO2017.txt");

		pedido.validaArquivoPedido();

	}
}
