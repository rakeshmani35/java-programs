package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatCheck {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:sss");
		
		String  strDate = formatter.format(date);  
	    System.out.println("Date Format with dd-M-yy hh:mm:ss : "+strDate); 
	    
	    SimpleDateFormat fprm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    String stringDate = "2020-07-01 18:28:43";
	    Date parse = fprm.parse(stringDate);
	    System.out.println("parse = "+parse);
	    String format = formatter.format(parse);
	    System.out.println("format = "+format);
	    
	    String stringDate1 = "2020-07-01 18:28:43:9999999";
	    System.out.println(stringDate1.length());
	    
	    String subSequence = stringDate1.substring(0, 19);
	    System.out.println(subSequence);
	}

}
