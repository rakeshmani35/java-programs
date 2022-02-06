package com.concurrentmodificationexception;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

	public static void main(String[] args) {

		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			list.add("E");
			String value = (String) it.next();
			System.out.println(value); // A B C D
		}
		
		System.out.println("list = "+list); // list = [A, B, C, D, E, E, E, E]
	}

}
