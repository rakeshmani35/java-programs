package com.parellal.stream;

import java.util.stream.IntStream;

public class IsStreamRunningInParallelMode {

	public static void main(String[] args) {
		
		 System.out.println("Normal...");
		 
		 IntStream sequencialStream1 = IntStream.rangeClosed(1, 10);
		 System.out.println(sequencialStream1.isParallel());
		 sequencialStream1.forEach(s -> System.out.print(s+" "));
		 
		 System.out.println();
		 System.out.println("Parallel...");
		 IntStream sequencialStream2 = IntStream.rangeClosed(1, 10);
		 IntStream parallel = sequencialStream2.parallel();
		 System.out.println(parallel.isParallel());
		 parallel.forEach(s -> System.out.print(s+" "));
	}

}
