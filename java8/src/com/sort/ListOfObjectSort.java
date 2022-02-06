package com.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// https://mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/
public class ListOfObjectSort {

	static class User {

		private String name;
		private int age;

		public User(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
		}
	}

	public static void main(String[] args) {

		 List<User> users = Arrays.asList(
	            new User("C", 30),
	            new User("D", 40),
	            new User("A", 60),
	            new User("B", 20),
	            new User("E", 50));
		 
		// -------------- Sort List in Natural Order -----------------
		 
		 List<User> sortedList = users.stream().sorted(Comparator.comparingInt(User::getAge))
				 							   .collect(Collectors.toList());
		 
		 System.out.println("Sorted List of objects - natural order : ");
		 sortedList.forEach(p -> System.out.print(p+" "));
		 
			// -------------- Sort List in Reverse Order --------------------
		 
		 List<User> sortedList2 = users.stream().sorted(Comparator.comparingInt(User::getAge).reversed())
		               .collect(Collectors.toList());
		 System.out.println("\n\nSorted List of objects - reverse order : ");
		 sortedList2.forEach(p -> System.out.print(p+" "));
	}

}
