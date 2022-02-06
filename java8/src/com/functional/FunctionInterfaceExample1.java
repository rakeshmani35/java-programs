package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Function<T,R> It represents a function that accepts one argument and returns
 * a result.
 * 
 * @author rakes
 *
 */
public class FunctionInterfaceExample1 {

	 static Integer addList(List<Integer> list){  
	        return list.stream()  
	                   .mapToInt(Integer::intValue)  
	                   .sum();  
	    }  

	public static void main(String[] args) {

		// Creating a list and adding values  
        List<Integer> list = new ArrayList<Integer>();  
        list.add(10);  
        list.add(20);  
        list.add(30);  
        list.add(40); 
        
     // Referring addList() method  
		Function<List<Integer>, Integer> func = FunctionInterfaceExample1::addList;
		Integer result = func.apply(list);
		System.out.println("result = " + result);
	}

}
