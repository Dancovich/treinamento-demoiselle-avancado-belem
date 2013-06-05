package gov.serpro.treinamento_demoiselle_avancado.util;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.configuration.Configuration;

@Configuration(prefix="auth" , resource="login")
public class LoginConfiguration {
	
	@Name("login")
	private String login;
	
	@Name("senha")
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
