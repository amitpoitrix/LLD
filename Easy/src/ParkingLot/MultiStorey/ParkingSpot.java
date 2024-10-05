package ParkingLot.MultiStorey;

import ParkingLot.MultiStorey.vehicle.Vehicle;
import ParkingLot.MultiStorey.vehicle.VehicleType;

// Each ParkingSpot will be associated with a specific ParkingFloor.
public class ParkingSpot {
    private VehicleType type;
    private Vehicle parkedVehicle;
    private final int spotNumber;
    private final int floorNumber;

    public ParkingSpot(VehicleType type, int floorNumber, int spotNumber) {
        this.type = type;
        this.floorNumber = floorNumber;
        this.spotNumber = spotNumber;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public void assignVehicle(Vehicle vehicle) {
        if(isAvailable() && vehicle.getType() == type) {
            parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Parking spot is unavailable or mismatch vehicleType");
        }
    }

    public void removeVehicle() {
        parkedVehicle = null;
    }

    public VehicleType getType() {
        return type;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
