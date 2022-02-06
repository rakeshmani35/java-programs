package com.singleton;

public class StaticBlockSingleton {

	private static final StaticBlockSingleton instance;

	private StaticBlockSingleton() {
	}

	static {
		instance = new StaticBlockSingleton();
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}

	public static void main(String[] args) {

		System.out.println("hach-code = " + StaticBlockSingleton.getInstance().hashCode());
		System.out.println("hach-code = " + StaticBlockSingleton.getInstance().hashCode());
	}

}
