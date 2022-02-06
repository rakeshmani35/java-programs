package com.parellal.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	private BigDecimal salary;

	public Employee() {
	}

	public Employee(String name, int age, BigDecimal salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}

public class ParallelStreamCaseStudy {

	private static final String DIR = System.getProperty("user.dir") + "/test/";

	
	private String generateRandomName(int length) {
		String name = new Random().ints(length, 97, 122)
				                  .mapToObj(x -> String.valueOf((char)x))
				                  .collect(Collectors.joining());
		
		return name;
	}
	
	private int generateRandomAge(int min, int max) {
		int age = new Random().ints(1, min, max)
				                  .findFirst()
				                  .getAsInt();
		
		return age;
	}
	
	private BigDecimal generateRandomSalary(double min, double max) {
		 double asDouble = new Random().doubles(1, min, max)
				                  .findFirst()
				                  .getAsDouble();
		 BigDecimal salary = new BigDecimal(asDouble).setScale(2, RoundingMode.HALF_UP);
		
		return salary;
	}
	
	private List<Employee> generateEmployee(int n){
		
		List<Employee> collect = Stream.iterate(0, x -> x+1)
		      .limit(n)
		      .map(m -> {
		                return new Employee(
		    		                        generateRandomName(4), 
		    		                        generateRandomAge(15,100), 
		    		                        generateRandomSalary(900.00, 200000.00));
		      
		      }).collect(Collectors.toList());
		
		return collect;
	}

	
	private static void save(Employee emp) {

        try (FileOutputStream fos = new FileOutputStream(new File(DIR + emp.getName() + ".txt"));
             ObjectOutputStream obs = new ObjectOutputStream(fos)) {
        	
            obs.writeObject(emp);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	public static void main(String[] args) throws IOException {

		Files.createDirectories(Paths.get(DIR));

		ParallelStreamCaseStudy obj = new ParallelStreamCaseStudy();
		
		 List<Employee> employees = obj.generateEmployee(10000);
		 
		 employees.parallelStream().forEach(ParallelStreamCaseStudy::save);
		 
		 System.out.println("saved....");

	}

}
