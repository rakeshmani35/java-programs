package com.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

// https://www.youtube.com/watch?v=XRHtOqGSH-Y

/**
 * if not specify serrialVersionUID, then JVM create separate serial version id
 * during serialization and de-serialization. And then exception occur.
 * 
 * Exception in thread "main" java.io.InvalidClassException:
 * com.serializable.Employee; local class incompatible: stream classdesc
 * serialVersionUID = -7647612041738061766, local class serialVersionUID =
 * -7873729497091271454
 * 
 * @author rakes
 *
 */
class Employee implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 7873344226234937630L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 7873344226234937630L;
	private static final long serialVersionUID = -7873729497091271454L;

	private int id;
	private String name;
	private String age;

	public Employee(int id, String name) {
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

	public Employee(int id, String name, String age) {
		super();
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

public class SerailVersionIdtest {

	public static void serialize() throws IOException {

		System.out.println("serialization start");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			// fos = new FileOutputStream("D:\\workspace\\serialization file\\file1.txt");
			fos = new FileOutputStream("employee.ser");
			oos = new ObjectOutputStream(fos);

			Employee e1 = new Employee(101, "A");
			Employee e2 = new Employee(102, "B");

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
			fis = new FileInputStream("employee.ser");
			ois = new ObjectInputStream(fis);
			
			Employee e1 = (Employee) ois.readObject();
			System.out.println(e1.getId());
			System.out.println(e1.getName());
		} finally {
			fis.close();
			ois.close();
		}

		System.out.println("Deserialization completed");
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// serialize();
		//deserialize();
	}

}
