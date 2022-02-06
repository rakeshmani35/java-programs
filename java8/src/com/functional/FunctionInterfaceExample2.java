package com.functional;

import java.util.function.Function;

/**
 * Function<T,R> It represents a function that accepts one argument and returns
 * a result.
 * 
 * @author rakes
 *
 */
public class FunctionInterfaceExample2 {

	 static String show(String message){  
	        return "Hello "+message;  
	    } 
	
	public static void main(String[] args) {
		// Function interface referring to a method  
        Function<String, String> fun = FunctionInterfaceExample2::show;  
        // Calling Function interface method  
        System.out.println(fun.apply("Peter"));  
	}

}
