package Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateAnd1 {

	public static void main(String[] args) {

		Predicate<Integer> greaterThan5 = x -> x > 5;
		Predicate<Integer> lessThan8 = x -> x < 8;

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// multiple filters
		List<Integer> collect = list.stream().filter(greaterThan5.and(lessThan8)).collect(Collectors.toList());

		System.out.println(collect);

	}

}
