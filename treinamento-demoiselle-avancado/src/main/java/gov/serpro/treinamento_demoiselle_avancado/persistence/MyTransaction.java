package gov.serpro.treinamento_demoiselle_avancado.persistence;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.transaction.Transaction;

public class MyTransaction implements Transaction {

	private static final long serialVersionUID = 561441274872818000L;

	private boolean isActive = false;
	
	@Inject
	private Logger logger;

	@Override
	public boolean isActive() {
		return this.isActive;
	}

	@Override
	public boolean isMarkedRollback() {
		return false;
	}

	@Override
	public void begin() {
		isActive=true;
		logger.info("Começando minha transação");
	}

	@Override
	public void commit() {
		isActive=false;
		logger.info("Terminando minha transação com sucesso");
	}

	@Override
	public void rollback() {
		isActive=false;
		logger.info("Minha transação foi abortada");
	}

	@Override
	public void setRollbackOnly() {
	}

}
