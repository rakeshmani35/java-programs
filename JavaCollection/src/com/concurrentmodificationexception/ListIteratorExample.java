package com.concurrentmodificationexception;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("PHP");
		list.add("SQL");
		list.add("Angular 2");
		
		ListIterator<String> listIterator = list.listIterator();
		listIterator.add("C++");
		//listIterator.remove(); // IllegalStateException
		while (listIterator.hasNext()) {
			
			//listIterator.remove(); // IllegalStateException
			
			String value = (String) listIterator.next();
			
			listIterator.remove(); // IllegalStateException
			
			System.out.println(value);
		}
		//System.out.println("listIterator = "+listIterator.toString());
		System.out.println("list = "+list);
	}

}
