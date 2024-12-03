package parking;

import sensors.ParkingSensor;

public class ParkingSpace {
    private final String id;
    private boolean isOccupied;
    private final ParkingSensor parkingSensor;

    public ParkingSpace(String id, ParkingSensor parkingSensor) {
        this.id = id;
        this.isOccupied = false;
        this.parkingSensor = parkingSensor;
    }

    public String getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }


    public ParkingSensor getParkingSensor() {
        return parkingSensor;
    }
}
