package com.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListOptionalTest {

	static class Employee {
		int id;
		String name;

		public Employee() {
		}

		public Employee(int id, String name) {
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

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + "]";
		}

	}

	public static void main(String[] args) {

		Employee e1 = new Employee(100, "A");
		Employee e2 = new Employee(101, "B");
		Employee e3 = new Employee(102, "C");
		Employee e4 = new Employee(103, "D");
		Employee e5 = new Employee(104, "E");

		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);

		Optional<Employee> findAny = list.stream().filter(e -> e.getId() == 101).findAny();
		if (findAny.isPresent()) {
			Employee employee = findAny.get();
			System.out.println(employee);
		}
		List<Employee> collect = new ArrayList<>();
		Optional<List<Employee>> listOptional = Optional.of(list);
		listOptional.ifPresent(p -> {
			List<Employee> collect1 = p.stream().filter(e -> e.getId() == 103).collect(Collectors.toList());
			collect.addAll(collect1);
		});
		System.out.println("collect = " + collect);

		List<String> mapCollect = new ArrayList<>();
		Optional<List<Employee>> mapOptional = Optional.of(list);
		mapOptional.ifPresent(p -> {
			List<String> collect1 = p.stream().filter(e -> e.getId() == 102).map(m -> m.getName()).collect(Collectors.toList());
			mapCollect.addAll(collect1);
		});
		System.out.println("map of stream = "+mapCollect);
	}

}
