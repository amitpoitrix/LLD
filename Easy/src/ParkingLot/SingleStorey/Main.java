package ParkingLot.SingleStorey;

import ParkingLot.SingleStorey.vehicle.Bike;
import ParkingLot.SingleStorey.vehicle.Car;
import ParkingLot.SingleStorey.vehicle.Truck;
import ParkingLot.SingleStorey.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parking Lot System with Single Storey");

        // First we'll create parking lot with below capacity
        // 2 - Car Spot, 2 - Bike Spot & 1 Truck Spot
        ParkingLot parkingLot = ParkingLot.getInstance(2,2,1);

        // Now we'll create different vehicle
        Vehicle car1 = new Car("CAR1");
        Vehicle bike1 = new Bike("BIKE1");
        Vehicle truck1 = new Truck("Truck1");

        Ticket car1Ticket = parkingLot.parkVehicle(car1);
        Ticket bike1Ticket = parkingLot.parkVehicle(bike1);
        Ticket truck1Ticket = parkingLot.parkVehicle(truck1);

        System.out.println("Ticket cost for " + car1Ticket.getVehicle().getType() + " is $" + parkingLot.removeVehicle(car1.getLicensePlate()));
        System.out.println("Ticket cost for " + bike1Ticket.getVehicle().getType() + " is $" + parkingLot.removeVehicle(bike1.getLicensePlate()));
        System.out.println("Ticket cost for " + truck1Ticket.getVehicle().getType() + " is $" + parkingLot.removeVehicle(truck1.getLicensePlate()));
    }
}
