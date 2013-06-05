package gov.serpro.treinamento_demoiselle_avancado.business;

import gov.serpro.treinamento_demoiselle_avancado.domain.Bookmark;
import gov.serpro.treinamento_demoiselle_avancado.domain.Telefone;
import gov.serpro.treinamento_demoiselle_avancado.persistence.BookmarkDAO;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.conversation.RegistroContextoExtension;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Beans;

@BusinessController
public class BookmarkBC extends DelegateCrud<Bookmark, Long, BookmarkDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;
	
	@Inject
	private RegistroContextoExtension extension;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			super.insert(new Bookmark("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br"));
			super.insert(new Bookmark("Demoiselle SourceForge", "http://sf.net/projects/demoiselle"));
			super.insert(new Bookmark("Twitter", "http://twitter.frameworkdemoiselle.gov.br"));
			super.insert(new Bookmark("Blog", "http://blog.frameworkdemoiselle.gov.br"));
			super.insert(new Bookmark("Wiki", "http://wiki.frameworkdemoiselle.gov.br"));
			super.insert(new Bookmark("Bug Tracking", "http://tracker.frameworkdemoiselle.gov.br"));
			super.insert(new Bookmark("Forum", "http://forum.frameworkdemoiselle.gov.br"));
			super.insert(new Bookmark("SVN", "http://svn.frameworkdemoiselle.gov.br"));
			super.insert(new Bookmark("Maven", "http://repository.frameworkdemoiselle.gov.br"));
			super.insert(new Bookmark("Downloads", "http://download.frameworkdemoiselle.gov.br"));
		}
	}

	@Override
	@Transactional
	//@LoggedIn
	//@RequiredRole( isOrRequired=true , value={"admin","guest"})
	public Bookmark insert(Bookmark bean) {
		Telefone telefone = Beans.getReference(Telefone.class);
		
		logger.info(telefone.getNumero());
		
		extension.getContext().terminarConversa();
		
		telefone = Beans.getReference(Telefone.class);
		
		logger.info(telefone.getNumero());
		
		return super.insert(bean);
	}
	
	
	
}
