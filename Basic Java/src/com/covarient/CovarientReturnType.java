package com.covarient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class A {
	A get() {
		return this;
	}
	public Object getObject() {
		return new Object();
	}
}

class B extends A {
	
	@Override
	B get() {
		return this;
	}

	@Override
	public String getObject() {
		// TODO Auto-generated method stub
		return "Rakesh";
	}
	
	void message() {
		System.out.println("welcome to covariant return type");
	}
}

public class CovarientReturnType {

	public static void main(String[] args) {

		//B b = new B();
		//b.get().message();
		
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		
		//System.out.println(set.ge);
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		list.indexOf("a");
		System.out.println(list.indexOf("a"));
	}

}
