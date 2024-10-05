package ParkingLot.MultiStorey;

import ParkingLot.MultiStorey.payment.PaymentMethod;
import ParkingLot.MultiStorey.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

// With Multiple Floors + Ticketing
public class ParkingLot {
    private static ParkingLot instance;
    // floorNumber -> ParkingFloor
    private Map<Integer, ParkingFloor> floors;
    // licensePlate -> Ticket
    private Map<String, Ticket> activeTickets;

    private ParkingLot(int numFloors, int carCapacity, int bikeCapacity, int truckCapacity) {
        floors = new HashMap<>();
        activeTickets = new HashMap<>();

        for (int i = 1; i <= numFloors ; i++) {
            floors.put(i, new ParkingFloor(i, carCapacity, bikeCapacity, truckCapacity));
        }
    }

    // for thread safety
    public static synchronized ParkingLot getInstance(int numFloors, int carCapacity, int bikeCapacity, int truckCapacity) {
        if(instance == null) {
            instance = new ParkingLot(numFloors, carCapacity, bikeCapacity, truckCapacity);
        }

        return instance;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        // First I'll find the freeSpot at each floor and then assign the vehicle
        for(ParkingFloor parkingFloor: floors.values()) {

            ParkingSpot freeParkingSpot = parkingFloor.getFreeSpot(vehicle.getType());

            if(freeParkingSpot != null) {
                // Now I got the free parking spot so I'll first assign the vehicle
                freeParkingSpot.assignVehicle(vehicle);

                // Now after assigning vehicle I need to generate the ticket
                Ticket ticket = new Ticket(vehicle, freeParkingSpot);
                activeTickets.put(vehicle.getLicensePlate(), ticket);

                System.out.println("Vehicle is parked at floor " + freeParkingSpot.getFloorNumber() + " and at spot: " + freeParkingSpot.getSpotNumber());

                return ticket;
            }
        }

        System.out.println("No free spot available for given vehicle: " + vehicle.getType());
        return null;
    }

    public void removeVehicle(String licensePlate, PaymentMethod paymentMethod) {
        // Before removing vehicle first we'll get ticket from given numberPlate
        Ticket ticket = activeTickets.get(licensePlate);

        if(ticket != null) {
            // Now I'll remove the vehicle from the spot mention in the ticket
            ParkingSpot parkedVehicleSpot = ticket.getParkingSpot();
            parkedVehicleSpot.removeVehicle();

            // Now making the payment mention in ticket with given payment method
            ticket.makePayment(paymentMethod);

            // Now I'll remove the licensePlate corresponding ticket from activeTicket list
            activeTickets.remove(licensePlate);
        } else {
            System.out.println("No ticket found for given license plate: " + licensePlate);
        }
    }
}
