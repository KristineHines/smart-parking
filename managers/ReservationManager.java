package managers;

import parking.ParkingSpace;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReservationManager {
    private final Map<String, ParkingSpace> licensePlateToReservedSpace = new HashMap<>();

    public boolean reserveSpace(String licensePlate, ParkingSpace space) {
        if (space.isReserved()) return false;
        this.licensePlateToReservedSpace.put(licensePlate, space);
        space.setReserved(true);
        return true;
    }

    public ParkingSpace getReservation(String licensePlate) {
        return this.licensePlateToReservedSpace.get(licensePlate);
    }

    public void getReservedVehicles() {
        if (this.licensePlateToReservedSpace.isEmpty()) {
            System.out.println("The parking lot is empty.");
        } else {
            System.out.println("Reservations:");
            for (Map.Entry<String, ParkingSpace> entry : this.licensePlateToReservedSpace.entrySet()) {
                System.out.println("License Plate: " + entry.getKey() + " Space: " + entry.getValue().getId());
            }
        }
    }

    public void cancelReservedVehicles(String licensePlate, ParkingSpace space) {
        Set<String> reservedVehicles = this.licensePlateToReservedSpace.keySet();
        if (reservedVehicles.isEmpty()) {
            System.out.println("This car is not in this space, or is not reserved");
        } else {
            System.out.println("Removed license plate " + licensePlate + " from " + space.getId());
            space.setReserved(false);
            this.licensePlateToReservedSpace.remove(licensePlate);
        }
    }
}
