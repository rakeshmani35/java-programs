package com.optional;

import java.util.Optional;

public class OptionalOrElse {

	public static void main(String[] args) {

		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();

		System.out.println(gender.orElse("Gender not available")); // MALE
		System.out.println(emptyGender.orElse("Gender not available")); // MALE

		System.out.println(gender.orElseGet(() -> "Gender not available")); // MALE
		System.out.println(emptyGender.orElseGet(() -> "Gender not available")); // <N/A>
	}

}
