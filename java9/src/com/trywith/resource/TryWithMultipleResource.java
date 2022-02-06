package com.trywith.resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// https://www.baeldung.com/java-try-with-resources
public class TryWithMultipleResource {

	public static void main(String[] args) {

		// ";" Separated
		try (Scanner scanner = new Scanner(new File("D:\\workspace\\java\\testing.txt"));
				PrintWriter writer = new PrintWriter(new File("D:\\workspace\\java\\testWrite.txt"))) {
			while (scanner.hasNext()) {
				writer.print(scanner.nextLine());
				writer.print("\n");
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

	}

}
