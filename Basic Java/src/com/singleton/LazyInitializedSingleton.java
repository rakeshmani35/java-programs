package com.singleton;

public class LazyInitializedSingleton {

	private static LazyInitializedSingleton instance = null;

	private LazyInitializedSingleton() {
	}

	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}

	public static void main(String[] args) {

		System.out.println("hach-code = " + LazyInitializedSingleton.getInstance().hashCode());
		System.out.println("hach-code = " + LazyInitializedSingleton.getInstance().hashCode());
	}

}
