package com.concurrentmodificationexception;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationExceptionWithArrayListSubList {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("Java");
		names.add("PHP");
		names.add("SQL");
		names.add("Angular 2");

		List<String> first2Names = names.subList(0, 2);
		Object[] array = first2Names.toArray();

		//System.out.println(names + " , " + first2Names);
		System.out.println(names );

		names.set(1, "JavaScript");
		// check the output below. :)
		//System.out.println(names + " , " + first2Names);
		System.out.println(names );

		// Let's modify the list size and get ConcurrentModificationException
		names.add("NodeJS");
		System.out.println(names + " , " + first2Names); // this line throws exception
		System.out.println(names );

	}

}
