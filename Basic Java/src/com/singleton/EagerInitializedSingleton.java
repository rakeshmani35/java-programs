package com.singleton;

public class EagerInitializedSingleton {

	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// private constructor to avoid client applications to use constructor
	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}

	public static void main(String[] args) {

		System.out.println("hach-code = " + EagerInitializedSingleton.getInstance().hashCode());
		System.out.println("hach-code = " + EagerInitializedSingleton.getInstance().hashCode());
	}

}
