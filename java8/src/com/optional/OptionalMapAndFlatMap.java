package com.optional;

import java.util.Optional;

public class OptionalMapAndFlatMap {

	public static void main(String[] args) {

		Optional<String> nonEmptyGender = Optional.of("male");
		Optional<String> emptyGender = Optional.empty();
		
		
		System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase)); // method reference
		System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(S -> S.toUpperCase()));
		
		System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));
		
		Optional<String> of = Optional.of("male");
		Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(of);
		System.out.println("Optional value   :: " + nonEmptyOtionalGender);
		System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(gender -> gender.map(String::toUpperCase)));
		
		

	}

}
