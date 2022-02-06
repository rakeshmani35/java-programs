package com.singleton;

public class BillPughSingleton {

	private static class BillPushHelper {
		private static final BillPughSingleton instance = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return BillPushHelper.instance;
	}
	public static void main(String[] args) {
		
		System.out.println("hach-code = " + BillPughSingleton.getInstance().hashCode());
		System.out.println("hach-code = " + BillPughSingleton.getInstance().hashCode());
	}

}
