package br.com.pe.urbana.teste;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class Teste {

	public static void main(String[] args) throws IOException {
		File arquivo = new File("PedidoTeste.txt");
		  
		  List<String> linhas = FileUtils.readLines(arquivo);
		  
		  for(String linha: linhas) {
		   
		   if(!linha.equals("0800")) {
		    
		    String[] text = linha.split(Pattern.quote("|"));
		    
		    System.out.println("--------------------------------------");
		    System.out.println("CPF: " + text[0]);
		    System.out.println("Uso: " + text[1]);
		    System.out.println("Valor: " + text[2]);
		    System.out.println("Nome: " + text[3]);
		    System.out.println("Tipo: " + text[4]);
		    System.out.println("Cod: " + text[5]);
		    System.out.println("--------------------------------------\n");
		     
		   }
		   
		  }

	}

}
