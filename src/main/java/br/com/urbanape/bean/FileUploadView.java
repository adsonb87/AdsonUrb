package br.com.urbanape.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class FileUploadView {
	
	private UploadedFile file;
	

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
		System.out.println(file.toString());
	}
	
	public void upload() throws IOException{
		
    }	
	
}
