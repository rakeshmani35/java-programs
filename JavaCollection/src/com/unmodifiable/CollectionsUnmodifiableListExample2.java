package com.unmodifiable;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsUnmodifiableListExample2 {

	public static void main(String[] args) {
		
		List<String> list = Stream.of("Google","Yahoo","Mozila").collect(Collectors.toList());
		
		
		list = Collections.unmodifiableList(list); // UnsupportedOperationException
		//Collections.unmodifiableList(list);  // work fine
		
		System.out.println("Original list :: "+list);
		
		list.add("Amazon");
		
		System.out.println("Original list :: "+list);
	}

}
