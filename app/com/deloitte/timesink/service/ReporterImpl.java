package com.deloitte.timesink.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.domain.Entry;
import com.deloitte.timesink.repository.EntryRepository;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;

@Service
public class ReporterImpl implements Reporter {

	private EntryRepository entryRepository;
	
	@Autowired
	ReporterImpl(EntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}
	
	@Override
	public long sumWastedTime(Context context, Date fromDate, Date toDate) {
		
		List<Entry> entries = entryRepository.findEntries(context, fromDate, toDate);
		
		long minutes = 0;
		for(Entry e : entries) {
			minutes += e.duration;
		}
		
		return minutes;
	}

}
