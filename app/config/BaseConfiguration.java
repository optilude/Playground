package config;

import com.deloitte.timesink.repository.ContextRepository;
import com.deloitte.timesink.repository.ContextRepositoryImpl;
import com.deloitte.timesink.repository.EntryRepository;
import com.deloitte.timesink.repository.EntryRepositoryImpl;
import com.deloitte.timesink.service.AuthenticationService;
import com.deloitte.timesink.service.AuthenticationServiceImpl;
import com.deloitte.timesink.service.Reporter;
import com.deloitte.timesink.service.ReporterImpl;
import com.google.inject.AbstractModule;

public class BaseConfiguration extends AbstractModule {

	@Override
	protected void configure() {
		bind(Reporter.class).to(ReporterImpl.class);
		bind(ContextRepository.class).to(ContextRepositoryImpl.class);
		bind(EntryRepository.class).to(EntryRepositoryImpl.class);
		bind(AuthenticationService.class).to(AuthenticationServiceImpl.class);
	}

}
