package com.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerInterfaceExample2 {

	static void ShowDetails(Map<Integer, String> map, String mapName) {
		System.out.println("----------" + mapName + " records-----------");
		map.forEach((key, value) -> System.out.println(key + " = " + value));

	}

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Mohan");
		map.put(110, "Sujeet");
		map.put(115, "Tom");
		map.put(120, "Danish");

		BiConsumer<Map<Integer, String>, String> biconsumer = BiConsumerInterfaceExample2::ShowDetails;

		biconsumer.accept(map, "Student");
	}

}
