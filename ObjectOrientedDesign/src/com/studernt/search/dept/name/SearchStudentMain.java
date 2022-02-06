package com.studernt.search.dept.name;

import java.util.LinkedHashMap;
import java.util.Map;

public class SearchStudentMain {

	private static Student[] getList() {
		Student[] stud = new Student[3];
		
		Marks suchMarks = new Marks(20, 25, 35);
		Student such = new Student("Such", suchMarks,"BSc");
		
		Marks rakMarks = new Marks(20, 15, 32);
		Student rak = new Student("Rak", suchMarks,"BA");
		
		Marks deepMarks = new Marks(25, 15, 36);
		Student deep = new Student("Deep", deepMarks,"BSc");
		
		stud[0] = such;
		stud[1] = rak;
		stud[2] = deep;
		
		return stud;
	}
	
	
	public static void getStudentByName(String name) {
		Student[] stud = getList();
		
		
		Map<String, Object> map =  null;
		Map<String, Integer> marks =  null;
		
		for (Student student : stud) {
			if (student.getName().contentEquals(name)) {
				
				map = new LinkedHashMap<String, Object>();
				marks = new LinkedHashMap<String, Integer>();
				
				// set name
				map.put("name", student.getName());
				
				//set marks subject wise
				int mathsMarks = student.getMarks().getMaths();
				int scienceMarks = student.getMarks().getScience();
				int englishMarks = student.getMarks().getEnglish();
				
				marks.put("Math", mathsMarks);
				marks.put("Science", scienceMarks);
				marks.put("Englist", englishMarks);
				map.put("Marks", marks);
				
				// set department
				map.put("Dept", student.getDept());
				
				// set average of marks
				int av = Math.abs((mathsMarks+scienceMarks+englishMarks)/3);
				Integer avarage = Integer.valueOf(av);
				map.put("Avarage", avarage);
				
			}
		}
		
		System.out.println(map);
	}
	
	public static void main(String[] args) {

		
		getStudentByName("Rak");
	}

}
