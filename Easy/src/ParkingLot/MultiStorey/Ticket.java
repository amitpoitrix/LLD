package ParkingLot.MultiStorey;

import ParkingLot.MultiStorey.payment.Payment;
import ParkingLot.MultiStorey.payment.PaymentMethod;
import ParkingLot.MultiStorey.vehicle.Vehicle;

public class Ticket {
    private Vehicle vehicle;
    private long entryTime;
    private ParkingSpot parkingSpot;
    private Payment payment;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = System.currentTimeMillis();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void makePayment(PaymentMethod paymentMethod) {
        double amountDue = calculateFee();
        this.payment = new Payment(paymentMethod, amountDue);
        this.payment.processPayment();
    }

    private double calculateFee() {
        long currentTime = System.currentTimeMillis();
        long parkedDuration = currentTime - entryTime;
        double hoursParked = parkedDuration / (1000.0 * 60 * 60);

        return switch (vehicle.getType()) {
            case CAR -> hoursParked * 10;   // $10 for car parking
            case BIKE -> hoursParked * 5;   // $5 for bike parking
            case TRUCK -> hoursParked * 20; // $20 for truck parking
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        };
    }
}
