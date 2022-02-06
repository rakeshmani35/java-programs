package com.string;

public class Replace {

	public static void main(String[] args) {

		String s1="javatpoint is a very good website";  
		System.out.println("s1.hashcode = "+s1.hashCode());
		
		//String replaceString=s1.replace('a','e');//replaces all occurrences of 'a' to 'e' 
		//String replaceString=s1.replace("very","much");//replaces all occurrences of 'a' to 'e'
		String replaceString=s1.replace("\\s","");//replaces all occurrences of 'a' to 'e'
		
		System.out.println("replaceString = "+replaceString);
		System.out.println("s1 = "+s1);
		
		System.out.println("replaceString.hashcode = "+replaceString.hashCode());
		System.out.println("s1.hashcode = "+s1.hashCode());
	}

}
