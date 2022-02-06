package com.exceptionTest;

public class ClassNotFoundExceptionTest {

	public static void main(String[] args) {
		
		
		try {
			//Class.forName("GeeksForGeeks");
			ClassLoader.getSystemClassLoader().loadClass("GeeksForGeeks");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

	}

}
