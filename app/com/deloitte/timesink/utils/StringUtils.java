package com.deloitte.timesink.utils;

public class StringUtils {
	
	public static String normalizeString(String in) {
		return in.toLowerCase().replaceAll("[^a-zA-Z0-9]+", "-"); 
	}
	
}
