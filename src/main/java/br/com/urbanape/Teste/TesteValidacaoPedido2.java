package br.com.pe.urbana.teste;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import br.com.pe.urbana.modelo.Pedido;
import br.com.pe.urbana.modelo.ValidaCpf;
import br.com.pe.urbana.modelo.ValidaQuantidadeDias;

public class TesteValidacaoPedido2 {

	public static void main(String[] args) throws IOException {

		File arquivo = new File("PedidoTeste3.txt");
		List<String> linhas = FileUtils.readLines(arquivo);

		if(!arquivo.getName().endsWith(".txt")){
			System.out.println("Tipo de arquivo incorreto !");
		}else{
			for (String linha : linhas) {
				if (!linha.equals("0800")) {
					
					String[] text = linha.split(Pattern.quote("|"));
					System.out.println(text.length);
						
					}
					
				}
			}		
		}
}