package com.stream;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class SequentialParallelComparison {

	public static void run(Stream<String> stream) {

		stream.forEach(s -> {
			System.out.println(LocalTime.now() + " - value: " + s + " - thread: " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

	}

	public static void main(String[] args) {

		String[] arr = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		System.out.println("..........\nRunning sequencial\n..........");
		run(Arrays.stream(arr).sequential());
		
		System.out.println("..........\nRunning parallel\n..........");
		run(Arrays.stream(arr).parallel());

	}

}
