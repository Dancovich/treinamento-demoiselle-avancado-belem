package gov.serpro.treinamento_demoiselle_avancado.util;

import javax.enterprise.inject.Alternative;

import br.gov.frameworkdemoiselle.internal.implementation.SecurityContextImpl;

@Alternative
public class NewSecurityContext extends SecurityContextImpl {

	private static final long serialVersionUID = 7153185215076202696L;

}
