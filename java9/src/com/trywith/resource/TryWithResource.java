package com.trywith.resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * In Java 7,9, with try-with-resources, the BufferedReader will be closed
 * automatically after try block.
 * 
 * new try-with-resources functionality is to replace the traditional and
 * verbose try-catch-finally block.
 * 
 * https://www.baeldung.com/java-try-with-resources
 * 
 * @author rakes
 *
 */
public class TryWithResource {

	public static void main(String[] args) {
		String line;

		try (BufferedReader br = new BufferedReader(new FileReader("D:\\workspace\\java\\testing.txt"))) {

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// br will be closed automatically

	}

}
