package org.junglejobs.newsservice.util;

import java.util.Date;

public class WrongDatesRangeException extends RuntimeException {

	
	private static final long serialVersionUID = -301978574786331755L;
	
	public WrongDatesRangeException(Date fromDate, Date toDate){
		super("Start date: " + fromDate + " is after end of range date: " + toDate);
	}
}
