package config;

import org.jadapter.guice.AbstractAdaptersModule;

import com.deloitte.timesink.domain.LocatedContext;

public class Adapters extends AbstractAdaptersModule {

	@Override
	protected void configureAdapters() {
		bindAdapter(LocatedContext.class);
	}

}
