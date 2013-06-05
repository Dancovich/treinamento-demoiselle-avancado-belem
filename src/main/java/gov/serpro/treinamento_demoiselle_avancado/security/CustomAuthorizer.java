package gov.serpro.treinamento_demoiselle_avancado.security;

import java.security.Principal;

import javax.inject.Inject;

import gov.serpro.treinamento_demoiselle_avancado.util.AuthConfiguration;
import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.security.SecurityContext;

public class CustomAuthorizer implements Authorizer {

	private static final long serialVersionUID = -1625585739895785885L;
	
	@Inject
	private AuthConfiguration authConfiguration;
	
	@Inject
	private SecurityContext securityContext;

	@Override
	public boolean hasRole(String role) {
		
		Principal usuario = securityContext.getCurrentUser();
		if(usuario!=null){
			String login = usuario.getName();
			
			String[] usuarios = authConfiguration.getLogin();
			String[] papeis = authConfiguration.getRole();
			
			for (int i=0; i<usuarios.length; i++){
				if (usuarios[i].equals(login) && papeis[i].equals(role)){
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean hasPermission(String resource, String operation) {
		// TODO Auto-generated method stub
		return false;
	}

}
