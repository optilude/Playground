package com.deloitte.timesink.repository;

import java.util.List;

import com.deloitte.timesink.domain.Context;

public interface ContextRepository {

	/**
	 * Get a context by its short name
	 */
	public Context getByShortName(String name);
	
	/**
	 * Get a list of all contexts
	 */
	public List<Context> allContexts();
	
	/**
	 * Find all contexts matching a search term
	 * @param searchTerm 
	 */
	public List<Context> findContexts(String searchTerm);
	
	/**
	 * Add a new context
	 */
	public void addContext(Context context);
	
	/**
	 * Delete a context
	 */
	public void deleteContext(Context context); 
	
}
