package gov.serpro.treinamento_demoiselle_avancado.view;

import gov.serpro.treinamento_demoiselle_avancado.security.Credential;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.message.DefaultMessage;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;

@ViewController
public class LoginMB {
	
	@Inject
	private Credential credential;
	
	@Inject
	private SecurityContext context;
	
	@Inject
	private MessageContext messageContext;
	
	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	
	public String logar(){
		try{
			context.login();
		}
		catch(AuthenticationException ae){
			messageContext.add(new DefaultMessage(ae.getMessage() , SeverityType.ERROR));
			return null;
		}
		
		return "index.jsf";
	}

}
