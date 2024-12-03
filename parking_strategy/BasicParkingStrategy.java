package parking_strategy;

import parking.ParkingLot;
import parking.ParkingSpace;

public class BasicParkingStrategy extends ParkingStrategy {
    private ParkingLot parkingLot;
    private int totalSpaces;

    public BasicParkingStrategy(ParkingLot parkingLot, int totalSpaces) {
        this.parkingLot = parkingLot;
        this.totalSpaces = totalSpaces;
    }

    public ParkingSpace findAvailableParking() {
        for (ParkingSpace space : this.parkingLot.getAvailableSpaces()) {
            if (!space.isReserved() && !space.isOccupied()) {
                return space;
            }
        }
        return null;
    }

    public void optimizeParking() {
        this.parkingLot.getAllSpaces().forEach(space -> {
            if (space.getParkingSensor().detectVehicle()) {
                markParkingSpaceOccupied(space);
            } else {
                markParkingSpaceVacant(space);
            }
        });
    }

    public void reserveParkingSpace(ParkingSpace space) {
        space.setReserved(true);
    }

    public void markParkingSpaceOccupied(ParkingSpace space) {
        space.setOccupied(true);
    }

    public void markParkingSpaceVacant(ParkingSpace space) {
        space.setOccupied(false);
    }

    public void notifyParkingLotFull() {
        System.out.println("Notifying parking lot is full.");
    }

    public void notifyParkingLotAvailable() {
        System.out.println("Notifying parking lot is available.");
    }

    public ParkingSpace makeParkingDecision() {
        return findAvailableParking();
    }

    public void handleParkingRequests() {
        if (this.parkingLot.isFull()) {
            notifyParkingLotFull();
        } else {
            notifyParkingLotAvailable();
        }
        System.out.println("Handling parking requests.");
    }
}
