package br.com.urbanape.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.urbanape.modelo.UsuarioDoSistemaSilu;

@SuppressWarnings("serial")
public class Autorizador implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent evento) {
		FacesContext contexto = evento.getFacesContext();

		String pagina = contexto.getViewRoot().getViewId();

		System.out.println(pagina.toString());

		if ("/login.xhtml".equals(pagina)) {
			return;
		}

		UsuarioDoSistemaSilu usuarioLogado = (UsuarioDoSistemaSilu) contexto.getExternalContext().getSessionMap()
				.get("UsuarioDoSistemaSilulogado");

		if (usuarioLogado != null) {
			return;
		}

		NavigationHandler handler = contexto.getApplication().getNavigationHandler();
		handler.handleNavigation(contexto, null, "/login.xhtml?faces-redirect-true");
		contexto.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}