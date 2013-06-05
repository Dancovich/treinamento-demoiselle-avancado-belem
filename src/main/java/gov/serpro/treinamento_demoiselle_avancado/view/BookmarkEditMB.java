package gov.serpro.treinamento_demoiselle_avancado.view;

import gov.serpro.treinamento_demoiselle_avancado.business.BookmarkBC;
import gov.serpro.treinamento_demoiselle_avancado.domain.Bookmark;
import gov.serpro.treinamento_demoiselle_avancado.domain.Telefone;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.conversation.RegistroContextoExtension;
import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("/bookmark_list.xhtml")
@LoggedIn
public class BookmarkEditMB extends AbstractEditPageBean<Bookmark, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;

	@Inject
	private BookmarkBC bookmarkBC;
	
	@Inject
	private Telefone telefone;
	
	@Inject
	private RegistroContextoExtension extension;
	
	@PostConstruct
	public void iniciarConversa(){
		extension.getContext().comecarConversa();
	}

	@Override
	@Transactional
	public String delete() {
		this.bookmarkBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		telefone.setNumero("123456789");
		
		this.bookmarkBC.insert(getBean());
		return getPreviousView();
	}
	
	@Transactional
	public String insertTransactional(){
		logger.info("MEU MÉTODO TRANSACIONAL FOI CHAMADO!");
		
		return null;
	}

	@Override
	@Transactional
	public String update() {
		this.bookmarkBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(this.bookmarkBC.load(getId()));
	}

}
