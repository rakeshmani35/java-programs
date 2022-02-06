package com.stream;

import java.util.stream.Stream;

public class StreamHashCodeTest {

	public static void main(String[] args) {
		
		Stream stream1 = Stream.of("A","B","C","D");
		
		Stream stream2 = stream1.map(m -> m.equals("C"));
		
		System.out.println("Hashcode of....");
		System.out.println("stream1 : "+stream1); // java.util.stream.ReferencePipeline$Head@23fc625e
		System.out.println("stream2 : "+stream2); // java.util.stream.ReferencePipeline$3@3f99bd52
	}

}
