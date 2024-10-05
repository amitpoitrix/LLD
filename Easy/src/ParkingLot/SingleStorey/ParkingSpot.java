package ParkingLot.SingleStorey;

import ParkingLot.SingleStorey.vehicle.Vehicle;
import ParkingLot.SingleStorey.vehicle.VehicleType;

public class ParkingSpot {
    private VehicleType type;
    private Vehicle parkedVehicle;

    public ParkingSpot(VehicleType type) {
        this.type = type;
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

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public VehicleType getType() {
        return type;
    }
}
