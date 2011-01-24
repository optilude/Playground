package com.deloitte.timesink.service;

import com.deloitte.timesink.domain.Location;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Dummy implementation of the LocatorService
 */
public class LocatorServiceImpl implements LocatorService {

	public LocatorServiceImpl() {
	}
	
	@Override
	public Location findBestMatch(String searchTerm) throws UnableToLocateException {
		checkNotNull(searchTerm);
		
		// Imagine calling a web service here or something
		
		if(searchTerm.equals("")) {
			throw new UnableToLocateException("Empty search term");
		}
		
		return new Location(1000, 2000);
	}
	
}
