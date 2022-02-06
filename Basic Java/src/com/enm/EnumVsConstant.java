package com.enm;



enum ThreadStates {
	START, RUNNING, WAITING, DEAD;
	
	
}

class ThreadStatesConstant {
	public static final int START = 1;
	public static final int WAITING = 2;
	public static final int RUNNING = 3;
	public static final int DEAD = 4;
	
	public ThreadStatesConstant() {
		// TODO Auto-generated constructor stub
	}
}

public class EnumVsConstant {

	private static void benefitsOfEnumOverConstants() {
		// Enum values are fixed
		simpleEnumExample(ThreadStates.START);
		simpleEnumExample(ThreadStates.WAITING);
		simpleEnumExample(ThreadStates.RUNNING);
		simpleEnumExample(ThreadStates.DEAD);
		simpleEnumExample(null);

		simpleConstantsExample(1);
		simpleConstantsExample(2);
		simpleConstantsExample(3);
		simpleConstantsExample(4);
		// we can pass any int constant
		simpleConstantsExample(5);
		
	}

	private static void simpleEnumExample(ThreadStates th) {
		if (th == ThreadStates.START)
			System.out.println("Thread started...CONSTANT");
		else if (th == ThreadStates.WAITING)
			System.out.println("Thread is waiting...CONSTANT");
		else if (th == ThreadStates.RUNNING)
			System.out.println("Thread is running...CONSTANT");
		else
			System.out.println("Thread is dead...CONSTANT");
	}

	private static void simpleConstantsExample(int i) {
		if (i == ThreadStatesConstant.START)
			System.out.println("Thread started...ENUM");
		else if (i == ThreadStatesConstant.WAITING)
			System.out.println("Thread is waiting...ENUM");
		else if (i == ThreadStatesConstant.RUNNING)
			System.out.println("Thread is running...ENUM");
		else
			System.out.println("Thread is dead...ENUM");
	}

	public static void main(String[] args) {
		
		benefitsOfEnumOverConstants();

	}

}
