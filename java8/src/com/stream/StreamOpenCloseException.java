package com.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * https://www.baeldung.com/java-stream-operated-upon-or-closed-exception
 * 
 * A Stream should be operated on (invoking an intermediate or terminal stream
 * operation) only once. A Stream implementation may throw IllegalStateException
 * if it detects that the Stream is being reused.
 * 
 * Whenever a terminal operation is called on a Stream object, the instance gets
 * consumed and closed.Therefore, we're only allowed to perform a single
 * operation that consumes a Stream, otherwise, we'll get an exception that
 * states that the Stream has already been operated upon or closed.
 * 
 * @author rakes
 *
 */
public class StreamOpenCloseException {

	public static void main(String[] args) {

		Stream<String> stringStream = Stream.of("W", "B", "C", "D");

		//stringStream = stringStream.distinct();
		Optional<String> result1 = stringStream.findAny();
		System.out.println(result1.get()); // A

		// Exception in thread "main" java.lang.IllegalStateException: stream has
		// already been operated upon or closed
		Optional<String> result2 = stringStream.findFirst();
		System.out.println(result2.get());

	}

}
