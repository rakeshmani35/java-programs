package com.parking.slot;

public class Bus extends Vehicle {

	public Bus() {
		spotsNeeded = 5;
		vehicleSize = VehicleSize.Large;
	}

	/*
	 * Checks if the spot is a Large. Doesn't check num of spots
	 */
	@Override
	public boolean canFitinSpot(ParkingSpot spot) {
		// TODO Auto-generated method stub
		return false;
	}
}
