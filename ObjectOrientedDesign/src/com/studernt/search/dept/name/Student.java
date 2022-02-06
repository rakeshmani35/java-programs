package com.studernt.search.dept.name;

public class Student {

	String name;
	Marks marks;
	String dept;

	public Student() {
	}

	public Student(String name, Marks marks, String dept) {
		super();
		this.name = name;
		this.marks = marks;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Marks getMarks() {
		return marks;
	}

	public void setMarks(Marks marks) {
		this.marks = marks;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + ", dept=" + dept + "]";
	}

}
