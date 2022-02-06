package com.parking.slot;

/**
 * The ParkingLot class is essentially a wrapper class for an array of Levels.
 * By implementing it this way, we are able to separate out logic that deals
 * with actually finding free spots and parking cars out from the broader
 * actions of the ParkingLot. If we didn’t do it this way, we would need to hold
 * parking spots in some sort of double array (or hash table which maps from a
 * level number to the list of spots). It's cleaner to just separate ParkingLot
 * from Level.
 * 
 * @author rakes
 *
 */
public class ParkingSpot {

	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;

	public ParkingSpot(Level lvl, int r, int n, VehicleSize s) {

	}

	public boolean isAvailable() {
		return vehicle == null;
	}

	/* Check if the spot is big enough and is available */
	public boolean canFitVehicle(Vehicle vehicle) {
		return false;

	}

	/* Park vehicle in this spot. */
	public boolean park(Vehicle v) {
		return false;

	}

	public int getRow() {
		return row;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	/*
	 * Remove vehicle from spot, and notify level that a new spot is available
	 */
	public void removeVehicle() {

	}
}
