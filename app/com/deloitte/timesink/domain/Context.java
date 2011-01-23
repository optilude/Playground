package com.deloitte.timesink.domain;

import static com.deloitte.timesink.utils.StringUtils.normalizeString;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Context extends Model {
	
	@Required
	public String shortName;
	
	@Required
	public String name;
	
	public String description;
	
	public Context(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public void setName(String name) {
		this.name = name;
		
		if(shortName == null || "".equals(shortName)) {
			this.shortName = normalizeString(name);
		}
	}

}
