package parking_strategy;

import parking.ParkingLot;
import parking.ParkingSpace;

public class BasicParkingStrategy extends ParkingStrategy {
    private ParkingLot parkingLot;

    public BasicParkingStrategy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpace findAvailableParking() {
        for (ParkingSpace space : parkingLot.getAvailableSpaces()) {
            if (!space.isOccupied()) {
                return space;
            }
        }
        return null;
    }

    public void optimizeParking() {
        System.out.println("Basic optimization not implemented.");
    }
}
