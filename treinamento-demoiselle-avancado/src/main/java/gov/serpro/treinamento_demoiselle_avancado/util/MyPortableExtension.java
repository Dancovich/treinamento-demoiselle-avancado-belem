package gov.serpro.treinamento_demoiselle_avancado.util;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.internal.producer.LoggerProducer;

public class MyPortableExtension implements Extension {
	
	public void capturarAfterBeanDiscovery( @Observes AfterBeanDiscovery event , BeanManager manager ){
		Logger logger = LoggerProducer.create(MyPortableExtension.class);
		
		logger.info("###########MEU PORTABLE EXTENSION FOI CHAMADO###########");
	}

}
