package com.deloitte.timesink.repository;

import java.util.Date;
import java.util.List;



import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.domain.Entry;
import com.deloitte.timesink.domain.Entry;


@Repository
public class EntryRepositoryImpl implements EntryRepository {

	@Override
	public List<Entry> findEntries(Context context, Date from, Date to) {
		return Entry.find("context = ? and dateTime between ? and ?", 
				context,from, to).fetch();
	}

	@Override
	public void addEntry(Entry entry) {
		entry.save();
	}

	@Override
	public void deleteEntry(Entry entry) {
		entry.delete();
	}

}
