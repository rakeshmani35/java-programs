package com.java10;

import java.lang.Runtime.Version;

public class TimeBasedReleaseVersioning1 {

	public static void main(String[] args) {

		//Version version = Runtime.version().parse("10.0.1");
		Version version = Runtime.version();
		int feature = version.feature();
		int interim = version.interim();
		int update = version.update();
		int patch = version.patch();
		
		System.out.println(feature);
		System.out.println(interim);
		System.out.println(update);
		System.out.println(patch);
	}

}
