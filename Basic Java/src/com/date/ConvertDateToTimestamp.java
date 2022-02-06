package com.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateToTimestamp {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		 
		Timestamp timestamp = new Timestamp(date.getTime()); // 2020-07-03 12:52:11.485
		
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Date parse = sf1.parse(timestamp.toString());
		
		SimpleDateFormat sf2 = new SimpleDateFormat("dd-MMM-YYYY hh:mm:ss.SSS");
		
		String format = sf2.format(parse);
		
		Timestamp valueOf = Timestamp.valueOf(format);
    System.out.println(valueOf);
	}

}
