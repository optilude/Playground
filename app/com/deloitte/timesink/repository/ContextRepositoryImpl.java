package com.deloitte.timesink.repository;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.domain.Context;


@Repository
public class ContextRepositoryImpl implements ContextRepository {
	
	@Override
	public Context getByShortName(String name) {
		return Context.find("byShortName", name).first();
	}
	
	@Override
	public List<Context> allContexts() {
		return Context.findAll();
	}

	@Override
	public List<Context> findContexts(String searchTerm) {
		return Context.find("byNameIsLike", "%" + searchTerm + "%").fetch();
	}

	@Override
	public void addContext(Context context) {
		context.save();
	}

	@Override
	public void deleteContext(Context context) {
		context.delete();
	}
	
}
