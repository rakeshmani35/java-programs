package com.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class RefelectionSingletom {

	private static  RefelectionSingletom instance = new RefelectionSingletom();

	private RefelectionSingletom() {
		// this is protect to create ne instance
		if (instance != null) {
			throw new IllegalStateException("Instance already created");
		}
		System.out.println("Single instance being created");
	}

	public static RefelectionSingletom getInstance() {

		return instance;
	}
}

public class SingletonProtectFromReflection_ByThrowException {

	public static void main(String[] args) {

		RefelectionSingletom instanceOne = RefelectionSingletom.getInstance();
		RefelectionSingletom instanceTwo = RefelectionSingletom.getInstance();

		try {
			Constructor<?>[] constructores = RefelectionSingletom.class.getDeclaredConstructors();
			for (Constructor constructor : constructores) {

				constructor.setAccessible(true);
				instanceTwo = (RefelectionSingletom) constructor.newInstance();
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
