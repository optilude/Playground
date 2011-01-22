package com.deloitte.timesink.service;

import java.util.Date;

import com.deloitte.timesink.domain.Context;

public interface Reporter {
	
	public long sumWastedTime(Context context, Date fromDate, Date toDate);
	
}
