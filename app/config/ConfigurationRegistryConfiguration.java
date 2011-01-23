package config;

import com.deloitte.utils.configregistry.ConfigurationRegistry;
import com.deloitte.utils.configregistry.PlayConfigurationRegistry;
import com.google.inject.AbstractModule;

public class ConfigurationRegistryConfiguration extends AbstractModule {

	@Override
	protected void configure() {
		bind(ConfigurationRegistry.class).to(PlayConfigurationRegistry.class);
	}

}
