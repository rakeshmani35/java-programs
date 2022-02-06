package Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

	public static void main(String[] args) {
		
		Predicate<String> lengthIs3 = x -> x.length() == 3;
		Predicate<String> startWithA = x -> x.startsWith("A");
		
		
		 List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
		 
		 List<String> collect = list.stream().filter(startWithA::test).collect(Collectors.toList());
		 System.out.println(collect);
		 // wrong
		 //list.stream().filter(startWithA::test && lengthIs3::test).collect(Collectors.toList());
		 List<String> collect2 = list.stream().filter(p -> startWithA.test(p) && lengthIs3.test(p)).collect(Collectors.toList());

		 System.out.println(collect2);
	}

}
