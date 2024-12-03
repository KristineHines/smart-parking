package parking_strategy;

import parking.ParkingLot;
import parking.ParkingSpace;

import java.util.List;

public class DynamicParkingStrategy extends ParkingStrategy {
    private ParkingLot parkingLot;
    private int totalSpaces;

    public DynamicParkingStrategy(ParkingLot parkingLot, int totalSpaces) {
        this.parkingLot = parkingLot;
        this.totalSpaces = totalSpaces;
        setup();
    }

    private void setup() {
        System.out.println("Setting up dynamic parking strategy.");
    }

    public ParkingSpace findAvailableParking() {
        return findOptimalParkingSpace();
    }

    // randomly update parking space occupancy
    public void optimizeParking() {
        List<ParkingSpace> spaces = this.parkingLot.getAllSpaces();
        for (ParkingSpace space : spaces) {
            updateParkingSpaceOccupancy(space, space.getParkingSensor().detectVehicle());
        }
    }

    public ParkingSpace findOptimalParkingSpace() {
        for (ParkingSpace space : this.parkingLot.getAvailableSpaces()) {
            if (!space.isReserved() && !space.isOccupied()) {
                return space;
            }
        }
        return null;
    }

    public void updateParkingSpaceOccupancy(ParkingSpace space, boolean isOccupied) {
        space.setOccupied(isOccupied);
    }

    public void adjustParkingAllocation() {
        System.out.println("Adjusting parking allocation.");
    }

    public void notifyOptimalParkingAvailable() {
        System.out.println("Notifying optimal parking available.");
    }

    public void handleParkingRequests() {
        System.out.println("Handling parking requests.");
    }

    public void makeParkingDecision() {
        System.out.println("Making parking decisions.");
    }

    public void optimizeParkingStrategy() {
        System.out.println("Optimizing parking strategy.");
    }

}
