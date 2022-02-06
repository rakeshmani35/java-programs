package com.java.visual.vm;

import java.util.ArrayList;
import java.util.List;

public class JVisualVMDemo {

	public static void main(String[] args) {
		System.out.println("Application Started ..........");
		
		List<User> list = new ArrayList<User>();
		
		for (int i = 1; i <= 10000; i++) {
			list.add(new User());
		}
		System.out.println("Application Ended ..........");
	}

}
