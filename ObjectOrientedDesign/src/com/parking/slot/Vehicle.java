package com.parking.slot;

import java.util.ArrayList;

/**
 * we have created an abstract class Vehicle, from which Car, Bus, and
 * Motorcycle inherit. To handle the different parking spot sizes.
 * 
 * @author rakes
 *
 */
public abstract class Vehicle {

	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize vehicleSize;

	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	public VehicleSize getVehicleSize() {
		return vehicleSize;
	}

	/*
	 * Park vehicle in this spot (among others, potentially)
	 */
	public void parkinSpot(ParkingSpot s) {
		parkingSpots.add(s);
	}

	/*
	 * Remove vehicle from spot, and notify spot that it's gone
	 */
	public void clearSpots() {

	}

	/*
	 * Checks if the spot is big enough for the vehicle (and is available). This *
	 * compares the SIZE only.It does not check if it has enough spots.
	 */
	public abstract boolean canFitinSpot(ParkingSpot spot);
}
