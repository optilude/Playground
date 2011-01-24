package com.deloitte.timesink.domain;

import com.deloitte.timesink.service.LocatorService;
import com.deloitte.timesink.service.UnableToLocateException;
import com.google.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * Adapter from Context to Located
 */
public class LocatedContext implements Located {

	private LocatorService locatorService;
	private Context context;
	
	public LocatedContext(Context context) {
		checkNotNull(context);
		
		this.context = context;
	}
	
	@Inject
	public void wire(LocatorService locatorService) {
		checkNotNull(locatorService);
		this.locatorService = locatorService;
	}
	
	@Override
	public Location getLocation() {
		checkState(locatorService != null, "Adapter not wired");
		try {
			return locatorService.findBestMatch(context.description);
		} catch(UnableToLocateException e) {
			return null;
		}
	}

}
