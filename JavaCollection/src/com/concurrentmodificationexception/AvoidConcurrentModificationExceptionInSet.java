package com.concurrentmodificationexception;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class AvoidConcurrentModificationExceptionInSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>(Arrays.asList("java", "C++", "C", "Python"));

		List<String> list = new CopyOnWriteArrayList<>(set);

		list.forEach(l -> {
			list.add("Angular");
			System.out.print(l);
		});
		
		System.out.println();
		System.out.println(list);
	}

}
