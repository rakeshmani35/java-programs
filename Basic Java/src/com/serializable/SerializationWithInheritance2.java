package com.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// https://www.journaldev.com/2452/serialization-in-java#Serialization-Inheritance
class SuperClass {

	private int id;
	private String value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

class SubClass extends SuperClass implements Serializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SubClass{id=" + getId() + ",value=" + getValue() + ",name=" + getName() + "}";
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();

		// notice the order of read and write should be same
		setId(ois.readInt());
		setValue((String) ois.readObject());
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();

		oos.writeInt(getId());
		oos.writeObject(getValue());
	}
}

public class SerializationWithInheritance2 {

	public static void main(String[] args) {
		
String fileName = "subclass.ser";
		
		SubClass subClass = new SubClass();
		subClass.setId(10);
		subClass.setValue("Data");
		subClass.setName("Pankaj");
		
		try {
			//SerializationUtil.serialize(subClass, fileName);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

}
