package com.unmodifiable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsUnmodifiableListExample1 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		Collections.addAll(list, "Google", "Mozila FireFox", "Yahoo");
		
		System.out.println("Originial List :: "+list);
		
		// convert list into unmodifiable Collection :: unmodifiableCollection(list)
		Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(list);
		System.out.println("unmodifiable Collection :: "+unmodifiableCollection);
		
		// convert list into unmodifiable list :: unmodifiableList(list)
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		
		// add element in original list
		list.add("Safari");
		System.out.println("After added new element :: Originial List :: "+list);
		
		// Unmodifiable List after adding element to the list:
		System.out.print("Unmodifiable List after adding element to the Originial list :: "+unmodifiableList);
		
		// java.lang.UnsupportedOperationException
		//System.out.println("add new element in Unmodifiable List :: "+unmodifiableList.add("Amazon"));
	}

}
