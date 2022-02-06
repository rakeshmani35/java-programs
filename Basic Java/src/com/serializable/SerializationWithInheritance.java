package com.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// https://www.javatpoint.com/serialization-in-java#serializationinheritance
class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4304758717413354412L;
	int id;
	String name;

	Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Student extends Person {
	String course;
	int fee;

	public Student(int id, String name, String course, int fee) {
		super(id, name);
		this.course = course;
		this.fee = fee;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

}

public class SerializationWithInheritance {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		serialize();
		deserialize();

	}

	public static void serialize() throws IOException {

		System.out.println("serialization start");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			// fos = new FileOutputStream("D:\\workspace\\serialization file\\file1.txt");
			fos = new FileOutputStream("student.ser");
			oos = new ObjectOutputStream(fos);

			Student s1 = new Student(101, "A", "Java", 100);
			Student s2 = new Student(102, "B", "C++", 200);

			oos.writeObject(s1);
			oos.writeObject(s2);

		} finally {
			fos.close();
			oos.close();

		}
		System.out.println("serialization completed");
	}

	public static void deserialize() throws IOException, ClassNotFoundException {

		System.out.println("Deserialization start");

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			// fis = new FileInputStream("D:\\workspace\\serialization file\\file1.txt");
			fis = new FileInputStream("student.ser");
			ois = new ObjectInputStream(fis);

			Student s1 = (Student) ois.readObject();
			System.out.println(s1.getId());
			System.out.println(s1.getName());
			System.out.println(s1.getCourse());
			System.out.println(s1.getFee());
		} finally {
			fis.close();
			ois.close();
		}

		System.out.println("Deserialization completed");
	}
}
