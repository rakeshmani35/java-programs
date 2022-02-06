package Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInFilter1 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Predicate<Integer> greaterThan5 = (x) -> (x > 5);
		
		list.stream().filter(greaterThan5).forEach(System.out::println);
	}

}
