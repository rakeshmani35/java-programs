package polymerphism.test;

interface A {
	public static final String str = "abc";

	public abstract void m1();
}

class Hello implements A {

	@Override
	public void m1() {
		System.out.println("m1() - implemented method in Hello class");

	}

	public void m2() {
		System.out.println("m2() - not implemented method in Hello class");
	}

}

public class InterfacePolymerphismTest {

	public static void main(String[] args) {

		A a = new Hello();

		a.m1();
		// a.m2(); compilation problem

	}

}
