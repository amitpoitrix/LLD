package ParkingLot.SingleStorey;

import ParkingLot.SingleStorey.vehicle.Vehicle;
import ParkingLot.SingleStorey.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingSpot> carSpot;
    private List<ParkingSpot> bikeSpot;
    private List<ParkingSpot> truckSpot;
    private HashMap<String, Ticket> activeTickets;

    private ParkingLot(int carCapacity, int bikeCapacity, int truckCapacity) {
        this.carSpot = new ArrayList<>();
        this.bikeSpot = new ArrayList<>();
        this.truckSpot = new ArrayList<>();
        this.activeTickets = new HashMap<>();

        for (int i = 0; i < carCapacity; i++) {
            carSpot.add(new ParkingSpot(VehicleType.CAR));
        }

        for (int i = 0; i < bikeCapacity; i++) {
            bikeSpot.add(new ParkingSpot(VehicleType.BIKE));
        }

        for (int i = 0; i < truckCapacity; i++) {
            truckSpot.add(new ParkingSpot(VehicleType.TRUCK));
        }
    }

    public static synchronized ParkingLot getInstance(int carCapacity, int bikeCapacity, int truckCapacity) {
        if(instance == null) {
            instance = new ParkingLot(carCapacity, bikeCapacity, truckCapacity);
        }

        return instance;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = getAvailableParkingSpot(vehicle.getType());

        if(parkingSpot != null) {
            parkingSpot.assignVehicle(vehicle);
            Ticket ticket = new Ticket(vehicle, parkingSpot);
            activeTickets.put(vehicle.getLicensePlate(), ticket);
            return ticket;
        }

        System.out.println("No vehicle spot found for vehicle type: " + vehicle.getType());
        return null;
    }

    private ParkingSpot getAvailableParkingSpot(VehicleType type) {
        List<ParkingSpot> parkingSpotList = getParkingLotList(type);

        for(ParkingSpot parkingSpot: parkingSpotList) {
            if(parkingSpot.isAvailable())
                return parkingSpot;
        }

        // As no parking spot available
        return null;
    }

    private List<ParkingSpot> getParkingLotList(VehicleType type) {
        switch (type) {
            case CAR:
                return carSpot;
            case BIKE:
                return bikeSpot;
            case TRUCK:
                return truckSpot;
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }

    public double removeVehicle(String licensePlate) {
        Ticket ticket = activeTickets.get(licensePlate);
        if(ticket != null) {
            ParkingSpot parkingSpot = ticket.getSpot();
            parkingSpot.removeVehicle();
            
            long currentTime = System.currentTimeMillis();
            long duration = currentTime - ticket.getEntryTime();
            
            return calculateFee(duration, ticket.getVehicle().getType());
        }

        System.out.println("No ticket is available with given license plate: " + licensePlate);
        return 0.0;
    }

    private double calculateFee(long duration, VehicleType type) {
        return switch (type) {
            case CAR, TRUCK -> duration * 15;
            case BIKE -> duration * 5;
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        };
    }
}
