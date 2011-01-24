package config;

import org.jadapter.JAdapter;
import org.jadapter.guice.GuiceTransformerRegistry;
import org.jadapter.registry.AdapterRegistry;
import org.jadapter.registry.TransformerRegistry;
import org.jadapter.registry.TransientAdapterRegistry;

import com.deloitte.timesink.domain.LocatedContext;
import com.deloitte.timesink.repository.ContextRepository;
import com.deloitte.timesink.repository.ContextRepositoryImpl;
import com.deloitte.timesink.repository.EntryRepository;
import com.deloitte.timesink.repository.EntryRepositoryImpl;
import com.deloitte.timesink.service.AuthenticationService;
import com.deloitte.timesink.service.AuthenticationServiceImpl;
import com.deloitte.timesink.service.LocatorService;
import com.deloitte.timesink.service.LocatorServiceImpl;
import com.deloitte.timesink.service.ReportingService;
import com.deloitte.timesink.service.ReportingServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class Services extends AbstractModule {

	@Override
	protected void configure() {
		bind(ContextRepository.class).to(ContextRepositoryImpl.class).in(Singleton.class);
		bind(EntryRepository.class).to(EntryRepositoryImpl.class).in(Singleton.class);
		
		bind(AuthenticationService.class).to(AuthenticationServiceImpl.class).in(Singleton.class);
		
		bind(ReportingService.class).to(ReportingServiceImpl.class).in(Singleton.class);
		bind(LocatorService.class).to(LocatorServiceImpl.class).in(Singleton.class);
		
		bind(TransformerRegistry.class).to(GuiceTransformerRegistry.class);
	}

}
