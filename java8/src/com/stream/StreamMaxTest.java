package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMaxTest {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
		
		int max = list.stream().max(Integer::compare).map(Integer::intValue).get();
		System.out.println("max = "+max);
		
		
		int min = list.stream().min(Integer::compare).map(Integer::intValue).get();
		System.out.println("min = "+min);
	}
	
	

}
