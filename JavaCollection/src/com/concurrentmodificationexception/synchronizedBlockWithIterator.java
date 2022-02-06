package com.concurrentmodificationexception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class synchronizedBlockWithIterator {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		//Collections.synchronizedList(list);
		
		synchronized (list) {
			Iterator<Integer> it = list.iterator();
			//it.remove();  // IllegalStateException
			//list.add(77);  //  ConcurrentModificationException
			
			while (it.hasNext()) {
				
				//it.remove();  // IllegalStateException
				//list.add(77);  //  ConcurrentModificationException
				
				Integer value = it.next();
				
				//it.remove();  // working and removing all elements
				//list.add(77);  //  ConcurrentModificationException
				
				if (value.equals(3)) {
					//list.remove(value); //  ConcurrentModificationException
					//list.add(77);  //  ConcurrentModificationException
					
					int index = list.indexOf(3);
					list.set(index, 10);
				}
				
				System.out.println("List Value:" + value);
			}
		}
		System.out.println(list);  // [1, 2, 10, 4, 5]

	}

}
