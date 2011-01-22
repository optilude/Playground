package controllers;

import java.util.List;

import org.joda.time.DateTime;

import play.modules.spring.Spring;
import play.mvc.Controller;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.domain.Entry;
import com.deloitte.timesink.repository.ContextRepository;
import com.deloitte.timesink.repository.EntryRepository;
import com.deloitte.timesink.service.Reporter;

public class Contexts extends Controller {

	protected static ContextRepository contextRepository = Spring.getBeanOfType(ContextRepository.class);
	protected static EntryRepository entryRepository = Spring.getBeanOfType(EntryRepository.class);
	protected static Reporter reporter = Spring.getBeanOfType(Reporter.class);
	
	public static void view(String name) {
		
		Context context = contextRepository.getByShortName(name);
		
		DateTime toDate = new DateTime();
		DateTime fromDate = toDate.minusDays(5);
		
		List<Entry> entries = entryRepository.findEntries(context, fromDate.toDate(), toDate.toDate()); 
		
		long wastedTime = reporter.sumWastedTime(context, fromDate.toDate(), toDate.toDate());
		
		render(context, entries, wastedTime);
	}
	
}
