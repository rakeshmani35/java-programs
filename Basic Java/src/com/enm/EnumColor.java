package com.enm;

/**
 * https://dzone.com/articles/enum-tricks-two-ways-to-extend-enum-functionality#:~:text=Java%20enum%20is%20a%20kind%20of%20a%20compiler%20magic.&text=Enum%20and%20has%20several%20static,cannot%20extend%20enum%20%2C%20as%20well.
 * 
 * Enum cannot either extend or be extended. So, how is it possible to extend
 * its functionality? The key word is "functionality." Enumcan implement
 * methods. For example, enumColor may declare abstract method draw() and each
 * member can override it:
 * 
 * @author rakes
 *
 */
enum AColor {

	RED {
		@Override
		public void draw() {
			System.out.println("red Enum value");

		}
	},
	GREEN {
		@Override
		public void draw() {
			System.out.println("green Enum value");
		}
	},
	BLUE {
		@Override
		public void draw() {
			System.out.println("blue Enum value");
		}
	};

	public abstract void draw();
}

public class EnumColor {

	public static void main(String[] args) {

		AColor[] values = AColor.values();
		for (AColor aColor : values) {
			System.out.println("aColor = "+aColor);
			System.out.println("aColor.name() = "+aColor.name());
			aColor.draw();
		}
	}

}
