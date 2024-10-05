package ParkingLot.MultiStorey;

import ParkingLot.MultiStorey.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

// ParkingFloor manages parking spots for each vehicle type on a specific floor.
public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot> carSpots;
    private List<ParkingSpot> bikeSpots;
    private List<ParkingSpot> truckSpots;

    public ParkingFloor(int floorNumber, int carCapacity, int bikeCapacity, int truckCapacity) {
        this.floorNumber = floorNumber;
        this.carSpots = new ArrayList<>();
        this.bikeSpots = new ArrayList<>();
        this.truckSpots = new ArrayList<>();

        for (int i = 0; i < carCapacity; i++) {
            carSpots.add(new ParkingSpot(VehicleType.CAR, floorNumber, i + 1));
        }

        for (int i = 0; i < bikeCapacity; i++) {
            bikeSpots.add(new ParkingSpot(VehicleType.BIKE, floorNumber, i + 1));
        }

        for (int i = 0; i < truckCapacity; i++) {
            truckSpots.add(new ParkingSpot(VehicleType.TRUCK, floorNumber, i + 1));
        }
    }

    public ParkingSpot getFreeSpot(VehicleType type) {
        // first it'll fetch all the spotList corresponding to given vehicle type at a particular floor
        // And if parking spot is available than just return it
        List<ParkingSpot> parkingSpotList = getParkingLotList(type);

        for(ParkingSpot parkingSpot: parkingSpotList) {
            if(parkingSpot.isAvailable())
                return parkingSpot;
        }

        // As no parking spot available
        return null;
    }

    private List<ParkingSpot> getParkingLotList(VehicleType type) {
        return switch (type) {
            case CAR -> carSpots;
            case BIKE -> bikeSpots;
            case TRUCK -> truckSpots;
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        };
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
