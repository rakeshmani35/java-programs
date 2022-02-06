package com.incrementtest;

public class IncreementTest {

	public static void test() {
		int x =0;
		int y = 0;
		
		for (int i = 0; i < 5; i++) {
			if (++x > 2 || ++y > 2) {
				x++;
			}
			
		}
		
		return ;
	}
	
	public static void main(String[] args) {
		test();
		
	}

}
