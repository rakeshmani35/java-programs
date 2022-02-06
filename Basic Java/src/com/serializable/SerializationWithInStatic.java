package com.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class EmployeeStatic implements Serializable {

	private static final long serialVersionUID = -7873729497091271454L;
	
	private int id;
	private static String name;
	private String age;

	public EmployeeStatic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public EmployeeStatic(int id, String name, String age) {
		this.id = id;
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}

public class SerializationWithInStatic {

	public static void serialize() throws IOException {

		System.out.println("serialization start");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			// fos = new FileOutputStream("D:\\workspace\\serialization file\\file1.txt");
			fos = new FileOutputStream("employeeStatic.ser");
			oos = new ObjectOutputStream(fos);

			EmployeeStatic e1 = new EmployeeStatic(101, "A", "33");
			EmployeeStatic e2 = new EmployeeStatic(102, "B", "44");

			oos.writeObject(e1);
			oos.writeObject(e1);
			oos.writeObject(e2);
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
			fis = new FileInputStream("employeeStatic.ser");
			ois = new ObjectInputStream(fis);

			EmployeeStatic e1 = (EmployeeStatic) ois.readObject();
			System.out.println(e1.getId());
			System.out.println(e1.getName());
			System.out.println(e1.getAge());
		} finally {
			fis.close();
			ois.close();
		}

		System.out.println("Deserialization completed");
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		serialize();
		deserialize();
	}

}
