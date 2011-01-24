package controllers;

import java.util.List;

import javax.inject.Inject;

import org.jadapter.registry.TransformerRegistry;
import org.joda.time.DateTime;

import play.mvc.Controller;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.domain.Entry;
import com.deloitte.timesink.domain.Located;
import com.deloitte.timesink.domain.Location;
import com.deloitte.timesink.repository.ContextRepository;
import com.deloitte.timesink.repository.EntryRepository;
import com.deloitte.timesink.service.ReportingService;

public class Contexts extends Controller {

	@Inject
	protected static ContextRepository contextRepository;
	
	@Inject
	protected static EntryRepository entryRepository;
	
	@Inject
	protected static ReportingService reporter;
	
	@Inject
	protected static TransformerRegistry adapters;
	
	public static void view(String name) {
		
		Context context = contextRepository.getByShortName(name);
		
		DateTime toDate = new DateTime();
		DateTime fromDate = toDate.minusDays(5);
		
		List<Entry> entries = entryRepository.findEntries(context, fromDate.toDate(), toDate.toDate()); 
		
		long wastedTime = reporter.sumWastedTime(context, fromDate.toDate(), toDate.toDate());
		
		Located located = adapters.transform(context, Located.class);
		Location location = located.getLocation();
		
		render(context, entries, wastedTime, location);
	}
	
}
