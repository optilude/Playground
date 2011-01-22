package com.deloitte.timesink.repository;

import java.util.Date;
import java.util.List;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.domain.Entry;

public interface EntryRepository {

	/**
	 * Find all entries in a given context and date/time range
	 */
	public List<Entry> findEntries(Context context, Date from, Date to);
	
	/**
	 * Add a new entry
	 */
	public void addEntry(Entry entry);
	
	/**
	 * Delete the given entry
	 */
	public void deleteEntry(Entry entry);
	
}
