package com.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// https://www.javatpoint.com/serialization-in-java#serializationinheritance

class Address {
	String addressLine, city, state;

	public Address(String addressLine, String city, String state) {
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}

class Student1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3996406391317631L;
	int id;
	String name;
	Address address;// HAS-A

	public Student1(int id, String name,Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}

public class SerializationWithInHasA {

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
			fos = new FileOutputStream("student1.ser");
			oos = new ObjectOutputStream(fos);

			Address a = new Address("l2", "city", "state");
			Student1 s1 = new Student1(111, "AAAA",a);
			Student1 s2 = new Student1(222, "BBB",a);

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
			fis = new FileInputStream("student1.ser");
			ois = new ObjectInputStream(fis);

			Student1 s1 = (Student1) ois.readObject();
			System.out.println(s1.getId());
			System.out.println(s1.getName());
			System.out.println(s1.getAddress().getCity());
		} finally {
			fis.close();
			ois.close();
		}

		System.out.println("Deserialization completed");
	}
}
