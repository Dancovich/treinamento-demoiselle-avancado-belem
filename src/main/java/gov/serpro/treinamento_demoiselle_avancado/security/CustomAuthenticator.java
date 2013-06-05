package gov.serpro.treinamento_demoiselle_avancado.security;

import gov.serpro.treinamento_demoiselle_avancado.util.LoginConfiguration;

import java.security.Principal;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authenticator;

@SessionScoped
public class CustomAuthenticator implements Authenticator {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Credential credential;
	
	@Inject
	private LoginConfiguration loginConfiguration;

	private Principal currentUser;

	@Override
	public void authenticate() throws AuthenticationException {
		
		if (loginConfiguration.getLogin().equals(credential.getLogin())
				&& loginConfiguration.getSenha().equals(credential.getSenha()) ){
		
			this.currentUser = new Principal() {
				
				String name = loginConfiguration.getLogin();
	
				public String getName() {
					return name;
				}
			};
		}
		else{
			throw new AuthenticationException("Não existe usuário");
		}
	}

	@Override
	public void unAuthenticate() {
		this.currentUser = null;
	}

	@Override
	public Principal getUser() {
		return this.currentUser;
	}
}