package com.itau.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itau.config.Messages;

public class DataValidate {
	
	public static Date getAndValidDate(String sDate) throws StarWarsException {
		 
	    try {
			return new SimpleDateFormat("ddMMyyyy").parse(sDate);
		} catch (ParseException e) {
			throw new StarWarsException(Messages.ERROR_DATE_VALIDATOR, Messages.SERVER_OTHER_ERROR);
		}  
	 
	 
	}  
}
