package com.singleton;

public class SerializedSingleton {

	private static final SerializedSingleton instance = new SerializedSingleton();
	
	private SerializedSingleton() {
		
	}
	
	public static SerializedSingleton getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {

	}

}
