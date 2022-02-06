package com.singleton;

public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance = null;

	private ThreadSafeSingleton() {
	}

	public static ThreadSafeSingleton getInstance() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}

		return instance;
	}

	public static void main(String[] args) {

		System.out.println("hach-code = " + ThreadSafeSingleton.getInstance().hashCode());
		System.out.println("hach-code = " + ThreadSafeSingleton.getInstance().hashCode());
	}

}
