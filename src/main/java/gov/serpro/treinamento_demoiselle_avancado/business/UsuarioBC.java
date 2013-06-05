package gov.serpro.treinamento_demoiselle_avancado.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import gov.serpro.treinamento_demoiselle_avancado.domain.Usuario;
import gov.serpro.treinamento_demoiselle_avancado.persistence.UsuarioDAO;

@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, Long, UsuarioDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
