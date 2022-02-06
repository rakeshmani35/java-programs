package com.memoryLeak;

/**
 * https://www.geeksforgeeks.org/garbage-collection-java/
 * 
 * write a program, to count the number of Employees working in the
 * company(excluding interns).To make this program, you have to use the concept
 * of a garbage collector.
 * 
 * @author rakes
 *
 */

class Employee {
	private int ID;
	private String name;
	private int age;
	private static int nextId = 1;

	// it is made static because it is keep common among all and shared by all
	// objects
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
		this.ID = nextId++;
	}

	public void show() {
		System.out.println("Id=" + ID + ", Name=" + name + ", Age=" + age);
	}

	public void showNextId() {
		System.out.println("Next employee id will be=" + nextId);
	}
}

public class UseEmployeeWithoutGC {

	public static void main(String[] args) {

		Employee E = new Employee("GFG1", 56);
		Employee F = new Employee("GFG2", 45);
		Employee G = new Employee("GFG3", 25);
		E.show();
		F.show();
		G.show();
		E.showNextId();
		F.showNextId();
		G.showNextId();

		{
			// It is sub block to keep all those interns.
			Employee X = new Employee("GFG4", 23);
			Employee Y = new Employee("GFG5", 21);
			X.show();
			Y.show();
			X.showNextId();
			Y.showNextId();
		}

		// After countering this brace, X and Y will be removed.Therefore, now it should
		// show nextId as 4.
		E.showNextId();// Output of this line
		// should be 4 but it will give 6 as output.
	}

}
