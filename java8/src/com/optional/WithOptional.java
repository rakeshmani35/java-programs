package com.optional;

import java.util.Optional;

public class WithOptional {

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
		private Optional<ScreenResolution> resolution;

		public DisplayFeatures(String size, Optional<ScreenResolution> resolution) {
			this.size = size;
			this.resolution = resolution;
		}

		public String getSize() {
			return size;
		}

		public Optional<ScreenResolution> getResolution() {
			return resolution;
		}
	}

	static class Mobile {
		private long id;
		private String brand;
		private String name;
		private Optional<DisplayFeatures> displayFeatures;

		// Likewise we can see Memory Features, Camera Features etc.

		public Mobile(long id, String brand, String name, Optional<DisplayFeatures> displayFeatures) {
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

		public Optional<DisplayFeatures> getDisplayFeatures() {
			return displayFeatures;
		}
	}

	static class MobileService {

		public int getMobileScreenWidth(Optional<Mobile> mobile) {

			int v =mobile.flatMap(m -> m.getDisplayFeatures())
			 .flatMap(dFeature -> dFeature.getResolution())
			 .map(screenResolution -> screenResolution.getWidth())
			 .orElse(0);
			
	
			return mobile.flatMap(m -> m.getDisplayFeatures())
					.flatMap(dFeature -> dFeature.getResolution())
					.map(screenResolution -> screenResolution.getWidth()).orElse(0);

		}

	}

	public static void main(String[] args) {

		ScreenResolution resolution = new ScreenResolution(750,1334);
		DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
		Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));

		MobileService mService = new MobileService();

		int width = mService.getMobileScreenWidth(Optional.of(mobile));
		System.out.println("Apple iPhone 6s Screen Width = " + width);

		Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 5s", Optional.empty());
		int width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
		System.out.println("Apple iPhone 5s Screen Width = " + width2);
	}

}
