package com.prectice;

public class ConvertTimeIn24HrFormat {

	private static String print24(String str) {
		
		// Get hours 
	    int h1 = (int)str.charAt(1) - '0'; 
	    int h2 = (int)str.charAt(0) - '0'; 
	    int hh = (h2 * 10 + h1 % 10); 
	    String result = "";
	    // If time is in "AM" 
	    if (str.charAt(8) == 'A') 
	    { 
	        if (hh == 12) 
	        { 
	        	result = "00";
	            for (int i = 2; i <= 7; i++) {
	            	result +=str.charAt(i);
	            }
	                
	        } 
	        else
	        { 
	            for (int i = 0; i <= 7; i++) {
	            	result +=str.charAt(i);
	            }
	              
	        } 
	    } 
	  
	    // If time is in "PM" 
	    else
	    { 
	        if (hh == 12) 
	        { 
	            result = "12";
	            for (int i = 2; i <= 7; i++) {
	            	 result +=str.charAt(i);
	            }
	                
	        } 
	        else
	        { 
	            hh = hh + 12; 
	            result = hh+"";
	            for (int i = 2; i <= 7; i++) {
	            	 result +=str.charAt(i);
	            }
	                
	        } 
	    } 
	    return  result;
	}  
	
	public static void main(String[] args) {
		String str = "12:45:54PM"; 
	    String print24 = print24(str); 
	    System.out.println(print24);

	}

	

}
