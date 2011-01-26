package com.deloitte.timesink.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.domain.Entry;
import com.deloitte.timesink.repository.EntryRepository;

public class ReportingServiceImpl implements ReportingService {
	
	private EntryRepository entryRepository;
	private Properties config;
	
	@Inject
	ReportingServiceImpl(EntryRepository entryRepository, @Named("config") Properties config) {
		this.entryRepository = checkNotNull(entryRepository);
		this.config = checkNotNull(config);
	}
	
	@Override
	public long sumWastedTime(Context context, Date fromDate, Date toDate) {
		
		int minTime = Integer.parseInt(config.getProperty("timesink.minTime"));
		
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
