package ParkingLot.MultiStorey.gates;

import ParkingLot.MultiStorey.ParkingLot;
import ParkingLot.MultiStorey.payment.PaymentMethod;

// Handles vehicle exit, ticket validation, and payment processing.
public class ExitGate {
    private boolean isAvailable;
    private final int gateId;
    private final ParkingLot parkingLot;

    public ExitGate(int gateId, ParkingLot parkingLot) {
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

    public void processExit(String licensePlate, PaymentMethod paymentMethod) {
        isAvailable = false;

        parkingLot.removeVehicle(licensePlate, paymentMethod);
        System.out.println("Vehicle " + licensePlate + " exited through gate: " + getGateId());

        isAvailable = true;
    }
}
