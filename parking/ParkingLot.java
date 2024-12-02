package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot {

    private ArrayList<ParkingSpace> parkingSpaces;

    public ParkingLot(int totalSpaces) {
        this.parkingSpaces = new ArrayList<>();
        for (int i = 1; i <= totalSpaces; i++) {
            this.parkingSpaces.add(new ParkingSpace("Space " + i));
        }
    }

    /**
     * Getters
     */
    public List<ParkingSpace> getAvailableSpaces() {
        return parkingSpaces.stream()
                .filter(space -> !space.isOccupied())
                .collect(Collectors.toList());
    }

    public List<ParkingSpace> getAllSpaces() {
        return parkingSpaces;
    }
}
