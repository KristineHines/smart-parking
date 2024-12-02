package managers;

import parking.ParkingSpace;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReservationManager {
    private Map<String, ParkingSpace> reservations = new HashMap<>();

    public boolean reserveSpace(String licensePlate, ParkingSpace space) {
        if (space.isOccupied()) return false;
        this.reservations.put(licensePlate, space);
        space.setOccupied(true);
        return true;
    }

    public ParkingSpace getReservation(String licensePlate) {
        return this.reservations.get(licensePlate);
    }

    public void getReservedVehicles() {
        Set<String> reservedVehicles = this.reservations.keySet();
        if (reservedVehicles.isEmpty()) {
            System.out.println("The parking lot is empty.");
        } else {
            System.out.println("Vehicles currently reserving parking spaces:");
            reservedVehicles.forEach(System.out::println);
        }
    }
}
