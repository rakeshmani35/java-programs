package com.override;

class Over {
	
	public void m1(String str) {
		System.out.println("String");
	}
	
	public void m1(Object obj) {
		System.out.println("Object");
	}
}

public class ObjectAndStringTest {

	public static void main(String[] args) {
		
		Over v = new Over();
		
		v.m1("rakesh"); // String
		
		v.m1(new Object()); // Object
		
		Object obj = new String(""); // Object
		v.m1(obj);
		
		Object obj1 = new String("rakesh"); // Object
		v.m1(obj1);
		
		String str = new String("rakesh"); // String
		v.m1(str);
		
		String str1 = new String(""); // String
		v.m1(str1);



	}

}
