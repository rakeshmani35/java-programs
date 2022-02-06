package memory.load;

public class LoadTest {

	static String str1 = "static variable";

	String str2 = "instance variable";

	static {
		System.out.println("static block");
	}
	{
		System.out.println("instance block");
	}

	public LoadTest() {
		System.out.println("constructor");
	}

	public static void m1() {
		System.out.println("static method");
	}

	public void m2() {
		System.out.println("instance method");
	}

	public static void main(String[] args) {
        new LoadTest();
	}

}
