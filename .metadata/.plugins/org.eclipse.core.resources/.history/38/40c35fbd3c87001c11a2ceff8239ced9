package com.anonumous.vs.lambda;

public class LambdaVsAnonymous {

	public static void main(String[] args) {
 
		int count = 10;
		  
		// Anonymous class
		Runnable run = new Runnable() {
			@Override
			public void run() {
				//int count = 0; // anonymous has own scope,  can declare duplicate variable in local
				System.out.println("anonymous testing count = "+count);
               //count++; // count turn as a final in anonymous class, so we can not chnage
				System.out.println("anonymous this keyword = "+this.getClass().getName());
			}
		};
		new Thread(run).start();

		// Lamdba Expression
       Runnable lamdba = () -> {
    	// lambda doen not has own scope. it will part of main class, so we can not create duplicate variable in local
    	   //int count = 0; 
    	   System.out.println("lamdba testing count = "+count);
    	 //count++; // count turn as a final in lamdba class, so we can not chnage
    	   
    	// Cannot use this in a static context, compilation error
    	  // System.out.println("lamdba this keyword = "+this.getClass().getName()); 
    	   
       };
       
       new Thread(lamdba).start();
	}

}
