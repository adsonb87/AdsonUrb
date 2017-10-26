package br.com.urbanape.Teste;

import java.io.IOException;

import br.com.urbanape.modelo.ValidaPedido;

public class Teste3 {
	public static void main(String[] args) throws IOException {

		ValidaPedido pedido = new ValidaPedido("PedidoTeste.txt");

		pedido.validaArquivoPedido();

	}
}
