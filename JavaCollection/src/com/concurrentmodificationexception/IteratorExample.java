package com.concurrentmodificationexception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("PHP");
		list.add("SQL");
		list.add("Angular 2");
		
		Iterator<String> it = list.iterator();
		//it.remove(); // IllegalStateException
		//list.add("C++"); //ConcurrentModificationException
		
		while (it.hasNext()) {
			//list.add("C++"); //ConcurrentModificationException
			//it.remove(); // IllegalStateException
			String value = (String) it.next();
			
			it.remove(); // this is working fine
			//it.remove(); // IllegalStateException 2 remove not work
			if (value.equals("Java")) {
				//it.remove(); // this is working fine
			}
			
			System.out.print(value +", ");
			System.out.println(list);
		}
		
		System.out.println();
		list.add("C++");
		System.out.println(list);
	}

}

/**
 * Java, [PHP, SQL, Angular 2]
PHP, [SQL, Angular 2]
SQL, [Angular 2]
Angular 2, []

[C++]

 */
