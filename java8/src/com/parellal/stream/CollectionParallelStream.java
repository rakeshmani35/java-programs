package com.parellal.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionParallelStream {

	private static List<String> getData() {

		List<String> list = new ArrayList<String>();

		int n = 97; // a = 97, z = 122
		while (n <= 122) {
			char c = (char) n;
			list.add(String.valueOf(c));
			n++;
		}

		return list;
	}

	public static void main(String[] args) {
		
		List<String> list = getData();
		
		
		System.out.println("Normal....");
		//list.stream().forEach(System.out::print);
		list.stream().forEach(s -> System.out.print(s+" "));
		
		System.out.println();
		System.out.println("Parallal....");
		//list.parallelStream().forEach(System.out::print);
		list.parallelStream().forEach(s -> System.out.print(s+" "));
	}

}
