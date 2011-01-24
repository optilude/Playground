package com.deloitte.timesink.service;

import com.deloitte.timesink.domain.Location;

/**
 * Search-based interface for locating things
 */
public interface LocatorService {
	
	/**
	 * Search for a location
	 */
	public Location findBestMatch(String searchTerm) throws UnableToLocateException;

}
