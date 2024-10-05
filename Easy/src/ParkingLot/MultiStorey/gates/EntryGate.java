package ParkingLot.MultiStorey.gates;

import ParkingLot.MultiStorey.ParkingLot;
import ParkingLot.MultiStorey.Ticket;
import ParkingLot.MultiStorey.vehicle.Vehicle;

// Handles vehicle entry, ticket generation, and assignment of parking spots.
public class EntryGate {
    private boolean isAvailable;
    private final int gateId;
    private final ParkingLot parkingLot;

    public EntryGate(int gateId, ParkingLot parkingLot) {
        this.isAvailable = true;
        this.gateId = gateId;
        this.parkingLot = parkingLot;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getGateId() {
        return gateId;
    }

    public Ticket processEntry(Vehicle vehicle) {
        isAvailable = false;

        Ticket ticket = parkingLot.parkVehicle(vehicle);
        System.out.println("Vehicle " + vehicle.getLicensePlate() + " entered through gate: " + getGateId());

        isAvailable = true;
        return ticket;
    }
}
