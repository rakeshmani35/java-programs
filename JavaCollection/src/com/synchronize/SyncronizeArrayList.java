package com.synchronize;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SyncronizeArrayList {

	public static void main(String[] args) {
		List<String> fruitList = Stream.of("Mango", "Banana", "Apple", "Strawberry", "Pineapple")
				.collect(Collectors.toList());
		
		 // Synchronizing ArrayList in Java 
		fruitList = Collections.synchronizedList(fruitList);

		
		 // OR Synchronizing ArrayList by use synchronize block 
		synchronized (fruitList) {
			
			fruitList.forEach(fruit -> System.out.println(fruit)); 
		}
	}

}
