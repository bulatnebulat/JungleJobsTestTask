package org.junglejobs.newsservice.util;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Wrong dates range") 
public class WrongDatesRangeException extends RuntimeException {

	
	private static final long serialVersionUID = -301978574786331755L;
	
	public WrongDatesRangeException(Date fromDate, Date toDate){
		super("Start date: " + fromDate + " is after end of range date: " + toDate);
	}
}
