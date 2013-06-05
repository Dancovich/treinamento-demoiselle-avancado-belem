package gov.serpro.treinamento_demoiselle_avancado.util;

import java.io.Serializable;

import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(prefix="auth",resource="auth")
public class AuthConfiguration implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String[] login;
	
	private String[] role;

	public String[] getLogin() {
		return login;
	}

	public void setLogin(String[] login) {
		this.login = login;
	}

	public String[] getRole() {
		return role;
	}

	public void setRole(String[] role) {
		this.role = role;
	}
	
	

}
