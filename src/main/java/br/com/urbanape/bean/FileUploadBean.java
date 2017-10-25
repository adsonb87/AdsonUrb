package br.com.pe.urbana.bean;

import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.UploadedFile;

import br.com.pe.urbana.modelo.ValidaPedido;

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
	
	public void upload(String endreçoArquivo) throws IOException{
		new ValidaPedido(endreçoArquivo).validaArquivoPedido();
    }	
	
}
