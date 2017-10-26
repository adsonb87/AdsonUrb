package br.com.urbanape.Teste;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import br.com.urbanape.modelo.Pedido;
import br.com.urbanape.modelo.ValidaCpf;
import br.com.urbanape.modelo.ValidaQuantidadeDias;

public class TesteValidacaoPedido {

	public static void main(String[] args) throws IOException {

		File arquivo = new File("RECARGA NOVEMBRO2017.txt");
		Pedido pedido = null;
		ValidaQuantidadeDias validaQtdDias = new ValidaQuantidadeDias();
		ValidaCpf validaCpf = new ValidaCpf();
		int line = 1;
		
		List<String> linhas = FileUtils.readLines(arquivo);
		ArrayList<String> lcpf = new ArrayList<>();

		if(!arquivo.getName().endsWith(".txt")){ //VALIDA O TIPO DO ARQUIVO
			System.out.println("Tipo de arquivo incorreto !");
		}else{
			for (String linha : linhas) {
				pedido = new Pedido();
				if (!linha.equals("0800")) {
					
					String[] text = linha.split(Pattern.quote("|"));
					
					//VERIFICA SE O CPF VAI ESTAR VAZIO E AP�S SE O CPF � V�LIDO, 
					//CASO N�O, EXIBE O ERRO NO LOG, SE FOR VAZIO INFORMA E PREENCHE O CPF COM 0
					if(!text[0].isEmpty()){
						if(!validaCpf.isCPF(text[0])){
							System.out.println("Erro cpf, linha: " + line);
						}				
						pedido.setCpf(text[0]);
						lcpf.add(text[0]);
					}else{
						System.out.println("Campo cpf se encontra vazio, linha: " + line);
						pedido.setCpf("00000000000");
					}
					
					
					//VERIFICA SE A QUANTIDADE DE DIAS VAI ESTAR VAZIA E SE ELA TEM O VALOR FIXO 1
					//CASO ELA ESTEJA VAZIA VAI SER PREENCHIDA COM 0 E VAI INFORMAR NO LOG
					if(!text[1].isEmpty()){
						if(!validaQtdDias.isQuantidadeDias(Integer.parseInt(text[1]))){
							System.out.println("Erro quantidade de dias, linha: " + line);
						}
						pedido.setUsoDiario(Integer.parseInt(text[1]));
					}else{
						System.out.println("Campo quantidade de dias se encontra vazio, linha: " + line);
						pedido.setUsoDiario(0);
					}
					
					
					//VERIFICA SE O VALOR MINIMO � MENOR QUE 3 PASSAGENS DO ANEL A OU VAZIA
					//CASO FOR VAZIO VAI PREENCHER O VALOR COM 0
					if(!text[2].isEmpty()){
						if(!(Double.parseDouble(text[2])>=960)){ //Se o valor minimo for menor que 3 passagens A acontece o erro
							System.out.println("Erro valor m�nimo di�rio, linha: " + line);
						}
						pedido.setValorUsoDiario(Double.parseDouble(text[2]));
					}else{
						System.out.println("Campo valor m�nimo di�rio vazio, linha: " + line);
						pedido.setValorUsoDiario(0);
					}
					
					
					//VERIFICA SE O CAMPO DO NOME CONT�M O NOME TESTE
					//CASO FOR USU�RIO DE TESTE ELE VAI INFORMAR NO LOG
					//COMO N�O � CAMPO OBRIGAT�RIO CASO ESTEJA V�ZIO VAI SER PREENCHIDO VAZIO
					if(!text[3].isEmpty()){
						if(text[3].toUpperCase().contains("TESTE")){
							System.out.println("Usu�rio de teste encontrado, linha: " + line);
						}
						pedido.setNome(text[3]);
					}else{
						pedido.setNome("");
					}
					
					
					//VERIFICA SE O CAMPO TIPO CARTAO VAI ESTAR VAZIO
					//CASO FOR VAZIO VAI SER PREENCHIDO COM 0, SE N�O FOR
					//VAI SER VERIFICADO SE � ALGUM DOS DOIS TIPOS 19 OU 17
					if(!text[4].isEmpty()){
						Integer tipoCartao = Integer.parseInt(text[4]);
						if(tipoCartao == 19 || tipoCartao == 17){
							pedido.setTipoCartao(tipoCartao);							
						}else{
							System.out.println("Erro tipo do cart�o, linha: " + line);
						}
					}else{
						System.out.println("Campo tipo cart�o vazio, linha: " + line);
						pedido.setTipoCartao(0);
					}
					
					
					//VERIFICA SE O CAMPO APLICACAO VAI ESTAR VAZIO
					//CASO FOR VAI SER PREENCHIDO COM 0, SE N�O FOR
					//VAI SER VERIFICADO SE � ALGUM DOS DOIS TIPOS 911 OU 905
					if(!text[5].isEmpty()){
						Integer aplicacao = Integer.parseInt(text[5]);
						if(aplicacao == 911 || aplicacao == 905){
							pedido.setAplicacao(aplicacao);							
						}else{
							System.out.println("Erro tipo da aplica��o, linha: " + line);
						}
					}else{
						System.out.println("Campo tipo cart�o vazio, linha: " + line);
						pedido.setAplicacao(0);
					}
					
				} else { //VAI PREENCHER O CABECALHO DO PEDIDO COM A PRIMEIRA LINHA DO ARQUIVO
					pedido.setCabecalho(linha);
				}
				line ++;
			}
			
			if(!duplicidadeCpf(lcpf).isEmpty()){ // CHAMA O MET�DO PARA VERIFICAR A DUPLICIDADE DE CPF,re
				System.out.println("Cpf em duplicidade nas linhas: " + duplicidadeCpf(lcpf));
			}
			System.out.println("Pedido Validado");
			
		}		

	}
	
	public static ArrayList<Integer> duplicidadeCpf(ArrayList<String> lcpf){
		// VERIFICAR SE H� DUPLICIDADE NO CPF
		int i = 2;
		int count = 0;
		ArrayList<Integer> ln = new ArrayList<>();
		for (String c0 : lcpf) {
			boolean found = false;
			for (String c : lcpf) {
				if (c0.equals(c)) {
					count++;
					found = true;
					if (count > 1) {
						ln.add(i);
						break;
					}
				}
			}
			i++;
			count = 0;
		}

		return ln;
	}
}
