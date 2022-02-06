import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Test {

	static class Student {
		String name;
		int age;
		int salary;

		public Student() {
		}

		public Student(String name, int age, int salary) {
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

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}

	}

	public static void main(String[] args) {

		List<Student> list = new ArrayList<Java8Test.Student>();

		Student s1 = new Student("rake", 29, 5000);
		Student s2 = new Student("deep", 26, 6000);
		Student s3 = new Student("such", 29, 9000);

		list.add(s1);
		list.add(s2);
		list.add(s3);
		System.out.println(list);

		Map<?, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getAge));

		System.out.println(collect);

		String str = "[Student [name=rake, age=29, salary=5000], Student [name=deep, age=26, salary=6000], Student [name=such, age=29, salary=9000]]";
		
		String[] split4 = str.split(", Student");

		if (split4[0].contains("Student ")) {
			split4[0]=split4[0].replace("Student ", "");
		}
		if (split4[0].contains("[[")) {
			split4[0]=split4[0].replace("[[", "[");
		}
		if (split4[split4.length-1].contains("]]")) {
			split4[split4.length-1]=split4[split4.length-1].replace("]]", "]");
		}
		
		String[] split = str.split("],");
		List<Map> list1 = new ArrayList<Map>();
		Map<String, String> map = new HashMap();
		for (String string : split) {
			
			if (string.contains("Student")) {
				string=string.replace("Student", "");
			}
			
			if (string.contains("[")) {
				string=string.replace("[", "");
			}
			
			if (string.contains("]]")) {
				string=string.replace("]]", "");
			}
			
			String[] split2 = string.split(",");
			for (String str2 : split2) {
				String[] split3 = str2.split("=");
				map.put(split3[0], split3[1]);
			}
			
			list1.add(map);
		}
System.out.println(list1);
	}

}
