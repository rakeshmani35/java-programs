package com.trywith.resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Before Java 7, we have to close the BufferedReader manually.
// https://www.baeldung.com/java-try-with-resources
public class TryCatchNormal {

	public static void main(String[] args) {

		BufferedReader br = null;
		String line;

		try {

			br = new BufferedReader(new FileReader("D:\\workspace\\java\\testing.txt"));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
