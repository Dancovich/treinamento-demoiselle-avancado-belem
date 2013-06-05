package gov.serpro.treinamento_demoiselle_avancado.util;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.security.LoggedInInterceptor;
import br.gov.frameworkdemoiselle.security.SecurityContext;

@LoggedIn
@Interceptor
public class MyLoggedInInterceptor extends LoggedInInterceptor {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SecurityContext securityContext;
	
	@AroundInvoke
	public Object manage(final InvocationContext ic) throws Exception {
		securityContext.checkLoggedIn();
		return ic.proceed();
	}

}
