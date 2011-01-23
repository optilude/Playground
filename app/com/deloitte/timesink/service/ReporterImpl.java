package com.deloitte.timesink.service;

import java.util.Date;
import java.util.List;

// XXX: Bug in Play means we can't use this on constructors
// import javax.inject.Inject;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.domain.Entry;
import com.deloitte.timesink.repository.EntryRepository;
import com.deloitte.utils.configregistry.ConfigurationRegistry;
import com.google.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class ReporterImpl implements Reporter {

	
	private EntryRepository entryRepository;
	private ConfigurationRegistry configurationRegistry;
	
	@Inject
	ReporterImpl(EntryRepository entryRepository, ConfigurationRegistry configurationRegistry) {
		this.entryRepository = checkNotNull(entryRepository);
		this.configurationRegistry = checkNotNull(configurationRegistry);
	}
	
	@Override
	public long sumWastedTime(Context context, Date fromDate, Date toDate) {
		
		int minTime = Integer.parseInt(configurationRegistry.getValue("timesink.minTime"));
		
		List<Entry> entries = entryRepository.findEntries(context, fromDate, toDate);
		
		long minutes = 0;
		for(Entry e : entries) {
			minutes += e.duration;
		}
		
		if(minutes < minTime) {
			return 0;
		}
		
		return minutes;
	}

}
