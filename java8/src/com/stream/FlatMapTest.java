package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapTest {

	public static void main(String[] args) {

		
		 String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		 
		 Stream<String[]> stream = Arrays.stream(data);
		 
		 System.out.print("use Arrays.stream(m) : ");
		// stream.flatMap(m -> Arrays.stream(m)).filter(x -> x.equals("a")).forEach(System.out::print);
		 
		 System.out.print("use  Stream.of(m) : ");
		 stream.flatMap(m -> Stream.of(m)).filter(x -> x.equals("a")).forEach(System.out::print);;
		 
		 System.out.println();
		 
		 // ****************************
		 
		 List<List<Integer> > number = new ArrayList<>();
		// adding the elements to number arraylist
	        number.add(Arrays.asList(1, 2));
	        number.add(Arrays.asList(3, 4));
	        number.add(Arrays.asList(5, 6));
	        number.add(Arrays.asList(7, 8));
	        
	        System.out.println("List of list-" + number);    
	        
	        Stream<Integer> flatMap = number.stream().flatMap(list -> list.stream());
	        Stream<String> map = flatMap.map(s -> String.valueOf(s));
			List<String> collect = map.collect(Collectors.toList());
			System.out.println("List<String> collect :: "+collect);
			
			int[] arr = {1,2,3,4,5};
			IntStream stream2 = Arrays.stream(arr);
			Stream<Integer> boxed = stream2.boxed();
			Stream<int[]> of = Stream.of(arr);
			
	}
}
