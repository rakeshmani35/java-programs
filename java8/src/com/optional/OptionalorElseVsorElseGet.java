package com.optional;

import java.util.Optional;

// https://www.baeldung.com/java-optional
public class OptionalorElseVsorElseGet {

	public void checkWithNullValue() {
		
		String text = null;

		System.out.print("Using orElseGet : ");
		String orElseGet = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		System.out.print(orElseGet);

		System.out.println();

		System.out.print("Using orElse : ");
		String orElse = Optional.ofNullable(text).orElse(this.getMyDefault());
		System.out.print(orElse);
	}

	
	public void checkWithValue() {
		
		String text = "Text present";
		
		System.out.print("Using orElseGet : ");
		String orElseGet = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		System.out.print(orElseGet);
		
		System.out.println();
		
		System.out.print("Using orElse : ");
		String orElse = Optional.ofNullable(text).orElse(this.getMyDefault());
		System.out.print(orElse);
		
	}
	
	public String getMyDefault() {
		System.out.println("getMyDefault() invoke");
		return "Default Value";
	}

	public static void main(String[] args) {
		OptionalorElseVsorElseGet op = new OptionalorElseVsorElseGet();

		System.out.println("check with null");
		System.out.println("-----------------");
		op.checkWithNullValue();
		
		
		System.out.println();
		System.out.println("check with value");
		System.out.println("-----------------");
		op.checkWithValue();
	}

}
