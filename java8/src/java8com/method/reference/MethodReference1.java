package java8com.method.reference;

interface Sayable {
	
	void say();
}

public class MethodReference1 {

	public static void saySomething() {
		System.out.println("Hello, this is static method.");  
	}
	
	public static void main(String[] args) {

		// reference static method
		Sayable sayable = MethodReference1::saySomething;
		
		sayable.say();
	}

}
