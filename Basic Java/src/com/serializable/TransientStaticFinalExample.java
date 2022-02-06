package com.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// http://learnfromexamples.com/transient-variable-vs-static-variable-in-java/
/**
 * Rules for Transient Variable vs Static Variable
 * 
 * 1. Transient variable will be ignored during serialization.
 * 
 * 2. Static variable won’t even participate in Serialization . 3. Static
 * variable will be serialized if the value is initialized during declaration
 * itself.
 * 
 * 4. If a variable contains both transient and static keyword, also if the
 * value is initialized during declaration, then it will be serialized. Because
 * here transient modifier will be ignored and static modifier will take over
 * the actions.
 * 
 * 5. Final variable will be serialized.
 * 
 * 6. If a variable contains both final and transient keyword, then it will be
 * serialized. Because here transient modifier will be ignored and final
 * modifier will take over the action
 * 
 * @author rakes
 *
 */
class TransientStaticFinalVariable implements Serializable {

	
	private static final long serialVersionUID = -3376139108809801305L;
	
	public TransientStaticFinalVariable() {
		System.out.println("Constructorr Called...");
	}

	public transient String v1;
	public transient String v2 = "V2";
	public static String v3;
	public static String v4 = "V4";
	public transient static String v5;
	public transient static String v6 = "V6";
	final String v7 = "V7";
	transient final String v8 = "V8";
}

public class TransientStaticFinalExample {

	public static void serialize() throws IOException {

		System.out.println("serialization start");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			// fos = new FileOutputStream("D:\\workspace\\serialization file\\file1.txt");
			fos = new FileOutputStream("transientStaticFinal.ser");
			oos = new ObjectOutputStream(fos);

			TransientStaticFinalVariable v = new TransientStaticFinalVariable();
			v.v1 = "V11";
			v.v2 = "V22";
			v.v3 = "V33";
			v.v4 = "V44";
			v.v5 = "V55";
			v.v6 = "V66";
			// v.v7 = "V77"; // CompileTime: The final field TransientStaticVariable.v7 cannot be assigned
			// v.v8 = "V88"; // CompileTime: The final field TransientStaticVariable.v7 cannot be assigned

			oos.writeObject(v);

		} finally {
			fos.close();
			oos.close();

		}
		System.out.println("serialization completed");
	}

	public static void deserialize() throws IOException, ClassNotFoundException {

		System.out.println("Deserialization start");

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			// fis = new FileInputStream("D:\\workspace\\serialization file\\file1.txt");
			fis = new FileInputStream("transientStaticFinal.ser");
			ois = new ObjectInputStream(fis);

			TransientStaticFinalVariable v = (TransientStaticFinalVariable) ois.readObject();
			System.out.println("After Deserialization...");
			System.out.println(v.v1); // null : transient, default value, not participate in serialization
			System.out.println(v.v2); // null : transient, default value, not participate in serialization
			System.out.println(v.v3); // V33 : static, updated value,  participate in serialization 
			System.out.println(v.v4); // V44 : static, updated value,  participate in serialization 
			System.out.println(v.v5); // V55 : transient-static, default value,  participate in serialization
			System.out.println(v.v6); // V66 : transient-static, default value,  participate in serialization
			System.out.println(v.v7); // v7 : final, fixed value,  participate in serialization
			System.out.println(v.v8); // v8 : transient-final, fixed value,  participate in serialization
		} finally {
			fis.close();
			ois.close();
		}

		System.out.println("Deserialization completed");
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		serialize();
		
		deserialize();
	}

}
