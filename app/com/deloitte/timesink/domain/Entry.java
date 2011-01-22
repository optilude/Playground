package com.deloitte.timesink.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Entry extends Model {

	public Date dateTime;
	public long duration;
	public String details;
	
	@ManyToOne
	public Context context;
	
	public Entry(Date dateTime, long duration, String details, Context context) {
		this.dateTime = dateTime;
		this.duration = duration;
		this.details = details;
		this.context = context;
	}
	
}
