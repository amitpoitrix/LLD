package ParkingLot.MultiStorey;

import ParkingLot.MultiStorey.payment.PaymentMethod;
import ParkingLot.MultiStorey.vehicle.Bike;
import ParkingLot.MultiStorey.vehicle.Car;
import ParkingLot.MultiStorey.vehicle.Truck;
import ParkingLot.MultiStorey.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parking Lot Design with Multiple floor Levels");

        ParkingLot parkingLot = ParkingLot.getInstance(3, 2, 2, 1);

        Vehicle car1 = new Car("CAR1");
        Vehicle bike1 = new Bike("BIKE1");
        Vehicle truck1 = new Truck("TRUCK1");

        Ticket car1Ticket = parkingLot.parkVehicle(car1);
        Ticket bike1Ticket = parkingLot.parkVehicle(bike1);
        Ticket truck1Ticket = parkingLot.parkVehicle(truck1);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { }

        parkingLot.removeVehicle("CAR1", PaymentMethod.CASH);
        parkingLot.removeVehicle("BIKE1", PaymentMethod.CREDIT_CARD);
        parkingLot.removeVehicle("TRUCK1", PaymentMethod.DEBIT_CARD);
    }
}
