package parking;

import sensors.CameraSensor;
import sensors.ParkingSensor;
import sensors.UltrasonicSensor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot {

    private ArrayList<ParkingSpace> parkingSpaces;

    public ParkingLot(int totalSpaces) {
        this.parkingSpaces = new ArrayList<>();

        // Use ultrasonic for half of the spaces and camera for the other half
        for (int i = 1; i <= totalSpaces; i++) {
            ParkingSensor sensor = i % 2 == 0 ? new UltrasonicSensor() : new CameraSensor();
            this.parkingSpaces.add(new ParkingSpace("Space " + i, sensor));
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
