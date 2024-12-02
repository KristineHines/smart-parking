package parking_strategy;

import parking.ParkingSpace;

public abstract class ParkingStrategy {
    public abstract ParkingSpace findAvailableParking();
    public abstract void optimizeParking();
}
