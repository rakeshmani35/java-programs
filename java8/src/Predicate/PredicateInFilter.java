package Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateInFilter {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		List<Integer> collect = list.stream().filter(p -> p>5).collect(Collectors.toList());
		collect.forEach(System.out::println);

	}
	

}
