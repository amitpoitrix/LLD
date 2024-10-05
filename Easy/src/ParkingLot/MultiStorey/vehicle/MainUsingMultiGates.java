package ParkingLot.MultiStorey.vehicle;

import ParkingLot.MultiStorey.ParkingLot;
import ParkingLot.MultiStorey.Ticket;
import ParkingLot.MultiStorey.gates.EntryGate;
import ParkingLot.MultiStorey.gates.ExitGate;
import ParkingLot.MultiStorey.gates.GateManager;
import ParkingLot.MultiStorey.payment.PaymentMethod;

import java.util.Arrays;

public class MainUsingMultiGates {
    public static void main(String[] args) {
        System.out.println("Parking Lot System with multiple floors + multi entry or exist gates");

        ParkingLot parkingLot = ParkingLot.getInstance(3, 5, 5, 2);

        // Creating multiple gates
        EntryGate entryGate1 = new EntryGate(1, parkingLot);
        EntryGate entryGate2 = new EntryGate(2, parkingLot);
        ExitGate exitGate1 = new ExitGate(1, parkingLot);
        ExitGate exitGate2 = new ExitGate(2, parkingLot);

        // Creating GateManager to handle multiple gates
        GateManager gateManager = new GateManager(Arrays.asList(entryGate1, entryGate2), Arrays.asList(exitGate1, exitGate2));

        // Parking vehicle through entry gates
        Vehicle car1 = new Car("CAR1");
        Vehicle bike1 = new Bike("BIKE1");
        Vehicle truck1 = new Truck("TRUCK1");

        Ticket car1Ticket = gateManager.getAvailableEntryGate().processEntry(car1);
        Ticket bike1Ticket = gateManager.getAvailableEntryGate().processEntry(bike1);
        Ticket truck1Ticket = gateManager.getAvailableEntryGate().processEntry(truck1);

        // Simulate some parking time
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { }

        // Exit vehicle through exit gates and make payment
        gateManager.getAvailableExitGate().processExit("CAR1", PaymentMethod.CREDIT_CARD);
        gateManager.getAvailableExitGate().processExit("BIKE1", PaymentMethod.DEBIT_CARD);
        gateManager.getAvailableExitGate().processExit("TRUCK1", PaymentMethod.CASH);
    }
}
