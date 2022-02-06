package com.type.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class Employee {

	private Integer id;
	private String name;

	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {

		return "Employee [id=" + id + ", name=" + name + "]";
	}
}

public class ReferenceType {

	public static void strongReference() {
		Employee emp = new Employee(100, "KK"); // emp is now string reference
		System.out.println("strong refernce value = " + emp);
		emp = null; // eligible for GC and removed by GC from memory
		System.out.println("strong refernce value = " + emp);
	}

	public static void weakReference() {
		Employee emp = new Employee(100, "KK"); // emp is now string reference
		WeakReference<Employee> weakRef = new WeakReference<Employee>(emp); // emp is now weak reference
		System.out.println("weak refernce value = " + weakRef.get());
		emp = null; // eligible for GC and BUT this reference is not removed by GC from memory
		System.gc(); // now removed from memory by GC
		System.out.println("weak refernce value = " + weakRef.get());
	}

	public static void softReference() {
		Employee emp = new Employee(100, "KK"); // emp is now string reference
		SoftReference<Employee> softRef = new SoftReference<Employee>(emp);
		System.out.println("soft refernce value = " + softRef.get());
		emp = null; // eligible for GC and BUT this reference is not removed by GC from memory
		System.gc(); // now also not removed from memory by GC util JVM badly need memory
		System.out.println("soft refernce value = " + softRef.get());
	}

	public static void phantomReference() {
		Employee emp = new Employee(100, "KK"); // emp is now string reference
		ReferenceQueue<Employee> refQueue = new ReferenceQueue<Employee>();
		PhantomReference< Employee> phRefe = new PhantomReference<Employee>(emp, refQueue);
		
	}

	public static void main(String[] args) {
		strongReference();
		weakReference();
		softReference();
	}

}
