package com.java10;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableTypeInference1 {

	public static void main(String[] args) {
		var str = "Hello world";
		  System.out.println("Java10 Local Variable Type Inference : "+str);
		//or
		  
		String str1 = "Hello world";
		System.out.println("Java8 Local Variable Type Inference : "+str1);
		
		var strInt = 10;
		System.out.println("Java10 Local Variable Type Inference : "+strInt);

		List list = new ArrayList<>();
		list.add(10);
		list.add(23.0f);
		list.add("rakesh");
		
		for (var localVar : list) {
			System.out.print(localVar+" ");
		}
		
	}

}
