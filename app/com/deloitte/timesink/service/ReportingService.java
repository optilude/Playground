package com.deloitte.timesink.service;

import java.util.Date;

import com.deloitte.timesink.domain.Context;

/**
 * Basic business logic for reporting on wasted time across entries
 */
public interface ReportingService {

	/**
	 * Get the total number of minutes of time wasted
	 * @param context Context to look in
	 * @param fromDate Start date
	 * @param toDate End date
	 * @return Number of minutes wasted
	 */
	public long sumWastedTime(Context context, Date fromDate, Date toDate);
	
}
