package com.map;

import java.util.HashMap;

public class ImmutableKeyTest {

	public static void main(String[] args) {
		String key1 = "A";
		String key2 = "B";

		HashMap<String, Integer> hm = new HashMap<>();

		hm.put(key1, 1);
		hm.put(key2, 2);
		
		System.out.println(hm);
		System.out.println("hm.get(key1) = "+hm.get(key1));
		System.out.println("hm.get(key2) = "+hm.get(key2));
		
		key1="D";
		
		System.out.println("-----------");
		System.out.println(hm);
		System.out.println("hm.get(key1) = "+hm.get(key1));
		System.out.println("hm.get(key2) = "+hm.get(key2));

	}

}
