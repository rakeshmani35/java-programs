package com.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonProtectFromReflection_ByEnum {

	enum SingletonEnum{
		INSTANCE
	}
	
	public static void main(String[] args) {
		
		
		SingletonEnum instanceOne = SingletonEnum.INSTANCE;
		SingletonEnum instanceTwo = SingletonEnum.INSTANCE;
		
		
		try {
			Constructor<?>[] constructores = SingletonEnum.class.getDeclaredConstructors();
			for (Constructor constructor : constructores) {

				constructor.setAccessible(true);
				instanceTwo = (SingletonEnum) constructor.newInstance();
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
