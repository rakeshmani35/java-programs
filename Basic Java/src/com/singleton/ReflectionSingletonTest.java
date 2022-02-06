package com.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingletonTest {

	private static EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
	private static EagerInitializedSingleton instanceTwo = EagerInitializedSingleton.getInstance();
	
	public static void main(String[] args) {
		

		try {
			Constructor<?>[] constructores = EagerInitializedSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructores) {

				constructor.setAccessible(true);
				instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
				break;

			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("hach-code = " + instanceOne.hashCode());
		System.out.println("hach-code = " + instanceTwo.hashCode());
	}

}
