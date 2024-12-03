package parking;

import sensors.CameraSensor;
import sensors.ParkingSensor;
import sensors.UltrasonicSensor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot {

    private final ArrayList<ParkingSpace> parkingSpaces;
    private int totalSpaces;
    private int availableNumberOfSpaces;
    private String operationalHours;
    private List<Coordinate> entranceCoordinates;
    private List<Coordinate> exitCoordinates;

    public ParkingLot(int totalSpaces) {
        this.parkingSpaces = new ArrayList<>();
        this.totalSpaces = totalSpaces;

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
                .filter(space -> !space.isReserved() && !space.isOccupied())
                .collect(Collectors.toList());
    }

    public List<ParkingSpace> getAllSpaces() {
        return parkingSpaces;
    }

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    public int getAvailableNumberOfSpaces() {
        return availableNumberOfSpaces;
    }

    public void setAvailableNumberOfSpaces(int availableNumberOfSpaces) {
        this.availableNumberOfSpaces = availableNumberOfSpaces;
    }

    public String getOperationalHours() {
        return operationalHours;
    }

    public void setOperationalHours(String operationalHours) {
        this.operationalHours = operationalHours;
    }

    public List<Coordinate> getEntranceCoordinates() {
        return entranceCoordinates;
    }

    public void setEntranceCoordinates(List<Coordinate> entranceCoordinates) {
        this.entranceCoordinates = entranceCoordinates;
    }

    public List<Coordinate> getExitCoordinates() {
        return exitCoordinates;
    }

    public void setExitCoordinates(List<Coordinate> exitCoordinates) {
        this.exitCoordinates = exitCoordinates;
    }

    public boolean isFull() {
            return getAvailableSpaces().isEmpty();
    }
}
