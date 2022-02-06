package com.optional;

import java.util.Optional;

public class OptionalIsPresentAndIfPresent {

	public static void main(String[] args) {

		Optional<String> gender = Optional.of("MALE");
		Optional<Object> emptyGender = Optional.empty();

		if (gender.isPresent()) {
			System.out.println("Value available.");
		} else {
			System.out.println("Value not available.");
		}
		gender.ifPresent(p -> System.out.println("In gender Option, value available."));
		//condition failed, no output print
        emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));

	}

}
