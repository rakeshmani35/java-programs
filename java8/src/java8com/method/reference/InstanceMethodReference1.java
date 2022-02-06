package java8com.method.reference;

interface Sayable1 {
	void say();
}

public class InstanceMethodReference1 {

	public void saySomething() {
		 System.out.println("Hello, this is non-static method."); 
	}
	
	public static void main(String[] args) {
		
		InstanceMethodReference1 instance = new InstanceMethodReference1();
		
		Sayable1 sayable1 = instance :: saySomething;
		sayable1.say();
		
		Sayable1 sayable2 = new InstanceMethodReference1() :: saySomething;
		sayable2.say();
	}

}
