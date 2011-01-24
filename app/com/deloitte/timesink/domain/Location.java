package com.deloitte.timesink.domain;

/**
 * A location (immutable value object)
 */
public class Location {

	private int northing;
	private int easting;
	
	public Location(int northing, int easting) {
		this.northing = northing;
		this.easting = easting;
	}
	
	public int getNorthing() {
		return northing;
	}
	
	public int getEasting() {
		return easting;
	}
	
	public String toString() {
		return String.format("%d north, %d east", northing, easting);
	}
	
}
