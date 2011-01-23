package com.deloitte.timesink.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.InPast;
import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Entry extends Model {

	@Required
	@InPast
	public Date dateTime;
	
	@Required
	@Min(1)
	public long duration;
	
	@Required
	public String details;
	
	@Required
	@ManyToOne
	public Context context;
	
	public Entry(Date dateTime, long duration, String details, Context context) {
		this.dateTime = dateTime;
		this.duration = duration;
		this.details = details;
		this.context = context;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s (%d mins)",
				new SimpleDateFormat("dd/mm/yyyy").format(dateTime),
				details,
				duration
			);
		
	}
	
}
