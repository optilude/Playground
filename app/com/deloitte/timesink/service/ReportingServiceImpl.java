package com.deloitte.timesink.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;
import java.util.List;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.domain.Entry;
import com.deloitte.timesink.repository.EntryRepository;
import com.deloitte.utils.configregistry.ConfigurationRegistry;
import com.google.inject.Inject;

//XXX: Play's partial javax.inject.Inject means we can't the real javax.inject.Inect
// this on constructors, so we use the Google one instead for now

public class ReportingServiceImpl implements ReportingService {

	
	private EntryRepository entryRepository;
	private ConfigurationRegistry configurationRegistry;
	
	@Inject
	ReportingServiceImpl(EntryRepository entryRepository, ConfigurationRegistry configurationRegistry) {
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
