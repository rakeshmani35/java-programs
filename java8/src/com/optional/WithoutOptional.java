package com.optional;

import com.optional.WithOptional.DisplayFeatures;
import com.optional.WithOptional.Mobile;
import com.optional.WithOptional.MobileService;
import com.optional.WithOptional.ScreenResolution;

public class WithoutOptional {
	static class ScreenResolution {
		private int width;
		private int height;

		public ScreenResolution(int width, int height) {
			this.width = width;
			this.height = height;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}
	}

	static class DisplayFeatures {
		private String size; // In inches
		private ScreenResolution resolution;

		public DisplayFeatures(String size, ScreenResolution resolution) {
			this.size = size;
			this.resolution = resolution;
		}

		public String getSize() {
			return size;
		}

		public ScreenResolution getResolution() {
			return resolution;
		}
	}

	static class Mobile {
		private long id;
		private String brand;
		private String name;
		private DisplayFeatures displayFeatures;

		// Likewise we can see Memory Features, Camera Features etc.

		public Mobile(long id, String brand, String name, DisplayFeatures displayFeatures) {
			this.id = id;
			this.brand = brand;
			this.name = name;
			this.displayFeatures = displayFeatures;
		}

		public long getId() {
			return id;
		}

		public String getBrand() {
			return brand;
		}

		public String getName() {
			return name;
		}

		public DisplayFeatures getDisplayFeatures() {
			return displayFeatures;
		}
	}

	static class MobileService {

		public int getMobileScreenWidth(Mobile mobile) {

			if (mobile != null) {
				DisplayFeatures dfeatures = mobile.getDisplayFeatures();
				if (dfeatures != null) {
					ScreenResolution resolution = dfeatures.getResolution();
					if (resolution != null) {
						return resolution.getWidth();
					}
				}
			}
			return 0;

		}

	}

	public static void main(String[] args) {
		ScreenResolution resolution = new ScreenResolution(750, 1334);
		DisplayFeatures dfeatures = new DisplayFeatures("4.7", resolution);
		Mobile mobile = new Mobile(2015001, "Apple", "Iphone 6s", dfeatures);

		MobileService mService = new MobileService();
		int mobileScreenWidth = mService.getMobileScreenWidth(mobile);
		System.out.println("Apple iPhone 6s Screen Width = " + mobileScreenWidth);

		ScreenResolution resolution2 = new ScreenResolution(0, 0);
		DisplayFeatures dfeatures2 = new DisplayFeatures("0", resolution2);
		Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 5s", dfeatures2);

		int mobileWidth2 = mService.getMobileScreenWidth(mobile2);
		System.out.println("Apple iPhone 5s Screen Width = " + mobileWidth2);

	}

}
