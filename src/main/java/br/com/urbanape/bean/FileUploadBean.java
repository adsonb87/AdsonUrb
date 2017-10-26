package br.com.urbanape.bean;

import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.UploadedFile;

import br.com.urbanape.modelo.ValidaPedido;

@ManagedBean
@ViewScoped
public class FileUploadBean {
	
	private UploadedFile file;
	

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
		System.out.println(file.toString());
	}
	
	public void upload(String enderecoArquivo) throws IOException{
		new ValidaPedido(enderecoArquivo).validaArquivoPedido();
    }	
	
}
