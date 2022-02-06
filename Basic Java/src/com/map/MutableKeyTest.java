package com.map;

import java.util.HashMap;
import java.util.Map;

class MutableKey {
	String name;
	int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MutableKey other = (MutableKey) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MutableKey [name=" + name + ", id=" + id + "]";
	}

}

public class MutableKeyTest {

	public static void main(String[] args) {

		MutableKey key = new MutableKey();
		key.setId(101);
		key.setName("abc");

		Map<MutableKey, String> hm = new HashMap<>();
		hm.put(key, "ram");

		System.out.println(hm);
		System.out.println("before change key = " + hm.get(key));

		key.setId(109);
		System.out.println("After change key = " + hm.get(key));
		System.out.println(hm);

	}

}
