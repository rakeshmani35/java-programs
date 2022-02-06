package com.concurrentmodificationexception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class SetConcurrentModificationExceptionTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>(Arrays.asList("java", "C++", "C", "Python"));

		
		
		// 1. Traditional way iterate
		System.out.print("Traditional way iterate = ");
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String courses = (String) it.next();
			System.out.print(courses + " ");
			// set.add("Angular"); // gives ConcurrentModificationException
		}

		// 2. Foreach conventional way iterate
		System.out.println();
		System.out.print("Foreach way iterate = ");
		for (String string : set) {
			System.out.print(string + " ");
			// set.add("Angular"); // gives ConcurrentModificationException
			// if (string.equals("java")) {
			// set.remove("java");
			// set.add("Angular");
			// }
		}

		// 2. Foreach java8 way iterate
		System.out.println();
		System.out.print("Foreach java8 way iterate = ");
		set.stream().forEach(str -> {
			System.out.print(str + " ");
			// set.add("Angular"); // gives ConcurrentModificationException
		});
        System.out.println();
		
		// Resolve concurrentModificationException in SET
		// 1. convert set to array
		Object[] array = set.toArray();
		System.out.println("set to array conversion = "+Arrays.toString(array));
		// 2. convert set to CopyOnWriteArralList
		CopyOnWriteArrayList list = new CopyOnWriteArrayList<>(set);
		list.add("PHP");
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			String str = (String) iterator.next();
			list.add("Angular");
			System.out.print(str+" ");
		}
	
		
		list.stream().forEach( i -> {});
		
		String s ="a";
		String b = s+"a";
		if ("aa"==b) {
			System.out.println("1");
		}else {
			System.out.println("2");
		}
	}

}
