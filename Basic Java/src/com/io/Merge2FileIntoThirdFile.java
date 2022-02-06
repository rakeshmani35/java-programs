package com.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * https://www.geeksforgeeks.org/java-program-merge-two-files-alternatively-third-file-2/?ref=rp
 * 
 * Create PrintWriter object for file3.txt
 * 
 * Open BufferedReader for file1.txt
 * 
 * Open BufferedReader for file2.txt
 * 
 * Run a loop to copy each line of file1.txt and then file2.txt to file3.txt
 * 
 * Flush PrintWriter stream and close resources.
 * 
 * @author rakes
 *
 */
public class Merge2FileIntoThirdFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		PrintWriter pw = new PrintWriter("D://workspace//file3.txt");

		BufferedReader br1 = new BufferedReader(new FileReader("D://workspace//file1.txt"));

		BufferedReader br2 = new BufferedReader(new FileReader("D://workspace//file2.txt"));

		String readLine1 = br1.readLine();
		String readLine2 = br2.readLine();

		while (readLine1 != null || readLine2 != null) {

			if (readLine1 != null) {
				pw.println(readLine1);
				readLine1 = br1.readLine();
			}

			if (readLine2 != null) {
				pw.println(readLine2);
				readLine2 = br2.readLine();
			}
		}

		pw.flush();
		br1.close();
		br2.close();

		System.out.println("Merged file1.txt and file2.txt alternatively into file3.txt");
	}

}
