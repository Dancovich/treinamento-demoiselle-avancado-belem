package gov.serpro.treinamento_demoiselle_avancado.domain;

import br.gov.frameworkdemoiselle.conversation.BatePapoScoped;

@BatePapoScoped
public class Telefone {
	
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
