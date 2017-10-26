package br.com.urbanape.bean;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@ViewScoped
public class FileDownloadView {
	
	private StreamedContent file;
	
	public FileDownloadView(){
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("log.txt");
		file = new DefaultStreamedContent(stream, "log.txt", "Log_Pedido.txt");
	}
	
	public StreamedContent getFile(){
		return file;
	}
}
