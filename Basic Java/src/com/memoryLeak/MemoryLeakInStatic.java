package com.memoryLeak;

import java.util.ArrayList;
import java.util.Random;

/**
 * https://stackify.com/memory-leaks-java/#:~:text=What%20is%20a%20Memory%20Leak,they're%20still%20being%20referenced.
 * 
 * @author rakes
 *
 */
public class MemoryLeakInStatic {

	public static final ArrayList<Double> list = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {

		Random random = new Random();
		
		for (int i = 0; i < 1000000; i++) {
			list.add(random.nextDouble());
		}
		
		System.gc();
		Thread.sleep(10000);
	}

}
