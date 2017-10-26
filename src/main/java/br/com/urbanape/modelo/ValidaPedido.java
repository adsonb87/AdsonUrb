package br.com.urbanape.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class ValidaPedido {

	private File arquivo;
	private Pedido pedido;
	private ValidaQuantidadeDias validaQtdDias;
	private ValidaCpf validaCpf;
	private int line;
	private List<String> linhasArquivo;
	private ArrayList<String> listaCpf;
	private PrintWriter pw;
	private FileWriter fw;
	private ArrayList<String> log;
	private ValidaPasseLivre validaPasseLivre;

	public ValidaPedido(String endereçoArquivo) throws IOException {
		this.arquivo = new File(endereçoArquivo); //RECEBE O ENDEREÇO DO ARQUIVO A SER IMPORTADO
		this.pedido = null;
		this.validaCpf = new  ValidaCpf();
		this.validaQtdDias = new ValidaQuantidadeDias();
		this.linhasArquivo = FileUtils.readLines(arquivo); //LÊ AS LINHAS DO ARQUIVO E CONVERTE EM ARRAY
		this.listaCpf = new ArrayList<>();
		this.line = 1;
		this.fw = new FileWriter("log.txt");
		this.pw = new PrintWriter(fw);
		this.log = new ArrayList<>();
		this.validaPasseLivre = new ValidaPasseLivre();
	}
	
	public boolean validaTipoArquivo(File arquivo){
		if(arquivo.getName().endsWith(".txt")){
			return true;
		}
		return false;
	}
	
	public void validaArquivoPedido() throws IOException{
		if(!validaTipoArquivo(arquivo)){
			System.out.println("Tipo de arquivo incorreto !");
		}else{
 			for(String linha : linhasArquivo){
				pedido = new Pedido();
				//VERIFICANDO SE A PRIMEIRA LINHA É O CABECALHO 0800
				if (!linha.equals("0800")) {
					//LÊ AS LINHAS DO ARQUIVO E SEPARA OS TRECHOS PELO SEPARADOR |
					String[] text = linha.split(Pattern.quote("|"));
										
					if(text.length<6){
						System.out.println("Layout incorreto, linha: " + line);
						pw.println("Layout incorreto, linha: " + line);
						pw.flush();
					}else{	
							//VERIFICA SE O CPF VAI ESTAR VAZIO E APÓS SE O CPF É VÁLIDO, 
						//CASO NÃO, EXIBE O ERRO NO LOG, SE FOR VAZIO INFORMA E PREENCHE O CPF COM 0
						if(!text[0].isEmpty()){
							if(!validaCpf.isCPF(text[0])){
								System.out.println("Erro cpf, linha: " + line);
								pw.println("Erro cpf, linha: " + line);
								pw.flush();
							}else if(validaPasseLivre.validaPL(text[0])){
								System.out.println("Cpf não se encontra na lista de PL, linha: " + line);
								pw.println("Cpf não se encontra na lista de PL, linha: " + line);
								pw.flush();
							}
							pedido.setCpf(text[0]);
							listaCpf.add(text[0]);
						}else{
							System.out.println("Campo cpf se encontra vazio, linha: " + line);
							pw.println("Campo cpf se encontra vazio, linha: " + line);
							pw.flush();
							pedido.setCpf("00000000000");
						}
						
						
						//VERIFICA SE A QUANTIDADE DE DIAS VAI ESTAR VAZIA E SE ELA TEM O VALOR FIXO 1
						//CASO ELA ESTEJA VAZIA VAI SER PREENCHIDA COM 0 E VAI INFORMAR NO LOG
						if(!text[1].isEmpty()){
							if(!validaQtdDias.isQuantidadeDias(Integer.parseInt(text[1]))){
								System.out.println("Erro quantidade de dias, linha: " + line);
								pw.println("Erro quantidade de dias, linha: " + line);
								pw.flush();
							}
							pedido.setUsoDiario(Integer.parseInt(text[1]));
						}else{
							System.out.println("Campo quantidade de dias se encontra vazio, linha: " + line);
							pw.println("Campo quantidade de dias se encontra vazio, linha: " + line);
							pw.flush();
							pedido.setUsoDiario(0);
						}
						
						
						//VERIFICA SE O VALOR MINIMO É MENOR QUE 3 PASSAGENS DO ANEL A OU VAZIA
						//CASO FOR VAZIO VAI PREENCHER O VALOR COM 0
						if(!text[2].isEmpty()){
							if(!(Double.parseDouble(text[2])>=960)){
								System.out.println("Erro valor mínimo diário, linha: " + line);
								pw.println("Erro valor mínimo diário, linha: " + line);
								pw.flush();
							}
							pedido.setValorUsoDiario(Double.parseDouble(text[2]));
						}else{
							System.out.println("Campo valor mínimo diário vazio, linha: " + line);
							pw.println("Campo valor mínimo diário vazio, linha: " + line);
							pw.flush();
							pedido.setValorUsoDiario(0);
						}
						
						
						//VERIFICA SE O CAMPO DO NOME CONTÉM O NOME TESTE
						//CASO FOR USUÁRIO DE TESTE ELE VAI INFORMAR NO LOG
						//COMO NÃO É CAMPO OBRIGATÓRIO CASO ESTEJA VÁZIO VAI SER PREENCHIDO VAZIO
						if(!text[3].isEmpty()){
							if(text[3].toUpperCase().contains("TESTE")){
								System.out.println("Usuário de teste encontrado, linha: " + line);
								pw.println("Usuário de teste encontrado, linha: " + line);
								pw.flush();
							}
							pedido.setNome(text[3]);
						}else{
							pedido.setNome("");
						}
						
						
						//VERIFICA SE O CAMPO TIPO CARTAO VAI ESTAR VAZIO
						//CASO FOR VAZIO VAI SER PREENCHIDO COM 0, SE NÃO FOR
						//VAI SER VERIFICADO SE É ALGUM DOS DOIS TIPOS 19 OU 17
						if(!text[4].isEmpty()){
							Integer tipoCartao = Integer.parseInt(text[4]);
							if(tipoCartao == 19 || tipoCartao == 17){
								pedido.setTipoCartao(tipoCartao);							
							}else{
								System.out.println("Erro tipo do cartão, linha: " + line);
								pw.println("Erro tipo do cartão, linha: " + line);
								pw.flush();
							}
						}else{
							System.out.println("Campo tipo cartão vazio, linha: " + line);
							pw.println("Campo tipo cartão vazio, linha: " + line);
							pw.flush();
							pedido.setTipoCartao(0);
						}
						
						
						//VERIFICA SE O CAMPO APLICACAO VAI ESTAR VAZIO
						//CASO FOR VAI SER PREENCHIDO COM 0, SE NÃO FOR
						//VAI SER VERIFICADO SE É ALGUM DOS DOIS TIPOS 911 OU 905
						if(!text[5].isEmpty()){
							Integer aplicacao = Integer.parseInt(text[5]);
							if(aplicacao == 911 || aplicacao == 905){
								pedido.setAplicacao(aplicacao);							
							}else{
								System.out.println("Erro tipo da aplicação, linha: " + line);
								pw.println("Erro tipo da aplicação, linha: " + line);
								pw.flush();
							}
						}else{
							System.out.println("Campo tipo cartão vazio, linha: " + line);
							pw.println("Campo tipo cartão vazio, linha: " + line);
							pw.flush();
							pedido.setAplicacao(0);
						}
				}
				} else { //VAI PREENCHER O CABECALHO DO PEDIDO COM A PRIMEIRA LINHA DO ARQUIVO
					pedido.setCabecalho(linha);
				}
				System.out.println("Linha: "+line);
				line ++;
			}
			if(!duplicidadeCpf(listaCpf).isEmpty()){ // CHAMA O METÓDO PARA VERIFICAR A DUPLICIDADE DE CPF,re
				System.out.println("Cpf em duplicidade nas linhas: " + duplicidadeCpf(listaCpf));
				pw.println("Cpf em duplicidade nas linhas: " + duplicidadeCpf(listaCpf));
				pw.flush();
			}
			System.out.println("Pedido validado com sucesso");
			pw.println("Pedido validado com sucesso");
			pw.flush();
			pw.close();
		}
	}
	
	public ArrayList<Integer> duplicidadeCpf(ArrayList<String> lcpf){
		// VERIFICAR SE HÁ DUPLICIDADE NO CPF
		int i = 2;
		int count = 0;
		ArrayList<Integer> ln = new ArrayList<>();
		for (String c0 : lcpf) {
			for (String c : lcpf) {
				if (c0.equals(c)) {
					count++;
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
