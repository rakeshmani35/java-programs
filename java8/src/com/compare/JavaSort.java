package com.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee {
	int eid;
	String fname;
	String lname;

	public Employee() {
	}

	public Employee(int eid, String fname, String lname) {
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", fname=" + fname + ", lname=" + lname + "]";
	}

}

public class JavaSort {

	private static ArrayList<Employee> getUnsortedEmployeeList() {
		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee(2, "Lokesh", "Gupta"));
		list.add(new Employee(1, "Alex", "Gussin"));
		list.add(new Employee(4, "Brian", "Sux"));
		list.add(new Employee(5, "Neon", "Piper"));
		list.add(new Employee(3, "David", "Beckham"));
		list.add(new Employee(7, "Alex", "Beckham"));
		list.add(new Employee(6, "Brian", "Suxena"));
		return list;
	}

	public static void main(String[] args) {

		ArrayList<Employee> employees = getUnsortedEmployeeList();

		// first name comparator
		Comparator<Employee> compareByFirstName = Comparator.comparing(Employee::getFname);

		// last name comparator
		Comparator<Employee> compareByLastName = Comparator.comparing(Employee::getLname);

		// Compare by first name and then last name (multiple fields)
		Comparator<Employee> compareByFullName = compareByFirstName.thenComparing(compareByLastName);

		// Use Comparator
		Collections.sort(employees, compareByFullName);

		// OR
		//Collections.sort(employees, Comparator.comparing(Employee::getFname)
		//		                              .thenComparing(compareByLastName));

		System.out.println(employees);
	}

}
