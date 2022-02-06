package com.concurrentmodificationexception;

import java.util.ArrayList;
import java.util.List;

// https://www.java67.com/2018/12/how-to-remove-objects-or-elements-while-iterating-Arraylist-java.html
public class ConcurrentModificationExceptionList4 {

	public static void main(String[] args) {

		List<String> loans = new ArrayList<>();
		loans.add("personal loan");
		loans.add("home loan");
		loans.add("auto loan");
		loans.add("credit line loan");
		loans.add("mortgage loan");
		loans.add("gold loan");

		// printing ArrayList before removing any element
		System.out.println(loans);

		for (String loan : loans) {
			if (loan.equals("personal loan")) {
				 //loans.remove(loan); // ConcurrentModificationException
				// loans.add("bike loan"); // ConcurrentModificationException
			}
		}
		// printing ArrayList after removing an element
		System.out.println(loans);

	}

}
