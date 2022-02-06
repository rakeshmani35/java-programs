package com.enm;

enum Size {
	SMALL {

		// overriding toString() for SMALL
		public String toString() {
			return "The size is small.";
		}
	},

	MEDIUM {

		// overriding toString() for MEDIUM
		public String toString() {
			return "The size is medium.";
		}
	},

	LARGE {
		public int largeSize() {
			return 2;
		}
	};

	public int largeSize() {
		// TODO Auto-generated method stub
		return 667;
	}
}

public class EnumConstantDerivation {

	public static void main(String[] args) {
		System.out.println(Size.MEDIUM.toString());
		
		System.out.println(Size.LARGE.largeSize());

	}

}
